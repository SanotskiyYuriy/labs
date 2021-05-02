import java.util.Arrays;

public class task2 {
public static String repeat(String input,int count){
    String output="";
    for(int i=0;i<input.length();i++){
        char ch=input.charAt(i);
        for (int j=0;j<count;j++)
            output+=ch;
    }
    return output;
}
public static int DefferenseMaxMin(int[]arr){
    if(Arrays.stream(arr).max().isPresent())
        return Arrays.stream(arr).max().getAsInt()- Arrays.stream(arr).min().getAsInt();
else return 0;
}
public static boolean isAvgWhole(int[]arr){
    return (Arrays.stream(arr).sum()% arr.length==0);
}
public static int[] cumulativeSum(int[]arr){
    int[]new_arr=arr.clone();
    if(arr.length>1)
    for(int i=1;i< new_arr.length;i++){
        new_arr[i]+=new_arr[i-1];
    }
    return new_arr;
}
public static int getDecimalPlaces(String str){
    if(str.indexOf('.')==-1) return 0;
    else return str.length()-str.indexOf('.');
}
public static int Fibbonaci(int a){
    if(a<3) return a;
    int[] arr=new int[a];
    arr[0]=1;
    arr[1]=2;
    for(int i=2;i<arr.length;i++)
        arr[i]=arr[i-1]+arr[i-2];
    return arr[a-1];
}
public static boolean isValid(String str){
   return( str.matches("\\d{5}"));
}
    public static boolean isStranglePair(String a,String b){
    if (a.length()==0||b.length()==0) return false;
    if (a.charAt(0)!=b.charAt(b.length()-1)) return false;
    if (b.charAt(0)!=a.charAt(a.length()-1)) return false;
    return true;
    }
public static boolean isPrefix(String word,String prefix){
    return word.indexOf(prefix)==0;
}
public static boolean isSuffix(String word,String suffix){
    return word.indexOf(suffix,word.length()-suffix.length())!=-1;
}
    public static void main(String[] args){
    }
}
