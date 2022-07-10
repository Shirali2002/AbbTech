package main;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int width = sc.nextInt();
        final int height = sc.nextInt();
        final double tan = (double) width/height;
         int[][] coordinates = new int[50][2];
        for (int[] singleCoordinate: coordinates) {
            Arrays.fill(singleCoordinate, -1);
        }



        for (int h = 1; h <= height; h++) {
            if(h==1 || h==height){
                for (int w = 1; w <= width; w++) {
                    if (w==width){
                        printStarWithNewLine();
                    } else {
                        printStar();
                    }
                }
            } else {
                for (int w = 1; w <= width; w++) {
                    if (w==1) {
                        printStar();
                    } else if (w == width){
                        printStarWithNewLine();
                    } else {
                        printSpace();
                    }
                }
            }
        }
    }



    private static void printStar(){
        System.out.print("*");
    }

    private static void printSpace(){
        System.out.print(" ");
    }

    private static void printStarWithNewLine(){
        System.out.println("*");
    }
}
