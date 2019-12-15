package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static double dystans(double x1, double y1, double x2, double y2)
    {
        double xDystans = x1 - x2;
        double yDystans = y1 - y2;

        return Math.sqrt(xDystans*xDystans + yDystans*yDystans);
    }


    public static void main(String[] args)
    {
        double x1 = 0, x2 = 0, y1 = 0, y2 = 0;

        try
        {
            Scanner input = new Scanner(System.in);

            System.out.println("Podaj x oraz y pierwszego punktu: ");
            x1 = input.nextDouble();
            y1 = input.nextDouble();

            System.out.println("Podaj x oraz y drugiego punktu: ");
            x2 = input.nextDouble();
            y2 = input.nextDouble();

            System.out.println("Dystans pomiedzy ("+ x1 + ", " + y1 + "), a (" +x2 + ", " + y2 + ") wynosi: " + dystans(x1,y1,x2,y2));
        }
        catch(InputMismatchException e)
        {
            System.out.println("Podane dane są w złym formacie");
        }
        catch(Exception e)
        {
            System.out.println("Wystąpił nieoczekiwany błąd");
            e.printStackTrace();
        }

    }
}
