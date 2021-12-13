package day8

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File

class SevenSegmentDisplayShould {

    @Test
    fun `Count how many times do digits 1,4,7,8 appears`(){
        val signalInput = getListFromFile("day8/signal_input_test.txt")

        val sevenSegmentDisplay = SevenSegmentDisplay()
        val numberOfTimes = sevenSegmentDisplay.countHowManyTimes1478Appears(signalInput)
        Assertions.assertThat(numberOfTimes).isEqualTo(26)
    }

    private fun getListFromFile(fileName: String): List<String> {
        val uri = this.javaClass.classLoader.getResource(fileName)

        return File(uri.file).useLines { it.toList() }
    }
}