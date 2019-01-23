package LeetCode.BackTracking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;



public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        CombinationSum combinationSum = new CombinationSum();
        System.out.println(combinationSum.combinationSum(candidates,7));
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        backtracking(ret,new ArrayList<>(),candidates,target,0);
        return ret;
    }

    public void backtracking(List<List<Integer>> ret, List<Integer> list, int[] candidates, int target, int position) {
        if(target<0) return;
        else if(target==0) ret.add(new ArrayList<>(list));
        else {
            for(int i=position;i<candidates.length;i++) {
                list.add(candidates[i]);
                backtracking(ret,list,candidates,target-candidates[i],i);
                list.remove(list.size()-1);
            }
        }
    }

}
