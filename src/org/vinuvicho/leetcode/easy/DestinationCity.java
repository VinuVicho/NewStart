package org.vinuvicho.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class DestinationCity {
    public String destCity(List<List<String>> paths) {
        List<String> destinations = new ArrayList<>();
        for (int i = 0, pathsSize = paths.size(); i < pathsSize; i++) {
            List<String> s = paths.get(i);
            destinations.add(s.get(1));
        }
        for (int i = 0; i < paths.size(); i++) {
            List<String> s = paths.get(i);
            destinations.remove(s.get(0));
        }
        return destinations.get(0);
    }
}
