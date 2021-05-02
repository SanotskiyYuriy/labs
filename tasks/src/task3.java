import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class task3 {
    public int solutions1(int a, int b, int c){
        int d=b*b-4*a*c;
        if (d>0) return 2;
        if (d==0) return 1;
        return 0;
    }
    public static int findZip(String str){
       int ind= str.indexOf("zip");
       if (ind==-1) return ind;
       ind=str.indexOf("zip",ind+3);
       return ind;
    }
    public static boolean checkPerfect(int a){
        int sum=0;
        for(int i=1;i<a;i++){
            if (a%i==0) sum+=i;
        }
        return (sum==a);
    }
    public static String flipEndChars(String str){
        if (str.length()<2) return "Incompitable";
        if (str.charAt(0)==str.charAt(str.length()-1)) return "Two's a pair.";
        return str.charAt(str.length()-1)+str.substring(1,str.length()-1)+str.charAt(0);

    }
    public static boolean isValidHexCode(String str){
        if(str.length()!=7) return false;
        if(str.charAt(0)!='#') return false;
        char[] arr=new char[]{'0','1','2',
                '3','4','5','6','7','8','9','a','b',
                'c','d','e','f','A','B','C','D','E','F'};
        Arrays.sort(arr);
        for(int i=1;i<7;i++)
        if(Arrays.binarySearch(arr,str.charAt(i))==-1) return false;
        return true;
    }
    public static boolean same(int[] arr1, int[] arr2){
        TreeSet<Integer> set1= new TreeSet();
        TreeSet<Integer> set2= new TreeSet();
        for(int el: arr1)
            set1.add(el);
        for(int el: arr2)
            set2.add(el);
        return set1.size()==set2.size();
    }
    public static boolean isKapreaker(Integer a){
        String str= ((Integer)(a*a)).toString();
        int left,right;
        left =Integer.parseInt(str.substring(0,str.length()/2));
        right=Integer.parseInt(str.substring(str.length()/2));
        return a==left+right;
    }
    public static String longestZero(String str){
        String zeroStr="";
        int i;
        for(i=0;str.indexOf(zeroStr)!=-1;i++){
            zeroStr+="0";
        }
        return "0".repeat(i-1);
    }
    public static boolean IsPrime(int a){
        for(int i=2;i<a;i++){
            if(a%i==0) return false;
        }
        return true;
    }
    public static int nextPrimitive(int i){
        while (true){
            if (IsPrime(i)) return i;
            i++;
        }
    }
    public static boolean rightTriangle(int a, int b, int c){
        if (a*a+b*b==c*c) return true;
        if (a*a+c*c==b*b) return true;
        if (b*b+c*c==a*a) return true;
        return false;
    }
    public static void main(String[] args){
    }
}
