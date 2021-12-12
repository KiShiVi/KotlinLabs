import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ShapeSerializerTest {

    @Test
    fun test_1() {
        val path = "memoryTest1.json"
        val shapeFactory = ShapeFactorImpl()
        val sourceList = mutableListOf(
            shapeFactory.createCircle(2.0),
            shapeFactory.createSquare(5.0))
        FileIO.fileWriter(ShapeSerializer.encode(sourceList), path)

        assertEquals("[{\"type\":\"Circle\",\"radius\":2.0},{\"type\":\"Square\",\"a\":5.0}]", FileIO.fileReader(path))
    }

    @Test
    fun test_2() {
        val path = "memoryTest2.json"
        val shapeFactory = ShapeFactorImpl()
        val sourceList = mutableListOf(
            shapeFactory.createRandomTriangle(),
            shapeFactory.createRandomCircle(),
            shapeFactory.createRandomRectangle())
        FileIO.fileWriter(ShapeSerializer.encode(sourceList), path)

        val inList = ShapeSerializer.decode<MutableList<Shape>>(FileIO.fileReader(path))

        assertEquals(ShapeSerializer.encode(sourceList), ShapeSerializer.encode(inList))
    }

}