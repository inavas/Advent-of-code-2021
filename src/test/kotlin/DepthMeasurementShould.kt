import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DepthMeasurementShould {

    @Test
    fun `Calculate how quickly depth increases`(){

        val measurements = listOf(199,200,208,210,200,207,240,269,260,263)

        val depthMeasurement = DepthMeasurement()

        val result = depthMeasurement.calculate(measurements)

        assertThat(result).isEqualTo(7)

    }
}