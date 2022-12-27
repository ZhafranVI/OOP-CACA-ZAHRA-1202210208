public class Calculation implements Runnable{
    double radius, side, area;
    double phi = 3.14;

    public void run(){
        System.out.println("======== Program will start in ========");
        for (int i = 3; i == 0; i--){
            System.out.println("Starting with thread" + i);
            try{
                Thread.sleep(600);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void setSquare(double side) throws IllegalArgumentException{
        if (side < 1){
            throw new IllegalArgumentException();
        } else {
            area = side*side;
            getSquare();
        }
    }
    
    public double getSquare(){
        return area;
        
    }

    public void setCircle(double side) throws IllegalArgumentException{
        if (side < 1){
            throw new IllegalArgumentException();
        } else {
            area = phi*radius*radius;
            getCircle();
        }
    }

    public double getCircle(){
        return area;
    }

    public void setTrapezoid(double atas, double bawah, double tinggi) throws IllegalArgumentException{
        double a = atas;
        double b = bawah;
        double t = tinggi;
        if (a < 1) {
            throw new IllegalArgumentException();
        } else if (b < 1){
            throw new IllegalArgumentException();
        } else if (t < 1){
            throw new IllegalArgumentException();
        } else {
            area = 0.5*t*(a+b);
            getTrapezoid();
        }
    }

    public double getTrapezoid(){
        return area;
    }
}
