package Easy_Problems;

public class PalindromeNumber_9 {
    public static void main(String[] args) {
        SolutionPalindromeNumber solutionPalindromeNumber
                = new SolutionPalindromeNumber();
        int x = 121;
        System.out.println(solutionPalindromeNumber.isPalindrome(x));
    }
}

class SolutionPalindromeNumber {
    public boolean isPalindrome(int x) {
        int num, r, rev = 0;
        num = x;
        while (num > 0) {
            r = num % 10;
            rev = (rev * 10) + r;
            num = num / 10;
        }
        return x == rev;
    }
}

/*Expected Output::
    true
* */