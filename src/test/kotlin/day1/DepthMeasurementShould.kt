package day1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.io.File

class DepthMeasurementShould {

    @Test
    fun `Calculate how quickly depth increases`(){
        val measurements = listOf(199,200,208,210,200,207,240,269,260,263)

        val depthMeasurement = DepthMeasurement()

        val result = depthMeasurement.calculate(measurements)

        assertThat(result).isEqualTo(7)
    }

    @Test
    fun `Calculate how quickly depth increases from input file`(){
        val measurements = getIntListFromFile("depth_input_test.txt")

        val depthMeasurement = DepthMeasurement()

        val result = depthMeasurement.calculate(measurements)

        assertThat(result).isEqualTo(7)
    }

    @Test
    fun `Calculate how many sums are larger from previous sums`(){
        val measurements = getIntListFromFile("depth_input_test.txt")

        val depthMeasurement = DepthMeasurement()

        val result = depthMeasurement.calculateSum(measurements)

        assertThat(result).isEqualTo(5)

    }

    private fun getIntListFromFile(fileName: String): List<Int> {
        val uri = this.javaClass.classLoader.getResource(fileName)

        return File(uri.file).useLines { it.toList() }.map { it.toInt() }
    }

}