package day2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.io.File

class SubmarineMovementShould {

    @Test
    fun `Calculate horizontal position and depth`(){
        val movements = getListFromFile("day2/depth_movements_input_test.txt")
        val submarineMovement = SubmarineMovement()

        val (horizontalPosition,depth) = submarineMovement.calculate(movements)

        assertThat(horizontalPosition).isEqualTo(15)
        assertThat(depth).isEqualTo(10)
    }

    @Test
    fun `Calculate total depth`(){
        val movements = getListFromFile("day2/depth_movements_input_test.txt")
        val submarineMovement = SubmarineMovement()

        val (horizontalPosition,depth) = submarineMovement.calculate(movements)

        val totalDepth = submarineMovement.calculateTotalDepth(horizontalPosition, depth)

        assertThat(totalDepth).isEqualTo(150)
    }

    @Test
    fun `Calculate horizontal position and depth with aim`(){
        val movements = getListFromFile("day2/depth_movements_input_test.txt")
        val submarineMovement = SubmarineMovement()

        val (horizontalPosition,depth) = submarineMovement.calculateWithAim(movements)

        assertThat(horizontalPosition).isEqualTo(15)
        assertThat(depth).isEqualTo(60)
    }

    @Test
    fun `Calculate total depth with aim`(){
        val movements = getListFromFile("day2/depth_movements_input_test.txt")
        val submarineMovement = SubmarineMovement()

        val (horizontalPosition,depth) = submarineMovement.calculateWithAim(movements)
        val totalDepth = submarineMovement.calculateTotalDepth(horizontalPosition, depth)

        assertThat(totalDepth).isEqualTo(900)
    }

    private fun getListFromFile(fileName: String): List<String> {
        val uri = this.javaClass.classLoader.getResource(fileName)

        return File(uri.file).useLines { it.toList() }
    }
}