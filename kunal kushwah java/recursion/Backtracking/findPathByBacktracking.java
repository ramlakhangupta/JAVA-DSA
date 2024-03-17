import java.util.Arrays;

public class findPathByBacktracking {
    public static void main(String[] args) {
        boolean[][] ans = {
            {true,true,true},
            {true,true,true},
            {true,true,true}
        };
        int[][] path = new int[ans.length][ans[0].length];
        allPathPrint("", ans, 0, 0, path, 1);
    }

    static void allPathPrint(String p, boolean[][] maze, int r, int c, int[][] path, int step){
 
        if(r == maze.length-1 && c == maze[0].length-1){
           for (int[]  arr : path) {
             System.out.println(Arrays.toString(arr));
           }
            return ;
        }

        if(!maze[r][c]){
            return;
        }

        //i am considering this block in my path
        maze[r][c] = false;
        path[r][c] = step;


        if(r < maze.length-1){
            allPathPrint(p+'D', maze, r+1, c, path, step+1);
        }


        if(c < maze[0].length-1){
            allPathPrint(p+'R',maze, r, c+1, path, step+1);
        }

        if(r>0){
           allPathPrint(p+'U',maze,r-1, c, path, step+1);
        }

        if(c>0){
            allPathPrint(p+'L',maze, r, c-1, path, step+1);
        }

        //this line is where the function will be over
        //so before the function gets removed, also remove the change tat were made by that were made by that function
        maze[r][c] = true;
        path[r][c] = 0;
    }
}
