package day2

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class SubmarineMovementShould {

    @Test
    fun `Calculate horizontal position and depth`(){
        val movements = listOf("forward 5","down 5","forward 8","up 3","down 8","forward 2")
        val submarineMovement = SubmarineMovement()

        val (horizontalPosition,depth) = submarineMovement.calculate(movements)

        Assertions.assertThat(horizontalPosition).isEqualTo(15)
        Assertions.assertThat(depth).isEqualTo(10)
    }
}