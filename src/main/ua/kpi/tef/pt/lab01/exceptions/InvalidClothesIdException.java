package ua.kpi.tef.pt.lab01.exceptions;

public class InvalidClothesIdException extends Throwable {

    public InvalidClothesIdException(){
        super();
    }

    public InvalidClothesIdException(String msg) {
        super(msg);
    }

}
