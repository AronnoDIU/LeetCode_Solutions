package Easy_Problems;

// 202. Happy Number

/*Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

    1. Starting with any positive integer, replace the number by the sum of the squares of its digits.
    2. Repeat the process until the number equals 1 (where it will stay),
    or it loops endlessly in a cycle which does not include 1.
    3. Those numbers for which this process ends in 1 are happy.

Return true if n is a happy number, and false if not.*/
public class HappyNumber_202 {
    public static void main(String[] args) {
        SolutionHappyNumber solutionHappyNumber
                = new SolutionHappyNumber();
        int n = 19;
        System.out.println(solutionHappyNumber.isHappy(n));
    }
}

class SolutionHappyNumber {
    public int find(int number) {
        int answer = 0;
        while (number > 0) {
            int remainsNumber = number % 10;
            answer += remainsNumber * remainsNumber;
            number /= 10;
        }
        return answer;
    }

    public boolean isHappy(int n) {
        int firstProcess = n;
        int secondProcess = n;
        do {
            firstProcess = find(firstProcess);
            secondProcess = find(find(secondProcess));
        } while (firstProcess != secondProcess);
        return firstProcess == 1;
    }

        /*int r = 1, number, sum = 0;
        number = n;
        while (number > 9) {
            while (number > 0) {
                r = number % 10;
                sum = sum + (r * r);
                number = number / 10;
            }
            number = sum;
            sum = 0;
        }
        return number == 1;*/
}
/*Expected Output::
Example 1:

Input: n = 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1

Example 2:

Input: n = 2
Output: false


* */