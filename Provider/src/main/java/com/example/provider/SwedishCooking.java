package com.example.provider;

import com.example.cooker.Cooker;
import com.example.cooker.Cuisine;

@Cuisine("Swedish")
public class SwedishCooking implements Cooker {

    @Override
    public void cook() {
        System.out.println("Cooking a delicious meal of Meatballs");
    }
}
