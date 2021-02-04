package kata.base

import kotlin.math.min

data class Stock
    private constructor(val value: Int, val lowestValue: Int, private val numberCombined: Int, private val sum: Int) {
    val average = sum / numberCombined

    companion object {
        fun of(value: Int) = Stock(value, value, 1,value)
        val NEUTRAL_ADDITION = of(0)
    }

    fun combine(stock: Stock) =
        Stock(stock.value + value, min(stock.lowestValue, lowestValue), numberCombined + stock.numberCombined, sum + stock.sum)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Stock
        if (value != other.value) return false
        return true
    }

    override fun hashCode() = value
}



