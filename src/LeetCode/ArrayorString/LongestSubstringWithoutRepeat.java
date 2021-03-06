package LeetCode.ArrayorString;

//3.Given a string, find the length of the longest substring without repeating characters.
//
//        Example 1:
//
//        Input: "abcabcbb"
//        Output: 3
//        Explanation: The answer is "abc", with the length of 3.
//        Example 2:
//
//        Input: "bbbbb"
//        Output: 1
//        Explanation: The answer is "b", with the length of 1.
//        Example 3:
//
//        Input: "pwwkew"
//        Output: 3
//        Explanation: The answer is "wke", with the length of 3.
//        Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

// Window Slide 方法， window是从前面重复的最后一个一直到后面重复的第一个； subsequence可以不连着，但是substring一定是要连着（abcccccd中abd是subsequence, abc,cd是substring)
// aaaabcdeffffff

import java.util.*;


public class LongestSubstringWithoutRepeat {

    public static void main(String[] args) {
        String s="aabbcc";
        LongestSubstringWithoutRepeat longestSubstringWithoutRepeat = new LongestSubstringWithoutRepeat();
        longestSubstringWithoutRepeat.lengthOfLongestSubstring_hashmap(s);


    }


    public int lengthOfLongestSubstring_hashset(String s){
        int n = s.length();
        int i = 0, j=0, ans =0;

        Set<Character> set = new HashSet<>();
        while(i<n&&j<n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
            }else {
                set.remove(s.charAt(i++));
            }

            ans = Math.max(j-i, ans);

        }
        System.out.println(ans);
        return ans;

    }

    public int lengthOfLongestSubstring_hashmap(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }


}
