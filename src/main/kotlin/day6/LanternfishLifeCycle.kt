package day6

class LanternfishLifeCycle {
    fun calculateBreeding(initialLanternfishInput: List<String>, days: Int): List<Int> {
        var initialLanternfish = initialLanternfishInput.first().split(",").map { it.toString().toInt() }.toMutableList()


        for (day in 0 until days) {
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

}
