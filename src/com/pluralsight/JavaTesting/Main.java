package com.pluralsight.JavaTesting;

import static com.pluralsight.JavaTesting.CoffeeType.Espresso;
import static com.pluralsight.JavaTesting.CoffeeType.FilterCoffee;
import static com.pluralsight.JavaTesting.CoffeeType.Latte;

public class Main {

    public static void main(String[] args) {
	// write your code here

        System.out.println();
        System.out.println("*** Testing Code ***");
        System.out.println();

        Coffee Coffee1 = new Coffee(Latte,4,8 );
        Coffee Coffee2 = new Coffee(Espresso,6,0 );
        Coffee Coffee3 = new Coffee(FilterCoffee,3,2 );

        System.out.println(Coffee1);
        System.out.println(Coffee2);
        System.out.println(Coffee3);

    }
}
