package ua.kpi.tef.pt.lab01.exceptions;

public class InvalidClothesIdException extends Throwable { // + todo created exception class (12)

    public InvalidClothesIdException(){
        super();
    }

    public InvalidClothesIdException(String msg) {
        super(msg);
    }

}
