package com.example;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;


@RunWith(Parameterized.class)
public class AnimalGetFoodTest {
    private String animalType;
    private List<String> validFood;
    private String exceptionMessage;
    private String familyText;

    public AnimalGetFoodTest(String animalType, List<String> validFood, String exceptionMessage) {
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

    static Animal animal;

    @Parameterized.BeforeParam
    public static void setUp() {
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
}