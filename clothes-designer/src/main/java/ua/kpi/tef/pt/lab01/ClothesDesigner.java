package ua.kpi.tef.pt.lab01;

import ua.kpi.tef.pt.lab01.controller.ClothesController;
import ua.kpi.tef.pt.lab01.entity.ClothingPart;
import ua.kpi.tef.pt.lab01.entity.UpperBodyClothes;
import ua.kpi.tef.pt.lab01.entity.parts.*;
import ua.kpi.tef.pt.lab01.service.*;

public class ClothesDesigner {

    private static final ClothesController clothesController = new ClothesController();

    private static final LeftLegService leftLegService = new LeftLegService();
    private static final RightLegService rightLegService = new RightLegService();
    private static final BodyService bodyService = new BodyService();
    private static final ButtonService buttonService = new ButtonService();
    private static final LeftSleeveService leftSleeveService = new LeftSleeveService();
    private static final RightSleeveService rightSleeveService = new RightSleeveService();

    private static final UpperBodyClothesService upperBodyClothesService = new UpperBodyClothesService(bodyService, buttonService, leftSleeveService, rightSleeveService);
    private static final LowerBodyClothesService lowerBodyClothesService = new LowerBodyClothesService(leftLegService, rightLegService, buttonService);

    public static void main(String[] args) {
        ClothingPart body = bodyService.create(Material.COTTON, Color.BLUE);
        ClothingPart button = buttonService.create(Material.COTTON, Color.BLUE, 10);

        UpperBodyClothes clothes_one = upperBodyClothesService.create("Big Coat", Type.MAN, Name.COAT,
                Size.L, 81.2, body, button);

        long clothes_one_id = clothesController.addUpperBody(clothes_one);
        clothesController.addUpperBody(clothes_one);

        clothesController.showClothes(clothes_one_id);

        upperBodyClothesService.editGeneral(clothesController.getUpperBody(clothes_one_id), "Bigger Coat", null, null, null, 99.2);
        upperBodyClothesService.editBody(clothesController.getUpperBody(clothes_one_id), Material.METAL, Color.GREEN);
        upperBodyClothesService.editButton(clothesController.getUpperBody(clothes_one_id), null, null, 4);

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