import org.antlr.v4.runtime.ANTLRInputStream
import org.antlr.v4.runtime.CommonTokenStream
import java.io.FileInputStream

fun main(args: Array<String>) {
    val inputStream = if (args.size > 0) FileInputStream(args[0]) else System.`in`
    val input = ANTLRInputStream(inputStream)
    val lexer = MathLexer(input)
    val tokens = CommonTokenStream(lexer)
    val parser = MathParser(tokens)
    val tree = parser.math()

    val visitor = MathEvalVisitor()
    visitor.visit(tree)
}

class MathEvalVisitor : MathBaseVisitor<Int?>() {
    override fun visitPrintResult(ctx: MathParser.PrintResultContext?): Int? {
        val value = visit(ctx?.expr())
        println("${ctx?.expr()?.text} = $value")
        return 0
    }

    override fun visitNum(ctx: MathParser.NumContext?): Int? {
        return ctx?.INT()?.text?.toInt()
    }

    override fun visitSum(ctx: MathParser.SumContext?): Int? {
        val left  = visit(ctx?.expr(0))!!
        val right = visit(ctx?.expr(1))!!

        return left + right
    }
}