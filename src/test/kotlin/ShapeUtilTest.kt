import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ShapeUtilTest {


    @Test
    fun calcTotalArea() {
        val shapeFactory = ShapeFactorImpl()
        val shapeUtil = ShapeUtil()
        val shapeList: MutableList<Shape> = arrayListOf()
        shapeList.add(shapeFactory.createCircle(5.0))
        shapeList.add(shapeFactory.createRectangle(4.0, 8.0))
        shapeList.add(shapeFactory.createTriangle(3.0, 4.0, 5.0))
        val result : Double = (25 * Math.PI) + (4 * 8) + 6
        assertEquals(shapeUtil.calcTotalArea(shapeList), result)
    }

    @Test
    fun calcTotalPerimeter() {
        val shapeFactory = ShapeFactorImpl()
        val shapeUtil = ShapeUtil()
        val shapeList: MutableList<Shape> = arrayListOf()
        shapeList.add(shapeFactory.createCircle(5.0))
        shapeList.add(shapeFactory.createRectangle(4.0, 8.0))
        shapeList.add(shapeFactory.createTriangle(3.0, 4.0, 5.0))
        val result : Double = (2 * Math.PI * 5) + (24) + 12
        assertEquals(shapeUtil.calcTotalPerimeter(shapeList), result)
    }

    @Test
    fun searchMinAreaShape() {
        val shapeFactory = ShapeFactorImpl()
        val shapeUtil = ShapeUtil()
        val shapeList: MutableList<Shape> = arrayListOf()
        shapeList.add(shapeFactory.createCircle(5.0))
        shapeList.add(shapeFactory.createRectangle(4.0, 8.0))
        val minAreaShape = shapeFactory.createTriangle(3.0, 4.0, 5.0)
        shapeList.add(minAreaShape)
        assertEquals(shapeUtil.searchMinAreaShape(shapeList), minAreaShape)
    }

    @Test
    fun searchMaxAreaShape() {
        val shapeFactory = ShapeFactorImpl()
        val shapeUtil = ShapeUtil()
        val shapeList: MutableList<Shape> = arrayListOf()
        val maxAreaShape = shapeFactory.createCircle(5.0)
        shapeList.add(maxAreaShape)
        shapeList.add(shapeFactory.createRectangle(4.0, 8.0))
        shapeList.add(shapeFactory.createTriangle(3.0, 4.0, 5.0))
        assertEquals(shapeUtil.searchMaxAreaShape(shapeList), maxAreaShape)
    }

    @Test
    fun searchMinPerimeterShape() {
        val shapeFactory = ShapeFactorImpl()
        val shapeUtil = ShapeUtil()
        val shapeList: MutableList<Shape> = arrayListOf()
        shapeList.add(shapeFactory.createCircle(5.0))
        shapeList.add(shapeFactory.createRectangle(4.0, 8.0))
        val minPerimeterShape = shapeFactory.createTriangle(3.0, 4.0, 5.0)
        shapeList.add(minPerimeterShape)
        assertEquals(shapeUtil.searchMinPerimeterShape(shapeList), minPerimeterShape)
    }

    @Test
    fun searchMaxPerimeterShape() {
        val shapeFactory = ShapeFactorImpl()
        val shapeUtil = ShapeUtil()
        val shapeList: MutableList<Shape> = arrayListOf()
        val maxPerimeterShape = shapeFactory.createCircle(5.0)
        shapeList.add(maxPerimeterShape)
        shapeList.add(shapeFactory.createRectangle(4.0, 8.0))
        shapeList.add(shapeFactory.createTriangle(3.0, 4.0, 5.0))
        assertEquals(shapeUtil.searchMaxPerimeterShape(shapeList), maxPerimeterShape)
    }
}