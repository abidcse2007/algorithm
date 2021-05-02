package algorithm.array;

/***
 * You are given an array of arrays of integers, where each array corresponds to a row in a triangle of numbers.
 * For example, [[1], [2, 3], [1, 5, 1]] represents the triangle:
 *
 *   1
 *  2 3
 * 1 5 1
 * We define a path in the triangle to start at the top and go down one row at a time to an adjacent value,
 * eventually ending with an entry on the bottom row. For example, 1 -> 3 -> 5. The weight of the path is the sum of the entries.
 *
 * Write a program that returns the weight of the maximum weight path.
 */
public class MaximumSumPathInATriangle {

    public int compute(int[][] input){

        for(int i = input.length -2; i>=0; i--){
            for(int j = 0; j <= i; j++){
                input[i][j] = input[i][j] + Math.max(input[i+1][j], input[i+1][j+1]);
            }
        }
        return  input[0][0];
    }

    public static void main(String[] args){
        int[][] input = new int[3][4];
        input[0][0] = 1;
        input[0][1] = 0;
        input[0][2] = 0;
        input[0][3] = 0;

        input[1][0] = 2;
        input[1][1] = 3;
        input[1][2] = 0;
        input[1][3] = 0;

        input[2][0] = 1;
        input[2][1] = 5;
        input[2][2] = 1;
        input[2][3] = 0;

        System.out.println("Result="+ new MaximumSumPathInATriangle().compute(input));
    }
}
