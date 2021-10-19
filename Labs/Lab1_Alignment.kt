enum class Alignment {
    LEFT,
    RIGHT,
    CENTER,
    JUSTIFY
}

fun alignText(
    text: String,
    lineWidth: Int = 120,
    alignment: Alignment = Alignment.LEFT
): String {
    val newText : MutableList<String> = arrayListOf()
    newText.add("")

    val oneStringText = text.replace('\n', ' ')

    for (word in oneStringText.split(' ')){
        var tempWord : String = word

        when{
            word.length > lineWidth -> {
                do {
                    val tempIt = lineWidth - newText.last().length
                    newText[newText.size - 1] += tempWord.substring(0, tempIt)
                    newText.add("")
                    tempWord = tempWord.substring(tempIt)
                } while (tempWord.length > lineWidth)
                newText[newText.size - 1] += tempWord
                spaceAtTheEndOfAWord(newText, lineWidth)
            }
            word.length > lineWidth - newText.last().length -> {
                newText.add(tempWord)
                spaceAtTheEndOfAWord(newText, lineWidth)
            }
            else -> {
                newText[newText.size - 1] += tempWord
                spaceAtTheEndOfAWord(newText, lineWidth)
            }
        }
    }
    return when (alignment){
        Alignment.LEFT      -> alignmentLeft(newText, lineWidth)
        Alignment.RIGHT     -> alignmentRight(newText, lineWidth)
        Alignment.CENTER    -> alignmentCenter(newText, lineWidth)
        Alignment.JUSTIFY   -> alignmentJustify(newText, lineWidth)
    }
}



private fun alignmentLeft (newText : MutableList<String>, lineWidth : Int) : String {
    // Накидываем пробелы справа от строки до заданной ширины
    for (iString in 0 until newText.size){
        while (newText[iString].length < lineWidth){
            newText[iString] = newText[iString] + " "
        }
    }
    return newText.joinToString(separator = "\n")
}



private fun alignmentRight (newText : MutableList<String>, lineWidth : Int) : String{
    for (iString in 0 until newText.size){
        // Перекидываем пробелы справа от строки налево
        while (newText[iString][newText[iString].length - 1] == ' '){
            newText[iString] = " " + newText[iString].substring(0, newText[iString].length - 1)
        }
        // Накидываем пробелы слева от строки до заданной ширины
        while (newText[iString].length < lineWidth){
            newText[iString] = " " + newText[iString]
        }
    }
    return newText.joinToString(separator = "\n")
}



private fun alignmentCenter (newText : MutableList<String>, lineWidth : Int) : String{
    for (iString in 0 until newText.size){
        deleteLeftAndRightSpaces(newText, iString)

        // Равномерно накидываем пробелы справа и слева от строки до заданной ширины
        while (newText[iString].length < lineWidth){
            if (newText[iString].length < lineWidth)
                newText[iString] = " " + newText[iString]
            if (newText[iString].length < lineWidth)
                newText[iString] = newText[iString] + " "
        }
    }
    return newText.joinToString(separator = "\n")
}



private fun alignmentJustify (newText : MutableList<String>, lineWidth : Int) : String{
    for (iString in 0 until newText.size){

        deleteLeftAndRightSpaces(newText, iString)

        val countOfWords = newText[iString].split(' ').count()
        var tempString = ""

        // Костыль, если слово в строке только одно - выравниваем его по левому краю
        if (countOfWords == 1) {
            tempString = newText[iString].split(' ')[0]
            newText[iString] = tempString
            continue
        }

        // Кол-во мест, куда требуется накидать пробелов
        var countOfSpaces = lineWidth

        for (word in newText[iString].split(' '))
            countOfSpaces -= word.length

        // Размер пробела между строками
        val sizeOfSpace = countOfSpaces / (countOfWords - 1)
        // Кол-во больших пробелов (равен sizeOfSpace + 1)
        var countOfBigSpaces = countOfSpaces % (countOfWords - 1)

        // Запихиваем все слова строки в tempString с нужным кол-вом пробелов между ними
        for (word in newText[iString].split(' ').subList(0, countOfWords - 1))
            if (countOfBigSpaces > 0) {
                tempString += word
                repeat(sizeOfSpace + 1) {
                    tempString += " "
                    countOfBigSpaces--
                }
            }
            else {
                tempString += word
                repeat(sizeOfSpace) {
                    tempString += " "
                }
            }
        newText[iString] = tempString + newText[iString].split(' ')[countOfWords - 1]
    }
    return newText.joinToString(separator = "\n")
}

private fun spaceAtTheEndOfAWord (newText: MutableList<String>, lineWidth : Int){
    if (newText[newText.size - 1].length < lineWidth)
        newText[newText.size - 1] += " "
    else
        newText.add("")
}

private fun deleteLeftAndRightSpaces(newText: MutableList<String>, iString: Int){
    while (newText[iString][newText[iString].length - 1] == ' '){
        newText[iString] = newText[iString].substring(0, newText[iString].length - 1)
    }
    while (newText[iString][0] == ' '){
        newText[iString] = newText[iString].substring(1)
    }
}

fun main(){
    val text : String = """Впервые более чем за 250 млн лет ящерицы смогли 
        |восстановить идеальный хвост. Это получилось при помощи ученых из Университета 
        |Южной Калифорнии. Исследователи сравнили, как хвосты ящериц растут во время 
        |эмбрионального периода и во взрослом возрасте — после того как первый хвост 
        |отпал. В обоих случаях ключевую роль играют нервные стволовые клетки, но ведут они себя по-разному.
        |У взрослых ящериц эти клетки вырабатывают молекулярный сигнал, блокирующий 
        |формирование скелета и нервов, но стимулирующий рост хряща. В итоге получается 
        |не хвост, а просто хрящевая трубка.
        |Ученые попробовали пересаживать эмбриональные клетки взрослым особям, 
        |но это не помогло. Тогда они применили генетическое редактирование и 
        |сделали эмбриональные клетки устойчивыми к молекулярному сигналу. После этого 
        |ящерицы смогли восстановить нормальный хвост уже во взрослом возрасте.
        |Теперь исследователи хотят усовершенствовать свой метод и использовать его для 
        |заживления глубоких и трудных ран.""".trimMargin()

    println(alignText(text = text, lineWidth = 100, alignment = Alignment.LEFT))
    println("=================================================================")
    println(alignText(text = text, lineWidth = 100, alignment = Alignment.RIGHT))
    println("=================================================================")
    println(alignText(text = text, lineWidth = 100, alignment = Alignment.CENTER))
    println("=================================================================")
    println(alignText(text = text, lineWidth = 100, alignment = Alignment.JUSTIFY))
}