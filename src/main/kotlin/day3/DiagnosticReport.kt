package day3

import java.util.*

class DiagnosticReport {
    fun calculateBinary(report: List<String>): Pair<String,String> {
        var gammaBinary = ""
        var epsilonBinary = ""

        for (index in 0 until report.first().length){
            val moreCommonNumber = report.map {it.elementAt(index) }.groupingBy { it }.eachCount().maxByOrNull { it.value }?.key
            val lessCommonNumber = report.map {it.elementAt(index) }.groupingBy { it }.eachCount().minByOrNull { it.value }?.key

            gammaBinary += moreCommonNumber
            epsilonBinary +=lessCommonNumber
        }

        return Pair(gammaBinary,epsilonBinary)

    }

    fun calculatePowerConsumption(gammaRate: String, epsilonRate: String): Int =
        gammaRate.binaryToDecimal() * epsilonRate.binaryToDecimal()

    fun calculateOxigenGeneratorRating(report: List<String>): String {
        var report2 = report

        for (index in 0 until report.first().length) {
            val moreCommonNumber = report2.map {it.elementAt(index) }.groupingBy { it }.eachCount().asIterable().reversed().maxByOrNull { it.value }?.key
            report2 = report2.filter { value -> value.elementAt(index).toString() == moreCommonNumber.toString() }
        }

        return report2[0]
    }


}


private fun String.binaryToDecimal(): Int  =
    this.toInt(2)