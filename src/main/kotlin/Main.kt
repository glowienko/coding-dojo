import ArraysAndBruteForce.allUniqueCombinationsSummingUpToTargetFinal
import ArraysAndBruteForce.allUniqueCombinationsSummingUpToTargetFinalRefactored
import DynamicProgramming.maxProfitFast
import DynamicProgramming.maxProfitMultipleTransactions
import DynamicProgramming.maxProfitSimple
import DynamicProgramming.maxProfitTwoTransactions
import Fibonacci.calculateFibonacci
import Fibonacci.calculateFibonacciBottomUp
import StringChallenges.longestCommonPrefix
import StringChallenges.longestCommonPrefixWithReduce
import StringChallenges.longestPalindrome
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import kotlin.random.Random
import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {
    println("SOLUTIONS:")
    println()

    println(longestPalindrome("aaaaa"))
    println(longestPalindrome("kajak"))
    println(longestPalindrome("kajak") == "kajak")
    println("------------------------------------------")

    println("max profit | dynamic programming")
    println(maxProfitTwoTransactions(intArrayOf(1, 2, 3, 4, 5)))
    println(maxProfitMultipleTransactions(intArrayOf(7, 1, 5, 3, 6, 4)))
    println(maxProfitFast(intArrayOf(7)))
    println(maxProfitSimple(intArrayOf(7, 1, 5, 3, 6, 4)))

    println("time measure maxProfitSimple O(n)) vs  maxProfitFast")
    val bigRandomArray = IntArray(90100) { Random.nextInt(1, 1000002) }
    println("brute force: ${executeMeasuringTimeMillis { maxProfitSimple(bigRandomArray) }} ms")
    println("fast: ${executeMeasuringTimeMillis { maxProfitFast(bigRandomArray) }} ms")
    println("multiple transactions: ${executeMeasuringTimeMillis { maxProfitMultipleTransactions(intArrayOf(1,2,3,4,5)) }} ms")

    println("------------------------------------------")
    println()
    println("fibonacci:")
    println(calculateFibonacci(10))
    println(calculateFibonacciBottomUp(10))

    println("longestCommonPrefix:")
    println(longestCommonPrefix(arrayOf("flower", "flow", "floight")))
    println(longestCommonPrefixWithReduce(arrayOf("flower", "flow", "floight")))
    println(longestCommonPrefix(arrayOf("cir", "car")))

    println("allUniqueCombinationsSummingUpToTargetFinal:")
    println(allUniqueCombinationsSummingUpToTargetFinal(intArrayOf(10, 1, 2, 7, 6, 1, 5), 8))
    println(allUniqueCombinationsSummingUpToTargetFinal(intArrayOf(4, 1, 1, 4, 4, 4, 4, 2, 3, 5), 10))
    println(allUniqueCombinationsSummingUpToTargetFinalRefactored(intArrayOf(4, 1, 1, 4, 4, 4, 4, 2, 3, 5), 10))

    println("measure complex allUniqueCombinationsSummingUpToTargetFinal:")
    println(
        "${
            measureTimeMillis {
                allUniqueCombinationsSummingUpToTargetFinal(
                    intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1), 23
                )
            }
        } ms "
    )
}
