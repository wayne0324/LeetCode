package LeetCode.Arrays;

//387.Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
//
//        Examples:
//
//        s = "leetcode"
//        return 0.
//
//        s = "loveleetcode",
//        return 2.
//        Note: You may assume the string contain only lowercase letters.

public class FirstUniqueCharacter {
    public int firstUniqChar(String s) {
        int[] counter = new int[26];
        for(int i=0; i<s.length(); i++){
            counter[s.charAt(i)-'a']++;
        }
        for(int i=0; i<s.length(); i++){
            if(counter[s.charAt(i)-'a']==1){
                return i;
            }

        }
        return -1;
    }
}

}
