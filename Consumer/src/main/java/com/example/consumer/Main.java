package com.example.consumer;

import com.example.cooker.Cooker;

import java.util.ServiceLoader;

public class Main {

    public static void main(String[] args) {

        ServiceLoader<Cooker> serviceLoader = ServiceLoader.load(Cooker.class);

        var dishes = serviceLoader.stream()
                .filter(cookerProvider -> cookerProvider.type().isAnnotation())
                .map(ServiceLoader.Provider::get)
                .toList();
    }
}
