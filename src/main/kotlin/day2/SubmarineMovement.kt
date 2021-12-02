package day2

class SubmarineMovement {

    fun calculate(movements: List<String>): Pair<Int, Int> {

        val horizontalPosition = calculateHorizontalPosition(movements)

        val depth = calculateDepth(movements)

        return Pair(horizontalPosition,depth)
    }

    fun calculateTotalDepth(horizontalPosition: Int, depth: Int): Int {
        return horizontalPosition*depth
    }


    private fun calculateHorizontalPosition(movements: List<String>) =
        movements.filter { command -> command.contains("forward") }
            .map { value -> value.lastCharAsNumber() }
            .sum()

    private fun calculateDepth(movements: List<String>): Int {
        var depthDown = movements.filter { command -> command.contains("down") }
            .map { value -> value.lastCharAsNumber() }
            .sum()

        val depthUp = movements.filter { command -> command.contains("up") }
            .map { value -> value.lastCharAsNumber() }
            .sum()

        return depthDown-depthUp

    }

    fun calculateWithAim(movements: List<String>): Pair<Int, Int> {
        var aim = 0
        var horizontalPosition = 0
        var depth = 0


        movements.forEach {
            when {
                "forward" in it -> {
                    horizontalPosition += it.last().toString().toInt()
                    depth += aim * it.lastCharAsNumber()
                }
                "down" in it -> {
                    aim += it.lastCharAsNumber()
                }
                "up" in it -> {
                    aim -= it.lastCharAsNumber()
                }
            }
        }

        return Pair(horizontalPosition,depth)
    }


}

private fun String.lastCharAsNumber(): Int  =
    this.last().toString().toInt()

