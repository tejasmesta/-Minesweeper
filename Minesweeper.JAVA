class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length;
        int n = board[0].length;

        int x =  click[0];
        int y = click[1];

        if(board[x][y] == 'M')
        {
            board[x][y] = 'X';
            return board;
        }        
       
        boolean[][] visited = new boolean[m][n];
        
        reveal(board, m, n, x, y, visited);
        
        return board;
    }
    
    int getCount(char[][] board, int i, int j, int m, int n)
    {
        int dx[] = {-1,0,1,0,1,-1,1,-1};
        int dy[] = {0,-1,0,1,1,-1,-1,1};
        
        int count = 0;
        
        for(int p=0; p<8; p++)
        {
            int x = i + dx[p];
            int y = j + dy[p];
            
            if(x<m && x>=0 && y<n && y>=0 && board[x][y] == 'M')
                count++;
        }
        
        return count;
    }
    
    void reveal(char[][] board, int m, int n, int x, int y, boolean[][] visited)
    {
        if(!(x<m && x>=0 && y<n && y>=0 && !visited[x][y]))
            return;
        
        
        int count = getCount(board, x, y, m, n);
        
        if(count > 0)
        {
            board[x][y] = String.valueOf(count).charAt(0);
            return;
        }
        
        board[x][y] = 'B';
        visited[x][y] = true;
        
        reveal(board, m, n, x-1, y, visited);
        reveal(board, m, n, x, y-1, visited);
        reveal(board, m, n, x+1, y, visited);
        reveal(board, m, n, x, y+1, visited);
        reveal(board, m, n, x-1, y-1, visited);
        reveal(board, m, n, x+1, y+1, visited);
        reveal(board, m, n, x+1, y-1, visited);
        reveal(board, m, n, x-1, y+1, visited);        
    }    
}