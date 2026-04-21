class Solution {
    public int[][] flipAndInvertImage(int[][] arr) {
        reverseRows(arr);
    for (int i = 0; i < arr.length; i++) {          // rows
            for (int j = 0; j < arr[i].length; j++) {   // columns
               arr[i][j]^=1;
            
    }
    }
    return arr;
    }
      public static void reverseRows(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int start = 0;
            int end = matrix[i].length - 1;

            while (start < end) {
                // Swap elements in the row
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;

                start++;
                end--;
            }
        }
    }
}
