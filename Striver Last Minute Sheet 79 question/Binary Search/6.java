class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        int n = s.length();
        char[][] matrix = new char[numRows][n];

        int i = 0;
        int j = 0;

        int index = 0;
        while (index < n) {

            // 🔹 Vertical down
            while (i < numRows && index < n) {
                matrix[i][j] = s.charAt(index);
                i++;
                index++;
            }

            i -= 2; // ek upar aur ek skip

            // 🔹 Diagonal up
            while (i >= 0 && j < n && index < n) {
                j++;
                matrix[i][j] = s.charAt(index);
                i--;
                index++;
            }

            i += 2; // next vertical ke liye reset
        }

        StringBuilder str = new StringBuilder();
        for (i = 0; i < numRows; i++) {
            for (j = 0; j < n; j++) {
                if (matrix[i][j] == '\u0000') {
                    continue;
                }
                str.append(matrix[i][j]);
            }
        }

        return str.toString();
    }
}
