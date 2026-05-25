class Solution {
    public int diagonalSum(int[][] mat) {
        if(mat.length == 1)
            return mat[mat.length-1][mat.length-1];
        int sum = 0;
        int i = 0;
        int j = 0;
        for(i = 0; i < mat.length; i++){
            for(j = 0; j<mat[i].length; j++){
            if (i == j)
                sum += mat[i][j];
            else if(i + j == mat.length - 1)
                sum += mat[i][j];
            }
    
        }
        
    return sum;
    }
}