package kcn.lotto;

import java.util.HashSet;

public class NumberSetGenerator
{
    public HashSet<Integer> returnRandomSubset(int sizeSet,int maxNumber){
        HashSet<Integer> returnSet = new HashSet<>();

        while(returnSet.size()<sizeSet){
            returnSet.add((int)(Math.random()*maxNumber));
        }

        return returnSet;
    }
}
