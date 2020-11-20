package ua.kpi.tef.pt.lab01;

import ua.kpi.tef.pt.lab01.controller.ClothesController;
import ua.kpi.tef.pt.lab01.model.ClothingPart;
import ua.kpi.tef.pt.lab01.model.UpperBodyClothes;
import ua.kpi.tef.pt.lab01.model.parts.*;
import ua.kpi.tef.pt.lab01.service.BodyService;
import ua.kpi.tef.pt.lab01.service.ButtonService;
import ua.kpi.tef.pt.lab01.service.UpperBodyClothesService;

public class ClothesDesigner {

    private static final ClothesController clothesController = new ClothesController();

    public static void main(String[] args) {
        ClothingPart body = BodyService.create(Material.COTTON, Color.BLUE);
        ClothingPart button = ButtonService.create(Material.COTTON, Color.BLUE, 10);

        UpperBodyClothesService.create("Big Coat 1", Type.MAN, Name.COAT, Size.L, 81.2, body, button);
        UpperBodyClothesService.create("Big Coat 2", Type.MAN, Name.COAT, Size.L, 81.2, body, button);
        UpperBodyClothesService.create("Big Coat 3", Type.MAN, Name.COAT, Size.L, 81.2, body, button);
        UpperBodyClothes clothes_one = UpperBodyClothesService.create("Big Coat", Type.MAN, Name.COAT, Size.L, 81.2, body, button);

        long clothes_one_id = clothesController.addUpperBody(clothes_one);
        clothesController.addUpperBody(clothes_one);

        clothesController.showClothes(clothes_one_id);

        UpperBodyClothesService.editGeneral(clothesController.getUpperBody(clothes_one_id),"new title", null, null, null, 90.2);
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