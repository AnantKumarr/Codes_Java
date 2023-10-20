class student
{
    static int noOfStudent=5;

    // student()
    // {
    //     noOfStudent++;
    // }
}


// there is no need to create objects to access the ststic variable of any class . We can directly
// access it by the help of the class name.Static variable name

class person
{
    public static void main(String args[])
    {
        System.out.println("No. of students before creating objects of student class  "+student.noOfStudent);
        // student st1=new student();
        // student st2=new student();
        //System.out.println("No. of students after creating objects of student class "+student.noOfStudent);
    }
}