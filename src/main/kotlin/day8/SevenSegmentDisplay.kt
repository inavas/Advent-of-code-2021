package day8

class SevenSegmentDisplay {
    fun countHowManyTimes1478Appears(signalInput: List<String>): Int {
        val numbersInput = signalInput.map { it.split("|") }
        val numbers = numbersInput.map { it[1].trimStart().split(" ") }

        var quantityOfNumbers = 0
        for (number in numbers){
            quantityOfNumbers += number.filter {
                (isNumberOne(it)) or (isNumberFour(it)) or (isNumberSeven(it)) or (isNumberEight(it))
            }.count()
        }

        return quantityOfNumbers
    }

    private fun isNumberEight(it: String) = it.length == 7

    private fun isNumberSeven(it: String) = it.length == 3

    private fun isNumberFour(it: String) = it.length == 4

    private fun isNumberOne(it: String) = it.length == 2

}
