class DepthMeasurement {
    fun calculate(measurements: List<Int>): Int {

        val result = measurements.zipWithNext { a, b -> a < b }

        return result.count { it }
    }

    fun calculateSum(measurements: List<Int>): Int {
        val measurementsInBlocksOfThree = measurements.windowed(3, 1)

        val result = measurementsInBlocksOfThree.map { it.sum() }.zipWithNext { a, b -> a < b }

        return result.count { it }
    }

}
