public class Palindrome {
    public static String reverseString(String input){
        String output="";
        for(int i=input.length()-1;i>=0;i--){
            output+=input.charAt(i);
        }
        return output;
    }
    public static boolean isPalindrome(String str){
        String reverse=reverseString(str);
        return str.equals(reverse);
    }
    public static void main(String[] args) {

        for (int i = 0; i < args.length; i++) {
            String str = args[i];
            if (isPalindrome(str)) System.out.println(str+" it is a Palindrome");
            else System.out.println(str+" it isn`t a Palindrome");
        }
    }
}
