package com.example;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;


@RunWith(Parameterized.class)
public class AnimalTest {
    private final String animalType;
    private final List<String> validFood;
    private final String exceptionMessage;

    public AnimalTest(String animalType, List<String> validFood, String exceptionMessage) {
        this.animalType = animalType;
        this.validFood = validFood;
        this.exceptionMessage = exceptionMessage;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getFoodParameters() {
        return new Object[][]{
                {"Хищник", List.of("Животные", "Птицы", "Рыба"), null},
                {"Травоядное", List.of("Трава", "Различные растения"), null},
                {"Несуществующее", null, "Неизвестный вид животного, используйте значение Травоядное или Хищник"},
        };
    }

    Animal animal;

    @Before
    public void setUp() {
        animal = new Animal();
    }

    @Test
    public void getFoodTest() throws Exception {
        if (exceptionMessage == null) {
            List<String> actualFood = animal.getFood(animalType);
            Assert.assertEquals(validFood, actualFood);
        } else {
            Assert.assertThrows(exceptionMessage, Exception.class, () -> animal.getFood(animalType));
        }
    }

    @Test
    public void getFamilyTest(){
        Assert.assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи",
                animal.getFamily());
    }
}