package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class LionParametrizedTest {
    private final String sex;
    private final boolean expectedHasMane;

    private final LionBehavior lionBehavior = null;


    public LionParametrizedTest(String sex, boolean expectedHasMane) {
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

}
