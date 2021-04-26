package algorithm.string;

public class MinimumInsertionRequiredToMakePalindrom {

    public int count(String input) {
        String s1 = input;
        String s2 = new StringBuilder(s1).reverse().toString();
        int[][] result = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            result[i][0] = 0;
        }

        for (int i = 0; i <= s2.length(); i++) {
            result[0][i] = 0;
        }

        for (int row = 1; row < result.length; row++) {
            for (int col = 1; col < result[0].length; col++) {
                if (s1.charAt(row - 1) == s2.charAt(col - 1)) {
                    result[row][col] =+ 1;

                } else {
                    result[row][col] = Math.max(result[row][col - 1], result[row - 1][col]);
                }
            }
        }

        for (int row = 0; row < s1.length() + 1; row++) {
            for (int col = 0; col < s2.length() + 1; col++) {
                System.out.print(result[row][col] + " ");
            }
            System.out.println();

        }

        return s1.length() -result[result.length -1][result[0].length -1];
    }

    public static void main(String[] args) {
        System.out.println(new MinimumInsertionRequiredToMakePalindrom().count("ace"));
    }

}
