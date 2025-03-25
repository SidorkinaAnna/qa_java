package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {
    private Feline feline;

    @Before
    public void setUp() {
        feline = Mockito.spy(new Feline());
    }

    @Test
    public void testEatMeatReturnsPredatorFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.doReturn(expectedFood).when(feline).getFood("Хищник");

        List<String> actualFood = feline.eatMeat();

        assertEquals(expectedFood, actualFood);
    }

    @Test
    public void testGetFamilyReturnsCorrectValue() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testGetKittensWithoutParameterReturnsOne() {
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void testGetKittensWithParameterReturnsCorrectValue() {
        int kittensCount = 3;
        assertEquals(kittensCount, feline.getKittens(kittensCount));
    }
}

