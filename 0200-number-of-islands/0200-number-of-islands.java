class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int islands = 0;
        //ищем острова
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    searchland(i, j, grid);
                }
            }
        }
        return islands;
    }

    public static void searchland(int x, int y, char[][] grid) {
        coord[] directions = new coord[4];
        directions[0] = new coord(-1, 0);
        directions[1] = new coord(0, -1);
        directions[2] = new coord(1, 0);
        directions[3] = new coord(0, 1);
        grid[x][y] = '0';
        for (int k = 0; k < 4; k++) {
            int i = x + directions[k].x;
            int j = y + directions[k].y;
            if (isinside(i, j, grid)) {
                if (grid[i][j] == '1') {
                    searchland(i, j, grid);
                }
            }
        }

    }

    public static boolean isinside(int x, int y, char[][] grid) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            return false;
        } else
            return true;
    }

    record coord(int x, int y) {
    }
}