package com.jim.spring.convertor;

import com.jim.spring.domain.Meeting;

import java.util.Comparator;

/**
 * Created by jim on 11-12-17.
 */
public class MeetingKeyComparator implements Comparator<String> {

    @Override
    public int compare(String m1, String m2) {
        Integer[] s1 = getIntergerArray(m1);
        Integer[] s2 = getIntergerArray(m2);

        for (int i = s1.length - 1; i >= 0; i--) {
            if (s1[i] > s2[i]) return 1;
            if (s1[i] < s2[i]) return -1;
        }
        return 0;
    }

    private Integer[] getIntergerArray(String string) {
        String[] strings = string.split("-");
        Integer[] ints = new Integer[strings.length];
        for (int i = 0; i < strings.length; i++) {
            ints[i] = Integer.valueOf(strings[i]);
        }
        return ints;
    }
}
