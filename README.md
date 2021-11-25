# KotlinLabs

---

## Description

This repository is intended for laboratory work on the "Programming in Kotlin" discipline.

At the moment, 5 laboratory works are presented here:

- **Lab #1**: Aligning Text
- **Lab #2**: Calculator
- **Lab #3**: Shape Factory
- **Lab #4**: Matrix
- **Lab #5**: Library Service

---
---

## Lab #1 - Aligning Text

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

```
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

## Lab #2 - Calculator

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

***infixPhrase: String*** - input expression *(Exmaple: "((-4+3))\*8/4")*

---
---

## Lab #3 - Shape Factory

---

### Task

Implement a set of classes describing a hierarchy of geometric shapes (circle, square, rectangle, triangle). For each shape, an interface must be implemented with methods for calculating the perimeter and area of ​​the shape.

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

```
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