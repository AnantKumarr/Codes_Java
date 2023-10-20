class push_zero_to_last
{
    public static void main(String[]args)
    {
        int []arr1={1, 0, 3, 5, 0, 7, 0, 0, 9, 10};
        int []arr2=new int[arr1.length];

        int i=0;
        int j=0;

        while(i<arr1.length)
        {
            if(arr1[i]!=0)
            {
                arr2[j]=arr1[i];
                i++;
                j++;
            }
            else
            i++;
        }

        while(j<arr1.length)
        {
            arr2[j]=0;
            j++;
        }

        for( i=0;i<arr1.length;i++)
        {
            System.out.print(" "+arr2[i]);
        }
    }
}