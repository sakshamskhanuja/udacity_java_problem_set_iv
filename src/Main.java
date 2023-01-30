public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        /*
         * Question 1
         *
         * Complete the factorial() function below. It should return the product of all the numbers from 1 to the
         * parameter n. For example, factorial(5) should return 120 because 1 x 2 x 3 x 4 x 5 = 120. Think about what
         * kind of loop you want to use to accomplish this.
         */
        System.out.println(main.factorial(5));

        /*
         * Question 2
         *
         * Complete the code in this function to find and return the lowest index in the String array stringArray that
         * the String target occurs. If the String target does not occur in stringArray, -1 should be returned.
         */
        System.out.println(main.indexOfFirstOccurrence(new String[]{"Learning", "Java", "is", "fun."}, "Java"));

        /*
         * Question 3
         *
         * A savings account yields 5% interest annually. This Java function is designed to determine how many years it
         * will take for you to have $1,000,000 on deposit given an initial value. The parameter represents the initial
         * deposit, and the function should return an integer number of years before there will be $1,000,000 or more
         * in the account. Write a loop to determine the number of years, and return that value.
         */
        System.out.println(main.yearsTillOneMillion(5000));

        /*
         * Question 4
         *
         * Complete the Java function below to print out all the Strings in the String array parameter in reverse order.
         * (The String at the highest index should be printed first, then the String at the next highest index, and so
         * on. The String at index 0 should be printed last.)
         */
        main.printInReverse(new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"});

        /*
         * Question 5
         *
         * Complete the function below, which finds the range covered by an integer array. Inside the function, find
         * the smallest value in the parameter array, and find the largest value, and return the largest value minus
         * the smallest value. If the array has length 0, return -1.
         */
        System.out.println(main.findRange(new int[]{1, 0, 2, 3, -1, 2}));

        /*
         * Question 6
         *
         * Let's improve the monopolyRoll() function from the previous problem set. Recall that in Monopoly, players
         * roll two six-sided dice to determine their move. If the same value is on both dice, this is called "rolling
         * doubles," and it means they go again. In the last problem set, you wrote a function that rolled two
         * six-sided dice and, if the values on both die were the same, rolled two more and returned the sum. This time,
         * write a function that does the same except it continues rolling until two non-equal values appear on the two
         * dice. In other words, the function should behave as follows:
         *
         * 1. Generate two random numbers in the 1 to 6 range.
         * 2. If they are not the same, return the sum of all numbers rolled so far.
         * 3. If they are the same, keep track of the total rolled so far and return to step 1.
         */
        System.out.println(main.monopolyRoll());

        /*
         * Optional challenge: in Monopoly, if a player rolls doubles three times in a row, they go to "jail." Modify
         * your function to keep track of the number of rolls made so far. If three consecutive doubles are rolled,
         * return -1 instead of continuing to roll.
         */
        System.out.println(main.monopolyRollOptionalChallenge1());

        /*
         * Optional challenge 2: in the last lesson, you learned about while loops and for loops as a way to make a
         * computer program repeat. There is another method for making a program repeat using only functions called
         * recursion. A "recursive" function is one which calls itself inside itself. See if you can write the
         * monopolyRoll() function by calling monopolyRoll() inside the function itself to handle the case where
         * further rolls are made.
         */
        System.out.println(main.monopolyRollOptionalChallenge2());
    }

    /**
     * Calculates the factorial of a number.
     *
     * @param n Whole number.
     * @return n!
     */
    public int factorial(int n) {
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    /**
     * Finds the index of target in a String array.
     *
     * @param stringArray String array.
     * @param target      String target.
     * @return Index of target in String array.
     */
    public int indexOfFirstOccurrence(String[] stringArray, String target) {
        for (int i = 0; i < stringArray.length; i++) {
            if (target.equals(stringArray[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Calculates the number of years to get 1,000,000 deposit on 5% interest annually.
     *
     * @param initialBalance Initial balance in bank account.
     * @return Number of years to reach 1,000,000.
     */
    public int yearsTillOneMillion(double initialBalance) {
        int years = 0;
        while (initialBalance <= 1000000) {
            initialBalance *= 1.05;
            years++;
        }
        return years;
    }

    /**
     * Prints a String array in reverse.
     */
    public void printInReverse(String[] stringArray) {
        for (int i = (stringArray.length - 1); i >= 0; i--) {
            System.out.println(stringArray[i]);
        }
    }

    /**
     * Finds the range covered by an integer array.
     *
     * @param intArray Integer array.
     * @return Difference between the maximum and minimum value in array.
     */
    public int findRange(int[] intArray) {
        if (intArray.length == 0) {
            return -1;
        }

        // Stores the minimum value.
        int min = Integer.MAX_VALUE;

        // Stores the maximum value.
        int max = Integer.MIN_VALUE;

        for (int element : intArray) {
            if (element > max) {
                max = element;
            }
            if (element < min) {
                min = element;
            }
        }
        return max - min;
    }


    /**
     * Rolls a 6 face dice.
     *
     * @return Number from 1 to 6.
     */
    public int rollDice() {
        int a = (int) (Math.random() * 6) + 1;
        System.out.println(a);
        return a;
    }

    /**
     * Rolls two dice.
     */
    public int monopolyRoll() {
        int rollA = rollDice();
        int rollB = rollDice();

        int total = rollA + rollB;

        while (rollA == rollB) {
            rollA = rollDice();
            rollB = rollDice();
            total += rollA + rollB;
        }
        return total;
    }

    /**
     * Rolls two dice. Optional Challenge - 1
     */
    public int monopolyRollOptionalChallenge1() {
        int rollA = rollDice();
        int rollB = rollDice();

        int count = 0;

        int total = rollA + rollB;

        while (rollA == rollB) {
            count++;
            if (count == 3) {
                return -1;
            }
            rollA = rollDice();
            rollB = rollDice();
            total += rollA + rollB;
        }
        return total;
    }

    /**
     * Rolls two dice. Optional Challenge - 2
     */
    public int monopolyRollOptionalChallenge2() {
        int rollA = rollDice();
        int rollB = rollDice();

        int total = rollA + rollB;

        if (rollA == rollB) {
            total += monopolyRollOptionalChallenge2();
        }

        return total;
    }
}