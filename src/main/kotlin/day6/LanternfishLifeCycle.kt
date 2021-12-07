package day6

class LanternfishLifeCycle {
    fun calculateBreeding(initialLanternfishInput: List<String>, days: Int): List<Int> {
        val initialLanternfish = initialLanternfishInput.first().split(",").map { it.toString().toInt() }


        return initialLanternfish.map { it-1 }
    }

}
