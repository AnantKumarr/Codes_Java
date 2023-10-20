class merge_and_sort
{
    public static void main(String []args)
    {
        int []Array1={1,5,6,7};
        int []Array2={2,4,8,10};
       
        int []Array3=merge_and_sort_Array(Array1,Array2,Array1.length,Array2.length);
         System.out.print("Merged array will look like   " );
         for(int i=0;i<Array1.length+Array2.length;i++)
         System.out.print(Array3[i]+" ");
    }

    public static int [] merge_and_sort_Array(int []Array1,int []Array2,int len1,int len2)
    {
       int len3=len1+len2;
       int [] Array3=new int[len3];
       int i=0;
       int j=0;
       int k=0;

       while(i<len1 && j<len2 )
       {
        if(Array1[i]<Array2[j]){
        Array3[k]=Array1[i];
        k++;
        i++;
       }
       else
       {
        Array3[k]=Array2[j];
         k++;
         j++;
       }
       }

       while(i<len1)
       {
        Array3[k]=Array1[i];
        k++;
        i++;
       }

       while(j<len2)
       {
        Array3[k]=Array2[j];
        k++;
        j++;
       }
        
       return Array3;
       
    }
}