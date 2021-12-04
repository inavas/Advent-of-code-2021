package day3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.io.File

class DiagnosticReportShould {

    @Test
    fun `Calculate gamma and epsilon rate`(){
        val report = getListFromFile("day3/diagnostic_report_test.txt")

        val diagnosticReport = DiagnosticReport()

        val (gammaRate,epsilonRate) = diagnosticReport.calculateBinary(report)
        assertThat(gammaRate).isEqualTo("10110")
        assertThat(epsilonRate).isEqualTo("01001")
    }

    @Test
    fun `Calculate power consumption`(){
        val gammaRate = "10110"
        val epsilonRate = "01001"
        val diagonsticReport = DiagnosticReport()

        val powerConsumption = diagonsticReport.calculatePowerConsumption(gammaRate, epsilonRate)
        assertThat(powerConsumption).isEqualTo(198)
    }

    @Test
    fun `Calculate oxigen generator rating`(){
        val report = getListFromFile("day3/diagnostic_report_test.txt")

        val diagnosticReport = DiagnosticReport()

        val oxigenGeneratorRating = diagnosticReport.calculateOxigenGeneratorRating(report)

        assertThat(oxigenGeneratorRating).isEqualTo("10111")
    }


    @Test
    fun `Calculate CO2 scrubber rating`(){
        val report = getListFromFile("day3/diagnostic_report_test.txt")

        val diagnosticReport = DiagnosticReport()

        val oxigenGeneratorRating = diagnosticReport.calculateCO2ScrubberRating(report)

        assertThat(oxigenGeneratorRating).isEqualTo("01010")
    }

    @Test
    fun `Calculate life support rating`(){
        val oxygenGeneratorRate = "10110"
        val co2ScrubberRate = "01001"
        val diagonsticReport = DiagnosticReport()

        val powerConsumption = diagonsticReport.calculateLifeSupportRating(oxygenGeneratorRate, co2ScrubberRate)
        assertThat(powerConsumption).isEqualTo(230)
    }


    private fun getListFromFile(fileName: String): List<String> {
        val uri = this.javaClass.classLoader.getResource(fileName)

        return File(uri.file).useLines { it.toList() }
    }
}