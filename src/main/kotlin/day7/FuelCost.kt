package day7

import kotlin.math.abs

class FuelCost {
    fun calculateMinimumFuelToAlign(crabsPositionInput: List<String>): Int {
        val crabsPosition = crabsPositionInput.first().split(",").map { it.toInt() }.sorted()
        val median: Int

        val middle: Int = crabsPosition.size / 2
        median = if (crabsPosition.size % 2 == 1) crabsPosition[middle]
                else (crabsPosition[middle - 1] + crabsPosition[middle]) / 2


        return crabsPosition.map { abs(it - median) }.sum()
    }

    fun calculateMinimumFuelToAlignCrabsForExpensiveMovement(crabsPosition: List<String>): Int {
        TODO("Not yet implemented")
    }

}
