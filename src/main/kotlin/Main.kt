import ArraysAndBruteForce.allUniqueCombinationsSummingUpToTargetFinal
import ArraysAndBruteForce.allUniqueCombinationsSummingUpToTargetFinalRefactored
import Fibonacci.calculateFibonacci
import Fibonacci.calculateFibonacciBottomUp
import StringChallenges.longestCommonPrefix
import StringChallenges.longestCommonPrefixWithReduce
import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {
    println("SOLUTIONS:")
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