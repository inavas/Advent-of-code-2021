package day3

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File

class DiagnosticReportShould {

    @Test
    fun `Calculate gamma and epsilon rate`(){
        val report = getListFromFile("day3/diagnostic_report_test.txt")

        val diagnosticReport = DiagnosticReport()

        val (gammaRate,epsilonRate) = diagnosticReport.calculateBinary(report)
        Assertions.assertThat(gammaRate).isEqualTo("10110")
        Assertions.assertThat(epsilonRate).isEqualTo("01001")
    }


    private fun getListFromFile(fileName: String): List<String> {
        val uri = this.javaClass.classLoader.getResource(fileName)

        return File(uri.file).useLines { it.toList() }
    }
}