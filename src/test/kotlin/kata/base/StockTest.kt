/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package kata.base

import kotlin.math.roundToInt
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class AppTest {
    @Test
    fun stockShouldBeAbleToBeCombined() {
        val stock20 = Stock(20)
        val stock30 = Stock(30)
        assertEquals(Stock(50), stock20.combine(stock30))
    }

    @Test
    fun stockShouldBeAbleToBeCombinedForDifferentValues() {
        val stock20 = Stock(20)
        val stock40 = Stock(40)
        assertEquals(Stock(60), stock20.combine(stock40))
    }

    @Test
    fun closureOfOperation() {
        val a: Stock = forAnyStock()
        val b: Stock = forAnyStock()
        assertTrue { a.combine(b) is Stock }
    }

    @Test
    fun adding0DoesntChanceValue() {
        val stock0 = Stock(0)
        val anyStock = forAnyStock()
        assertEquals(anyStock, anyStock.combine(stock0))
    }

    @Test
    fun neutralElement() {
        val a = forAnyStock()
        assertEquals(a, a.combine(Stock.NEUTRAL_ADDITION)) // combine right
        assertEquals(a, Stock.NEUTRAL_ADDITION.combine(a)) // combine left
    }

    @Test
    fun associativity() {
        val a = forAnyStock();
        val b = forAnyStock();
        val c = forAnyStock();
        assertEquals(a.combine(b).combine(c), a.combine(b.combine(c)));
    }

    @Test
    fun associativityForMultiplication() {
        val a = forAnyStock();
        val b = forAnyStock();
        val c = forAnyStock();
        assertEquals(a.multiply(b).multiply(c), a.multiply(b.multiply(c)));
    }

    @Test
    fun neutralElementForMultiplication() {
        val a = forAnyStock()
        assertEquals(a, a.multiply(Stock.NEUTRAL_MULTIPLY)) // combine right
        assertEquals(a, Stock.NEUTRAL_MULTIPLY.multiply(a)) // combine left
    }


    @Test
    fun closureOfOperationForMultiply() {
        val a: Stock = forAnyStock()
        val b: Stock = forAnyStock()
        assertTrue { a.multiply(b) is Stock }
    }

    @org.junit.Test
    fun shouldBeAbleToTellMinimalStock() {
        val stock20 = Stock(20)
        val stock40 = Stock(40)
        val combined = stock20.combine(40)
        combined.minimalValue
    }

    private fun forAnyStock(): Stock {
        return  Stock((Math.random() * 100).roundToInt())
    }

    //Closure of operations
    //Neutral element
    //Associativity


}
