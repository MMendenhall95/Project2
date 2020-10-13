package midtermpt2;

import java.util.Arrays;
import java.util.Random;

public class MidtermPt2 {

    public static int[] bruteforce(int[] num, int sum) {
        int[] indexes = new int[2];
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num.length; j++) {
                if ((num[i] + num[j]) == sum) {
                    indexes[0] = i;
                    indexes[1] = j;
                    return indexes;
                }
            }
        }
        return null;

    }

    public static int[] binarySearchSorted(int[] num, int sum) {
        int value = 0;
        int[] results = new int[2];
        for (int i = 0; i < num.length; i++) {
            value = sum - num[i];
            if ((Arrays.binarySearch(num, value) >= 0)) {
                results[0] = i;
                results[0] = Arrays.binarySearch(num, value);
                return results;
            }

        }
        return null;

    }

    public static void printValues(int[] index, int[] array, int sum) {
        if (index == null) {
            System.out.println("Nothing found");
        } else {
            System.out.println("Numbers adding to " + sum + " in array with " + array.length + " values: \n" + array[index[0]] + " + " + array[index[1]]);
        }
    }

    public static void main(String[] args) {
        int[] hun = new int[100];
        int[] thou = new int[1000];
        int[] hunThou = new int[100000];
        int[] mill = new int[1000000];
        int up = 100;
        int lo = -100;
        Random random = new Random();
        int sum = random.nextInt(200 + 200) - 200;

        //fills arrays with random numbers
        for (int i = 0; i < 1000000; i++) {
            if (i < 100) {
                hun[i] = random.nextInt(up - lo) + lo;
                thou[i] = random.nextInt(up - lo) + lo;
                hunThou[i] = random.nextInt(up - lo) + lo;
                mill[i] = random.nextInt(up - lo) + lo;
            } else if (i < 1000 && i >= 100) {
                thou[i] = random.nextInt(up - lo) + lo;
                hunThou[i] = random.nextInt(up - lo) + lo;
                mill[i] = random.nextInt(up - lo) + lo;
            } else if (i < 100000 && i >= 1000) {
                hunThou[i] = random.nextInt(up - lo) + lo;
                mill[i] = random.nextInt(up - lo) + lo;
            } else {
                mill[i] = random.nextInt(up - lo) + lo;
            }
        }

        System.out.println("values in array of length 100: ");
        for (int i = 0; i < hun.length; i++) {
            System.out.print(hun[i] + ", ");
        }

        System.out.println("\nUNSORTED BRUTE FORCE:");
        printValues(bruteforce(hun, sum), hun, sum);
        printValues(bruteforce(thou, sum), thou, sum);
        printValues(bruteforce(hunThou, sum), hunThou, sum);
        printValues(bruteforce(mill, sum), mill, sum);

        System.out.println("\nUNSORTED BINARY SEARCH:");
        printValues(binarySearchSorted(hun, sum), hun, sum);
        printValues(binarySearchSorted(thou, sum), thou, sum);
        printValues(binarySearchSorted(hunThou, sum), hunThou, sum);
        printValues(binarySearchSorted(mill, sum), mill, sum);

        System.out.println("\nSORTED BRUTE FORCE:");

        Arrays.sort(hun);
        Arrays.sort(thou);
        Arrays.sort(hunThou);
        Arrays.sort(mill);
        //         binarySearchSorted(hun, sum);

        printValues(bruteforce(hun, sum), hun, sum);
        printValues(bruteforce(thou, sum), thou, sum);
        printValues(bruteforce(hunThou, sum), hunThou, sum);
        printValues(bruteforce(mill, sum), mill, sum);

        System.out.println("\nSORTED BINARY SEARCH:");
        printValues(binarySearchSorted(hun, sum), hun, sum);
        printValues(binarySearchSorted(thou, sum), thou, sum);
        printValues(binarySearchSorted(hunThou, sum), hunThou, sum);
        printValues(binarySearchSorted(mill, sum), mill, sum);
    }

}
