package LeetCode.ArrayorString;

public class ToLowerCase {
    public String toLowerCase(String str) {
        if(str == null){
            return null;
        }
        char[] a = str.toCharArray();
        for(int i=0;i<a.length;i++){
            if('A'<=a[i]&&a[i]<='Z'){
                a[i] = (char)(a[i] - 'A' + 'a');
            }
        }
        return new String(a);
    }
}
