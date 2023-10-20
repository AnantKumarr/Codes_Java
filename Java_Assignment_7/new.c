#include<stdio.h>
int pills(int a,int b)
{

   if(a>=b)
   return a-b;

   else if(b%2==0)
    {
        b=b/2;
        return 1 + pills(a,b);        
    }
    else 
    {
        b++;
        return 1 + pills(a,b);
    }

}
int main()
{
    int stVal,target;
    printf("enter the start value and the target:");
    scanf("%d",&stVal);
    scanf("%d",&target);
    int a=pills(stVal,target);
    printf("output= %d",a);    

    return 0;
}

escape the matrix - SAMRIDHI TIWARI.txt
Displaying escape the matrix - SAMRIDHI TIWARI.txt.