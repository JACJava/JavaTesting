package com.pluralsight.JavaTesting;

import org.junit.Assert;
import org.junit.Test;

public class CafeTest {

    /* can brew espresso */

    @Test
    public void canBrewEspresso(){

        //Given...
        Cafe cafe = new Cafe();
        cafe.restockBeans(7);

        //When...
        Coffee coffee = cafe.brew(CoffeeType.Espresso);

        //Then...
        // make sure it's an espresso
        Assert.assertEquals(CoffeeType.Espresso, coffee.getType());

        // make sure it's got no milk
        Assert.assertEquals(0,coffee.getMilk());

        // deliberately make an error
        //Assert.assertEquals("Wrong quantity of coffee", 1,coffee.getMilk());

        // make sure there's enough coffee in it
        Assert.assertEquals(7,coffee.getBeans());
    }

    @Test
    public void brewingEspressoConsumesBeans(){

        //Given...
        Cafe cafe = new Cafe();
        cafe.restockBeans(7);

        //When...
        Coffee coffee = cafe.brew(CoffeeType.Espresso);

        //Then...
        //Restocked with 7 beans, and then used them all in the espresso, so beans in stock should be
        //decremented to zero
        Assert.assertEquals(0, cafe.getBeansInStock());

    }

    //test the idea of brewing a latte and it requires milk
    // need to have a then clause that says exceptions are okay
    @Test(expected = IllegalStateException.class)
    //@Test
    public void lattesRequiresMilk(){

        //Given...
        Cafe cafe = new Cafe();
        cafe.restockBeans(7);

        //When...
        Coffee coffee = cafe.brew(CoffeeType.Latte);


    }



}
