import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by NeelaGouda on 6/1/19.
 */
public class ClockwiseMatrixTest {

    ClockwiseMatrix clockwiseMatrix = new ClockwiseMatrix();
    Random rand = new Random();


    @Test
    public void testMatrixPrinterEmpty() throws Exception {
        String result = clockwiseMatrix.matrixPrinter(new int[0][0]);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testMatrixPrinterBasic() throws Exception {

        //1*1
        int[][] one = {{1}};
        String result1 = clockwiseMatrix.matrixPrinter(one);
        assertEquals("1", result1);

        //1*2
        int[][] oneByTwo = {{1, 2}};
        String result2 = clockwiseMatrix.matrixPrinter(oneByTwo);
        assertEquals("1,2", result2);

        //2*1
        int[][] twoByOne = {{1},
                {2}};
        String result3 = clockwiseMatrix.matrixPrinter(twoByOne);
        assertEquals("1,2", result3);

        //2*1
        int[][] twoBytwo = {
                {1, 2},
                {3, 4}};
        String result4 = clockwiseMatrix.matrixPrinter(twoBytwo);
        assertEquals("1,2,4,3", result4);


    }

    @Test
    public void testMatrixPrinterCombos() throws Exception {

        //even*even (4*4)
        int[][] evenByEven = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {7, 6, 5, 4},
                {3, 2, 1, 4},
        };
        String result1 = clockwiseMatrix.matrixPrinter(evenByEven);
        assertEquals("1,2,3,4,8,4,4,1,2,3,7,5,6,7,5,6", result1);

        //odd*odd (3*5)
        int[][] oddByOdd = {
                {1, 2, 3},
                {4, 5, 6},
                {3, 4, 5},
                {6, 7, 8},
                {2, 3, 4}
        };
        String result2 = clockwiseMatrix.matrixPrinter(oddByOdd);
        assertEquals("1,2,3,6,5,8,4,3,2,6,3,4,5,4,7", result2);

        //even*odd (4*3)
        int[][] evenByOdd = {
                {1, 2, 3},
                {5, 6, 7},
                {7, 6, 5},
                {3, 2, 1},
        };
        String result3 = clockwiseMatrix.matrixPrinter(evenByOdd);
        assertEquals("1,2,3,7,5,1,2,3,7,5,6,6", result3);

        //odd*even (3*4)
        int[][] oddByEven =  {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {7, 6, 5, 4},
        };
        String result4 = clockwiseMatrix.matrixPrinter(oddByEven);
        assertEquals("1,2,3,4,8,4,5,6,7,5,6,7", result4);


    }

    @Test
    public void testMatrixPrinterStress() throws Exception {
        int[][] matrix1 = createMatrix(3503, 1534);
        String result1 = clockwiseMatrix.matrixPrinter(matrix1);
        String[] size = result1.split(",");
        assertEquals(3503*1534, size.length);

    }

    private int[][] createMatrix(int rowSize, int colSize) {

        int[][] matrix = new int[rowSize][colSize];
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                matrix[r][c] = getNumber();
            }
        }

        return matrix;
    }

    private int getNumber() {
        return rand.nextInt(50) + 1;
    }
}