package com.example.consumer;

import com.example.cooker.Cooker;
import com.example.cooker.Cuisine;

import java.util.ServiceLoader;

public class Main {

    public static void main(String[] args) {

        ServiceLoader<Cooker> serviceLoader = ServiceLoader.load(Cooker.class);

        var dishes = serviceLoader.stream()
                .filter(cookerProvider -> cookerProvider.type().isAnnotation())
                .map(ServiceLoader.Provider::get)
                .toList();

        for (Cooker dish : dishes) {
            if (dishes.getClass().getSimpleName().startsWith("Swedish"))
                dish.cook();
        }

        for (Cooker dish : serviceLoader) {
            var annotation = dish.getClass().getAnnotation(Cuisine.class);
            if (annotation == null)
                System.out.println("No annotation of type Cuisine found");
            else
                System.out.println("Annotation Cuisine with value: " + annotation.value());
        }
    }
}
