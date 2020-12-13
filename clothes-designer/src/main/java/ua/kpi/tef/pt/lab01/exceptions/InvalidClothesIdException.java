package ua.kpi.tef.pt.lab01.exceptions;

import java.security.InvalidParameterException;

public class InvalidClothesIdException extends InvalidParameterException {

    public InvalidClothesIdException(String msg) {
        super(msg);
    }

}
