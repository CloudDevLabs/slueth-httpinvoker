package com.cdl.sleuthhttpinvoker.randomservice.model;

import java.io.Serializable;

public class RandomReply implements Serializable {
    private int random;

    public RandomReply(int random) {
        this.random = random;
    }

    public int getRandom() {
        return random;
    }

    @Override
    public String toString() {
        return "RandomReply{" +
                "random=" + random +
                '}';
    }
}
