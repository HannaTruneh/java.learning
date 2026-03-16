/*
פעולות, חלק 1
 פעולת return - חייבת להיות כאשר מחזירים ערך
 פעולות שמחזירות ערכים, שלא מחזירות
 חותמת פעולה, שם, מה היא מקבלת והסוג שמקבלת
*/

import java.util.Scanner;

public class Lesson8 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n1, n2, n3, sum;

        print("Enter first number:");
        n1 = in.nextInt();
        System.out.println("Enter second number:");
        n2 = in.nextInt();

        sum = sumNumbers(n1, n2);
        print("The sum is: " + sum);

        print("Enter third number:");
        n3 = in.nextInt();
        if (isZugi(n3)) {
            print("IS ZUGI");
        } else {
            print("IS NOT ZUGI");
        }


        in.close();

    }

    public static int sumNumbers(int number1, int number2) {
        return number1 + number2;
    }

    public static boolean isZugi(int number) {
        return number % 2 == 0;
    }

    public static void print(String s){
        System.out.println(s);
    }

}
