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
        val diagnosticReport = DiagnosticReport()

        val powerConsumption = diagnosticReport.calculatePowerConsumption(gammaRate, epsilonRate)
        assertThat(powerConsumption).isEqualTo(198)
    }

    @Test
    fun `Calculate oxigen generator rating`(){
        val report = getListFromFile("day3/diagnostic_report_test.txt")

        val diagnosticReport = DiagnosticReport()

        val oxygenGeneratorRating = diagnosticReport.calculateOxygenGeneratorRating(report)

        assertThat(oxygenGeneratorRating).isEqualTo("10111")
    }


    @Test
    fun `Calculate CO2 scrubber rating`(){
        val report = getListFromFile("day3/diagnostic_report_test.txt")

        val diagnosticReport = DiagnosticReport()

        val co2GeneratorRating = diagnosticReport.calculateCO2ScrubberRating(report)

        assertThat(co2GeneratorRating).isEqualTo("01010")
    }

    @Test
    fun `Calculate life support rating`(){
        val report = getListFromFile("day3/diagnostic_report_test.txt")

        val diagnosticReport = DiagnosticReport()

        val oxygenGeneratorRating = diagnosticReport.calculateOxygenGeneratorRating(report)
        val co2GeneratorRating = diagnosticReport.calculateCO2ScrubberRating(report)

        val powerConsumption = diagnosticReport.calculateLifeSupportRating(oxygenGeneratorRating, co2GeneratorRating)
        assertThat(powerConsumption).isEqualTo(230)
    }


    private fun getListFromFile(fileName: String): List<String> {
        val uri = this.javaClass.classLoader.getResource(fileName)

        return File(uri.file).useLines { it.toList() }
    }
}