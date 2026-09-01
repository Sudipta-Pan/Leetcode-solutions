class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length, n = classroom[0].length();
        int sr = 0, sc = 0, k = 0;

        int[][] id = new int[m][n];
        for (int[] a : id) Arrays.fill(a, -1);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = classroom[i].charAt(j);
                if (c == 'S') {
                    sr = i;
                    sc = j;
                } else if (c == 'L') {
                    id[i][j] = k++;
                }
            }
        }

        int full = (1 << k) - 1;
        boolean[][][][] seen = new boolean[m][n][energy + 1][1 << k];

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sr, sc, energy, 0, 0});
        seen[sr][sc][energy][0] = true;

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        while (!q.isEmpty()) {
            int[] a = q.poll();
            int r = a[0], c = a[1], e = a[2];
            int mask = a[3], moves = a[4];

            if (mask == full) return moves;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d], nc = c + dc[d];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n ||
                    classroom[nr].charAt(nc) == 'X' || e == 0)
                    continue;

                int ne = e - 1;
                int nm = mask;
                char ch = classroom[nr].charAt(nc);

                if (ch == 'L')
                    nm |= 1 << id[nr][nc];

                if (ch == 'R')
                    ne = energy;

                if (!seen[nr][nc][ne][nm]) {
                    seen[nr][nc][ne][nm] = true;
                    q.add(new int[]{nr, nc, ne, nm, moves + 1});
                }
            }
        }

        return -1;
    }
}