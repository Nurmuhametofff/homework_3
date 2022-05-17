import junit.framework.Assert.assertEquals
import org.junit.Test

class MainKtTest {

    @Test
    fun pay_MastercardAndMaestro_min75_000() {
        val typecard = 1
        val pr = 70000.0
        val amount = 50.0

        val result = pay(
            typeCard = typecard,
            previousRemittance = pr,
            amount = amount
        )

        assertEquals(50.0, result, 1.0)

    }
    @Test
    fun pay_MastercardAndMaestro_max75_000() {
        val typecard = 1
        val pr = 76000.0
        val amount = 50.0

        val result = pay(
            typeCard = typecard,
            previousRemittance = pr,
            amount = amount
        )

        assertEquals(29.7, result, 1.0)

    }

    @Test
    fun pay_VisaAndMir(){
        val typecard = 3
        val pr = 70000.0
        val amount = 50.0

        val result =pay(
            typeCard = typecard,
            previousRemittance = pr,
            amount = amount
        )

        assertEquals(49.625, result, 1.0)
    }
    @Test
    fun pay_VKpay(){
        val typecard = 5
        val pr = 70000.0
        val amount = 50.0

        val result =pay(
            typeCard = typecard,
            previousRemittance = pr,
            amount = amount
        )
        assertEquals(50.0, result, 1.0)
    }
    @Test
    fun pay_Else() {
        val typecard = 6
        val pr = 70000.0
        val amount = 50.0

        val result = pay(
            typeCard = typecard,
            previousRemittance = pr,
            amount = amount
        )
        assertEquals(50.0, result, 1.0)
    }

    @Test
    fun pay_Amount() {
        val typecard = 6
        val pr = 70000.0
        val amount = 0.0

        val result = pay(
            typeCard = typecard,
            previousRemittance = pr,
            amount = amount
        )
        assertEquals(0.0, result, 1.0)
    }

}