package com.example.demo.flatMap;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.*;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class FlatMap {

    @Test
    void flatMap1() {
        assertEquals(Optional.of("STRING"), Optional
                .of("string")
                .flatMap(s -> Optional.of("STRING")));

        Optional<String> s1 = Optional.of("string").flatMap(s -> Optional.of(s));
        log.info("test : {}", s1.get());

        assertEquals(Optional.of(Optional.of("STRING")),
                Optional
                        .of("string")
                        .map(s -> Optional.of("STRING")));
    }

    @Test
    void flatMapInStream() {
        List<String> myList = Stream.of("a", "b")
                .map(String::toUpperCase)
                .collect(toList());
        assertEquals(asList("A", "B"), myList);

        List<List<String>> list = asList(
                asList("a"),
                asList("b"));
        System.out.println(list);
        Optional<String> reduce = list.stream().flatMap(s -> s.stream()).reduce((a, b) -> (a + b));
        log.info(" etst: {}", reduce.get());

    }
}
