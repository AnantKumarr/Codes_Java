import java.util.Scanner ;
class Average
{
    public static void main(String [] args){
        Scanner sc=new Scanner (System.in);
        System.out.print("Enter thr size of the array : ");
        int length=sc.nextInt();
        int []arr=new int [length];

        for(int i=0;i<length;i++)
        {
            System.out.print("Enter the element :");
            arr[i]=sc.nextInt();
        }
        int sum=0;
         for(int i=0;i<length;i++)
        {
            sum+=arr[i];
        }

        float avg=(float)sum/length;
        System.out.print("Average of the elements of the array are " +avg);


    }
}