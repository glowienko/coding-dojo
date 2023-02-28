object Fibonacci {
    fun calculateFibonacci(n: Int): Long {
        val memory = LongArray(n + 1)
        memory[1] = 1
        return calculateFibonacci(n, memory)
    }

    fun calculateFibonacciBottomUp(n: Int): Int {
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

    private fun calculateFibonacci(n: Int, memory: LongArray): Long {
        if (n == 0) return 0L
        if (memory[n] == 0L) memory[n] = calculateFibonacci(n - 1, memory) + calculateFibonacci(n - 2, memory)
        return memory[n]
    }
}