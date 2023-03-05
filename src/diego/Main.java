package diego;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //считываем марки Диего
        Scanner sc = new Scanner(System.in);
        int countStick = sc.nextInt();
        int[] stickers = new int[countStick];
        //проверка нулевого значения
        if (countStick == 0) {
            sc.nextInt();
        }
        for (int i = 0; i < stickers.length; i++) {
            stickers[i] = sc.nextInt();
        }
        //считываем марки коллекционеров
        int countColl = sc.nextInt();
        int[] stickColl = new int[countColl];
        //проверка нулевого значения
        if (countColl == 0) {
            sc.nextLine();
            sc.nextLine();
            System.out.println(0);
            return;
        }
        for (int i = 0; i < stickColl.length; i++) {
            stickColl[i] = sc.nextInt();
        }
        sc.close();
        //сортируем, удалаяем копии
        stickers = Arrays.stream(stickers).distinct().sorted().toArray();

        //ищем подходящие марки (бинпоиск)
        if (countStick == 0) {
            for (int i = 0; i < stickColl.length; i++) {
                System.out.println(0);
            }
            return;
        }
        System.out.println("\n");
        for (int i = 0; i < stickColl.length; i++) {
            if (stickColl[i] > stickers[stickers.length - 1] ) {
                System.out.println(stickers.length);
                continue;
            } else if (stickColl[i] <= stickers[0]) {
                System.out.println(0);
                continue;
            }
            int l = 0;
            int r = stickers.length - 1;
            int m = (l + r)/2;
            while (l < r) {
                m = (l + r)/2;
                if (stickers[m] >= stickColl[i]) {
                    r = m;
                }
                else {
                    l = m + 1;
                }
            }
            if (stickers[m] == stickColl[i] || stickers[m] > stickColl[i]) {
                m--;
            }
            System.out.println(m + 1);
        }

    }

}
