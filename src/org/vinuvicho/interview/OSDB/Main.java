package org.vinuvicho.interview.OSDB;

@SuppressWarnings("ALL")
public class Main {
    public static void main(String[] args) {
        String s = "";
        if (s.isEmpty()) return;
        StringBuilder result = new StringBuilder();
        result.append(s.charAt(0));
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                count++;
            }
            else {
                result.append(count).append(s.charAt(i));
                count = 1;
            }
        }
        result.append(count);
        System.out.println(result);
    }
}
