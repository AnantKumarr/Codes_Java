class Student
{
    int rollNo;
    String name;
    String course;
    float fee;

    Student(int rollNo,String name ,String course)
    {
        this.rollNo=rollNo;
        this.name=name;
        this.course=course;
        

    }
    Student(int rollNo,String name,String course,float fee )
    {
        this(rollNo,name,course);
        this.fee=fee;
    }

    public void display()
    {
        System.out.println("Roll number is "+this.rollNo);
        System.out.println("name is "+this.name);
        System.out.println("course is "+this.course);
        System.out.println("fees for the course is "+this.fee);

    }
}

class School
{
    public static void main(String args[])
    {
        Student S1=new Student(2201023,"Anant Kumar","E.C.E");
        Student S2=new Student(2201024,"Animesh Kumar","C.S.E",133500);
        S1.display();
        System.out.println();
        S2.display();
    }
}