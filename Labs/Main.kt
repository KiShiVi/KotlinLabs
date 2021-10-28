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

    val shapeFactory = ShapeFactorImpl()
    val shapeUtil = ShapeUtil()
    val shapeList : MutableList<Shape> = arrayListOf()
    shapeList.add(shapeFactory.createCircle(5.0))
    shapeList.add(shapeFactory.createRandomCircle())

    shapeList.add(shapeFactory.createSquare(6.0))
    shapeList.add(shapeFactory.createRandomSquare())

    shapeList.add(shapeFactory.createRectangle(4.0, 8.0))
    shapeList.add(shapeFactory.createRandomRectangle())

    shapeList.add(shapeFactory.createTriangle(3.0, 4.0, 5.0))
    shapeList.add(shapeFactory.createRandomTriangle())

    shapeList.add(shapeFactory.createRandomShape())

    println(shapeUtil.calcTotalArea(shapeList))
    println(shapeUtil.calcTotalPerimeter(shapeList))
    println(shapeUtil.searchMaxAreaShape(shapeList).javaClass.typeName)
    println(shapeUtil.searchMinAreaShape(shapeList).javaClass.typeName)
    println(shapeUtil.searchMaxPerimeterShape(shapeList).javaClass.typeName)
    println(shapeUtil.searchMinPerimeterShape(shapeList).javaClass.typeName)
}