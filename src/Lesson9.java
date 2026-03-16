import java.util.Scanner;
import java.util.Random;

public class Lesson9 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random r = new Random();

        int[] numbers = new int[1000];

        int count = 0;
        boolean isFound = false;


        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = r.nextInt(1000) + 1; // מג'נרט מספרים בין 1 ל-1000
        }

        for (int i = 0; i < numbers.length; i++) {
            count++;
            if (numbers[i] == 1) isFound = true;
        }

        print("Numbers of steps: " + count);
        count = 0;
        isFound = false;

        count = findOne(numbers);
        print("Numbers of steps = : " + findOne(numbers));

        in.close();


    }

    public static void print(String n){
        System.out.println(n);
    }

    public static int findOne(int[] numbers){
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            count++;
            if (numbers[i] == 1) return count;
        }
        return -1; // לא נמצא
    }

}

