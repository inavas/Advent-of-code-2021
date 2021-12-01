class DepthMeasurement {
    fun calculate(measurements: List<Int>): Int {

        val result = measurements.zipWithNext{ a, b -> a < b }

    return result.count{ it }
    }

}
