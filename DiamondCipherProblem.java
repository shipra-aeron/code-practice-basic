import java.util.Arrays;

public class DiamondCipherProblem {

        public static char[][] encryptDiamondCipher(char[][] table) {
            int n = table.length;
            int m = table[0].length;

            char[][] diamond = new char[2 * n][n];

            // Fill the diamond with empty spaces
            for (char[] row : diamond) {
                Arrays.fill(row, ' ');
            }

            // Populate the diamond with characters from the table
            for (int i = 0; i < n; i++) {
                int rowStart = i / 2;
                for (int j = 0; j < m; j++) {
                    diamond[rowStart + j][i] = table[i][j];
                }
            }

            // Populate the diagonals of the diamond
            for (int i = 0; i < n; i++) {
                int colStart = n - i - 1;
                for (int j = 0; j <= i; j++) {
                    diamond[n + j][colStart + j] = table[i][j];
                }
            }

            return diamond;
        }

        public static void printDiamond(char[][] diamond) {
            for (char[] row : diamond) {
                for (char cell : row) {
                    System.out.print(cell + "\t");
                }
                System.out.println();
            }
        }

        public static void main(String[] args) {
            char[][] table = {
                    {'a', 'b', 'c', 'd'},
                    {'e', 'f', 'g', 'h'},
                    {'i', 'j', 'k', 'l'},
                    {'m', 'n', 'o', 'p'}
            };

            char[][] encryptedTable = encryptDiamondCipher(table);
            printDiamond(encryptedTable);
        }
    }


