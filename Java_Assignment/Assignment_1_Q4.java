import java.util.Scanner;

class HighToKthHigh
{
    public static void main(String []args)
    {
    Scanner sc=new Scanner (System.in);
    System.out.println("Enter the length of the array :");
    int length=sc.nextInt();
    int []arr=new int[length];
    
    for(int i=0;i<length;i++)
    arr[i]=sc.nextInt();
    
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

    System.out.print("Enter the k th highest number upto which you want to found ");
    int k_high=sc.nextInt();
 
       for(int i=length-1;i!=k_high;i--)
       {
        System.out.print(arr[i]);
       }
    
    }
    }
