open class Matrix constructor(var matrix: Array<Array<Int>>) {
    init {
        if (matrix.isEmpty() || matrix[0].isEmpty())
            throw Exception("Empty Matrix")
        val constSize = matrix[0].size
        for (i in matrix)
            if (i.size != constSize)
                throw Exception("Wrong Matrix")
    }

    operator fun get(i: Int, j: Int): Int {
        if (i < 0 || j < 0 || i > (this.getDimension().first - 1) || j > (this.getDimension().second - 1))
            throw Exception("Wrong Index")
        return matrix[i][j]

    }

    fun getDimension(): Pair<Int, Int> {
        return Pair(matrix.size, matrix[0].size)
    }

    operator fun plus(other: Matrix): Matrix {
        if (this.getDimension() != other.getDimension())
            throw Exception("Different Dimensions")
        val outMatrix: Array<Array<Int>> = Array(this.getDimension().first) { Array(this.getDimension().second) { 0 } }
        for (i in matrix.indices)
            for (j in matrix[i].indices)
                outMatrix[i][j] = this[i, j] + other[i, j]
        return Matrix(outMatrix)
    }

    operator fun minus(other: Matrix): Matrix {
        if (this.getDimension() != other.getDimension())
            throw Exception("Different Dimensions")
        val outMatrix: Array<Array<Int>> = Array(this.getDimension().first) { Array(this.getDimension().second) { 0 } }
        for (i in matrix.indices)
            for (j in matrix[i].indices)
                outMatrix[i][j] = this[i, j] - other[i, j]
        return Matrix(outMatrix)
    }

    operator fun times(other: Matrix): Matrix {
        if (this.getDimension().second != other.getDimension().first)
            throw Exception("Different Local Dimensions")
        val outMatrix: Array<Array<Int>> = Array(this.getDimension().first) { Array(other.getDimension().second) { 0 } }
        var tempScalar: Int
        for (i in outMatrix.indices) {
            for (j in outMatrix[0].indices) {
                tempScalar = 0
                for (k in matrix[i].indices) {
                    tempScalar += this[i, k] * other[k, j]
                }
                outMatrix[i][j] = tempScalar
            }
        }
        return Matrix(outMatrix)
    }

    override fun toString(): String {
        var outString = ""
        for (i in matrix.indices) {
            for (j in matrix[0].indices)
                outString += matrix[i][j].toString() + " "
            outString += "\n"
        }
        return outString
    }
}

class MutableMatrix constructor(matrix: Array<Array<Int>>) : Matrix(matrix) {
    operator fun set(i: Int, j: Int, value: Int) {
        matrix[i][j] = value
    }

    private fun localSet(other: Matrix) {
        for (i in matrix.indices)
            for (j in matrix[0].indices)
                this[i, j] = other[i, j]
    }

    operator fun plusAssign(other: Matrix) {
        matrix = Array(this.getDimension().first) { Array(this.getDimension().second) { 0 } }
        this.localSet(this + other)
    }

    operator fun minusAssign(other: Matrix) {
        matrix = Array(this.getDimension().first) { Array(this.getDimension().second) { 0 } }
        this.localSet(this - other)
    }

    operator fun timesAssign(other: Matrix) {
        matrix = Array(this.getDimension().first) { Array(other.getDimension().second) { 0 } }
        this.localSet(this * other)
    }


    operator fun unaryMinus(): Matrix {
        TODO("Not yet implemented")
    }

    operator fun unaryPlus(): Matrix {
        return this
    }

    operator fun div(other: Matrix) {
        TODO("Not yet implemented")
    }

    operator fun div(scalar: Int) {
        TODO("Not yet implemented")
    }
}
