fun main() {
//    val NotAlignedText: String = """Впервые более чем за 250 млн лет ящерицы смогли
//        |восстановить идеальный хвост. Это получилось при помощи ученых из Университета
//        |Южной Калифорнии. Исследователи сравнили, как хвосты ящериц растут во время
//        |эмбрионального периода и во взрослом возрасте — после того как первый хвост
//        |отпал. В обоих случаях ключевую роль играют нервные стволовые клетки, но ведут они себя по-разному.
//        |У взрослых ящериц эти клетки вырабатывают молекулярный сигнал, блокирующий
//        |формирование скелета и нервов, но стимулирующий рост хряща. В итоге получается
//        |не хвост, а просто хрящевая трубка.
//        |Ученые попробовали пересаживать эмбриональные клетки взрослым особям,
//        |но это не помогло. Тогда они применили генетическое редактирование и
//        |сделали эмбриональные клетки устойчивыми к молекулярному сигналу. После этого
//        |ящерицы смогли восстановить нормальный хвост уже во взрослом возрасте.
//        |Теперь исследователи хотят усовершенствовать свой метод и использовать его для
//        |заживления глубоких и трудных ран.""".trimMargin()
//
//    println(alignText(text = NotAlignedText, lineWidth = 100, alignment = Alignment.LEFT))
//    println("=================================================================")
//    println(alignText(text = NotAlignedText, lineWidth = 100, alignment = Alignment.RIGHT))
//    println("=================================================================")
//    println(alignText(text = NotAlignedText, lineWidth = 100, alignment = Alignment.CENTER))
//    println("=================================================================")
//    println(alignText(text = NotAlignedText, lineWidth = 100, alignment = Alignment.JUSTIFY))

//    println(calculate("12    + 3"))
//    println(calculate("-3+4^+4"))
//    println(calculate("(4+3)*9/ -4"))
//    println(calculate("((-4+3))*8/4"))
//    println(calculate("cos(sin(5 + 4/3/1))"))
//    println(calculate("(sin(pi))^2 + (cos(pi))^2"))
//    println(calculate("e-e+e-e+e*(e*e)-e*(e*e)"))

//    val shapeFactory = ShapeFactorImpl()
//    val shapeUtil = ShapeUtil()
//    val shapeList: MutableList<Shape> = arrayListOf()
//    shapeList.add(shapeFactory.createCircle(5.0))
//    shapeList.add(shapeFactory.createRandomCircle())
//
//    shapeList.add(shapeFactory.createSquare(6.0))
//    shapeList.add(shapeFactory.createRandomSquare())
//
//    shapeList.add(shapeFactory.createRectangle(4.0, 8.0))
//    shapeList.add(shapeFactory.createRandomRectangle())
//
//    shapeList.add(shapeFactory.createTriangle(3.0, 4.0, 5.0))
//    shapeList.add(shapeFactory.createRandomTriangle())
//
//    shapeList.add(shapeFactory.createRandomShape())
//
//    println(shapeUtil.calcTotalArea(shapeList))
//    println(shapeUtil.calcTotalPerimeter(shapeList))
//    println(shapeUtil.searchMaxAreaShape(shapeList).javaClass.typeName)
//    println(shapeUtil.searchMinAreaShape(shapeList).javaClass.typeName)
//    println(shapeUtil.searchMaxPerimeterShape(shapeList).javaClass.typeName)
//    println(shapeUtil.searchMinPerimeterShape(shapeList).javaClass.typeName)

    val table = Array(2) { Array(3) { 0 } }
    table[0] = arrayOf(1, 2, 3)     // первая строка таблицы
    table[1] = arrayOf(4, 5, 6)     // вторая строка таблицы
    var A: Matrix = Matrix(table)

    val table2 = Array(3) { Array(2) { 0 } }
    table2[0] = arrayOf(1, 2)     // первая строка таблицы
    table2[1] = arrayOf(3, 4)     // вторая строка таблицы
    table2[2] = arrayOf(5, 6)
    var B: Matrix = Matrix(table2)

    val table3 = Array(2) { Array(3) { 0 } }
    table3[0] = arrayOf(1, 2, 3)     // первая строка таблицы
    table3[1] = arrayOf(4, 5, 6)     // вторая строка таблицы
    var C: Matrix = Matrix(table)

    print((A-C).toString())
}