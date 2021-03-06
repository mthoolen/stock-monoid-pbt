/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package kata.base

import com.pholser.junit.quickcheck.Property
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck
import org.junit.runner.RunWith
import java.math.BigInteger
import kotlin.math.roundToInt
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@RunWith(JUnitQuickcheck::class)
class StockTest {
    @Test
    fun stockShouldBeAbleToBeCombined() {
        val stock20 = Stock.of(20)
        val stock30 = Stock.of(30)
        assertEquals(Stock.of(50), stock20.combine(stock30))
    }


    @Test
    fun closureOfOperation() {
        val a: Stock = forAnyStock()
        val b: Stock = forAnyStock()
        assertTrue { a.combine(b) is Stock }
    }

    @Test
    fun adding0DoesntChanceValue() {
        val stock0 = Stock.of(0)
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
    fun shouldBeAbleToTellMinimalStock() {
        val stock20 = Stock.of(20)
        val stock40 = Stock.of(40)
        val combined = stock20.combine(stock40)
        assertEquals(20, combined.lowestValue)
    }

    @Test
    fun shouldBeAbleToTellAverage() {
        val stock20 = Stock.of(20)
        val stock40 = Stock.of(40)
        val combined = stock20.combine(stock40)
        assertEquals(30, combined.average)
    }

    @Test
    fun associativityForAverage() {
        val a = forAnyStock();
        val b = forAnyStock();
        val c = forAnyStock();
        val left = a.combine(b).combine(c)
        val right = a.combine(b.combine(c))
        assertEquals(left.average, right.average);
    }

    @Test
    fun associativityForMinimum() {
        val a = forAnyStock();
        val b = forAnyStock();
        val c = forAnyStock();
        assertEquals(a.combine(b).combine(c).lowestValue, a.combine(b.combine(c)).lowestValue);
    }

    private fun forAnyStock() = Stock.of((Math.random() * 100).roundToInt())
}
