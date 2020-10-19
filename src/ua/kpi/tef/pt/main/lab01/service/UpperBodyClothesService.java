package ua.kpi.tef.pt.main.lab01.service;

import ua.kpi.tef.pt.main.lab01.model.*;
import ua.kpi.tef.pt.main.lab01.model.enums.Name;
import ua.kpi.tef.pt.main.lab01.model.enums.Size;
import ua.kpi.tef.pt.main.lab01.model.enums.Type;

import java.util.Iterator;

public class UpperBodyClothesService {

    private final BodyService bodyService = new BodyService();
    private final LeftSleeveService leftSleeveService = new LeftSleeveService();
    private final RightSleeveService rightSleeveService = new RightSleeveService();
    private final ButtonService buttonService = new ButtonService();
    // ...

    /**
     * Used to create any lower body clothes. Asks user by itself
     */
    // todo implement user controls
    public UpperBodyClothes create() {
        UpperBodyClothes upperBodyClothes = new UpperBodyClothes();
        upperBodyClothes.setType(findType());
        upperBodyClothes.setName(findName());
        upperBodyClothes.setSize(findSize());

        upperBodyClothes.add(bodyService.create());
        upperBodyClothes.add(leftSleeveService.create());
        upperBodyClothes.add(rightSleeveService.create());
        upperBodyClothes.add(buttonService.create());

        upperBodyClothes.setTitle("Shirt for the tester");
        return upperBodyClothes;
    }

    // todo implement user controls
    public void edit(UpperBodyClothes upperBodyClothes) {
        upperBodyClothes.setType(findType());
        upperBodyClothes.setName(findName());
        upperBodyClothes.setSize(findSize());

        Iterator<ClothingPart> clothingPartIterator = upperBodyClothes.getIterator(); // todo use iterator at clothingPart toString (to print parts from newline)
        while(clothingPartIterator.hasNext()){
            ClothingPart part = clothingPartIterator.next();
            if(part instanceof Body) { // todo try to use map here
                bodyService.edit(part);
            } else if(part instanceof LeftSleeve) {
                leftSleeveService.edit(part);
            } else if(part instanceof RightSleeve) {
                rightSleeveService.edit(part);
            } else if(part instanceof Button) {
                buttonService.edit(part);
            }
        }

        upperBodyClothes.setTitle("Edited Shirt"); // todo change to findTitle()
    }

    public void show(UpperBodyClothes item) {
        System.out.println(item.toString());
    }

    // todo implement user input recognition
    private Type findType() {
        return Type.WOMAN;
    }

    private Size findSize() {
        return Size.M;
    }

    private Name findName() {
        return Name.SHIRT;
    }

    private String findTitle() { return "Title Upper Body"; }

}
    // collect basic data about the type of the Clothes, will it have pockets, sleeves, buttons and how many.
    // Then create needed UpperBodyClothes based on that data
    // generally ask all the questions about the clothes