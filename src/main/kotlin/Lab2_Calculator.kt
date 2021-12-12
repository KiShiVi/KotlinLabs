import java.util.*
import kotlin.math.*

private enum class OperatorType {
    PREFIX,
    OPEN_BRACKET,
    CLOSE_BRACKET,
    BINARY,
    CONST,
    DIGIT,
    ERROR,
    NULL
}

private val tokens: List<Token> = listOf(
    Token("(", -1, OperatorType.OPEN_BRACKET),
    Token(")", -1, OperatorType.CLOSE_BRACKET),
    Token("+", 1, OperatorType.BINARY),
    Token("-", 1, OperatorType.BINARY),
    Token("*", 2, OperatorType.BINARY),
    Token("/", 2, OperatorType.BINARY),
    Token("^", 3, OperatorType.BINARY),
    Token("sin", 0, OperatorType.PREFIX),
    Token("cos", 0, OperatorType.PREFIX),
    Token("tg", 0, OperatorType.PREFIX),
    Token("ctg", 0, OperatorType.PREFIX),
    Token("lg", 0, OperatorType.PREFIX),
    Token("ln", 0, OperatorType.PREFIX),
    Token("pi", -1, OperatorType.CONST),
    Token("e", -1, OperatorType.CONST)
)

private class Token constructor(val singleToken: String, val priority: Int, val type: OperatorType)

fun calculate(infixPhrase: String): Double {
    val polishList: List<Token> = toPolishPhrase(infixPhrase)
    val localStack: Stack<Double> = Stack()

    for (i in polishList) {
        when (i.type) {
            OperatorType.DIGIT -> localStack.push(i.singleToken.toDouble())
            OperatorType.BINARY -> {
                when (i.singleToken) {
                    "+" -> localStack.push(localStack.pop() + localStack.pop())
                    "-" -> localStack.push(-localStack.pop() + localStack.pop())
                    "*" -> localStack.push(localStack.pop() * localStack.pop())
                    "/" -> localStack.push(reverseDiv(localStack.pop(), localStack.pop()))
                    "^" -> localStack.push(reversePow(localStack.pop(), localStack.pop()))
                }
            }
            OperatorType.PREFIX -> {
                when (i.singleToken) {
                    "sin" -> localStack.push(sin(localStack.pop()))
                    "cos" -> localStack.push(cos(localStack.pop()))
                    "tg" -> localStack.push(tan(localStack.pop()))
                    "ctg" -> localStack.push(ctg(localStack.pop()))
                    "lg" -> localStack.push(log2(localStack.pop()))
                    "ln" -> localStack.push(ln(localStack.pop()))
                }
            }
            else -> throw Exception("Something gone wrong")
        }
    }

    //print(polishList.joinToString(" "))
    return localStack.pop()
}

private fun toPolishPhrase(infixPhrase: String): List<Token> {

    var localInfixPhrase = infixPhrase.replace(" ", "")
    var prevToken: Token
    var token = Token("", -2, OperatorType.NULL)
    val polishList: MutableList<Token> = arrayListOf()
    val localStack: Stack<Token> = Stack()

    while (localInfixPhrase.isNotEmpty()) {
        prevToken = token
        token = parseToken(localInfixPhrase, prevToken)
        if (token.singleToken.isEmpty())
            throw Exception("program Error")
        localInfixPhrase = localInfixPhrase.substring(token.singleToken.length)
        when (token.type) {
            OperatorType.CONST -> {
                when (token.singleToken) {
                    "pi" -> polishList.add(Token(Math.PI.toString(), -1, OperatorType.DIGIT))
                    "e" -> polishList.add(Token(Math.E.toString(), -1, OperatorType.DIGIT))
                }
            }
            OperatorType.DIGIT -> polishList.add(token)
            OperatorType.PREFIX -> localStack.push(token)
            OperatorType.OPEN_BRACKET -> localStack.push(token)
            OperatorType.CLOSE_BRACKET -> {

                if (localStack.isEmpty())
                    throw Exception("Incorrect phrase")

                var tempToken: Token = localStack.pop()

                while (tempToken.type != OperatorType.OPEN_BRACKET) {
                    polishList.add(tempToken)

                    if (localStack.isEmpty())
                        throw Exception("Incorrect phrase")

                    tempToken = localStack.pop()
                }
            }
            OperatorType.BINARY -> {
                while (localStack.isNotEmpty() && (localStack.peek().type == OperatorType.PREFIX ||
                            localStack.peek().priority >= token.priority)
                ) polishList.add(localStack.pop())

                localStack.push(token)
            }
            else -> throw Exception("Something gone wrong")
        }
    }

    while (localStack.isNotEmpty()) {
        if (localStack.peek().type == OperatorType.OPEN_BRACKET ||
            localStack.peek().type == OperatorType.CLOSE_BRACKET
        )
            throw Exception("Incorrect phrase (brackets)")
        polishList.add(localStack.pop())
    }

    return polishList
}

// parses one token (12*sin(5-3) --> "12", "*", "sin", "(", "5", "-", "3", "3")
private fun parseToken(infixPhrase: String, prevToken: Token): Token {
    if (infixPhrase.isEmpty())
        throw Exception("parseToken error")
    var outToken = ""
    var iCounter = 0

    if (infixPhrase[0].isDigit()) {
        while (iCounter < infixPhrase.length && infixPhrase[iCounter].isDigit()) {
            outToken += infixPhrase[iCounter]
            iCounter++
        }
        return Token(outToken, -1, OperatorType.DIGIT)
    }

    for (token in tokens) {
        if (infixPhrase.length < token.singleToken.length)
            continue
        if (infixPhrase.substring(0, token.singleToken.length) == token.singleToken) {

            if (token.priority in 2..3 &&
                (prevToken.type == OperatorType.NULL ||
                        prevToken.type == OperatorType.OPEN_BRACKET ||
                        prevToken.type == OperatorType.BINARY)
            )
                throw Exception("Incorrect phrase")

            //  check for unary + and -
            return if (((token.singleToken == "+") || (token.singleToken == "-")) &&
                ((prevToken.type == OperatorType.NULL) ||
                        (prevToken.type == OperatorType.BINARY) ||
                        (prevToken.type == OperatorType.OPEN_BRACKET))
            ) {
                outToken += token.singleToken
                iCounter++
                while (iCounter < infixPhrase.length && infixPhrase[iCounter].isDigit()) {
                    outToken += infixPhrase[iCounter]
                    iCounter++
                }
                Token(outToken, -1, OperatorType.DIGIT)
            } else {
                token
            }
        }
    }
    // not parsed
    return Token("", -2, OperatorType.ERROR)
}

private fun reversePow(a: Double, b: Double): Double {
    return b.pow(a)
}

private  fun reverseDiv(a: Double, b: Double) : Double{
    return b / a
}

private fun ctg(a: Double): Double {
    return cos(a) / sin(a)
}