class Solution {
    public void setZeroes(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean firstCol = false;

        // Step 1: Mark rows and columns
        for (int i = 0; i < rows; i++) {

            if (matrix[i][0] == 0) {
                firstCol = true;
            }

            for (int j = 1; j < cols; j++) {

                if (matrix[i][j] == 0) {

                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Step 2: Fill zeros using markers
        for (int i = 1; i < rows; i++) {

            for (int j = 1; j < cols; j++) {

                if (matrix[i][0] == 0 ||
                    matrix[0][j] == 0) {

                    matrix[i][j] = 0;
                }
            }
        }

        // Step 3: Handle first row
        if (matrix[0][0] == 0) {

            for (int j = 0; j < cols; j++) {
                matrix[0][j] = 0;
            }
        }

        // Step 4: Handle first column
        if (firstCol) {

            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}