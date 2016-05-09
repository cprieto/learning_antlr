import java.io.FileInputStream
import org.antlr.v4.runtime.ANTLRInputStream
import org.antlr.v4.runtime.CommonTokenStream

fun main(args: Array<String>) {
    val inputStream = if (args.size > 0) FileInputStream(args[0]) else System.`in`
    val input = ANTLRInputStream(inputStream)
    val lexer = ExprLexer(input)
    val tokens = CommonTokenStream(lexer)
    val parser = ExprParser(tokens)
    val tree = parser.prog()

    val visitor = EvalVisitor()
    visitor.visit(tree)
}

class EvalVisitor : ExprBaseVisitor<Int>() {
}
