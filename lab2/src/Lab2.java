import java.util.Scanner;

public class Lab2 {

    static Scanner sc = new Scanner(System.in);

    public static Point3d inputPoint(){

        return new Point3d(sc.nextDouble(),sc.nextDouble(),sc.nextDouble());
    }
    public static Double formulaGerona(double a,double b, double c){
        double p=(a+b+c)/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }
    public static Double computeArea(Point3d p1,Point3d p2,Point3d p3){
        double a,b,c;
        a=p1.distanceTo(p2);
        b=p1.distanceTo(p3);
        c=p2.distanceTo(p3);
        double y=formulaGerona(a,b,c);
        return y;
    }
    public static void main(String[] args){
        Point3d a=inputPoint();
        Point3d b=inputPoint();
        Point3d c=inputPoint();
        if(!a.equals(b)&&!a.equals(c)&&!b.equals(c))
            System.out.println(computeArea(a,b,c));
        else System.out.println("Point equals");
    }
}
