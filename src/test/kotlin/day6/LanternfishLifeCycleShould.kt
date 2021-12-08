package day6

import org.assertj.core.api.Assertions.assertThat
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
        assertThat(resultingLanternfish).isEqualTo(expectedLanternfish)
        assertThat(resultingLanternfish.size).isEqualTo(5)
    }

    @Test
    fun `Calculate quantity of lanternfish after 1 day faster`(){
        val initialLanternfish = getListFromFile("day6/lanternfish_input_test.txt")

        val lanternfishLifeCycle = LanternfishLifeCycle()
        val days = 1
        val resultingLanternfish = lanternfishLifeCycle.calculateBreedingFaster(initialLanternfish, days)

        assertThat(resultingLanternfish).isEqualTo(5)
    }


    @Test
    fun `Calculate quantity of lanternfish after 18 days`(){
        val initialLanternfish = getListFromFile("day6/lanternfish_input_test.txt")

        val lanternfishLifeCycle = LanternfishLifeCycle()
        val days = 18
        val resultingLanternfish = lanternfishLifeCycle.calculateBreeding(initialLanternfish, days)
        val totalFishes = resultingLanternfish.size

        val expectedLanternfish = listOf(6,0,6,4,5,6,0,1,1,2,6,0,1,1,1,2,2,3,3,4,6,7,8,8,8,8)

        assertThat(resultingLanternfish).isEqualTo(expectedLanternfish)
        assertThat(totalFishes).isEqualTo(26)
    }

    @Test
    fun `Calculate quantity of lanternfish after 18 days faster`(){
        val initialLanternfish = getListFromFile("day6/lanternfish_input_test.txt")

        val lanternfishLifeCycle = LanternfishLifeCycle()
        val days = 18
        val resultingLanternfish = lanternfishLifeCycle.calculateBreedingFaster(initialLanternfish, days)

        assertThat(resultingLanternfish).isEqualTo(26)
    }

    @Test
    fun `Calculate quantity of lanternfish after 256 days`(){
        val initialLanternfish = getListFromFile("day6/lanternfish_input_test.txt")

        val lanternfishLifeCycle = LanternfishLifeCycle()
        val days = 256
        val resultingLanternfish = lanternfishLifeCycle.calculateBreedingFaster(initialLanternfish, days)

        assertThat(resultingLanternfish).isEqualTo(26984457539)
    }


    private fun getListFromFile(fileName: String): List<String> {
        val uri = this.javaClass.classLoader.getResource(fileName)

        return File(uri.file).useLines { it.toList() }
    }
}