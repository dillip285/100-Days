



public class FindShortestDistance {

    public static void main(String[] args) {
        int[][] input = new int[][]{
                                 {0,5,3,1,4,0,0,0},
                                 {0,0,0,0,0,0,1,0},
                                 {0,0,0,0,0,0,2,0},
                                 {0,0,0,0,0,2,0,0},
                                 {0,0,0,0,0,0,0,4},
                                 {0,0,0,0,0,0,0,1},
                                 {0,0,0,0,0,0,0,0},
                                 {0,0,0,0,0,0,1,0},
                         };
        System.out.println(findSortestDistance(input, 1,6,0));
    }

    public static int findSortestDistance(int[][] matrix, int start, int end,int pathSum){
        int sortest = Integer.MAX_VALUE;
        if(start==end) return pathSum;
        int r = start-1;
        for(int c=0;c<matrix[r].length;c++){
            if(matrix[r][c]!=0){
                sortest = Math.min(sortest,findSortestDistance(matrix,c+1,end,pathSum+matrix[r][c]));
            }
        }
        return sortest;
    }
}