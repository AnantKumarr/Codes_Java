import java.util.Scanner;

class Largest{
    public static void main(String []args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the length of the array ");
        int length=sc.nextInt();
        int []arr=new int [length];
         for(int i=0;i<length;i++)
         {
            System.out.print("Enter the elements : ");
            arr[i]=sc.nextInt();
         }

         int max=Integer.MIN_VALUE;
         for(int e:arr)
         {
            if(e>max)
            max=e;
         }
         System.out.print("Largest element among the array would be "+max);

        // Finding the second largest element 
        System.out.println("Second Largest element among the array would be "+Sec_max(arr,length));
        
    }
    public static int Sec_max(int []arr,int length)
    {
      int temp=0;
     
    for(int i = 0; i < length; i++)    
    {    
      for(int j = i+1; j < length; j++)    
        {    
            if(arr[j] < arr[i])    
            {    
                temp = arr[i];    
                arr[i] = arr[j];    
                arr[j] = temp;   
            }

        }
    }
    return arr[length-2];
    }
}