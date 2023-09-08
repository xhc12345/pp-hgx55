import java.util.*;

import org.antlr.v4.runtime.tree.TerminalNode;

class Var_Info{
    String ID;
    String type=null;
    boolean readOnly=false;   // for const
    boolean isPrimative=false;    // int, char, boolean, enums
    boolean isArray=false, isEnum=false;

    static private Set<String> primatives = new HashSet<>(Arrays.asList("int", "char", "boolean", "enum"));
    public Var_Info(String ID, String type, boolean constant, boolean isArray, boolean isEnum){
        this.ID = ID;
        this.type = type;
        this.readOnly = constant;
        if(primatives.contains(type)) this.isPrimative = true;
        this.isArray = isArray;
        this.isEnum = isEnum;
    }
}

class Method_Info{
    String ID;
    String returnType = "void";
    // overloading, comma-delim, eg "int,int,boolean" or "char,int,char"
    Set<String> formParsFormats = new HashSet<String>();

    public Method_Info(String ID, String returnType){
        this.ID = ID;
        this.returnType = returnType;
    }

    public boolean overloadExists(String combo){
        return formParsFormats.contains(combo);
    }

    public boolean overloadExists(String... types){
        String combo = String.join(",",types);
        return formParsFormats.contains(combo);
    }

    public void addOverload(String... types){
        String combo = String.join(",",types);
        if(!formParsFormats.contains(combo)){
            formParsFormats.add(combo);
        }
    }

    public void addOverload(String combo){
        if(!formParsFormats.contains(combo)){
            formParsFormats.add(combo);
        }
    }
}

class Class_Info{
    String ID;
    boolean isInterface=false;
    Set<String> parentClasses;          // classes and their parents
    Set<String> implementations;        // interfaces and their parents
    Map<String, Method_Info> methods;   // methods available to this class
    
    public Class_Info(String ID, boolean isInterface){
        this.ID = ID;
        this.isInterface = isInterface;
        parentClasses = new HashSet<String>();
        implementations = new HashSet<String>();
    }

    public void addParent(String c){
        parentClasses.add(c);
    }

    public void addInterface(Set<String> i){
        implementations.addAll(i);
    }
}

public class Visitor extends SimpleLangBaseVisitor<Integer> { 
    private Map<String, Var_Info> globalVars = new HashMap<String, Var_Info>();
    private Map<String, Var_Info> localVars;
    private Map<String, Method_Info> staticMethods = new HashMap<String, Method_Info>();
    private Map<String, Class_Info> allClasses = new HashMap<String, Class_Info>();
    private Map<String, Class_Info> allInterfaces = new HashMap<String, Class_Info>();

    private void error(String msg){
        System.out.println(msg);
        // System.exit(0);
    }


    @Override public Integer visitProject(SimpleLangParser.ProjectContext ctx){
        String projectName = ctx.ID().getText();

        boolean hasEntry=false, voidEntry=false, noParamEntry=false;
        List<SimpleLangParser.MethodDeclContext> allMethods = ctx.methodDecl();
        for(SimpleLangParser.MethodDeclContext m: allMethods){
            // search for entry() and check if it's good
            if(m.ID().getText().equals("entry")){
                hasEntry = true;
                if(m.type()==null){
                    voidEntry=true;
                }
                if(m.formPars()==null){
                    noParamEntry=true;
                }
            }
        }
        if(!hasEntry || !voidEntry || !noParamEntry){
            error("ENTRY ERROR");
        }

        List<Var_Info> allGlobalVar = new ArrayList<Var_Info>();
        List<SimpleLangParser.ConstDeclContext> constants = ctx.constDecl();
        for(SimpleLangParser.ConstDeclContext constDecl: constants){
            allGlobalVar.addAll(getConstVars(constDecl));
        }
        List<SimpleLangParser.VarDeclContext> variables = ctx.varDecl();
        for(SimpleLangParser.VarDeclContext varDecl: variables){
            allGlobalVar.addAll(getVarDeclVars(varDecl));
        }
        List<SimpleLangParser.EnumDeclContext> enums = ctx.enumDecl();
        for(SimpleLangParser.EnumDeclContext enumDecl: enums){
            // TODO: collect all enums and convert to Var_Info
        }

        for(Var_Info var: allGlobalVar){
            // check each ID collected to see if any duplicated
            if(globalVars.containsKey(var.ID)){
                error("VAR ERROR: "+var.ID+" was already declared");
            } else{
                globalVars.put(var.ID,var);
            }
        }


        List<SimpleLangParser.ClassDeclContext> classes = ctx.classDecl();
        for(SimpleLangParser.ClassDeclContext classDecl: classes){
            String className = classDecl.ID().getText();
            if(allClasses.containsKey(className)){
                error("REPEATED CLASS ERROR: "+className);
                continue;
            }
            String parentClass = classDecl.type()!=null? classDecl.type().getText(): null;
            Set<String> implementations = null;
            if(classDecl.implementations()!=null){
                List<SimpleLangParser.TypeContext> impl = classDecl.implementations().type();
                implementations = new HashSet<String>();
                for(SimpleLangParser.TypeContext i: impl){
                    String iName = i.ID().getText();
                    if(implementations.contains(iName)){
                        error("REPEATED IMPLEMENTS ERROR: "+iName);
                    } else {
                        implementations.add(iName);
                    }
                }
            }
            Class_Info classAdv = new Class_Info(className, false);
            classAdv.addParent(parentClass);
            classAdv.addInterface(implementations);
            allClasses.put(className, classAdv);
        }

        List<SimpleLangParser.InterfaceDeclContext> interfaces = ctx.interfaceDecl();
        for(SimpleLangParser.InterfaceDeclContext interf: interfaces){
            String iName = interf.ID().getText();
            if(allInterfaces.containsKey(iName)){
                error("REPEATED INTERFACE ERROR: "+iName);
                continue;
            }
            Class_Info interfAdv = new Class_Info(iName, true);
            allInterfaces.put(iName, interfAdv);
        }

        List<SimpleLangParser.MethodDeclContext> methods = ctx.methodDecl();
        for(SimpleLangParser.MethodDeclContext method: methods){
            String type = method.type()!=null? method.type().getText() : "void";
            String methodName = method.ID().getText();
            String formParTypeCombo="";
            if(method.formPars()!=null){
                // combine the types in formPars
                for(Var_Info formPar:getFormParsVars(method.formPars())){
                    formParTypeCombo = String.join(",", formParTypeCombo, formPar.type);
                }
            }
            if(staticMethods.containsKey(methodName)){
                // check if this method declaration is overloading successfully
                Method_Info targetMethod = staticMethods.get(methodName);
                if(targetMethod.overloadExists(formParTypeCombo)){
                    error("OVERLOADING ERROR: "+methodName+'('+formParTypeCombo+')'+" already declared");
                } else {
                    targetMethod.addOverload(formParTypeCombo);
                }
            } else {
                // create new method and its form pars
                Method_Info methodAdv = new Method_Info(methodName, type);
                methodAdv.addOverload(formParTypeCombo);
                staticMethods.put(methodName, methodAdv);
            }
            
        }

        return visitChildren(ctx);
    }

    private List<Var_Info> getConstVars(SimpleLangParser.ConstDeclContext target){
        List<Var_Info> allID = new ArrayList<Var_Info>();
        List<SimpleLangParser.ConstAssignContext> allConsts = target.constAssign();
        String type = target.type().getText();
        for(SimpleLangParser.ConstAssignContext k: allConsts){
            String ID = k.ID().getText();
            Var_Info kInfo = new Var_Info(ID, type, true, false, false);
            allID.add(kInfo);
        }
        return allID;
    }

    @Override public Integer visitConstDecl(SimpleLangParser.ConstDeclContext ctx) {

        return visitChildren(ctx);
    }

    @Override public Integer visitClassDecl(SimpleLangParser.ClassDeclContext ctx) {
        String className = ctx.ID().getText();
        return visitChildren(ctx);
    }

    @Override public Integer visitMethodDecl(SimpleLangParser.MethodDeclContext ctx) {
        localVars = new HashMap<String, Var_Info>(); // new method means new set of local vars

        String methodName = ctx.ID().getText();
        List<Var_Info> allMethodScopeID = new ArrayList<Var_Info>();
        if(ctx.formPars()!=null){   // add all formPars ID to method scope
            List<Var_Info> formParVars = getFormParsVars(ctx.formPars());
            allMethodScopeID.addAll(formParVars);
        }
        if(ctx.varDecl()!=null){    // add all varDecl ID to method scope
            for(SimpleLangParser.VarDeclContext var: ctx.varDecl()){
                List<Var_Info> varDeclVars = getVarDeclVars(var);
                allMethodScopeID.addAll(varDeclVars);
            }
        }
        for(Var_Info var: allMethodScopeID){
            // check each ID collected to see if any duplicated
            if(localVars.containsKey(var.ID)){
                error("VAR ERROR: "+var.ID+" was already declared");
            } else{
                localVars.put(var.ID,var);
            }
        }
        return visitChildren(ctx);
    }

    private List<String> varInfoListToIDList(List<Var_Info> input){
        List<String> ret = new ArrayList<String>();
        for(Var_Info var: input){
            ret.add(var.ID);
        }
        return ret;
    }

    private List<Var_Info> getFormParsVars(SimpleLangParser.FormParsContext target){
        List<Var_Info> allID = new ArrayList<Var_Info>();
        List<SimpleLangParser.FormParContext> allFormPars = target.formPar();
        for(SimpleLangParser.FormParContext par: allFormPars){
            String ID = par.ID().getText();
            String type = par.type().getText();
            boolean isArray = par.LBRACKET()!=null;
            Var_Info parInfo = new Var_Info(ID, type, false, isArray, false);
            allID.add(parInfo);
        }
        return allID;
    }

    @Override public Integer visitFormPars(SimpleLangParser.FormParsContext ctx) {
        
        return visitChildren(ctx);
    }

    private List<Var_Info> getVarDeclVars(SimpleLangParser.VarDeclContext target){
        List<Var_Info> allID = new ArrayList<Var_Info>();
        List<SimpleLangParser.VarContext> allVar = target.var();
        String type = target.type().getText();
        for(SimpleLangParser.VarContext var: allVar){
            String ID = var.ID().getText();
            Var_Info varInfo = new Var_Info(ID, type, false, false, false);
            allID.add(varInfo);
        }
        return allID;
    }

    @Override public Integer visitVarDecl(SimpleLangParser.VarDeclContext ctx) {
        
        return visitChildren(ctx);
    }

    @Override public Integer visitInterfaceMethodDecl(SimpleLangParser.InterfaceMethodDeclContext ctx) {
        Set<String> allValidID = new HashSet<String>();
        if(ctx.formPars()!=null){   // add all formPars ID to method scope
            List<Var_Info> formParID = getFormParsVars(ctx.formPars());
            for(Var_Info var: formParID){
                // check each ID collected to see if any duplicated
                if(allValidID.contains(var.ID)){
                    error("VAR ERROR: "+var.ID+" was already declared");
                } else{
                    allValidID.add(var.ID);
                }
            }
        }
        
        return visitChildren(ctx);
    }

    @Override public Integer visitFactor(SimpleLangParser.FactorContext ctx) {
        if(ctx.type()!=null){
            String type = ctx.type().ID().getText();
            if(!allClasses.containsKey(type) && !allInterfaces.containsKey(type)){
                // error("NAME USE ERROR: "+type+" not declared");
            }
        }
        return visitChildren(ctx);
    }

}
