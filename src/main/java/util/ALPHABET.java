package util;

import java.util.Arrays;
import java.util.List;

public class ALPHABET {

    static List<String> alphabet = Arrays.asList("a", "b", "c", "d", "e", "f","g","h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t" ,"u", "v", "w", "x", "y", "z");

    public static void print() {
        System.out.print(alphabet.get(1));
    }

    //erhöht den Buchstaben um x - bei überlauf bleibt der Buchstabe auf a
    public static String incrementletter(String start, int x) {
        int i = 0;
        for (int j = 0; j < 25 ; j++) {
            System.out.print(j);
            if (alphabet.get(j) == start)
                i = j+x;

        }
        return alphabet.get(i);
    }
    

}
