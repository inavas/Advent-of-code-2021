package day3

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
        var resultingReport = report

        for (index in 0 until report.first().length) {
            val moreCommonNumber = resultingReport.map {it.elementAt(index) }.groupingBy { it }.eachCount().asIterable().reversed().maxByOrNull { it.value }?.key
            resultingReport = resultingReport.filter { value -> value.elementAt(index).toString() == moreCommonNumber.toString() }
        }

        return resultingReport[0]
    }

    fun calculateCO2ScrubberRating(report: List<String>): String {
        var resultingReport = report

        for (index in 0 until report.first().length) {
            val moreCommonNumber = resultingReport.map {it.elementAt(index) }.groupingBy { it }.eachCount().toSortedMap().minByOrNull { it.value }?.key
            resultingReport = resultingReport.filter { value -> value.elementAt(index).toString() == moreCommonNumber.toString() }
        }

        return resultingReport[0]
    }

    fun calculateLifeSupportRating(oxygenGeneratorRate: String, co2ScrubberRate: String): Int {
        TODO("Not yet implemented")
    }


}


private fun String.binaryToDecimal(): Int  =
    this.toInt(2)