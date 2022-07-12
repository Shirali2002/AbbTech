package main;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String a = "  change      MOnday   ".trim().toLowerCase();

        String[] splitted = a.split(" ");
        System.out.println(splitted[splitted.length-1]);

//        for (String s: splitted) {
//            System.out.println(s);
//        }
    }
}
