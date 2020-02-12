package com.gsafety.dawn.enterprise.common.util;

import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortUtil {
    private static final String STRING_SEPARATOR = "&sort=";

    public static Sort createSort(String sort) {
        String[] sortStrArr = sort.split(STRING_SEPARATOR);
        return createSort(Arrays.asList(sortStrArr));
    }

    public static Sort createSort(List<String> sorts) {
        List<Sort.Order> orders = new ArrayList<>();
        for (String sortStr : sorts) {
            String[] strArr = sortStr.split(",");
            if (strArr.length == 2) {
                orders.add(new Sort.Order(Sort.Direction.fromString(strArr[1]), strArr[0]));
            } else {
                orders.add(Sort.Order.by(strArr[0]));
            }
        }
        return Sort.by(orders);
    }
}