package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Leet Code: 118. Pascal's Triangle
 * */

public class PascalTriangle {
	
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal=new ArrayList<>();
        List<Integer> row,pre=null;
        
        for(int i=0;i<numRows;i++){
            row=new ArrayList<>();
            for(int j=0;j<=i;j++)
                if(j==0||j==i)
                    row.add(1);
                else
                    row.add(pre.get(j-1)+pre.get(j));
            
                pre=row;
                pascal.add(row);
        }
        
        return pascal;
    }

}
