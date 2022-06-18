package array;

import java.util.ArrayList;
import java.util.List;

public class RepeatandMissingNumberArray {
	/*Method-1*/
	int[] findTwoElement(int arr[], int n) {
        if(n==1)
            return arr;
        int[] ans=new int[2];
        for(int i=0;i<n;i++){
            int val=Math.abs(arr[i]);
            if(arr[val-1]>0)
                arr[val-1]*=-1;
            else
                ans[0]=val;
        }
        
        for(int i=0;i<n;i++){
            if(arr[i]>0){
                ans[1]=i+1;
                break;
            }
        }
        return ans;
    }
	
	/*Method-2*/
	
	public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        int n=A.size();
        ArrayList<Integer> ans=new ArrayList<>();
        int xor=0;
        for(int i=0;i<n;i++)
            xor^=A.get(i);
        for(int i=1;i<=n;i++)
            xor^=i;
        // System.out.println(xor);
        int pos=-1;
        for(int i=0;i<=31;i++)
            if((xor&(1<<i))!=0)
                pos=i;
        
        int bucket1=0, bucket2=0;

        for(int j=0;j<n;j++){
            int tpos=-1;
            int v=A.get(j);
            for(int i=0;i<=31;i++)
                if((v&(1<<i))!=0)
                    tpos=i;
            if(tpos==pos)
                bucket1^=v;
            else
                bucket2^=v;

        }
        // System.out.println(bucket1+" "+bucket2);
        for(int j=1;j<=n;j++){
            int tpos=-1;
            for(int i=0;i<=31;i++)
                if((j&(1<<i))!=0)
                    tpos=i;
            // System.out.println(tpos);
            if(tpos==pos)
                bucket1^=j;
            else
                bucket2^=j;

        }
        // System.out.println(bucket1+" "+bucket2);
        for(int i=0;i<n;i++){
            if(bucket1==A.get(i)){
                ans.add(bucket1);
                ans.add(bucket2);
                break;
            }
            if(bucket2==A.get(i)){
                ans.add(bucket2);
                ans.add(bucket1);
                break;
            }
        }
        // System.out.println(ans);


        return ans;
    }

}
