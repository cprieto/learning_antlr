import org.antlr.v4.runtime.ANTLRInputStream
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTreeWalker

fun main(args: Array<String>) {
    val input = ANTLRInputStream(System.`in`)
    val lexer = ArrayInitLexer(input)
    val tokens = CommonTokenStream(lexer)
    val parser = ArrayInitParser(tokens)
    val tree = parser.init()

    val walker = ParseTreeWalker()
    walker.walk(ShortToUnicode(), tree)

    println()
}

public class ShortToUnicode : ArrayInitBaseListener() {
    override fun enterInit(ctx : ArrayInitParser.InitContext) {
        print('"')
    }

    override fun exitInit(ctx: ArrayInitParser.InitContext) {
        print('"')
    }

    override fun enterValue(ctx: ArrayInitParser.ValueContext) {
        val value = ctx.INT().getText().toInt()
        print("\\u%04x".format(value))
    }
}
