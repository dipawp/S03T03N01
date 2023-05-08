package controller;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
	
	public static String getString(String message){
        Scanner sc = new Scanner(System.in);
        String input = "";
        boolean correct = false;

        do {
            System.out.println(message);
            try {
                input = sc.nextLine();
                correct = true;
            } catch (InputMismatchException ex){
                System.out.println("Només estan permesos caràcters.");
            }
        } while(!correct);
        return input;
    }
	
	
	public static int getInt(String message){
        Scanner sc = new Scanner(System.in);
        int input = 0;
        boolean correct = false;

        do {
            System.out.println(message);
            try {
                input = sc.nextInt();
                correct = true;
            } catch (InputMismatchException ex){
                System.out.println("Només estan permesos nombres sencers.");
            }
            sc.nextLine();
        } while(!correct);
        return input;
    }
	
	public static float getFloat(String message){
        Scanner sc = new Scanner(System.in);
        float input = 0;
        boolean correct = false;

        do {
            System.out.println(message);
            try {
                input = sc.nextFloat();
                correct = true;
            } catch (InputMismatchException ex){
                System.out.println("Només estan permesos nombres amb decimals.");
            }
            sc.nextLine();
        } while(!correct);
        return input;
    }

}
