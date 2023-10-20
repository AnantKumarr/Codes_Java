import java.util.Scanner ;

 class Maximum
{
    public static void main(String [] args){
        Scanner sc=new Scanner (System.in);
        System.out.println("Enter three numbers ");
       int num1=sc.nextInt();
       int num2=sc.nextInt();
       int num3=sc.nextInt();

       if(num1>num2)
       {
        if(num1>num3)
        System.out.println(num1+" is maximum");
        else
        System.out.println(num3+" is maximum");
       }
        else
        {
            if(num2>num3)
            System.out.println(num2+" is maximum");
            else
            System.out.println(num3+" is maximum");
        }

        
        // finding maximum with the help of ternary operator

        int largest=Largest_Ternary(num1,num2,num3);
        System.out.print("Largest element is "+largest);

    }

       
       public static int Largest_Ternary(int a,int b,int c)
       {
        int largest = (a>=b  && a>=c ) ? a:(b>=a && b>=c) ? b:c;
        return largest;
       }
}

    