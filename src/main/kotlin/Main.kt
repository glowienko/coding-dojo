import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {
    println()
    println("SOLUTION:")
    println()

    println(fibonacci(10))
    println(fibonacciBottomUp(10))

//    println(longestCommonPrefix(arrayOf("flower", "flow", "floight")))
//    println(longestCommonPrefix(arrayOf("cir", "car")))
//    println(longestCommonPrefixWithReduce(arrayOf("flower", "flow", "floight")))

//    println(allUniqueCombinationsSummingUpToTarget(intArrayOf(10, 1, 2, 7, 6, 1, 5), 8))
//    println(allUniqueCombinationsSummingUpToTargetFinal(intArrayOf(10, 1, 2, 7, 6, 1, 5), 8))
//    println(allUniqueCombinationsSummingUpToTarget(intArrayOf(4, 1, 1, 4, 4, 4, 4, 2, 3, 5), 10))
//    println(allUniqueCombinationsSummingUpToTargetFinal(intArrayOf(4, 1, 1, 4, 4, 4, 4, 2, 3, 5), 10))

//    println(
//        "${
//            measureTimeMillis {
//                allUniqueCombinationsSummingUpToTargetFinal(
//                    intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1), 29
//                )
//            }
//        } ms "
//    )


}

fun fibonacci(n: Int): Long {
    val memory = LongArray(n + 1)
    memory[1] = 1
    return fibonacci(n, memory)
}

fun fibonacci(n: Int, memory: LongArray): Long {
    if (n == 0) return 0L
    if (memory[n] == 0L) memory[n] = fibonacci(n - 1, memory) + fibonacci(n - 2, memory)
    return memory[n]
}

fun fibonacciBottomUp(n: Int): Int {
    if (n == 0) return 0
    if (n == 1) return 1

    var previous = 0
    var current = 1
    var result = current + previous

    for (i in 2 until n) {
        previous = current
        current = result
        result = current + previous
    }

    return result
}

fun allUniqueCombinationsSummingUpToTargetFinal(candidates: IntArray, target: Int): List<List<Int>> {
    val potentialSolutions = mutableListOf<Pair<Int, List<Int>>>()
    val results = mutableListOf<List<Int>>()

    candidates.sorted().forEach { current ->
        println(potentialSolutions)
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

fun longestPalindrome(s: String): String {
    var result = s.first().toString()


    return result
}


fun longestCommonPrefix(strs: Array<String>): String {
    val sortedStrings = strs.sortedBy { it.length }
    var solution = ""
    for (index in sortedStrings.first().indices) {
        val currentChar = sortedStrings.first()[index]
        if (sortedStrings.all { it[index] == currentChar }) solution += currentChar
        else break
    }

    return solution
}

fun longestCommonPrefixWithReduce(strs: Array<String>): String =
    strs.minByOrNull { it.length }
        ?.toCharArray()
        ?.map { it.toString() }
        ?.reduceIndexedOrNull { index, acc, current ->
            if (strs.all { it[index].toString() == current }) acc + current
            else return acc
        } ?: ""


/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
fun maxProfit(prices: IntArray): Int {
    return 0
}



/*
Triple Step: A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3
steps at a time. Implement a method to count how many possible ways the child can run up the
stairs.
 */
fun climbCombinations(n: Int) {

}