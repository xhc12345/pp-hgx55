import java.util.*;

import org.antlr.v4.runtime.tree.TerminalNode;

public class Visitor extends SimpleLangBaseVisitor<Integer> {
    private Map<String, Integer> memory = new HashMap<>();


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
        List<SimpleLangParser.FormParContext> allFormPars = ctx.formPar();
        Set<String> allParID = new HashSet<String>();
        for(SimpleLangParser.FormParContext par: allFormPars){
            // check if any param is has duplicated names
            String ID = par.ID().getText();
            if(allParID.contains(ID)){
                error("VAR ERROR: "+ID+" was declared");
            } else{
                allParID.add(ID);
            }
        }
        return visitChildren(ctx);
    }

    private List<String> getVarDeclID(SimpleLangParser.VarDeclContext target){
        List<String> allID = new ArrayList<String>();
        List<TerminalNode> allVar = target.ID();
        for(TerminalNode var: allVar){
            // add new ID into list
            String ID = var.getText();
            allID.add(ID);
        }
        return allID;
    }

    @Override public Integer visitVarDecl(SimpleLangParser.VarDeclContext ctx) {
        
        return visitChildren(ctx);
    }
}
