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
    val memory = hashMapOf<String, Int?>()

    override fun visitInt(p0: ExprParser.IntContext?): Int? {
        val value = p0?.INT()!!.text.toInt()
        return value
    }

    override fun visitAddSub(p0: ExprParser.AddSubContext?): Int? {
        val left = visit(p0?.expr(0))
        val right = visit(p0?.expr(1))
        val op = p0?.op!!.type

        return if (op == ExprParser.ADD) (left + right) else (left - right)
    }

    override fun visitMulDiv(p0: ExprParser.MulDivContext?): Int? {
        val left = visit(p0?.expr(0))
        val right = visit(p0?.expr(1))
        val op = p0?.op!!.type

        return if (op == ExprParser.MUL) (left * right) else (left / right)
    }

    override fun visitAssign(p0: ExprParser.AssignContext?): Int? {
        val id = p0?.ID()!!.text
        val value = visit(p0?.expr())

        memory[id] = value

        return value
    }

    override fun visitId(p0: ExprParser.IdContext?): Int? {
        val id = p0?.ID()!!.text
        if (memory.containsKey(id))
            return memory[id]
        return null
    }

    override fun visitParens(ctx: ExprParser.ParensContext?): Int? {
        val value = visit(ctx?.expr())
        return value
    }

    override fun visitPrintExpr(p0: ExprParser.PrintExprContext?): Int? {
        val value = visit(p0?.expr())
        println(value)
        return null
    }

    override fun visitClear(p0: ExprParser.ClearContext?): Int? {
        memory.clear()
        return null
    }
}
