import java.io.FileInputStream
import org.antlr.v4.runtime.ANTLRInputStream
import org.antlr.v4.runtime.CommonTokenStream

fun main(args: Array<String>) {
    val inputStream = if (args.size > 0) FileInputStream(args[0]) else System.`in`
    val input = ANTLRInputStream(inputStream)
    val lexer = RowsLexer(input)
    val tokens = CommonTokenStream(lexer)
    val col = if (args.size > 1) args[1].toInt() else 0
    val parser = RowsParser(tokens, col)
    parser.setBuildParseTree(false)

    parser.file()
}
