package day2

class SubmarineMovement {

    fun calculate(movements: List<String>): Pair<Int, Int> {

        val horizontalPosition = calculateHorizontalPosition(movements)

        val depth = calculateDepth(movements)

        return Pair(horizontalPosition,depth)
    }

    private fun calculateHorizontalPosition(movements: List<String>) =
        movements.filter { command -> command.contains("forward") }
            .map { value -> value.last().toString().toInt() }
            .sum()

    private fun calculateDepth(movements: List<String>): Int {
        var depthDown = movements.filter { command -> command.contains("down") }
            .map { value -> value.last().toString().toInt() }
            .sum()

        val depthUp = movements.filter { command -> command.contains("up") }
            .map { value -> value.last().toString().toInt() }
            .sum()

        return depthDown-depthUp

    }

    fun calculateTotalDepth(horizontalPosition: Int, depth: Int): Int {
        return horizontalPosition*depth
    }


}
