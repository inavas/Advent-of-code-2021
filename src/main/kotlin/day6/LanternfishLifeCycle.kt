package day6

class LanternfishLifeCycle {
    fun calculateBreeding(initialLanternfishInput: List<String>, days: Int): List<Int> {
        val initialLanternfish = initialLanternfishInput.first().split(",").map { it.toString().toInt() }.toMutableList()


        repeat(days) {
            for (i in 0 until initialLanternfish.size) {
                if (initialLanternfish[i] == 0) {
                    initialLanternfish[i].apply { initialLanternfish[i] = 6 }
                    initialLanternfish.add(8)
                } else {
                    initialLanternfish[i].apply { initialLanternfish[i] = initialLanternfish[i] - 1 }
                }
            }
        }

        return initialLanternfish
    }

    fun calculateBreedingFaster(initialLanternfishInput: List<String>, days: Int): Long {
        val initialLanternfish = initialLanternfishInput.first().split(",").map { it.toInt() }

        val lanternFishState = mutableMapOf(0 to 0L, 1 to 0L, 2 to 0L, 3 to 0L, 4 to 0L, 5 to 0L, 6 to 0L, 7 to 0L, 8 to 0L)

        (0..8).forEach { state ->
            val quantityOfState = initialLanternfish.filter { it == state }.count().toLong()
            lanternFishState[state] = quantityOfState
        }


        for (i in 0 until days) {
            val newFishes = lanternFishState[0]
            lanternFishState[0] = lanternFishState[1]!!
            lanternFishState[1] = lanternFishState[2]!!
            lanternFishState[2] = lanternFishState[3]!!
            lanternFishState[3] = lanternFishState[4]!!
            lanternFishState[4] = lanternFishState[5]!!
            lanternFishState[5] = lanternFishState[6]!!
            lanternFishState[6] = lanternFishState[7]!! + newFishes!!
            lanternFishState[7] = lanternFishState[8]!!
            lanternFishState[8] = newFishes
        }


        return lanternFishState.map { it.value }.sum()
    }

}