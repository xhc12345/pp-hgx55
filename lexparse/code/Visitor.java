import java.util.List;

public class Visitor extends SimpleLangBaseVisitor<Integer> {
    @Override public Integer visitProject(SimpleLangParser.ProjectContext ctx){
        String projectName = ctx.ID().getText();
        System.out.println("project name is "+projectName);
        List<SimpleLangParser.MethodDeclContext> allMethods = ctx.methodDecl();
        System.out.print(allMethods.size()+" methods: ");
        for(SimpleLangParser.MethodDeclContext m: allMethods){
            System.out.print(m.ID().getText()+',');
        }System.out.println();
        return visitChildren(ctx);
    }

    @Override public Integer visitClassDecl(SimpleLangParser.ClassDeclContext ctx) {
        String className = ctx.ID().getText();
        System.out.println("class is "+className);
        return visitChildren(ctx);
    }
}
