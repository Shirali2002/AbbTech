package main;

import java.io.*;
import java.util.Scanner;

public class CalcApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("first number: ");
        int a = sc.nextInt();
        System.out.println("second number: ");
        int b = sc.nextInt();

        System.out.print("sum = ");
        System.out.print(a+b);
    }
}
