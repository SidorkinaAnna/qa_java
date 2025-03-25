package com.example;

import java.util.List;

public class Lion {

    boolean hasMane;
    private LionBehavior lionBehavior;

    public Lion(String sex, LionBehavior lionBehavior) throws Exception {
        this.lionBehavior = lionBehavior;
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }


    public int getKittens() {
        return lionBehavior.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return lionBehavior.getFood();
    }
}
