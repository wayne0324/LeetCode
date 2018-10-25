package LeetCode.ArrayorString;
//242. Given two strings s and t , write a function to determine if t is an anagram of s.
//
//        Example 1:
//
//        Input: s = "anagram", t = "nagaram"
//        Output: true
//        Example 2:
//
//        Input: s = "rat", t = "car"
//        Output: false
//        Note:
//        You may assume the string contains only lowercase alphabets.
//
//        Follow up:
//        What if the inputs contain unicode characters? How would you adapt your solution to such case?

import java.util.Arrays;

public class Anagram {
    public boolean isAnagram_Solution1(String s, String t) {
        if(s.length() != t.length()){return false;}
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        if(Arrays.equals(arr1, arr2)){return true;}
        else{return false;}
    }


    public boolean isAnagram_Solution2(String s, String t) {
        if(s.length() != t.length()){return false;}

        int[] counter = new int[26];

        for(int i = 0; i < s.length(); i++){
            counter[s.charAt(i)-'a']++;   //The reason for - 'a', is that it "shifts" the ascii/unicode value so that a - z have values 0 - 25.
            counter[t.charAt(i)-'a']--;
        }
        for(int count:counter){
            if(count!=0) {return false;}

        }
        return true;

    }


}
