package com.example.consumer;

import com.example.cooker.Cooker;

import java.util.Scanner;
import java.util.ServiceLoader;

public class Main {

    public static void main(String[] args) {

        ServiceLoader<Cooker> serviceLoader = ServiceLoader.load(Cooker.class);

        var dishes = serviceLoader.stream()
                .map(ServiceLoader.Provider::get)
                .toList();

//        for (Cooker dish : serviceLoader) {
//            var annotation = dish.getClass().getAnnotation(Cuisine.class);
//            if (annotation == null)
//                System.out.println("No annotation of type Cuisine found");
//            else
//                System.out.println("Annotation Cuisine with value: " + annotation.value());
//        }

        System.out.println("What cuisine would you like to cook from?");
        System.out.println("1: Swedish");
        System.out.println("2: Dutch");
        System.out.println("3: Thai");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase();
        if (input.equals("1") || input.equals("swedish")) {
            for (Cooker dish : dishes) {
                if (dish.getClass().getSimpleName().startsWith("Swedish")) {
                    dish.cook();
                }
            }
        }
        if (input.equals("2") || input.equals("dutch")) {
            for (Cooker dish : dishes) {
                if (dish.getClass().getSimpleName().startsWith("Dutch")) {
                    dish.cook();
                }
            }
        }
        if (input.equals("3") || input.equals("thai")) {
            for (Cooker dish : dishes) {
                if (dish.getClass().getSimpleName().startsWith("Thai")) {
                    dish.cook();
                }
            }
        }
    }
}
