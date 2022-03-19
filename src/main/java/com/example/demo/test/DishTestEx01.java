package com.example.demo.test;

import com.example.demo.lambda.Dish;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

@Slf4j
public class DishTestEx01 {
  public static void main(String[] args) {
    List<Dish> menu = Arrays.asList(
        new Dish("pork", false, 800, Dish.Type.MEAT),
        new Dish("beef", false, 700, Dish.Type.MEAT),
        new Dish("chicken", false, 400, Dish.Type.MEAT),
        new Dish("french fries", true, 530, Dish.Type.OTHER),
        new Dish("rice", true, 350, Dish.Type.OTHER),
        new Dish("season fruit", true, 120, Dish.Type.OTHER),
        new Dish("pizza", true, 550, Dish.Type.OTHER),
        new Dish("prawns", false, 300, Dish.Type.FISH),
        new Dish("salmon", false, 450, Dish.Type.FISH)
    );

    Map<Dish.Type, List<Dish>> caloricDishesByType =
        menu.stream().filter(dish -> dish.getCalories() > 500)
            .collect(groupingBy(Dish::getType));
    log.info("test:{}", caloricDishesByType);

    Map<Dish.Type, List<String>> dishNameByType
        = menu.stream()
              .collect(groupingBy(Dish::getType, mapping(Dish::getName, toList())));

    log.info("test !!!! : {}", dishNameByType);

    Map<Dish.Type, List<Dish>> caloricDishesByType1
        = menu.stream()
              .collect(groupingBy(Dish::getType
                  , filtering(dish -> dish.getCalories() > 500 ,toList()))
              );
    log.info("test 3 : {}", caloricDishesByType1);

    Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel =
        menu.stream().collect(
            groupingBy(Dish::getType,
              groupingBy(dish -> {
               if(dish.getCalories() <= 400)
                 return CaloricLevel.DIET;
               else if (dish.getCalories() <= 700)
                 return CaloricLevel.NORMAL; else return CaloricLevel.FAT;
              })
            )
        );
    log.info("test 4 : {}", dishesByTypeCaloricLevel);

  }
}

enum CaloricLevel {
  DIET, NORMAL, FAT
}
