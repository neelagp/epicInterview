/**
 * Created by NeelaGouda on 6/1/19.
 */
public class ClockwiseMatrix {

    public String matrixPrinter(int[][] matrix) {

        /**
         * layer by layer start by top left
         * Runs in O(N) time and space complexity is O(1)
         * Took an hour including test cases , approach etc
         */

        StringBuilder builder = new StringBuilder();
        if (matrix.length == 0) return builder.toString();

        //initialize row and column start and end index
        int r1 = 0, r2 = matrix.length - 1;
        int c1 = 0, c2 = matrix[0].length - 1;

        while(r1 <= r2 && c1 <= c2){
            for(int c=c1; c<=c2; c++) builder.append(matrix[r1][c]).append(",");
            for(int r=r1+1; r<=r2; r++)builder.append(matrix[r][c2]).append(",");
            if(r1 < r2 && c1<c2) {
                for(int c=c2-1; c>c1; c--) builder.append(matrix[r2][c]).append(",");
                for(int r=r2;r>r1; r--) builder.append(matrix[r][c1]).append(",");
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }

        return builder.substring(0, builder.length() - 1);

    }
}
