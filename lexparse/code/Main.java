import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import java.nio.file.Path;
import java.nio.file.FileSystems;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("\nRunning semantic analyzer...\n########################");
        System.out.println("Input: "+Arrays.toString(args));
        if(args.length!=1){
            System.out.println("No files to test");
            return;
        }
        String inputPath = args[0];
        Path path = FileSystems.getDefault().getPath(inputPath);
        CharStream input = CharStreams.fromPath(path);
        SimpleLangLexer lexer = new SimpleLangLexer(input);
        SimpleLangParser parser = new SimpleLangParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.project();

        Visitor visitor = new Visitor();
        visitor.visit(tree);
    }
}