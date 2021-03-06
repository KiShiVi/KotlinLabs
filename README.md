# KotlinLabs

---

## Table of contents

0. [Description](#description)
1. [Lab #1 - AligningText](#lab1)
2. [Lab #2 - Calculator](#lab2)
3. [Lab #3 - ShapeFactory](#lab3)
4. [Lab #4 - Matrix](#lab4)
5. [Lab #5 - LibraryService](#lab5)
6. [Lab #6 - ShapeCollector](#lab6)

---

## Description <a name = "description"></a>

This repository is intended for laboratory work on the "Programming in Kotlin" discipline.

At the moment, 5 laboratory works are presented here:

- **Lab #1**: Aligning Text
- **Lab #2**: Calculator
- **Lab #3**: Shape Factory
- **Lab #4**: Matrix
- **Lab #5**: Library Service

---
---

## Lab #1 - Aligning Text <a name = "lab1"></a>

---

### Task

Given multiline text and page width in characters. It is necessary to "implement" align to the left, right, edge, center, or width.

---

### Rules

- If the next word does not completely fit into the line, it must be wrapped
- If the word is longer than the size of the line, it must be wrapped character by character. The hyphen "-" can be omitted
- When aligning to the left, there should be no spaces at the beginning of the line
- When right-aligned, there should be no spaces at the end of the line
- When aligning to the width, there should be no spaces at the beginning and end of the line.
- The punctuation mark after the word should not be wrapped
- When formatting in width, the width of spaces between words within one line should not differ by more than 1
- The source text is formatted correctly, that is, not extra spaces between words and before punctuation marks

---

### API

```Kotlin
fun alignText(
    text: String,
    lineWidth: Int = 120,
    alignment: Alignment = Alignment.LEFT
): String
```

This method returns aligned text

***text: String*** - input text

***lineWidth: Int*** - formatting width

***alignment: Alignment*** - formatting type

---
---

## Lab #2 - Calculator <a name = "lab2"></a>

---

### Task

Implement a simple calculator of algebraic expressions (e.g. based on the reverse polish notation algorithm) passed as a string

---

### Rules

- The expression can contain any number of parentheses - (,)
- Must support binary operations +, -, *, /, ^
- Unary minus, unary plus
- There can be any number of spaces between the signs of operations and operands
- If an incorrect expression that cannot be parsed is passed, an exception should be thrown
- Add support for sin, cos, tg, ctg, lg, ln functions
- Add support for constants pi, e
- Add unit tests for the resulting code.

---

### Examples of valid expressions

- 12+ 3
- -3+4^+4
- (4+3)*9/ -4
- ((-4+3))*8/4

### Examples of invalid expressions

- (-3+9))*30
- +4 */ 33
- *3 + 3
- 3+alksdjfklsdjfkldj+asdfd+3

---

### API

```fun calculate(infixPhrase: String): Double```

Returns the result of an expression

***infixPhrase: String*** - input expression *(Example: "((-4+3))\*8/4")*

---
---

## Lab #3 - Shape Factory <a name = "lab3"></a>

---

### Task

Implement a set of classes describing a hierarchy of geometric shapes (circle, square, rectangle, triangle). For each shape, an interface must be implemented with methods for calculating the perimeter and area of ??????the shape.

Implement the ShapeFactory class with methods for creating shapes of all types according to the passed parameters, as well as methods that allow you to create a shape of each type with random sizes and a method that allows you to create a random shape.

All created shapes must be correct (for example, a square with a side of negative size is not correct)

---

### API

---

#### ShapeFactory

```ShapeFactorImpl()``` - ShapeFactory Constructor

```createCircle(radius: Double): Circle``` - creates a circle

***radius: Double*** - radius of circle

```createSquare(a: Double): Square``` - creates a square

***a: Double*** - side length of a square

```createRectangle(a: Double, b: Double): Rectangle``` - creates a rectangle

***a: Double*** - length of the rectangle

***b: Double*** - width of the rectangle

```createTriangle(a: Double, b: Double, c: Double): Triangle``` - creates a triangle

***a: Double*** - first side of triangle

***b: Double*** - second side of triangle

***c: Double*** - third side of triangle

```createRandomCircle(): Circle``` - creates a random circle

```createRandomSquare(): Square``` - creates a random square

```createRandomRectangle(): Rectangle``` - creates a random rectangle

```createRandomTriangle(): Triangle``` - creates a random triangle

```createRandomShape(): Shape``` - creates a random shape

---

#### ShapeUtil



*for the following methods' argument - `shapes: List<Shape>` - list of shapes*

```calcTotalArea(shapes: List<Shape>): Double``` - total area search

```calcTotalPerimeter(shapes: List<Shape>): Double``` - total perimeter search

```searchMinAreaShape(shapes: List<Shape>): Shape?``` - search for a figure with a minimum area. Null if the input list is empty

```searchMaxAreaShape(shapes: List<Shape>): Shape?``` - search for a figure with a maximum area. Null if the input list is empty

```searchMinPerimeterShape(shapes: List<Shape>): Shape?``` - search for a figure with a minimum perimeter. Null if the input list is empty

```searchMaxPerimeterShape(shapes: List<Shape>): Shape?``` - search for a figure with a maximum perimeter. Null if the input list is empty

---
#### Shapes

```Kotlin
interface Shape {
    fun calcArea(): Double
    fun calcPerimeter(): Double
}

class Circle(val radius: Double) : Shape
class Square(val a: Double) : Shape
class Rectangle(val a: Double, val b: Double) : Shape
class Triangle(val a: Double, val b: Double, val c: Double) : Shape
```

---
---

## Lab #4 - Matrix <a name = "lab4"></a>

---

### Task

It is necessary to implement a class for working with two-dimensional matrices (you can choose any numeric data type for matrix elements)

The class should provide capabilities for:

- Matrix initialization
- Viewing the value of the element at position (i, j) and changing this element through the [] operator
- View matrix dimensions
- Performing arithmetic operations on matrices using the operators +, -, *, + =, - +, * =. Clarification: the ???+??? operator must create a new matrix and does not change the state of the matrices to the left and right of the operator. The ???+ =??? operator must modify the matrix on the left (see the hint). Likewise for other pairs of operators.
- Multiplication / division of a matrix by a scalar through the operators *, /, * =, / =
- Using the unary plus and minus operators
- Comparing two matrices ==
- Outputting the matrix state to a string - toString ()
- Divide the implementation into a hierarchy of immutable and mutable matrices (Matrix, MutableMatrix)

---

### API

---

#### Matrix

```Matrix(inMatrix: Array<Array<Double>>)``` - matrix constructor

***inMatrix: Array\<Array\<Double\>\>*** - input two-dimensional array, which is a matrix

```getDimension(): Pair<Int, Int>``` - get dimension of Matrix

The following operators are overloaded in the matrix:

- [] ```operator fun get(i: Int, j: Int): Double```
- \+ ```operator fun plus(other: Matrix): Matrix```
- \+ ```operator fun unaryPlus(): Matrix```
- \- ```operator fun minus(other: Matrix): Matrix```
- \- ```operator fun unaryMinus(): Matrix```
- \* ```operator fun times(other: Matrix): Matrix```
- \* ```operator fun times(scalar: Double): Matrix```
- / ```operator fun div(scalar: Double): Matrix```
- == ```fun equals(other: Any?): Boolean```
- *toString()*
- *hashCode()*

---

#### MutableMatrix: Matrix(matrix)


```MutableMatrix(inMatrix: Array<Array<Double>>)``` - mutable matrix constructor

***inMatrix: Array\<Array\<Double\>\>*** - input two-dimensional array, which is a matrix

```getDimension(): Pair<Int, Int>``` - get dimension of Matrix

The following operators are overloaded in the matrix:

- = ```operator fun set(i: Int, j: Int, value: Double)```
- += ```operator fun plusAssign(other: Matrix)```
- \-= ```operator fun minusAssign(other: Matrix)```
- \*= ```operator fun timesAssign(other: Matrix)```
- \*= ```operator fun timesAssign(scalar: Double)```
- / ```operator fun divAssign(scalar: Double)```

---
### Example

```Kotlin
    val table = Array(2) { Array(3) { 0.0 } }
    table[0] = arrayOf(1.0, 2.0, 3.0)
    table[1] = arrayOf(4.0, 5.0, 6.0)
    val a = MutableMatrix(table)

    val table2 = Array(3) { Array(2) { 0.0 } }
    table2[0] = arrayOf(1.0, 2.0)
    table2[1] = arrayOf(3.0, 4.0)
    table2[2] = arrayOf(5.0, 6.0)
    val b = Matrix(table2)

    val table3 = Array(2) { Array(3) { 0.0 } }
    table3[0] = arrayOf(1.0, 2.0, 3.0)
    table3[1] = arrayOf(4.0, 5.0, 6.0)
    val c = Matrix(table3)

    println("Matrix A:\n${a.toString()}")
    println("Position [0,0] in A is ${a[0, 0]}\n")
    println("A + C is:\n${(a + c).toString()}")
    println("A - C is:\n${(a - c).toString()}")
    println("A * B is:\n${(a * b).toString()}")
    println("B * A is:\n${(b * a).toString()}")
    println("A == C? ${a == c}\n")
    println("Set 2.0 to [0, 0] in A")
    a[0, 0] = 2.0
    println("Matrix A:\n${a.toString()}")
    println("A / 5.0\n")
    println("Matrix A:\n${(a/5.0).toString()}")
    println("A == C? ${a == c}\n")
```

---
---

## Lab #5 - LibraryService <a name = "lab5"></a>

---

### Task

Implement the "Library" service model.

The library has books, each book has a title, list of authors, genre and year of publication.
The library has users, each of them has a first and last name.

Each book in the library can have one of the statuses:
- available,
- used by user% user_name%,
- admission is expected,
- on restoration

Implement a service with the following capabilities:
- Register new users and delete existing ones.
- Add new books
- View a list of all books
- View a list of all available books
- View the current status of all books
- Search for books by author, title, genre, year of publication
- Give out the book to the user
- Return the book to the library
- Send the book for restoration
- Add information that a book will soon be available in the library.

Restrictions:
- For simplicity, we assume that each book exists in a single copy.
- You cannot give one user more than three books per hand
- All operations must check the possibility of their execution and check the integrity of the data (for example, you cannot check out a book to an unregistered user or check out a book that is not available)

Technical limitations:
- All classes with data (Author, Book, User, Status) must be immutable

Addition:
- Implement all findBooks functions as one function with default parameters
- Add unit tests

---

### API

---

#### Data Classes

```data class Book (val title: String, val author: Author, val genre: Genre, val year: Year)```

```data class Author (val name: String)```

```data class User (val name: String)```

```data class Year (val year: Int)```

---

#### LibraryService

```Library()``` - library constructor

```findBooks(title: String? = null, author: Author? = null, year: Year? = null, genre: Genre? = null): List<Book>```

***title: String?*** - book title

***author: Author?*** - book author

***year: Year?*** - year of publication of the book

***genre: Genre?*** - book genre

Search for a book by parameters. Searches only by the specified parameters - ignores the rest. Returns a list of found books


```getAllBooks(): List<Book>``` - returns a list of all books

```getAllAvailableBooks(): List<Book>``` - returns a list of all available books

```getBookStatus(book: Book): Status?``` - returns the status of the book. *NULL* if the book is not found

```getAllBookStatuses(): Map<Book, Status>``` - returns all books and their statuses

```setBookStatus(book: Book, status: Status)``` - assigns the status to the book

```addBook(book: Book, status: Status = Status.Available)``` - adds a book

```registerUser(user: User): User?``` - registers a new user. returns NULL if user already exists or new User

```unregisterUser(user: User): User?``` - removes the user from the database. returns NULL if user does not exist or User

```takeBook(user: User, book: Book): Book?``` - give the user a book. NULL if the book was not issued or Book

```returnBook(book: Book)``` - returns the book to the library

---

### Example

```Kotlin
    val library: LibraryService = Library()

    library.addBook(Book("???????????? ??????????", Author("?????????? ??????????"), Genre.DETECTIVE, Year(1892)), Status.Available)
    library.addBook(Book("???????????? ??????????", Author("?????????? ??????????"), Genre.DETECTIVE, Year(1893)), Status.Available)
    library.addBook(Book("???????????? ??????????", Author("?????????? ??????????"), Genre.DETECTIVE, Year(1903)), Status.Available)
    library.addBook(Book("??????????????", Author("???????????? ??????????"), Genre.RELIGIOUS, Year(1903)), Status.Available)
    library.addBook(Book("???????????????????? ???? ??????????????????", Author("???????????? ??????????"), Genre.FANTASY, Year(1979)), Status.Available)
    library.addBook(Book("??????????", Author("?????????? ??????????????????????"), Genre.NOVEL, Year(1868)), Status.Available)
    library.addBook(Book("????????????", Author("??????"), Genre.RELIGIOUS, Year(1228)), Status.Available)
    library.addBook(Book("???????????? ??????", Author("???????????? ????????????"), Genre.TECHNICAL, Year(2008)), Status.Available)

    val result: List<Book> = library.findBooks(genre = Genre.RELIGIOUS)

    for (i in result)
        println(i)
```


## Lab #6 - ShapeCollector <a name = "lab6"></a>

---

### Task

Using the code from work # 3, implement a ShapeCollector class to store shapes using Generics. Use the Shape interface as the upper bound for the type parameter.
The class should provide the following methods:

- ```add``` - adds a shape to the collector
- ```addAll``` - adds a collection of shapes to the collector
- ```getAll``` - Returns a list of all shapes that are stored in the collector
- ```getAllSorted``` - Returns all the shapes that are stored in the collector, sorted using the Comparator passed to the method
- ```getAllByClass``` - only returns the shapes of the class that is passed to this method as a parameter
- Implement comparators to sort a list of shapes by area and by perimeter in ascending and descending order. Move the implemented comparators into a separate ShapeComparators object.
- Implement comparators to sort circles by radius in ascending and descending order and put them in ShapeComparators.

---

### API

---

#### ShapeComparator

```Kotlin
object ShapeComparator {
val perimeterComparator = compareBy<Shape> { it.calcPerimeter() }
val perimeterComparatorDesc = compareByDescending<Shape> { it.calcPerimeter() }
val areaComparator = compareBy<Shape> { it.calcArea() }
val areaComparatorDesc = compareByDescending<Shape> { it.calcArea() }
val radiusComparator = compareBy<Circle> { it.radius }
val radiusComparatorDesc = compareByDescending<Circle> { it.radius }
}
```

This object presents different types of ShapeCollector sorting

---

#### class ShapeCollector\<T : Shape\>

```fun add(new: T)``` - adds a new shape to the collector

```fun addAll(new: Collection<T>)``` - adds shapes from the collection to the collector

```fun getAll(): List<T>``` - returns a list of all shapes in the collector

```fun getAllSorted(comparator: Comparator<in T>): List<T>``` - returns a sorted list of all shapes in the collector

```fun getAllByClass(shapeClass: Class<out T>): List<T>``` - only returns the shapes of the class that is passed to this method as a parameter

---

### Example

```Kotlin
val shapeFactory = ShapeFactorImpl()
val shapeCollector = ShapeCollector<Shape>()
val circleCollector = ShapeCollector<Circle>()

shapeCollector.add(shapeFactory.createCircle(5.0))
shapeCollector.add(shapeFactory.createSquare(6.0))
shapeCollector.add(shapeFactory.createRectangle(4.0, 8.0))
shapeCollector.add(shapeFactory.createTriangle(3.0, 4.0, 5.0))
shapeCollector.add(shapeFactory.createRandomShape())

circleCollector.add(shapeFactory.createCircle(5.0))
circleCollector.add(shapeFactory.createCircle(4.0))
circleCollector.add(shapeFactory.createCircle(10.0))

//circleCollector.add(shapeFactory.createRectangle(4.0, 8.0)) !!! Will not compile

for ( i in shapeCollector.getAllSorted(ShapeComparator.perimeterComparator))
    println(i.toString() + " " + i.calcPerimeter())
println("---------------------------")

//    for ( i in shapeCollector.getAllSorted(ShapeComparator.radiusComparator)) !!! Will not compile
//        println(i.toString() + " " + i.calcArea())
//    println("---------------------------")

for ( i in circleCollector.getAllSorted(ShapeComparator.radiusComparator))
    println(i.toString() + " " + i.calcArea())
println("---------------------------")

for ( i in shapeCollector.getAllByClass(Square::class.java))
    println(i.toString())
}
```