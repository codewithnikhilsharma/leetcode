class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length; // number of rows in the grid
        int n = grid[0].length; // number of columns in the grid
        int count = 0; // counter to keep track of number of closed islands
        boolean[][] visited = new boolean[m][n]; // to keep track of visited cells
        
        // loop through all cells, skipping the border cells
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) { // if this is an unvisited land cell
                    boolean isClosed = dfs(grid, visited, i, j); // check if it is a closed island
                    if (isClosed) {
                        count++; // increment the counter if it is a closed island
                    }
                }
            }
        }
        return count; // return the number of closed islands
    }
    
    private boolean dfs(int[][] grid, boolean[][] visited, int i, int j) {
        int m = grid.length; // number of rows in the grid
        int n = grid[0].length; // number of columns in the grid
        if (i < 0 || i >= m || j < 0 || j >= n) { // if out of bounds, not a closed island
            return false;
        }
        if (visited[i][j]) { // if already visited, not a closed island
            return true;
        }
        visited[i][j] = true; // mark as visited
        if (grid[i][j] == 1) { // if water, not a closed island
            return true;
        }
        boolean isClosed = true; // flag to check if all adjacent cells are water (closed island)
        isClosed &= dfs(grid, visited, i - 1, j); // check the cell to the left
        isClosed &= dfs(grid, visited, i + 1, j); // check the cell to the right
        isClosed &= dfs(grid, visited, i, j - 1); // check the cell above
        isClosed &= dfs(grid, visited, i, j + 1); // check the cell below
        return isClosed; // return whether all adjacent cells are water (closed island)
    }
}
