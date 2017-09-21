package recursionTasks;

/**
 * Created by Евгений Дубовой on 18.09.2017.
 */
public class Recursion {

    public static void main(String[] args) {
        String a = "aabbab";
        int [] mas = {11, 3,5, 11, 6,4,2,11,1};
        int p = array11(mas, 0);
    }
    /*We have triangle made of blocks. The topmost row has 1 block, the next row down
     has 2 blocks, the next row has 3 blocks, and so on. Compute recursively
     the total number of blocks in such a triangle with the given number of rows.*/
    public int triangle(int rows) {
        if (rows==0) return 0;
        return rows + triangle(rows-1);
    }

    /*Given a non-negative int n, return the sum of its digits recursively.*/
    public int sumDigits(int n) {
        if (n/10==0) return n;
        return n%10 + sumDigits(n/10);
    }

    //Given a non-negative int n, return the count of the occurrences of 7 as a digit
    public int count7(int n) {
        if (n<=10){
            return n == 7 ? 1 : 0;
        }
        return n % 10 == 7 ? count7(n/10) + 1 : count7(n/10);
    }

    /*Given a non-negative int n, compute recursively the count of the
    occurrences of 8 as a digit, except that an 8 with another 8 immediately to its left
    counts double*/
    public int count8(int n) {
        if (n <= 10){
            return n == 8 ? 1 : 0;
        }
        return n % 10 == 8 && n/10 % 10 == 8 ?
                count8(n/10)+2 : (n%10 == 8 ?
                count8(n/10)+1: count8(n/10) );
    }

    /*Given base and n that are both 1 or more, compute recursively
    the value of base to the n power*/
    public int powerN(int base, int n) {
        return n==1? base : powerN(base, n-1)*base;
    }

    //Given a string, compute recursively the number of lowercase 'x' chars in the string.
    public int countX(String str) {
        if (str.length()==0) return 0;;
        return str.charAt(0) == 'x' ? countX(str.substring(1))+1 : countX(str.substring(1));
    }

    //Given a string, compute recursively the number of times lowercase "hi" appears in the string.
    public int countHi(String str) {
        if(str.length() < 2){
            return 0 ;
        }
        return str.charAt(0) == 'h' && str.charAt(1) == 'i'?
                countHi(str.substring(2)) + 1 : countHi(str.substring(1));
    }

    //Given a string, compute recursively a new string where all the 'x' chars have been removed.
    public String noX(String str) {
        if(str.length() == 0){
            return "";
        }
        return str.startsWith("x") ?
                noX(str.substring(1)) : str.substring(0,1)+noX(str.substring(1));
    }

    public boolean array6(int[] nums, int index) {
        if (index == nums.length){
            return false;
        }
        return nums[index] == 6 || array6(nums, index + 1);
    }

    public static int array11(int[] nums, int index) {
        if (index == nums.length) return 0;
        return nums[index] == 11 ?
                array11(nums, index+1) + 1 : array11(nums, index+1);
    }
}
