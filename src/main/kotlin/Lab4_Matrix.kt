open class Matrix constructor(private var inMatrix: Array<Array<Double>>) {
    protected var matrix: Array<Array<Double>> = emptyArray()

    init {
        if (inMatrix.isEmpty() || inMatrix[0].isEmpty())
            throw IllegalArgumentException("Empty Matrix")
        val constSize = inMatrix[0].size
        matrix = Array(inMatrix.size) { Array(inMatrix[0].size) { 0.0 } }
        for (i in inMatrix)
            if (i.size != constSize)
                throw IllegalArgumentException("Wrong Matrix")
        for (i in inMatrix.indices)
            for (j in inMatrix[0].indices)
                matrix[i][j] = inMatrix[i][j]
    }

    operator fun get(i: Int, j: Int): Double {
        if (i < 0 || j < 0 || i > (this.getDimension().first - 1) || j > (this.getDimension().second - 1))
            throw IndexOutOfBoundsException("Wrong Index")
        return matrix[i][j]

    }

    fun getDimension(): Pair<Int, Int> {
        return Pair(matrix.size, matrix[0].size)
    }

    open operator fun plus(other: Matrix): Matrix {
        if (this.getDimension() != other.getDimension())
            throw IllegalArgumentException("Different Dimensions")
        val outMatrix: Array<Array<Double>> =
            Array(this.getDimension().first) { Array(this.getDimension().second) { 0.0 } }
        for (i in matrix.indices)
            for (j in matrix[i].indices)
                outMatrix[i][j] = this[i, j] + other[i, j]
        return Matrix(outMatrix)
    }

    open operator fun minus(other: Matrix): Matrix {
        if (this.getDimension() != other.getDimension())
            throw IllegalArgumentException("Different Dimensions")
        val outMatrix: Array<Array<Double>> =
            Array(this.getDimension().first) { Array(this.getDimension().second) { 0.0 } }
        for (i in matrix.indices)
            for (j in matrix[i].indices)
                outMatrix[i][j] = this[i, j] - other[i, j]
        return Matrix(outMatrix)
    }

    open operator fun times(other: Matrix): Matrix {
        if (this.getDimension().second != other.getDimension().first)
            throw IllegalArgumentException("Different Local Dimensions")
        val outMatrix: Array<Array<Double>> =
            Array(this.getDimension().first) { Array(other.getDimension().second) { 0.0 } }
        var tempScalar: Double
        for (i in outMatrix.indices) {
            for (j in outMatrix[0].indices) {
                tempScalar = 0.0
                for (k in matrix[i].indices) {
                    tempScalar += this[i, k] * other[k, j]
                }
                outMatrix[i][j] = tempScalar
            }
        }
        return Matrix(outMatrix)
    }

    open operator fun div(scalar: Double): Matrix {
        val outMatrix: Array<Array<Double>> =
            Array(this.getDimension().first) { Array(this.getDimension().second) { 0.0 } }
        for (i in matrix.indices)
            for (j in matrix[0].indices)
                outMatrix[i][j] = this[i, j] / scalar
        return Matrix(outMatrix)
    }

    open operator fun times(scalar: Double): Matrix {
        val outMatrix: Array<Array<Double>> =
            Array(this.getDimension().first) { Array(this.getDimension().second) { 0.0 } }
        for (i in matrix.indices)
            for (j in matrix[0].indices)
                outMatrix[i][j] = this[i, j] * scalar
        return Matrix(outMatrix)
    }

    open operator fun unaryMinus(): Matrix {
        val outMatrix: Array<Array<Double>> =
            Array(this.getDimension().first) { Array(this.getDimension().second) { 0.0 } }
        for (i in matrix.indices)
            for (j in matrix[0].indices)
                outMatrix[i][j] = -this[i, j]
        return Matrix(outMatrix)
    }

    open operator fun unaryPlus(): Matrix {
        return this
    }

    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Matrix)
            return false

        if (this.getDimension() != other.getDimension())
            return false

        for (i in matrix.indices)
            for (j in matrix[0].indices)
                if (this[i, j] != other[i, j]) return false

        return true
    }

    private operator fun set(i: Int, j: Int, value: Double) {
        matrix[i][j] = value
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

    internal fun getArray(): Array<Array<Double>> {
        return matrix
    }

    override fun hashCode(): Int {
        var result = inMatrix.contentDeepHashCode()
        result = 31 * result + matrix.contentDeepHashCode()
        return result
    }
}

class MutableMatrix constructor(matrix: Array<Array<Double>>) : Matrix(matrix) {
    operator fun set(i: Int, j: Int, value: Double) {
        matrix[i][j] = value
    }

    private fun localSet(other: Matrix) {
        for (i in matrix.indices)
            for (j in matrix[0].indices)
                this[i, j] = other[i, j]
    }

    override operator fun plus(other: Matrix): MutableMatrix {
        return MutableMatrix((other + this).getArray())
    }

    override operator fun minus(other: Matrix): MutableMatrix {
        return MutableMatrix((other - this).getArray())
    }

    override operator fun times(other: Matrix): MutableMatrix {
        return MutableMatrix((other * this).getArray())
    }

    override operator fun times(scalar: Double): MutableMatrix {
        return MutableMatrix((Matrix(this.getArray()) * scalar).getArray())
    }

    override operator fun div(scalar: Double): MutableMatrix {
        return MutableMatrix((Matrix(this.getArray()) / scalar).getArray())
    }

    override operator fun unaryMinus(): MutableMatrix {
        return MutableMatrix(Matrix(this.getArray()).unaryMinus().getArray())
    }

    override operator fun unaryPlus(): MutableMatrix {
        return this
    }

    operator fun plusAssign(other: Matrix){
        localSet(this + other)
    }

    operator fun minusAssign(other: Matrix){
        localSet(this - other)
    }

    operator fun timesAssign(other: Matrix){
        val tempMatrix = this * other
        matrix = Array(tempMatrix.getDimension().first) { Array(tempMatrix.getDimension().second) { 0.0 } }
        localSet(tempMatrix)
    }

    operator fun timesAssign(scalar: Double){
        localSet(this * scalar)
    }

    operator fun divAssign(scalar: Double){
        localSet(this / scalar)
    }
}
