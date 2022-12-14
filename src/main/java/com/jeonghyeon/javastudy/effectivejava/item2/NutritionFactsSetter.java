package com.jeonghyeon.javastudy.effectivejava.item2;

public class NutritionFactsSetter {
    private int servingSize = -1; // 필수 : 기본값 없음
    private int servings = -1; // 필수 : 기본값 없음
    private int calories = 0; // 선택
    private int fat = 0;  // 선택
    private int sodium = 0;   // 선택
    private int carbohydrate = 0; // 선택

    public NutritionFactsSetter(){}

    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }
}
