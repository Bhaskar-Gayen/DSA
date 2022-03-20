package algorithm;

class MainClass {
	
	/* Find Square root of a Number using Binary Search Time complexity O(Log n) */
    public int mySqrt(int x) {
        if(x==0||x==1) return x;
        long s=0, e=x>>1;
        long ans=0;
        while(s<=e){
            long mid=(s+e)>>1;
            long sq=mid*mid;
            if(sq==x)
                return (int)mid;
            else{
                if(sq>x)
                    e=mid-1;
                else{
                    ans=mid;
                    s=mid+1;
                }
            }
        }
        double d= morePrecise((int)ans, x, 9);
        System.out.println(d);
        return (int)ans;
    }
    
    //Calculate decimal part of square root of a number
    static double morePrecise(int integer, int x, int decimalpoint){
        double factor = 1, ans=0;
        for(int i=0;i<decimalpoint;i++){
            factor /=10;
            for(ans=integer;ans*ans<x;ans+=factor);
        }
        return ans;
    }
    
    /* Find Square root of a Number Time Complexity O(root(n)) */ 
    static int fun(int x){
        long y=0;
            while(y*y<=x){
            y++;
            }
            return (int)y-1;
            }
}