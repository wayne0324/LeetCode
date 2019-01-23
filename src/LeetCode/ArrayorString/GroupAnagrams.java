package LeetCode.ArrayorString;

import com.sun.javafx.tools.packager.MakeAllParams;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.*;

//49. Given an array of strings, group anagrams together.
//
//Example:
//
//Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
//Output:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]
//Note:
//
//All inputs will be in lowercase.
//The order of your output does not matter.
public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        System.out.println(Arrays.toString(groupAnagrams.groupAnagram(strs).toArray()));
    }

    public List<List<String>> groupAnagram(String[] strs){
    if(strs.length == 0) return new ArrayList<>();
    Map<String, List> ans = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if(ans.containsKey(key)==false){
                ans.put(key, new ArrayList());
            }
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());

    }

}

