abstract class Shape{
    abstract  double area();
    abstract  double perimeter();
}


class Circles extends Shape {
    private double radius;

    public Circles(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }

    @Override
    double perimeter() {
        return 2 * Math.PI * radius;
    }
}
class Rectangles extends Shape {
    int length;
    int breadth;

    public Rectangles(int l, int b) {
        this.length = l;
        this.breadth = b;
    }

    double area() {
        return length * breadth;
    }

    double perimeter() {
        return 2 * (length + breadth);
    }
}
class Triangle extends Shape{
    double side1;
    double side2;
    double side3;
    double s = (side1+side2+side3)/2;
    public Triangle(double s1,double s2,double s3){
        this.side1 = s1;
        this.side2 = s2;
        this.side3 = s3;
    }
    double area(){
        return Math.sqrt(s*(s-side1)(s-side2)(s-side3));
    }
    double perimeter(){
        return side1+side2+side3;
    }
}
class java_Question_1 {
    public static void main(String[] args) {
         Circles c = new Circles(7);
         Rectangles r = new Rectangles(4,7);
         Triangle t = new Triangle(5.0,6.0,7.0);

        System.out.println("The area of circle is: "+c.area());
        System.out.println("The perimeter of circle is: "+c.perimeter());
        System.out.println("The area of rectangle is: "+r.area());
        System.out.println("The perimeter of rectangle is: "+r.perimeter());
        System.out.println("The area of triangle is: "+t.area());
        System.out.println("The perimeter of triangle is: "+t.perimeter());
    }
}
