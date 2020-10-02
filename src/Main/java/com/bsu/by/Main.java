package com.bsu.by;

import java.util.Scanner;

//Polina Sinkevich 9gr. V12
public class Main {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter natural k (influences the correctness of the calculation) ");
            int k = sc.nextInt();
            if (k < 0) {
                throw new Exception("Error! k should be natural number.");
            }
            System.out.println("Enter x (-1,1) ");
            double x = sc.nextDouble();

            if ((x <= -1) || (x >= 1)) {
                throw new Exception("Error! x is out of range (-1,1)");
            }
            double argument = (1 + x) / (1 - x);
            System.out.println(argument);
            double resStandartFunc = Math.log((1 + x) / (1 - x));
            double e = Math.pow(10, -k);
            double resTeilor = getRes(e, x);
            System.out.printf("Result using Teilor's formula is %.3f\n ", resTeilor);
            System.out.printf("Result using standart functions is %.3f\n", resStandartFunc);


        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static double getRes(double e, double x) {
        double term = 1.;
        double sum = 0.;
        int i = 1;
        while (Math.abs(term) >= Math.abs(e)) {
            term = Math.pow(x, i) / i;
            sum += term;
            i += 2;
        }
        return sum * 2;
    }
}
