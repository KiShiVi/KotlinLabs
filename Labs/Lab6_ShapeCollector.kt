object ShapeComparator {
    val perimeterComparator = compareBy<Shape> { it.calcPerimeter() }
    val perimeterComparatorDesc = compareByDescending<Shape> { it.calcPerimeter() }
    val areaComparator = compareBy<Shape> { it.calcArea() }
    val areaComparatorDesc = compareByDescending<Shape> { it.calcArea() }
    val radiusComparator = compareBy<Circle> { it.radius }
    val radiusComparatorDesc = compareByDescending<Circle> { it.radius }
}

class ShapeCollector<T : Shape> {
    private val allShapes = mutableListOf<T>()

    fun add(new: T) {
        allShapes.add(new)
    }

    fun addAll(new: Collection<T>) {
        for (shape in new)
            allShapes.add(shape)
    }

    fun getAll(): List<T> {
        return allShapes
    }

    fun getAllSorted(comparator: Comparator<in T>): List<T> {
        return getAll().sortedWith(comparator)
    }

    fun getAllByClass(shapeClass: Class<out T>): List<T>{
        val specificShapes = mutableListOf<T>()
        for (shape in allShapes)
            if (shape::class.java == shapeClass)
                specificShapes.add(shape)
        return specificShapes
    }
}