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
    if (lineWidth <= 0)
        throw Exception("lineWidth less than or equal to 0")

    val newText: MutableList<String> = arrayListOf()
    newText.add("")

    val oneStringText = text.replace('\n', ' ')

    for (word in oneStringText.split(' ')) {
        var tempWord: String = word

        when {
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
    return when (alignment) {
        Alignment.LEFT -> alignmentLeft(newText, lineWidth)
        Alignment.RIGHT -> alignmentRight(newText, lineWidth)
        Alignment.CENTER -> alignmentCenter(newText, lineWidth)
        Alignment.JUSTIFY -> alignmentJustify(newText, lineWidth)
    }
}


private fun alignmentLeft(newText: MutableList<String>, lineWidth: Int): String {
    // Insert spaces to the right of the line to the specified width
    for (iString in 0 until newText.size) {
        while (newText[iString].length < lineWidth) {
            newText[iString] = newText[iString] + " "
        }
    }
    return newText.joinToString(separator = "\n")
}


private fun alignmentRight(newText: MutableList<String>, lineWidth: Int): String {
    for (iString in 0 until newText.size) {
        // Throwing spaces to the right of the line to the left
        while (newText[iString].length > 1 && newText[iString][newText[iString].length - 1] == ' ') {
            newText[iString] = " " + newText[iString].substring(0, newText[iString].length - 1)
        }
        // Insert spaces to the left of the line to the specified width
        while (newText[iString].length < lineWidth) {
            newText[iString] = " " + newText[iString]
        }
    }
    return newText.joinToString(separator = "\n")
}


private fun alignmentCenter(newText: MutableList<String>, lineWidth: Int): String {
    for (iString in 0 until newText.size) {
        deleteLeftAndRightSpaces(newText, iString)

        // Add spaces evenly to the right and left of the line to the specified width
        while (newText[iString].length < lineWidth) {
            if (newText[iString].length < lineWidth)
                newText[iString] = " " + newText[iString]
            if (newText[iString].length < lineWidth)
                newText[iString] = newText[iString] + " "
        }
    }
    return newText.joinToString(separator = "\n")
}


private fun alignmentJustify(newText: MutableList<String>, lineWidth: Int): String {
    for (iString in 0 until newText.size) {

        deleteLeftAndRightSpaces(newText, iString)

        val countOfWords = newText[iString].split(' ').count()
        var tempString = ""

        // Crutch, if there is only one word in a line - align it to the left
        if (countOfWords == 1) {
            tempString = newText[iString].split(' ')[0]
            newText[iString] = tempString
            continue
        }

        // Number of places where you want to add spaces
        var countOfSpaces = lineWidth

        for (word in newText[iString].split(' '))
            countOfSpaces -= word.length

        // Space between lines
        val sizeOfSpace = countOfSpaces / (countOfWords - 1)
        // Number of large spaces (equal to sizeOfSpace + 1)
        var countOfBigSpaces = countOfSpaces % (countOfWords - 1)

        // We push all the words of the string into tempString with the required number of spaces between them
        for (word in newText[iString].split(' ').subList(0, countOfWords - 1))
            if (countOfBigSpaces > 0) {
                tempString += word
                repeat(sizeOfSpace + 1) {
                    tempString += " "
                    countOfBigSpaces--
                }
            } else {
                tempString += word
                repeat(sizeOfSpace) {
                    tempString += " "
                }
            }
        newText[iString] = tempString + newText[iString].split(' ')[countOfWords - 1]
    }
    return newText.joinToString(separator = "\n")
}

private fun spaceAtTheEndOfAWord(newText: MutableList<String>, lineWidth: Int) {
    if (newText[newText.size - 1].length < lineWidth)
        newText[newText.size - 1] += " "
    else
        newText.add("")
}

private fun deleteLeftAndRightSpaces(newText: MutableList<String>, iString: Int) {
    while (newText[iString].length > 1 && newText[iString][newText[iString].length - 1] == ' ') {
        newText[iString] = newText[iString].substring(0, newText[iString].length - 1)
    }
    while (newText[iString].length > 1 && newText[iString][0] == ' ') {
        newText[iString] = newText[iString].substring(1)
    }
}