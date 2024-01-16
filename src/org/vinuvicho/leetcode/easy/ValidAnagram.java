package org.vinuvicho.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> letterCount = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (letterCount.containsKey(letter)) {
                letterCount.put(letter, letterCount.get(letter)+1);
            } else {
                letterCount.put(letter, 1);
            }
        }


        return false; //TODO
    }
}
