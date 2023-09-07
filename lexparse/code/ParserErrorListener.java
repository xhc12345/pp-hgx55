import org.antlr.v4.runtime.*;

public class ParserErrorListener extends BaseErrorListener {
    @Override public void syntaxError(
        Recognizer<?, ?> recognizer,
        Object offendingSymbol,
        int lineNum,
        int charPos,
        String msg,
        RecognitionException re
    ) {
        System.out.println("PARSER ERROR: line " + lineNum + ':' + charPos + ' ' + msg);
    }
}