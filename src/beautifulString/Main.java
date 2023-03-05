package beautifulString;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();

        int n = s.length();
        int[] freq = new int[26]; // массив для хранения количества символов
        int left = 0, right = 0, maxCharCount = 0, maxBeauty = 1;

        while (right < n) {
            freq[s.charAt(right) - 'a']++; // увеличиваем количество символа
            maxCharCount = Math.max(maxCharCount, freq[s.charAt(right) - 'a']); // обновляем максимальное количество повторяющихся символов
            int beauty = right - left + 1 - maxCharCount; // вычисляем красоту текущей строки
            if (beauty <= k) { // если мы можем сделать текущую строку более красивой, то обновляем красоту
                maxBeauty = Math.max(maxBeauty, right - left + 1);
            } else { // если мы не можем сделать текущую строку более красивой, то сдвигаем левую границу
                freq[s.charAt(left) - 'a']--;
                left++;
            }
            right++;
        }

        System.out.println(maxBeauty);

    }
}
