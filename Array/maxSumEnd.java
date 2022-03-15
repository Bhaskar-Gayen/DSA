 /* Max array sum from end of a array */
 int maxSumEnd(ArrayList A){
 int sumsofer=0;
    for(int i=0;i<B;i++)
        sumsofer+=A.get(i);
    int f=B-1, r=A.size()-1;
    int maxsum=sumsofer;
    while(f>=0&&r>=0){
        sumsofer+=A.get(r--);
        sumsofer-=A.get(f--);
        maxsum=Math.max(sumsofer,maxsum);
    }
    return maxsum;
}