object StringChallenges {

    //string task but actually dynamic programming approach bottom up
    fun longestPalindrome(s: String): String {
        var result = s[0].toString()

        //TODO make refactoring, code can be simplified
        for (currentIndex in 0 until s.lastIndex) {
            if (s[currentIndex] == s[currentIndex + 1]) { // even len palindrome
                var newPalindrome = s.substring(currentIndex..currentIndex + 1)
                for (i in 1 until s.lastIndex - currentIndex) {
                    if (currentIndex - i >= 0 && s[currentIndex - i] == s[currentIndex + i + 1])
                        newPalindrome = s.substring(currentIndex - i..currentIndex + i + 1)
                    else break
                }
                if (newPalindrome.length > result.length) result = newPalindrome
                if (result.length == s.length) return result
            }

            if (currentIndex > 0 && s[currentIndex - 1] == s[currentIndex + 1]) { // odd len palindrome
                var newPalindrome = s.substring(currentIndex - 1..currentIndex + 1)
                for (i in 2..s.lastIndex - currentIndex) {
                    if (currentIndex - i >= 0 && s[currentIndex - i] == s[currentIndex + i])
                        newPalindrome = s.substring(currentIndex - i..currentIndex + i)
                    else break
                }
                if (newPalindrome.length > result.length) result = newPalindrome
                if (result.length == s.length) return result
            }
        }
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