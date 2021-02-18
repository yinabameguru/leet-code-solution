package cn.com.meguru.helper;

public class Helper {
    public void swap(char[] chars, int i, int j) {
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
    }
}
