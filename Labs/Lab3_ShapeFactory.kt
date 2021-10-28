interface Shape {
    fun calcArea(): Double
    fun calcPerimeter(): Double
}

class Circle constructor(private val radius: Double) : Shape {
    override fun calcArea(): Double {
        TODO("Not yet implemented")
    }

    override fun calcPerimeter(): Double {
        TODO("Not yet implemented")
    }
}

class Square constructor(private val a: Double) : Shape {
    override fun calcArea(): Double {
        TODO("Not yet implemented")
    }

    override fun calcPerimeter(): Double {
        TODO("Not yet implemented")
    }
}

class Rectangle constructor(private val a: Double, private val b: Double) : Shape {
    override fun calcArea(): Double {
        TODO("Not yet implemented")
    }

    override fun calcPerimeter(): Double {
        TODO("Not yet implemented")
    }
}

class Triangle constructor(private val a: Double, private val b: Double, private val c: Double) : Shape {
    init {
        if (a + b <= c || a + c <= b || b + c <= a)
            throw Exception("Triangle with sides $a, $b, $c does not exist")
    }

    override fun calcArea(): Double {
        TODO("Not yet implemented")
    }

    override fun calcPerimeter(): Double {
        TODO("Not yet implemented")
    }
}

interface ShapeFactory {
    fun createCircle(/* parameters */): Circle
    fun createSquare(/* parameters */): Square
    fun createRectangle(/* parameters */): Rectangle
    fun createTriangle(/* parameters */): Triangle

    fun createRandomCircle(): Circle
    fun createRandomSquare(): Square
    fun createRandomRectangle(): Rectangle
    fun createRandomTriangle(): Triangle

    fun createRandomShape(): Shape
}

class ShapeFactorImpl : ShapeFactory {
    override fun createCircle(): Circle {
        TODO("Not yet implemented")
    }

    override fun createSquare(): Square {
        TODO("Not yet implemented")
    }

    override fun createRectangle(): Rectangle {
        TODO("Not yet implemented")
    }

    override fun createTriangle(): Triangle {
        TODO("Not yet implemented")
    }

    override fun createRandomCircle(): Circle {
        TODO("Not yet implemented")
    }

    override fun createRandomSquare(): Square {
        TODO("Not yet implemented")
    }

    override fun createRandomRectangle(): Rectangle {
        TODO("Not yet implemented")
    }

    override fun createRandomTriangle(): Triangle {
        TODO("Not yet implemented")
    }

    override fun createRandomShape(): Shape {
        TODO("Not yet implemented")
    }
}
