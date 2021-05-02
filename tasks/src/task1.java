public class task1 {
    public static int remainder(int a,int b){
        return a%b;
    }
    public static double triArea(double a,double b){
        return a*b*0.5;
    }
    public static int animals (int chiken,int cows,int pigs){
        return chiken*2+cows*4+pigs*4;
    }
    public static boolean profitable (double prob,double prize,double pay){
        return prob*prize>pay;
    }
    public static String operation (int a,int b,int N){
        if (a+b==N) return "added";
        if (a-b==N) return "subtracted";
        if (a*b==N) return "multimplied";
        if (a/b==N) return "devided";
        return  "none";
    }
    public static int ctoa (char a){
        return (int) a;
    }
    public static int appUpTo(int a){
        return (a+1)*a/2;
    }
    public static int nextEdge(int a,int b){
        return a+b-1;
    }
    public static int sumOfCubes(int[]a){
        int sum=0;
       for (int element:a){
           sum+=element*element*element;
       }
       return sum;
    }
    public static boolean abcmath(int a,int b,int c){
        for(int i=0;i<b;i++){
            a+=a;
        }
        return a%c==0;
    }
    public static void main(String [] args){
    }
}
