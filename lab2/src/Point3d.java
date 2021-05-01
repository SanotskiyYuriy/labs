public class Point3d {
    private double round(double val){
        val*=100;
        val=(int) val;
        return val/100;
    }
    private double x,y,z;
    public Point3d ( double x, double y,double z) {
      this.x=x;
      this.y=y;
      this.z=z;
    }
    public Point3d () {
        this(0,0,0);
    }
    public double getX () {
        return x;
    }
    public double getY(){
        return y;
    }
    public double getZ(){
        return z;
    }
    public void setX ( double val) {
        x = val;
    }
    public void setY ( double val) {
        y=val;
    }
    public void setZ(double val){
        z=val;
    }
    public boolean equals(Point3d val){
        if (x!=val.x) return false;
        if (y!=val.y) return false;
        if (z!=val.z) return false;
        return true;
    }
    public double distanceTo(Point3d val){
        return round(Math.sqrt(Math.pow(x-val.x,2)+Math.pow(y-val.y,2)+Math.pow(z-val.z,2)));
    }
}
