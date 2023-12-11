package com.example.project_qs;
public class MealOrder {

    private MealType mealType;
    private int quantity;

    public MealOrder(MealType mealType, int quantity) {
        this.mealType = mealType;
        this.quantity = quantity;
    }

    public MealType getMealType() {
        return mealType;
    }

    public int getQuantity() {
        return quantity;
    }

    // Adicione métodos adicionais conforme necessário
}

