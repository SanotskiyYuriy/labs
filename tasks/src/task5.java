import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class task5  {
    public static int[] encrypt(String str) {
        int length = str.length();
        int[] result = new int[length];
        result[0] = str.charAt(0);

        for (int i = 1; i < length; i++) {
            result[i] = str.charAt(i) - str.charAt(i - 1);
        }

        return result;
    }

    public static String decrypt(int[] arr) {
        int[] encoded = new int[arr.length];

        System.arraycopy(arr, 0, encoded, 0, arr.length);

        char[] result = new char[arr.length];

        result[0] = (char) arr[0];

        for (int i = 1; i < encoded.length; i++) {
            result[i] = (char) (encoded[i] + encoded[i - 1]);
            encoded[i] = encoded[i] + encoded[i - 1];
        }

        return new String(result);
    }

    public static boolean canMove(String name, String start, String end) {
        char startLetter = start.charAt(0);
        int startNumber = Integer.parseInt(String.valueOf(start.charAt(1)));
        char endLetter = end.charAt(0);
        int endNumber = Integer.parseInt(String.valueOf(end.charAt(1)));

        if (startLetter == endLetter && startNumber == endNumber) return false;

        switch (name) {
            case "Pawn": {
                if (startLetter == endLetter && startNumber == 2 && endNumber == 4)
                    return true;
                return startLetter == endLetter && endNumber == (startNumber + 1);
            }
            case "Knight": {
                return (Math.abs(startLetter - endLetter) == 2 && Math.abs(startNumber - endNumber) == 1) || (Math.abs(startLetter - endLetter) == 1 && Math.abs(startNumber - endNumber) == 2);
            }
            case "Bishop": {
                return Math.abs(startLetter - endLetter) == Math.abs(startNumber - endNumber);
            }
            case "Rook": {
                return (startLetter == endLetter && startNumber != endNumber) || (startLetter != endLetter && startNumber == endNumber);
            }
            case "Queen": {
                if ((startLetter == endLetter && startNumber != endNumber) || (startLetter != endLetter && startNumber == endNumber))
                    return true;
                if (Math.abs(startLetter - endLetter) == Math.abs(startNumber - endNumber))
                    return true;
                break;
            }
            case "King": {
                return Math.abs(startLetter - endLetter) < 2 && Math.abs(startNumber - endNumber) < 2;
            }
            default:
                return false;
        }

        return false;
    }

    public static boolean canComplete(String str1, String str2) {
        char[] chars = str1.toCharArray();
        int startOfSearch = 0;
        for (char c : chars) {
            if (str2.indexOf(String.valueOf(c), startOfSearch) != -1)
                startOfSearch = str2.indexOf(String.valueOf(c), startOfSearch) + 1;
            else
                return false;
        }
        return true;
    }

    public static int sumDigProd(int[] mass) {
        int sum = 0;

        for (int value : mass) {
            sum += value;
        }

        while (sum > 9) {
            int mult = 1;

            while (sum > 0) {
                mult *= sum % 10;
                sum /= 10;
            }

            sum = mult;
        }

        return sum;
    }

    public static ArrayList<String> sameVowelGroup(String[] strs) {
        String[] allVowels = new String[]{"a", "e", "y", "u", "i", "o"};
        String vowels = "";
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < allVowels.length; i++) {
            if (strs[0].contains(allVowels[i]) && !vowels.contains(allVowels[i])) {
                vowels += allVowels[i];
            }
        }

        if (vowels.length() > 0) {
            result.add(strs[0]);
        } else {
            return result;
        }

        for (int i = 1; i < strs.length; i++) {
            boolean pass = true;

            for (int j = 0; j < vowels.length(); j++) {
                if (!strs[i].contains(String.valueOf(vowels.charAt(j)))) {
                    pass = false;
                    break;
                }
            }

            if (pass) result.add(strs[i]);
        }

        return result;
    }

    public static boolean validateCard(long cardNum) {
        StringBuilder str = new StringBuilder();
        long number = cardNum;

        if (Long.toString(number).length() >= 14 && Long.toString(number).length() <= 19) {
            // step 1
            long lastNum = number % 10;
            StringBuilder cardNumStr = new StringBuilder(Long.toString(number /= 10));
            // step 2
            cardNumStr.reverse();
            // step 3
            for (int i = 0; i < cardNumStr.length(); i++) {
                if (i % 2 == 0) {
                    int c = Character.getNumericValue(cardNumStr.charAt(i)) * 2;

                    if (c > 9) {
                        String buf = Integer.toString(c);

                        str.append(Character.getNumericValue(buf.charAt(0)) + Character.getNumericValue(buf.charAt(1)));
                    } else {
                        str.append(c);
                    }
                } else {
                    str.append(cardNumStr.charAt(i));
                }
            }

            System.out.println(str);
            int sum = 0;

            for (int i = 0; i < str.length(); i++) {
                sum += Character.getNumericValue(str.charAt(i));
            }

            System.out.println(sum);
            System.out.println(lastNum);

            return lastNum == 10 - sum % 10;
        }

        return false;
    }

    public static String numToEng(int num) {
        String str = "";
        if (num == 0) return "zero";

        switch (num / 100) {
            case 1: {
                str += "one hundred ";
                break;
            }
            case 2: {
                str += "two hundred ";
                break;
            }
            case 3: {
                str += "three hundred ";
                break;
            }
            case 4: {
                str += "four hundred ";
                break;
            }
            case 5: {
                str += "five hundred ";
                break;
            }
            case 6: {
                str += "six hundred ";
                break;
            }
            case 7: {
                str += "seven hundred ";
                break;
            }
            case 8: {
                str += "eight hundred ";
                break;
            }
            case 9: {
                str += "nine hundred ";
                break;
            }
        }

        switch (num / 10 % 10) {
            case 1: {
                switch (num % 10) {
                    case 0: {
                        str += "ten";
                        return str;
                    }
                    case 1: {
                        str += "eleven";
                        return str;
                    }
                    case 2: {
                        str += "twelve";
                        return str;
                    }
                    case 3: {
                        str += "thirteen";
                        return str;
                    }
                    case 4: {
                        str += "fourteen";
                        return str;
                    }
                    case 5: {
                        str += "fifteen";
                        return str;
                    }
                    case 6: {
                        str += "sixteen";
                        return str;
                    }
                    case 7: {
                        str += "seventeen";
                        return str;
                    }
                    case 8: {
                        str += "eighteen";
                        return str;
                    }
                    case 9: {
                        str += "nineteen";
                        return str;
                    }
                }
            }

            case 2: {
                str += "twenty ";
                break;
            }
            case 3: {
                str += "thirty ";
                break;
            }
            case 4: {
                str += "forty ";
                break;
            }
            case 5: {
                str += "fifty ";
                break;
            }
            case 6: {
                str += "sixty ";
                break;
            }
            case 7: {
                str += "seventy ";
                break;
            }
            case 8: {
                str += "eighty ";
                break;
            }
            case 9: {
                str += "ninety ";
                break;
            }
        }

        switch (num % 10) {
            case 1: {
                str += "one";
                break;
            }
            case 2: {
                str += "two";
                break;
            }
            case 3: {
                str += "three";
                break;
            }
            case 4: {
                str += "four";
                break;
            }
            case 5: {
                str += "five";
                break;
            }
            case 6: {
                str += "six";
                break;
            }
            case 7: {
                str += "seven";
                break;
            }
            case 8: {
                str += "eight";
                break;
            }
            case 9: {
                str += "nine";
                break;
            }
        }

        return str;
    }

    public static String numToRus(int num) {
        String str = "";

        if (num == 0) return "????????";

        switch (num / 100) {
            case 1: {
                str += "?????? ";
                break;
            }
            case 2: {
                str += "???????????? ";
                break;
            }
            case 3: {
                str += "???????????? ";
                break;
            }
            case 4: {
                str += "?????????????????? ";
                break;
            }
            case 5: {
                str += "?????????????? ";
                break;
            }
            case 6: {
                str += "???????????????? ";
                break;
            }
            case 7: {
                str += "?????????????? ";
                break;
            }
            case 8: {
                str += "?????????????????? ";
                break;
            }
            case 9: {
                str += "?????????????????? ";
                break;
            }
        }

        switch (num / 10 % 10) {
            case 1: {
                switch (num % 10) {
                    case 0: {
                        str += "????????????";
                        return str;
                    }
                    case 1: {
                        str += "??????????????????????";
                        return str;
                    }
                    case 2: {
                        str += "????????????????????";
                        return str;
                    }
                    case 3: {
                        str += "????????????????????";
                        return str;
                    }
                    case 4: {
                        str += "????????????????????????";
                        return str;
                    }
                    case 5: {
                        str += "????????????????????";
                        return str;
                    }
                    case 6: {
                        str += "??????????????????????";
                        return str;
                    }
                    case 7: {
                        str += "????????????????????";
                        return str;
                    }
                    case 8: {
                        str += "??????????????????????????";
                        return str;
                    }
                    case 9: {
                        str += "????????????????";
                        return str;
                    }
                }
            }

            case 2: {
                str += "???????????????? ";
                break;
            }
            case 3: {
                str += "???????????????? ";
                break;
            }
            case 4: {
                str += "?????????? ";
                break;
            }
            case 5: {
                str += "?????????????????? ";
                break;
            }
            case 6: {
                str += "???????????????????? ";
                break;
            }
            case 7: {
                str += "?????????????????? ";
                break;
            }
            case 8: {
                str += "?????????????????????? ";
                break;
            }
            case 9: {
                str += "?????????????????? ";
                break;
            }
        }

        switch (num % 10) {
            case 1: {
                str += "????????";
                break;
            }
            case 2: {
                str += "??????";
                break;
            }
            case 3: {
                str += "??????";
                break;
            }
            case 4: {
                str += "????????????";
                break;
            }
            case 5: {
                str += "????????";
                break;
            }
            case 6: {
                str += "??????????";
                break;
            }
            case 7: {
                str += "????????";
                break;
            }
            case 8: {
                str += "????????????";
                break;
            }
            case 9: {
                str += "????????????";
                break;
            }
        }

        return str;
    }

    public static String getSha256Hash(String str) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] text = digest.digest(str.getBytes(StandardCharsets.UTF_8));

        return HexBin.encode(text).toLowerCase();
    }

    public static String correctTitle(String str) {
        String[] tokens = str.split(" ");

        for (int i = 0; i < tokens.length; i++) {
            if (!tokens[i].equalsIgnoreCase("of") && !tokens[i].equalsIgnoreCase("and") && !tokens[i].equalsIgnoreCase("the") && !tokens[i].equalsIgnoreCase("in")) {
                tokens[i] = String.valueOf(tokens[i].charAt(0)).toUpperCase() + tokens[i].substring(1).toLowerCase();
            } else {
                tokens[i] = tokens[i].toLowerCase();
            }
        }

        return String.join(" ", tokens);
    }

    public static String haxLattice(int n) {
        int num = 1;
        int i = 1;
        String res = "";
        String str2 = "";

        while (n > num) {
            i++;
            num = 3 * i * (i - 1) + 1;
        }

        int l = i;

        if (n != num)
            res = "invalid";
        else {
            while (l < i * 2 - 1) {

                for (int a = 0; a < i * 2 - 1 - l; a++)
                    res += "  ";

                for (int b = 0; b < l; b++)
                    res += " o  ";

                res += "\n";
                l++;
            }

            while (l >= i) {

                for (int a = 0; a < i * 2 - 1 - l; a++)
                    res += "  ";

                for (int b = l; b > 0; b--)
                    res += " o  ";

                res += "\n";
                l--;
            }
        }

        return res;
    }
    public static void main(String [] args){
    }
}
