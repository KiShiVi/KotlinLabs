import Lab5_LibraryService.*

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
//    println(shapeUtil.searchMaxAreaShape(shapeList)?.javaClass?.typeName)
//    println(shapeUtil.searchMinAreaShape(shapeList)?.javaClass?.typeName)
//    println(shapeUtil.searchMaxPerimeterShape(shapeList)?.javaClass?.typeName)
//    println(shapeUtil.searchMinPerimeterShape(shapeList)?.javaClass?.typeName)
//
//    val table = Array(2) { Array(3) { 0.0 } }
//    table[0] = arrayOf(1.0, 2.0, 3.0)
//    table[1] = arrayOf(4.0, 5.0, 6.0)
//    val a = MutableMatrix(table)
//
//    val table2 = Array(3) { Array(2) { 0.0 } }
//    table2[0] = arrayOf(1.0, 2.0)
//    table2[1] = arrayOf(3.0, 4.0)
//    table2[2] = arrayOf(5.0, 6.0)
//    val b = Matrix(table2)
//
//    val table3 = Array(2) { Array(3) { 0.0 } }
//    table3[0] = arrayOf(1.0, 2.0, 3.0)
//    table3[1] = arrayOf(4.0, 5.0, 6.0)
//    val c = Matrix(table3)
//
//    println("Matrix A:\n${a.toString()}")
//    println("Position [0,0] in A is ${a[0, 0]}\n")
//    println("A + C is:\n${(a + c).toString()}")
//    println("A - C is:\n${(a - c).toString()}")
//    println("A * B is:\n${(a * b).toString()}")
//    println("B * A is:\n${(b * a).toString()}")
//    println("A == C? ${a == c}\n")
//    println("Set 2.0 to [0, 0] in A")
//    a[0, 0] = 2.0
//    println("Matrix A:\n${a.toString()}")
//    println("A / 5.0\n")
//    println("Matrix A:\n${(a/5.0).toString()}")
//    println("A == C? ${a == c}\n")
//
//    val library: LibraryService = Library()
//
//    library.addBook(Book("Шерлок Холмс", Author("Конан Дойль"), Genre.DETECTIVE, Year(1892)), Status.Available)
//    library.addBook(Book("Шерлок Холмс", Author("Конан Дойль"), Genre.DETECTIVE, Year(1893)), Status.Available)
//    library.addBook(Book("Шерлок Холмс", Author("Конан Дойль"), Genre.DETECTIVE, Year(1903)), Status.Available)
//    library.addBook(Book("Человек", Author("Иоганн Ранке"), Genre.RELIGIOUS, Year(1903)), Status.Available)
//    library.addBook(Book("Автостопом по галактике", Author("Дуглас Адамс"), Genre.FANTASY, Year(1979)), Status.Available)
//    library.addBook(Book("Идиот", Author("Федор Достоевский"), Genre.NOVEL, Year(1868)), Status.Available)
//    library.addBook(Book("Библия", Author("Бог"), Genre.RELIGIOUS, Year(1228)), Status.Available)
//    library.addBook(Book("Чистый код", Author("Роберт Мартин"), Genre.TECHNICAL, Year(2008)), Status.Available)
//
//    val result: List<Book> = library.findBooks(genre = Genre.RELIGIOUS)
//
//    for (i in result)
//        println(i)
}