package com.example.provider;

import com.example.cooker.Cooker;
import com.example.cooker.Cuisine;

@Cuisine ("Dutch")
public class DutchCooking implements Cooker {

    @Override
    public void cook() {
        System.out.println("Cooking a delicious meal of Stamppot!");
    }
}
