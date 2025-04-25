package com.example.provider;

import com.example.cooker.Cooker;
import com.example.cooker.Cuisine;

@Cuisine("Thai")
public class ThaiCooking implements Cooker {

    @Override
    public void cook() {
        System.out.println("Cooking a delicious meal of Panang");
    }
}
