package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    private String sex = "Самка";
    @Mock
    private LionBehavior lionBehavior;



    @Test
    public void constructorExceptionTest(){
        Assert.assertThrows("", Exception.class, () -> new Lion("bee", lionBehavior));
    }

    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion(sex, lionBehavior);

        int kittensCount = 3;
        Mockito.when(lionBehavior.getKittens()).thenReturn(kittensCount);
        Assert.assertEquals(kittensCount, lion.getKittens());

        Mockito.verify(lionBehavior).getKittens();
    }

    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion(sex, lionBehavior);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(lionBehavior.getFood()).thenReturn(expectedFood);
        Assert.assertEquals(expectedFood, lion.getFood());

        Mockito.verify(lionBehavior).getFood();
    }

}
