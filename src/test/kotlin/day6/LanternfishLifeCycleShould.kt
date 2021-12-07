package day6

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File

class LanternfishLifeCycleShould {

    @Test
    fun `Calculate quantity of lanternfish after 1 day`(){
        val initialLanternfish = getListFromFile("day6/lanternfish_input_test.txt")

        val lanternfishLifeCycle = LanternfishLifeCycle()
        val days = 1
        val resultingLanternfish = lanternfishLifeCycle.calculateBreeding(initialLanternfish, days)

        val expectedLanternfish = listOf(2,3,2,0,1)
        Assertions.assertThat(resultingLanternfish).isEqualTo(expectedLanternfish)

    }

    private fun getListFromFile(fileName: String): List<String> {
        val uri = this.javaClass.classLoader.getResource(fileName)

        return File(uri.file).useLines { it.toList() }
    }
}