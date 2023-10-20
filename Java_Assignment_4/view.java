
import java.util.ArrayList;

class Student{
    String name;
    int rollNo;
    private ArrayList<Grade> subGrade;

    public Student(String name,int roll){
        this.name = name;
        this.rollNo = roll;
        this.subGrade = new ArrayList<>();
    }

    public void addSubject(String subName,double grade){
        Grade grades = new Grade(subName,grade);
        subGrade.add(grades);
    }

    public double calAverage(){
        double sum = 0.0;
        for(Grade student : subGrade){
            sum = sum + student.getGrade();
        }
        return sum/subGrade.size();
    }
    
    public void studentInfo(){
        System.out.println("Name: "+name);
        System.out.println("Roll number: "+rollNo);
        System.out.println("Subject Grage:");
        for(Grade gra : subGrade){
            System.out.println("Subject:"+gra.getSubject()+" : "+gra.getGrade());
        }
        System.out.println("Average Grade is: "+calAverage());
    }
}

class Grade{
    private String subject;
    private double grade;
    public Grade(String sub,double g){
        this.subject = sub;
        this.grade = g;
    }
    public String getSubject(){
        return subject;
    }
    public double getGrade(){
        return grade;
    }
}
class java_Question_1 {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        Student student1 = new Student("Deepak",100);
        student1.addSubject("Maths",9.8);
        student1.addSubject("Computer Science",9.4);
        student1.addSubject("Physics",9.0);
        students.add(student1);

        Student student2 = new Student("Anant",200);
        student2.addSubject("Maths",7.8);
        student2.addSubject("Computer Science",9.9);
        student2.addSubject("Physics",9.2);
        students.add(student2);

        for(Student student:students){
            student.studentInfo();
            System.out.println();
        }
    }
}
























    import java.util.ArrayList;

class Student{
    String name;
    int rollNo;
    private ArrayList<Grade> subGrade;

    public Student(String name,int roll){
        this.name = name;
        this.rollNo = roll;
        this.subGrade = new ArrayList<>();
    }

    public void addSubject(String subName,double grade){
        Grade grades = new Grade(subName,grade);
        subGrade.add(grades);
    }

    public double calAverage(){
        double sum = 0.0;
        for(Grade student : subGrade){
            sum = sum + student.getGrade();
        }
        return sum/subGrade.size();
    }
    
    public void studentInfo(){
        System.out.println("Name: "+name);
        System.out.println("Roll number: "+rollNo);
        System.out.println("Subject Grage:");
        for(Grade gra : subGrade){
            System.out.println("Subject:"+gra.getSubject()+" : "+gra.getGrade());
        }
        System.out.println("Average Grade is: "+calAverage());
    }

}
class Grade{
    private String subject;
    private double grade;
    public Grade(String sub,double g){
        this.subject = sub;
        this.grade = g;
    }
    public String getSubject(){
        return subject;
    }
    public double getGrade(){
        return grade;
    }
}
class java_Question_1 {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        Student student1 = new Student("Deepak",100);
        student1.addSubject("Maths",9.8);
        student1.addSubject("Computer Science",9.4);
        student1.addSubject("Physics",9.0);
        students.add(student1);

        Student student2 = new Student("Anant",200);
        student2.addSubject("Maths",7.8);
        student2.addSubject("Computer Science",9.9);
        student2.addSubject("Physics",9.2);
        students.add(student2);

        for(Student student:students){
            student.studentInfo();
            System.out.println();
        }
    }
























    
import java.util.ArrayList;

class Student{
    String name;
    int rollNo;
    private ArrayList<Grade> subGrade;

    public Student(String name,int roll){
        this.name = name;
        this.rollNo = roll;
        this.subGrade = new ArrayList<>();
    }

    public void addSubject(String subName,double grade){
        Grade grades = new Grade(subName,grade);
        subGrade.add(grades);
    }

    public double calAverage(){
        double sum = 0.0;
        for(Grade student : subGrade){
            sum = sum + student.getGrade();
        }
        return sum/subGrade.size();
    }
    
    public void studentInfo(){
        System.out.println("Name: "+name);
        System.out.println("Roll number: "+rollNo);
        System.out.println("Subject Grage:");
        for(Grade gra : subGrade){
            System.out.println("Subject:"+gra.getSubject()+" : "+gra.getGrade());
        }
        System.out.println("Average Grade is: "+calAverage());
    }

}
class Grade{
    private String subject;
    private double grade;
    public Grade(String sub,double g){
        this.subject = sub;
        this.grade = g;
    }
    public String getSubject(){
        return subject;
    }
    public double getGrade(){
        return grade;
    }
}
class java_Question_1 {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        Student student1 = new Student("Deepak",100);
        student1.addSubject("Maths",9.8);
        student1.addSubject("Computer Science",9.4);
        student1.addSubject("Physics",9.0);
        students.add(student1);

        Student student2 = new Student("Anant",200);
        student2.addSubject("Maths",7.8);
        student2.addSubject("Computer Science",9.9);
        student2.addSubject("Physics",9.2);
        students.add(student2);

        for(Student student:students){
            student.studentInfo();
            System.out.println();
        }
    }
  
}