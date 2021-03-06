package ru.otus.hw;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;

public class HelloOtus {
    public static void main(String... args) {
        var items = ImmutableMap.of("coin", 3, "glass", 4, "pencil", 1);
        items.entrySet().stream().forEach(System.out::println);

        var fruits = Lists.newArrayList("orange", "banana", "kiwi", "mandarin", "date", "quince");
        fruits.stream().forEach(System.out::println);
    }
}
