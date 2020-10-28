package ua.kpi.tef.pt.lab01.exceptions;

public class InvalidClothingSectionException extends Throwable {
    public InvalidClothingSectionException(){
        super();
    }

    public InvalidClothingSectionException(String msg) {
        super(msg);
    }
}
