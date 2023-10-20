class MyClass
{
    int num;
    public void setName(int num)
    {
        this.num=num;
        display();
    }

    public void display()
    {
        System.out.println("Number is "+num);
    }

    public void function1()
    {
        function2(this);
    }
    public void function2(MyClass obj)
    {
        obj.num=15;
        display();
    }
    public MyClass test()
    {
        return this;
    }
    
}

class practice
{
    public static void main(String args[])
    {
        MyClass c1=new MyClass();
        c1.setName(4);
        c1.test().setName(20);
        c1.function1();
       
    }
}