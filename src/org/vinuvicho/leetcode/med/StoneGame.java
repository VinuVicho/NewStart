package org.vinuvicho.leetcode.med;

import java.util.ArrayList;
import java.util.List;

public class StoneGame {
    public static void main(String[] args) {
        System.out.println(stoneGame(new int[] {7,7,12,16,41,48,41,48,11,9,34,2,44,30,27,12,11,39,31,8,23,11,47,25,15,23,4,17,11,50,16,50,38,34,48,27,16,24,22,48,50,10,26,27,9,43,13,42,46,24}));
    }
    static boolean stoneGame(int[] piles) {
        return true;
//        ArrayList<Short> list = new ArrayList<>();
//        for (int pile : piles) list.add((short) pile);
//        return calculate(0, 0, list);
    }
//    static boolean calculate(int alex, int lee, ArrayList<Short> piles) {
//        return (piles.size() == 0) ? alex > lee :
//                (leeTurn(alex + piles.get(0), lee, listRemover(piles, true), true)
//                && leeTurn(alex + piles.get(0), lee, listRemover(piles, true), false)
//                || leeTurn(alex + piles.get(piles.size() - 1), lee, listRemover(piles, false), true)
//                && leeTurn(alex + piles.get(piles.size() - 1), lee, listRemover(piles, false), false));
//    }
//    static boolean leeTurn(int alex, int lee, ArrayList<Short> piles, boolean first) {
//        return calculate(alex, lee + piles.get(first ? 0 : piles.size()-1), listRemover(piles, first));
//    }
//    static ArrayList<Short> listRemover(ArrayList<Short> list, boolean first) {
//        ArrayList<Short> newList = new ArrayList<>(list);
//        newList.remove(first ? 0 : list.size()-1);
//        return newList;
//    }
}
