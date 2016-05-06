import org.antlr.v4.runtime.ANTLRInputStream
import org.antlr.v4.runtime.CommonTokenStream

fun main(args: Array<String>) {
    val input = ANTLRInputStream(System.`in`)
    val lexer = ArrayInitLexer(input)
    val tokens = CommonTokenStream(lexer)
    val parser = ArrayInitParser(tokens)
    val tree = parser.init()

    println(tree.toStringTree(parser))
}
