package day2

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File

class SubmarineMovementShould {

    @Test
    fun `Calculate horizontal position and depth`(){
        val movements = getListFromFile("day2/depth_movements_input_test.txt")
        val submarineMovement = SubmarineMovement()

        val (horizontalPosition,depth) = submarineMovement.calculate(movements)

        Assertions.assertThat(horizontalPosition).isEqualTo(15)
        Assertions.assertThat(depth).isEqualTo(10)
    }

    private fun getListFromFile(fileName: String): List<String> {
        val uri = this.javaClass.classLoader.getResource(fileName)

        return File(uri.file).useLines { it.toList() }
    }
}