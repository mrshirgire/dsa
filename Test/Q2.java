package Test;
/*
Determine whether a given discount coupon is valid or not
The validity of a coupon is determined by:
An empty discount coupon is valid
if a coupon A is valid, then a coupon C made by adding one character d to both the beginning of A and the end of A is also valid ( C = dAd is valid)
if two coupons A & B are valid, then the concatenation of B & A is also valid ( AB & BA are both valid )
Given n coupons, all lower case english characters, determine if a coupon is valid or not. Valid is denoted by 1, invalid by 0

coupons = ['abba', 'abca']
checking abba

An empty coupon is valid
Under the second rule, the same character can be added to the beginning and end of a valid coupon. Add b to get bb as valid
Using the same rule, add a to the beginning and end of 'bb' to get 'abba'.
it is valid
check 'abca'

using rule 2, the 'a' added to the beginning and end of bc does not change its validity
the remaining string bc is not valid. there is no rule allowing the addition of different chars to the ends of the string
it is invalid
coupons = ['daabbd', 'abc']
aa & bb are valid therefore aabb is valid
adding d to front and end makes it daabbd valid
[1, 0]

coupon

* */
public class Q2 {

    public static void main(String[] args) {
        String s = "daabbd";


        System.out.println(validateCoupon(s));
    }

    static boolean validateCoupon(String str) {
        if (str.length() == 0 ) {
            return true;
        }

        if (str.length() % 2  == 1) {
            return false;
        }

        int left = 0;
        int right = str.length() - 1;

        while (left < right && left < str.length()) {
            if (str.charAt(left) == str.charAt(right)) {
                left++;
                right--;
            } else {
                boolean isMirror = false;
                if (str.charAt(left) == str.charAt(left + 1)) {
                    left+=2;
                    isMirror = true;
                }
                if (str.charAt(right) == str.charAt(right-1)) {
                    right-=2;
                    isMirror = true;
                }
                if (!isMirror) {
                    return false;
                }
            }
        }
        return true;
    }
}
