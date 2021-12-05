package day4

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File

class BingoShould {

    @Test
    fun `Calculate first winning row`(){
        val bingoInputs = getListFromFile("day4/bingo_test.txt")
        val expectedWinningRow = listOf("14","21","17","24","4")

        val bingo = Bingo()
        val winningRow = bingo.calculateWinningRow(bingoInputs)

        Assertions.assertThat(winningRow).isEqualTo(expectedWinningRow)
    }

    private fun getListFromFile(fileName: String): List<String> {
        val uri = this.javaClass.classLoader.getResource(fileName)

        return File(uri.file).useLines { it.toList() }
    }
}