package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    private String sex;
    private boolean expectedHasMane;
    @Mock
    private LionBehavior lionBehavior;


    public LionTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getFoodParameters() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }


    @Test
    public void constructorExceptionTest(){
        Assert.assertThrows("", Exception.class, () -> new Lion("bee", lionBehavior));
    }
    @Test
    public void maneTest() throws Exception{
        Lion lion = new Lion(sex, lionBehavior);
        Assert.assertEquals(expectedHasMane, lion.doesHaveMane());
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
