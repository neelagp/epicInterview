/**
 * Created by NeelaGouda on 6/1/19.
 */
public class Itoa {

    /**
     * Used the logic from here: https://mathbits.com/MathBits/CompSci/Introduction/frombase10.htm
     *  Process:
     1.  Divide the "desired" base (in this case base 2) INTO the number you are trying to convert.
     2.  Write the quotient (the answer) with a remainder like you did in elementary school.
     3.  Repeat this division process using the whole number from the previous quotient (the number in front of the remainder).
     4.  Continue repeating this division until the number in front of the remainder is only zero.
     5.  The answer is the remainders read from the bottom up.

     * Took about  40 mins
     */

    /**
     * @param value
     * @param base  its either octal,decimal or hex
     * @return
     */

    String itoa(int value, int base) {

        // will cause overflow ,  even min will cause overflow as it exceeds 32 bit, hence <=
        if (value > Integer.MAX_VALUE || value <= Integer.MIN_VALUE) return "";

        boolean negative = value < 0;

        String result = "";

        //base cases
        if (value == 0)
            return "0";

        //use positive numeric value for conversion
        if (negative) value = -1 * value;


        while (value != 0) {
            result = (value % base) + result; //step 2
            value = value / base; // step 3
        }

        if (negative)
            result = "-" + result;
        return result;

    }
}
