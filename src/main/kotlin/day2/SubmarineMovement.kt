package day2

class SubmarineMovement {

    fun calculate(movements: List<String>): Pair<Int, Int> {

        val horizontalPosition = movements.filter { command -> command.contains("forward") }
                                        .map { value -> value.last().toString().toInt() }
                                        .sum()

        var depthDown = movements.filter { command -> command.contains("down") }
            .map { value -> value.last().toString().toInt() }
            .sum()

        val depthUp = movements.filter { command -> command.contains("up") }
            .map { value -> value.last().toString().toInt() }
            .sum()

        return Pair(horizontalPosition,depthDown-depthUp)
    }



}
