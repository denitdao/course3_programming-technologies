package ua.kpi.tef.pt.lab01.service;

import ua.kpi.tef.pt.lab01.model.*;
import ua.kpi.tef.pt.lab01.model.enums.Name;
import ua.kpi.tef.pt.lab01.model.enums.Size;
import ua.kpi.tef.pt.lab01.model.enums.Type;

import java.util.Iterator;

public class LowerBodyClothesService {

    private final LeftLegService leftLegService = new LeftLegService();
    private final RightLegService rightLegService = new RightLegService();
    private final ButtonService buttonService = new ButtonService();
    // ...

    /**
    * Used to create any lower body clothes. Asks user by itself
    */
    // todo implement user controls
    public LowerBodyClothes create() {
        LowerBodyClothes lowerBodyClothes = new LowerBodyClothes();
        lowerBodyClothes.setType(findType());
        lowerBodyClothes.setName(findName());
        lowerBodyClothes.setSize(findSize());

        lowerBodyClothes.add(leftLegService.create());
        lowerBodyClothes.add(rightLegService.create());
        lowerBodyClothes.add(buttonService.create());

        lowerBodyClothes.setTitle("Jeans for the tester");
        return lowerBodyClothes;
    }

    // todo implement user controls
    public void edit(LowerBodyClothes lowerBodyClothes) {
        lowerBodyClothes.setType(findType());
        lowerBodyClothes.setName(findName());
        lowerBodyClothes.setSize(findSize());

        Iterator<ClothingPart> clothingPartIterator = lowerBodyClothes.getIterator();
        while(clothingPartIterator.hasNext()){
            ClothingPart part = clothingPartIterator.next();
            if(part instanceof LeftLeg) {
                leftLegService.edit(part);
            } else if(part instanceof RightLeg) {
                rightLegService.edit(part);
            } else if(part instanceof Button) {
                buttonService.edit(part);
            }
        }

        lowerBodyClothes.setTitle("Edited Jeans for the tester");
    }

    public void show(LowerBodyClothes item) {
        System.out.println(item.toString());
    }

    // todo implement user input recognition
    private Type findType() { //todo implement user input
        return Type.MAN;
    }

    private Size findSize() { //todo implement user input
        return Size.M;
    }

    private Name findName() { //todo implement user input
        return Name.JEANS;
    }

    private String findTitle() { return "Title Lower Body"; }

}
