package ua.kpi.tef.pt.main.lab01.service;

import ua.kpi.tef.pt.main.lab01.model.*;
import ua.kpi.tef.pt.main.lab01.model.parts.Name;
import ua.kpi.tef.pt.main.lab01.model.parts.Size;
import ua.kpi.tef.pt.main.lab01.model.parts.Type;

import java.util.Iterator;

public class LowerBodyClothesService {

    private final LeftLegService leftLegService = new LeftLegService();
    private final RightLegService rightLegService = new RightLegService();
    private final ButtonService buttonService = new ButtonService();
    // ...

    /**
    * Used to create any lower body clothes. Asks user by itself
    */
    // implement user controls
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

    // implement user controls
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

    private Type findType() {
        return Type.MAN;
    }

    private Size findSize() {
        return Size.M;
    }

    private Name findName() {
        return Name.JEANS;
    }

    private String findTitle() { return "Title Lower Body"; }

}
