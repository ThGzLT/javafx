package learn1java;

import javafx.scene.control.ProgressBar;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import static jdk.nashorn.internal.objects.NativeArray.length;

public class PrimeFactors {

    private static int number;
    private static int z;
    ProgressBar progress = new ProgressBar(0);

    public static int PR1(){
        int a = 100;
        int b = 200;
        int c = 26;
        for (int z = a; z<=b; z+=c){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }

            System.out.println(z);



        }
        System.out.println(c);
        return z;
    }




    public static int PR() {
        int a = 100;
        int b = 200;
        int c = 26;
        double[] duomenys = {a, b, c};
        Instant instant = Instant.now();
        System.out.println(instant + " " + "Naudojami skaiciai:" + Arrays.toString(duomenys));
        for (int z = a; z <= b; z += c) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            int number = z;
            Instant instant1 = Instant.now();
            System.out.print(instant1 + "   ");
            for (int i = 2; i <= number; i++) {

                while (number % i == 0) {
                    System.out.print(i + "*");
                    number = number / i;
                }
            }
            if (number < 1) ;

            System.out.println("=" + z + "  ");
        }
        Instant instantt = Instant.now();
        System.out.println(instantt + " " + "skaiciavimo pabaiga");

        return number;
    }


    public static void main(String[] args) {
        PR1();
        PR();
    }
}