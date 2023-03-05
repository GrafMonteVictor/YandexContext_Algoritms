package minimalRectangle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] coord = new String[2];
        coord = sc.nextLine().split(" ");
        int xMin = Integer.parseInt(coord[0]);
        int yMin = Integer.parseInt(coord[1]);
        int xMax = Integer.parseInt(coord[0]);
        int yMax = Integer.parseInt(coord[1]);

        int i = 0;
        while (n - 1 > i) {
            coord = sc.nextLine().split(" ");
            xMin = Integer.min(xMin,Integer.parseInt(coord[0]));
            yMin = Integer.min(yMin,Integer.parseInt(coord[1]));
            xMax = Integer.max(xMax,Integer.parseInt(coord[0]));
            yMax = Integer.max(yMax,Integer.parseInt(coord[1]));
            i++;
        }
        sc.close();
        System.out.println(xMin + " " + yMin + " " + xMax + " " + yMax);
    }
}
