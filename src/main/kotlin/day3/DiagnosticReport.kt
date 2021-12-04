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

    fun calculatePowerConsumption(gammaRate: String, epsilonRate: String): Int {
        TODO("Not yet implemented")
    }

}
