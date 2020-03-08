import java.util.LinkedList;

/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    // //20191119  DFS 复杂度O（n^2）,注：效率更高
                    // dfs(grid,i,j);

                    //20191119 BFS 复杂度O(n^2)
                    bfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int i, int j) {
        Queue <int[]> list = new LinkedList<>();
        list.add(new int[]{i,j});
        while(!list.isEmpty()){
            int []cur = list.remove();
            i = cur[0];
            j = cur[1];
            if(0<=i && i<grid.length && 0<=j && j<grid[0].length && grid[i][j]=='1'){
                grid[i][j] = '0';
                list.add(new int[]{i+1,j});
                list.add(new int[]{i-1,j});
                list.add(new int[]{i,j+1});
                list.add(new int[]{i,j-1});
            }
        }
    }

    private void dfs(char[][] grid, int i, int j) {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] == '0')
            return;
        
        grid[i][j] = '0';
        dfs(grid, i+1, j);
        dfs(grid, i, j+1);
        dfs(grid, i-1, j);
        dfs(grid, i, j-1);
    }

}
// @lc code=end

