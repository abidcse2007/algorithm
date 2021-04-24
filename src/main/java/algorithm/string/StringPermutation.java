package algorithm.string;

import java.util.HashMap;
import java.util.Map;

public class StringPermutation {

    public void permute(String input){
        Map<Character, Integer> countMap = new HashMap<>();
        for(int i = 0; i< input.length(); i++){
            countMap.put(input.charAt(i), 1);
        }

        char[] placeHolder = new char[input.length()];
        compute(0,input,countMap,placeHolder);

    }


    public void compute(int level, String input, Map<Character, Integer> countMap, char[] placeHolder){
        if(level >= input.length()){
            System.out.println(String.valueOf(placeHolder));
            return;
        }else{
            for(int i = 0; i< input.length(); i++){
                if(countMap.get(input.charAt(i)) == 0){
                    continue;
                }
                placeHolder[level] = input.charAt(i);
                countMap.put(input.charAt(i), countMap.get(input.charAt(i)) -1);
                compute(level+1, input,countMap, placeHolder);
                countMap.put(input.charAt(i), countMap.get(input.charAt(i)) + 1);
            }
        }
    }


    public static void main(String[] args){
        new StringPermutation().permute("ABC");
    }
}
