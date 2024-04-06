package com.gui.swing.Service;

import java.util.Random;

public class GeneralService {

    protected static int generateConfirmationCode(int beginRange, int endRange){
        return (int) (Math.random() * (endRange - beginRange + 1) + beginRange);
    }
}
