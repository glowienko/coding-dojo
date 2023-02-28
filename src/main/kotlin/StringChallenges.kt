object StringChallenges {

    fun longestPalindrome(s: String): String {
        var result = s.first().toString()
        // TODO: IMPLEMENT ME

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

}