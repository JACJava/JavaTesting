package com.pluralsight.JavaTesting;

/* A coffee shop that can brew cofee and maintains an internal stock of beans and milk */

public class Cafe {

    private int beansInStock = 0;
    private int milkInStock = 0;

    /* method called "brew" that produces coffee, takes coffee type as a parameter */
    public Coffee brew(CoffeeType coffeeType) {return brew(coffeeType, 1);}

    public Coffee brew(CoffeeType coffeeType, int quantity) {

        requirePositive(quantity);

        /* checks that it has the beans and milk to produce the coffee drink */
        int requiredBeans = coffeeType.getRequiredBeans() * quantity;
        int requiredMilk = coffeeType.getRequiredMilk() * quantity;
        if (requiredBeans > beansInStock || requiredMilk > milkInStock) {
            throw new IllegalStateException("Insufficient beans or milk");
        }

        /* updates the stock amount */
        beansInStock -= requiredBeans;
        milkInStock -= requiredMilk;

        /* builds new coffee object */
        return new Coffee(coffeeType, requiredBeans, requiredMilk);
    }

    /* method to restock beans */
    public void restockBeans(int weightInGrams) {
        requirePositive(weightInGrams);
        beansInStock += weightInGrams;
    }

    /* method to restock milk */
    public void restockMilk(int weightInGrams) {
        requirePositive(weightInGrams);
        milkInStock += weightInGrams;
    }

    private void requirePositive(int value) {
        if (value < 1){
            throw new IllegalArgumentException();
        }
    }

    /* check the amount of beans and milk in stock */
    public int getBeansInStock() {return beansInStock;}

    public int getMilkInStock() {return milkInStock;}



}
