package de.hochschule_bochum.tetris.utils;

import java.util.Random;

public class Utils {
    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
}
