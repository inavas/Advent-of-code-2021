package day7

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File

class FuelCostShould {

    @Test
    fun `Calculate cheapest cost of fuel to align crabs`(){
        val crabsPosition = getListFromFile("day7/crabs_position_test.txt")

        val fuelCost = FuelCost()
        val costOfFuel = fuelCost.calculateMinimumFuelToAlign(crabsPosition)

        Assertions.assertThat(costOfFuel).isEqualTo(37)
    }

    private fun getListFromFile(fileName: String): List<String> {
        val uri = this.javaClass.classLoader.getResource(fileName)

        return File(uri.file).useLines { it.toList() }
    }
}