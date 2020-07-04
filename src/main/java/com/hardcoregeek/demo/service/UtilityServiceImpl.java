package com.hardcoregeek.demo.service;

public class UtilityServiceImpl implements Utility {
    @Override
    public int sumOf(int x, int y) {
        int sum = 0;
        for (int i = x; i <= y; i++) {
            sum += i;
        }
        return sum;
    }
}
