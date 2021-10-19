package com.whitecloak.digitalbank.util;

import java.util.Random;

public class AccountUtils {

    public static Long generateAccountNumber() {
        return (long) (new Random().nextInt(9000000) + 1000000);
    }
}
