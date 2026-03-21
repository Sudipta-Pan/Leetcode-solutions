class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int total = rows * cols;
        int[][] result = new int[total][2];

        int[][] dir = {
            {0, 1},   // right
            {1, 0},   // down
            {0, -1},  // left
            {-1, 0}   // up
        };

        int steps = 1;
        int direction = 0;
        int index = 0;

        int r = rStart;
        int c = cStart;
        result[index++] = new int[]{r, c};

        while (index < total) {
            for (int i = 0; i < 2; i++) {

                for (int j = 0; j < steps; j++) {
                    r += dir[direction][0];
                    c += dir[direction][1];

                    if (r >= 0 && r < rows && c >= 0 && c < cols) {
                        result[index++] = new int[]{r, c};
                        if (index == total) return result;
                    }
                }

                direction = (direction + 1) % 4; // change direction
            }
            steps++; // increase step size
        }

        return result;
    }
}