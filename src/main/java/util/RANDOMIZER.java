package util;

import java.util.Random;

public class RANDOMIZER {

    public static String randNumS(int lower, int upper) {
        Random r = new Random();
        int n = r.nextInt(upper-lower+1) + lower;
        String s = String.valueOf(n);
        System.out.print(lower+" - "+upper+": "+s+"\n");
        return s;
    }
}

