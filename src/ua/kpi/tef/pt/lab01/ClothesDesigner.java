package ua.kpi.tef.pt.lab01;

import ua.kpi.tef.pt.lab01.controller.ClothesController;
import ua.kpi.tef.pt.lab01.model.enums.Color;

import java.util.Arrays;

public class ClothesDesigner {

    private final ClothesController clothesController = new ClothesController();

    // todo ask about the type of action (create, edit, show, delete)
    public void start(int action) {
        System.out.println("\tType number of action you want to choose:");

        switch(action++){
            case 1: {
                clothesController.createClothes();
                break;
            }
            case 2: {
                clothesController.editClothes();
                break;
            }
            case 3: {
                clothesController.showClothes();
                break;
            }
            case 4: {
                clothesController.deleteClothes();
                break;
            }
            case 5: { // set 0
                System.out.println("Closing the app");
                return;
            }
            default: {
                System.out.println("Wrong action number");
            }
        }
        start(action);
    }

    public static void main(String[] args) {
        ClothesDesigner app = new ClothesDesigner();
        System.out.println("\t\tStart building your clothes");
        app.start(1);
    }
}




// приложение - конструктор дизайна одежды
// возможность зайти в конструктор для описания требований к будущей единице одежды
// далее, основываясь на подробном описании дизайнер сможет создать одежду. (не в рамках этого приложения)


// (clothes) <- (upper body / lower body)
//                         ||
//                  (clothing part)

 /*
    1) Create and run object of the designer
    2) Ask about if I want to create, delete or edit my current designs (if any)
    3) Creating design
        choose type of the clothing (shoes, clothes, hats...)
        choose material (depends on the type)
        choose size
        choose color
        choose ...
        save
    4) Editing design
        show existing
        choose design
        choose field to edit
        edit...
    5) Delete design
        show existing
        choose design
        delete

_____________
    DESIGN TYPES
    1) Men / Women / Children / Unisex
*/