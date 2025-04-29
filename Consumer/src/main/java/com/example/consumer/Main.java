package com.example.consumer;

import com.example.cooker.Cooker;
import com.example.cooker.Cuisine;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ServiceLoader;

public class Main {

    public static void main(String[] args) {

        ServiceLoader<Cooker> serviceLoader = ServiceLoader.load(Cooker.class);

        var dishes = serviceLoader.stream()
                .map(ServiceLoader.Provider::get)
                .toList();

        System.out.println("What cuisine would you like to cook from? Pick a number 1-3!");
        int i = 1;
        Map<Integer, Cooker> options = new HashMap<>();
        for (Cooker dish : dishes) {
            Cuisine cuisine = dish.getClass().getAnnotation(Cuisine.class);
            if (cuisine != null) {
                System.out.println(i + ": " + cuisine.value());
                options.put(i++, dish);
            }
        }

        Scanner scanner = new Scanner(System.in);
        try {
            int input = scanner.nextInt();

            Cooker selectedDish = options.get(input);
            if (selectedDish != null) {
                selectedDish.cook();
            } else {
                System.out.println("Please pick a valid number from the menu.");
            }
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter a number between 1 and 3.");
        } finally {
            scanner.close();
        }
    }
}
