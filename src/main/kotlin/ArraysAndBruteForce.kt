object ArraysAndBruteForce {

    fun allUniqueCombinationsSummingUpToTargetFinal(candidates: IntArray, target: Int): List<List<Int>> {
        val potentialSolutions = mutableListOf<Pair<Int, List<Int>>>()
        val results = mutableListOf<List<Int>>()

        candidates.sorted().forEach { current ->
//            println(potentialSolutions)
            val iterator = potentialSolutions.listIterator()
            iterator.forEach {
                if (it.first - current == 0) {
                    val newSolution = (it.second + current).sorted()
                    if (!results.contains(newSolution)) results.add(newSolution)
                }

                if (it.first - current > 0) {
                    val newPotentialSolution = it.first - current to it.second + current
                    if (!potentialSolutions.contains(newPotentialSolution)) {
                        iterator.add(newPotentialSolution)
                    }
                }
            }

            val remainingSum = target - current
            val newSolution = listOf(current)
            if (remainingSum > 0 && !potentialSolutions.contains(remainingSum to newSolution)) {
                potentialSolutions.add(remainingSum to newSolution)
            }

            if (remainingSum == 0 && !results.contains(newSolution)) {
                results.add(newSolution)
            }
        }

        return results
    }

    fun allUniqueCombinationsSummingUpToTargetFinalRefactored(candidates: IntArray, target: Int): List<List<Int>> {
        val candidatesDesc = candidates.sortedDescending()
        val potentialSolutions = mutableListOf<Pair<Int, List<Int>>>()
        val results = mutableListOf<List<Int>>()

        candidatesDesc.forEach { current ->
            potentialSolutions.filter { it.first - current >= 0 }.forEach {
                val remaining = it.first - current
                if (remaining == 0) {
                    val newSolution = (it.second + current).sorted()
                    if (!results.contains(newSolution)) results.add(newSolution)
                }

                val newPotentialSolution = remaining to it.second + current
                if (!potentialSolutions.contains(newPotentialSolution)) {
                    potentialSolutions.add(newPotentialSolution)
                }
            }

            val newSolution = target - current to listOf(current)
            if (newSolution.first > 0 && !potentialSolutions.contains(newSolution)) {
                potentialSolutions.add(newSolution)
            }

            if (newSolution.first == 0 && !results.contains(newSolution.second)) {
                results.add(newSolution.second)
            }
        }

        return results
    }
}