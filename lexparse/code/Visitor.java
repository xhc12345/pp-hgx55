import java.util.List;

public class Visitor extends SimpleLangBaseVisitor<Integer> {


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
            System.out.println("ENTRY ERROR");
        }

        return visitChildren(ctx);
    }

    @Override public Integer visitClassDecl(SimpleLangParser.ClassDeclContext ctx) {
        String className = ctx.ID().getText();
        System.out.println("class is "+className);
        return visitChildren(ctx);
    }

    @Override public Integer visitMethodDecl(SimpleLangParser.MethodDeclContext ctx) {
        
        return visitChildren(ctx);
    }
}
