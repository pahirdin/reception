package com.phd.reception.utiles;

import java.util.Random;

/**
 * @author pahaied@asiainfo.com
 * @date 2020-05-05
 */
public  class Sequns {

    public static int getRandomNickname(int length) {
        StringBuilder val = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            val.append(random.nextInt(10));
        }
        return Integer.parseInt(val.toString());
    }
}
