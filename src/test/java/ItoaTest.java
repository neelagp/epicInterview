import org.junit.Test;
import org.omg.PortableInterceptor.Interceptor;

import static org.junit.Assert.*;

/**
 * Created by NeelaGouda on 6/1/19.
 */
public class ItoaTest {

    Itoa itoa = new Itoa();

    @Test
    public void testZeroBaseItoa() throws Exception {

        String result = this.itoa.itoa(0, 8);
        assertEquals("0", result);

        String resultOctal = this.itoa.itoa(-1, 8);
        assertEquals("-1", resultOctal);

        String resultHexMax = this.itoa.itoa(Integer.MAX_VALUE, 16);
        assertEquals("715151515151515", resultHexMax);

        String resultOctalMax = this.itoa.itoa(Integer.MAX_VALUE, 8);
        assertEquals("17777777777", resultOctalMax);

        String resultDecimalMax = this.itoa.itoa(Integer.MAX_VALUE, 10);
        assertEquals(String.valueOf(Integer.MAX_VALUE), resultDecimalMax);

        String resultDecimalMin = this.itoa.itoa(Integer.MIN_VALUE + 1, 10);
        assertEquals("-" + String.valueOf(Integer.MIN_VALUE - 1), resultDecimalMin);


    }

    @Test
    public void testPositiveItoa() throws Exception {

        String resultOctal = this.itoa.itoa(9875, 8);
        assertEquals("23223", resultOctal);

        String resultHex = this.itoa.itoa(9875, 16);
        assertEquals("2693", resultHex);

        String resultDecimal = this.itoa.itoa(9875, 10);
        assertEquals("9875", resultDecimal);

    }

    @Test
    public void testNegativeItoa() throws Exception {

        String resultOctal = this.itoa.itoa(-9875, 8);
        assertEquals("-23223", resultOctal);

        String resultHex = this.itoa.itoa(-9875, 16);
        assertEquals("-2693", resultHex);

        String resultDecimal = this.itoa.itoa(-9875, 10);
        assertEquals("-9875", resultDecimal);

    }

}