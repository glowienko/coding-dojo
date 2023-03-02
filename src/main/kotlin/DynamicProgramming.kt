object DynamicProgramming {
    /*
    You are given an array prices where prices[i] is the price of a given stock on the ith day.
    You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
    Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
     */
    fun maxProfitSimple(prices: IntArray): Int {
        var profit = 0

        for (currentBuyIndex in 0 until prices.lastIndex) {
            for (currentSellIndex in currentBuyIndex + 1..prices.lastIndex) {
                if (prices[currentSellIndex] - prices[currentBuyIndex] > profit)
                    profit = prices[currentSellIndex] - prices[currentBuyIndex]
            }
        }

        return profit
    }

    fun maxProfitFast(prices: IntArray): Int {
        var profit = 0
        var buyIndex = 0

        for (currentIndex in 1..prices.lastIndex) {
            val currentValue = prices[currentIndex]
            val existingBuyValue = prices[buyIndex]

            if (currentValue < existingBuyValue) {
                buyIndex = currentIndex
                continue
            }

            if (currentValue - existingBuyValue > profit) {
                profit = currentValue - existingBuyValue
            }
        }

        return profit
    }

    /*
    On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time.
    However, you can buy it then immediately sell it on the same day (multiple transactions possible).

    So we can sell and buy and move forward for another sell on same day/index.

    Solution notes: it is a must to take any profit - as we do not know if we have more or any in the nexy days/indices
     12345
     54339
     */
    fun maxProfitMultipleTransactions(prices: IntArray): Int {
        var profit = 0

        for (currentIndex in 1..prices.lastIndex) {
            val currentValue = prices[currentIndex]
            val buyPrice = prices[currentIndex - 1]
            if (currentValue - buyPrice > 0) {
                profit += currentValue - buyPrice
            }
        }

        return profit
    }

    fun maxProfitTwoTransactions(prices: IntArray): Int { // not fully working, needs some more complex memory
        val profits = mutableListOf(0)
        var lowestPriceProfit = 0
        var currentLowestPrice = prices[0]

        for (currentIndex in 1..prices.lastIndex) {
            val currentValue = prices[currentIndex]
            val buyPrice = prices[currentIndex - 1]
            val currentProfit = currentValue - buyPrice

            if (buyPrice < currentLowestPrice) {
                currentLowestPrice = buyPrice
            }

            val currentMaxProfit = currentValue - currentLowestPrice
            if (currentMaxProfit > 0 && currentMaxProfit > currentProfit) {
                lowestPriceProfit = currentMaxProfit
            } else if (currentProfit > 0) {
                profits.add(currentProfit)
            }
        }
        profits += lowestPriceProfit
        return profits.sortedDescending().take(2).sum()
    }

    /*
    Triple Step: A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3
    steps at a time. Implement a method to count how many possible ways the child can run up the
    stairs.
    */
    fun climbCombinations(n: Int) {

    }

}