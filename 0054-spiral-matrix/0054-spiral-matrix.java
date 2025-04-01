class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix==null || matrix.length==0) 
            return new ArrayList<Integer>();
 
        return spiralCount(matrix,0,0,matrix.length,matrix[0].length);
    }

    public ArrayList<Integer> spiralCount(int [][] matrix, int x, int y, int m, int n){
        ArrayList<Integer> result = new ArrayList<Integer>();
 
        if(m<=0||n<=0) 
            return result;
 
        //only one element left
        if(m==1&&n==1) {
            result.add(matrix[x][y]);
            return result;
        }
 
        //top - move right
        for(int i=0;i<n-1;i++){
            result.add(matrix[x][y++]);
        }
 
        //right - move down
        for(int i=0;i<m-1;i++){
            result.add(matrix[x++][y]);
        }
 
        //bottom - move left
        if(m>1){    
            for(int i=0;i<n-1;i++){
                result.add(matrix[x][y--]);
            }
        }
 
        //left - move up
        if(n>1){
            for(int i=0;i<m-1;i++){
                result.add(matrix[x--][y]);
            }
        }
 
        if(m==1||n==1)
            result.addAll(spiralCount(matrix, x, y, 1, 1));
        else    
            result.addAll(spiralCount(matrix, x+1, y+1, m-2, n-2));
 
        return result;
    }            
}
