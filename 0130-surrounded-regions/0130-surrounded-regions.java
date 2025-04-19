class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        //смотрим все края
        for(int i=0;i<m;i++) {
            if(board[i][0]=='O') {
                searchland(i,0,board);
            }
            if(board[i][n-1]=='O') {
                searchland(i,n-1,board);
            }
        }
        for(int j=0;j<n;j++) {
            if (board[0][j] == 'O') {
                searchland(0,j,board);
            }
            if (board[m-1][j] == 'O') {
                searchland(m-1,j,board);
            }
        }
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if (board[i][j]=='O') {
                    board[i][j] = 'X';
                }
                if (board[i][j]=='=') {
                    board[i][j]='O';
                }
            }
        }
    }
    public static void searchland(int x, int y, char[][] grid) {
        coord[] directions = new coord[4];
        directions[0]=new coord(-1,0);
        directions[1]=new coord(0,-1);
        directions[2]=new coord(1,0);
        directions[3]=new coord(0,1);
        grid[x][y] = '=';
        for (int k=0;k<4;k++) {
            int i = x+directions[k].x;
            int j = y+directions[k].y;
            if (isinside(i,j,grid)) {
                if(grid[i][j]=='O') {
                    searchland(i,j,grid);
                } //if X or = - do nothing
            }
        }

    }
    public static boolean isinside (int x, int y, char[][]grid) {
        if (x<0 || y<0 || x>=grid.length || y>=grid[0].length) {
            return false;
        } else
            return true;
    }
    record coord(int x,int y) {}
}