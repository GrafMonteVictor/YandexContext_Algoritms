package sumElementsRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);

        //заполняем линейную матрицу
        int[][] prefixSumMatrix = new int[rows][cols];
        for (int i = 0; i < prefixSumMatrix.length; i++) {
            for (int j = 0; j < prefixSumMatrix[i].length; j++) {
                if (i == 0 && j == 0) {
                    prefixSumMatrix[0][0] = sc.nextInt();
                    continue;
                }
                if (i == 0) {
                    prefixSumMatrix[i][j] = prefixSumMatrix[i][j - 1] + sc.nextInt();
                } else if (j == 0) {
                    prefixSumMatrix[i][j] = prefixSumMatrix[i - 1][j] + sc.nextInt();
                } else {
                    int element = sc.nextInt();
                    prefixSumMatrix[i][j] = (prefixSumMatrix[i][j - 1] + prefixSumMatrix[i - 1][j])
                            - prefixSumMatrix[i - 1][j - 1] + element;
                }
            }
            sc.nextLine();
        }

        //чтение координат, вычисление суммы
        int[] sumsRecrangle = new int[k];
        for (int i = 0; i < k; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            sc.nextLine();
            if ((x1 == 1) && (y1 == 1)) {
                sumsRecrangle[i] = prefixSumMatrix[x2 - 1][y2 - 1];
            //если выбраны элементы из первого столбца
            } else if (y1 == 1 && x1 > 1) {
                sumsRecrangle[i] = prefixSumMatrix[x2 - 1][y2 - 1] - prefixSumMatrix[x1 - 2][y2  - 1];
            //если выбраны элементы из первой строки
            } else if (x1 == 1 && y1 > 1) {
                sumsRecrangle[i] = prefixSumMatrix[x2 - 1][y2 - 1] - prefixSumMatrix[x2 - 1][y1 - 2];
            } else {
                sumsRecrangle[i] = prefixSumMatrix[x2 - 1][y2 - 1] - (prefixSumMatrix[x1 - 2][y2 - 1]
                        + prefixSumMatrix[x2 - 1][y1 - 2]) + prefixSumMatrix[x1 - 2][y1 - 2];
            }
        }
        sc.close();

        Arrays.stream(sumsRecrangle).forEach(System.out::println);
    }
}
