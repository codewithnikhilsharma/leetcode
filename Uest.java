class Solution {
    public int closetTarget(String[] words, String target, int startIndex) {

     int m=startIndex;
     int n=startIndex;
     int len=words.length;
     int count=0;

     while(count<len)
     {
         if((words[m].equals(target)) || (words[n]).equals(target))
         {
             return count;
         }
         
             if(m==len-1)
             {
                 m=0;
             }
             else
             {
                 m+=1;
             }
             if(n==0)
             {
                 n=len-1;
             }
             else
             {
                 n-=1;
             }
             count++;
        }
        return -1;   
    }
}
