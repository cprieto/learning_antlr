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

public class ShortToUnicode : ArrayInitBaseListener() {
    override fun enterInit(ctx : ArrayInitParser.InitContext) {
        println('"')
    }

    override fun exitInit(ctx: ArrayInitParser.InitContext) {
        println('"')
    }

    override fun enterValue(ctx: ArrayInitParser.ValueContext) {
        val value = ctx.INT().getText().toInt()
        println("\\u%04x".format(value))
    }
}
