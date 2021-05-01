public class Primes {

    public static boolean IsPrime(int a){
        for(int i=2;i<a;i++){
            if(a%i==0) return false;
        }
        return true;
    }

    public static void main (String[] args){
        for(int i=2;i<=100;i++){
            if(IsPrime(i))
                System.out.println(i);
        }
    }
}


