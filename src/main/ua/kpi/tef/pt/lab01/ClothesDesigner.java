package ua.kpi.tef.pt.lab01;

import ua.kpi.tef.pt.lab01.controller.ClothesController;
import ua.kpi.tef.pt.lab01.exceptions.InvalidClothesIdException;
import ua.kpi.tef.pt.lab01.exceptions.InvalidClothingSectionException;

public class ClothesDesigner {

    private final ClothesController clothesController = new ClothesController();

    // ask about the type of action (create, edit, show, delete)
    public void start(int action, long id, int part) {
        System.out.println("\tType number of action you want to choose:");

        switch(action){
            case 1: {
                System.out.println("Creating clothes.");
                try {
                    clothesController.createClothes(part);
                } catch (InvalidClothingSectionException e) {
                    System.out.println(e.getMessage()); // + todo use of exception (13)
                }
                break;
            }
            case 2: {
                System.out.println("Editing clothes.");
                try {
                    clothesController.editClothes(id);
                } catch (InvalidClothesIdException e) {
                    System.out.println(e.getMessage());
                }
                break;
            }
            case 3: {
                System.out.println("Showing clothes.");
                try {
                    clothesController.showClothes(id);
                } catch (InvalidClothesIdException e) {
                    System.out.println(e.getMessage());
                }
                break;
            }
            case 4: {
                System.out.println("Deleting clothes.");
                try {
                    clothesController.deleteClothes(id);
                } catch (InvalidClothesIdException e) {
                    System.out.println(e.getMessage());
                }
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
    }

    public static void main(String[] args) {
        ClothingPart body = BodyService.create(Material.COTTON, Color.BLUE);
        ClothingPart button = ButtonService.create(Material.COTTON, Color.BLUE, 10);

        UpperBodyClothes clothes_one = UpperBodyClothesService.create(Type.MAN, Name.COAT, Size.L, "Big Coat", body, button);

        long clothes_one_id = clothesController.addUpperBody(clothes_one);

        clothesController.showClothes(clothes_one_id);

        UpperBodyClothesService.editGeneral(clothesController.getUpperBody(clothes_one_id), null, null, null, "new title");
        UpperBodyClothesService.editBody(clothesController.getUpperBody(clothes_one_id), Material.METAL, Color.GREEN);
        UpperBodyClothesService.editButton(clothesController.getUpperBody(clothes_one_id), null, null, 4);

        clothesController.showClothes(clothes_one_id);
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