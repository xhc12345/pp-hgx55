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
        System.exit(0);
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
        Set<String> allValidID = new HashSet<String>();
        List<String> allMethodScopeID = new ArrayList<String>();
        if(ctx.formPars()!=null){   // add all formPars ID to method scope
            List<String> formParID = getFormParsID(ctx.formPars());
            allMethodScopeID.addAll(formParID);
        }
        if(ctx.varDecl()!=null){    // add all varDecl ID to method scope
            for(SimpleLangParser.VarDeclContext var: ctx.varDecl()){
                List<String> varDeclID = getVarDeclID(var);
                allMethodScopeID.addAll(varDeclID);
            }
        }
        for(String ID: allMethodScopeID){
            // check each ID collected to see if any duplicated
            if(allValidID.contains(ID)){
                error("VAR ERROR: "+ID+" was already declared");
            } else{
                allValidID.add(ID);
            }
        }
        return visitChildren(ctx);
    }

    private List<String> getFormParsID(SimpleLangParser.FormParsContext target){
        List<String> allID = new ArrayList<String>();
        List<SimpleLangParser.FormParContext> allFormPars = target.formPar();
        for(SimpleLangParser.FormParContext par: allFormPars){
            // add new ID into list
            String ID = par.ID().getText();
            allID.add(ID);
        }
        return allID;
    }

    @Override public Integer visitFormPars(SimpleLangParser.FormParsContext ctx) {
        
        return visitChildren(ctx);
    }

    private List<String> getVarDeclID(SimpleLangParser.VarDeclContext target){
        List<String> allID = new ArrayList<String>();
        List<SimpleLangParser.VarContext> allVar = target.var();
        String type = target.type().getText();
        for(SimpleLangParser.VarContext var: allVar){
            String ID = var.getText();
            allID.add(ID);// add new ID into list
            Var_Info varInfo = new Var_Info(ID, type, false, false, false);
            
            
        }
        return allID;
    }

    @Override public Integer visitVarDecl(SimpleLangParser.VarDeclContext ctx) {
        
        return visitChildren(ctx);
    }

    @Override public Integer visitInterfaceMethodDecl(SimpleLangParser.InterfaceMethodDeclContext ctx) {
        Set<String> allValidID = new HashSet<String>();
        if(ctx.formPars()!=null){   // add all formPars ID to method scope
            List<String> formParID = getFormParsID(ctx.formPars());
            for(String ID: formParID){
                // check each ID collected to see if any duplicated
                if(allValidID.contains(ID)){
                    error("VAR ERROR: "+ID+" was already declared");
                } else{
                    allValidID.add(ID);
                }
            }
        }
        
        return visitChildren(ctx);
    }
}
