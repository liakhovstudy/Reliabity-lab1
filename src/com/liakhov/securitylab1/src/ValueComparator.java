package com.liakhov.securitylab1.src;

import java.util.Comparator;
import java.util.Map;

/**
 * @author: dmytro
 * @date: 10/5/15
 */
public class ValueComparator implements Comparator {

    private Map baseMap;

    public ValueComparator(Map baseMap) {
        this.baseMap = baseMap;
    }

    @Override
    public int compare(Object o1, Object o2) {
        return (double)baseMap.get(o1) >= (double)baseMap.get(o2) ? -1 : 1;
    }
}
