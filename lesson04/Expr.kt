import java.io.InputStream
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

    println(tree.toStringTree(parser))
}
