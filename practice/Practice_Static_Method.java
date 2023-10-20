class cube
{
    //int side;
    static int side;
    // cube(int x)
    // {
    //     side=x;
    // }

    static int volume()
    {
        //return side*side*side;             Static method can accessonly static data .since 
                                             // side is a local variable it can not be accessed 
                                             // in  a static method
        //System.out.println("Surface area is "+surfaceArea());
        return side*side*side;
        
    }

    static int surfaceArea()
    {
        return 4*side*side;
    }
}

class math
{
    static                               //this is a static block generally used to initialise the value of static variable. this block will get executed only once 
    {
        cube.side=5;
    }
    public static void main(String args[])
    {
        System.out.println("Volume is "+cube.volume());
        System.out.println("Surface area is "+cube.surfaceArea());
    }
}