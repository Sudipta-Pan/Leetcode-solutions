class Solution {
    public int[][] transpose(int[][] matrix) {
        int no_of_row = matrix.length;
        int no_of_column = matrix[0].length;
        int[][] result = new int[no_of_column][no_of_row];
        for(int i = 0; i < no_of_column; i++){
            for (int j = 0; j < no_of_row; j++) {
                result[i][j] = matrix[j][i];
            }
        }
        return result;
    }
}