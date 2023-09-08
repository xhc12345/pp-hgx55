import java.util.*;

import org.antlr.v4.runtime.tree.TerminalNode;

class Var_Info{
    String ID;
    String type=null;
    boolean readOnly=false;   // for const
    boolean isPrimative=false;    // int, char, boolean, enums
    boolean isArray=false, isEnum=false;
    // String returnType=null;  // only if isMethod
    // Set<String> formParsFormats;    // overloading, comma-delim, eg "int,int,boolean" or "char,int,char"

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

public class Visitor extends SimpleLangBaseVisitor<Integer> { 
    private Map<String, Var_Info> globalVars = new HashMap<String, Var_Info>();
    private Map<String, Var_Info> classes = new HashMap<String, Var_Info>();
    private Map<String, Var_Info> localVars;
    // private Stack<Map<String, Var_Info>> localVarsStack = new Stack<Map<String, Var_Info>>();

    private void error(String msg){
        System.out.println(msg);
        // System.exit(0);
    }


    @Override public Integer visitProject(SimpleLangParser.ProjectContext ctx){
        String projectName = ctx.ID().getText();
        System.out.println("project name is "+projectName);

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


        ctx.classDecl();

        ctx.interfaceDecl();

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
        System.out.println("class is "+className);
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
}
