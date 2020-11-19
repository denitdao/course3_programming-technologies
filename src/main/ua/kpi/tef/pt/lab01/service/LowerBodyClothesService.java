package ua.kpi.tef.pt.lab01.service;

import ua.kpi.tef.pt.lab01.model.*;
import ua.kpi.tef.pt.lab01.model.parts.*;

import java.util.Iterator;

public class LowerBodyClothesService {

    /**
    * Used to create any lower body clothes. Asks user by itself
    */
    static public LowerBodyClothes create(Type type, Name name, Size size, String title, ClothingPart... clothingParts) {
        LowerBodyClothes lowerBodyClothes = new LowerBodyClothes();
        lowerBodyClothes.setType(type);
        lowerBodyClothes.setName(name);
        lowerBodyClothes.setSize(size);
        lowerBodyClothes.setTitle(title);

        lowerBodyClothes.add(clothingParts[0]);
        //...

        return lowerBodyClothes;
    }

    public static void editGeneral(LowerBodyClothes lowerBodyClothes, Type type, Name name, Size size, String title) {
        if(type != null) lowerBodyClothes.setType(type);
        if(name != null) lowerBodyClothes.setName(name);
        if(size != null) lowerBodyClothes.setSize(size);
        if(title != null) lowerBodyClothes.setTitle(title);
    }

    public static void editLeftLeg(UpperBodyClothes lowerBodyClothes, Material material, Color color, Fit fit) {
        Iterator<ClothingPart> clothingPartIterator = lowerBodyClothes.getIterator();
        while(clothingPartIterator.hasNext()){
            ClothingPart part = clothingPartIterator.next();
            if(part instanceof LeftLeg) {
                LeftLegService.edit(part, material, color, fit);
                break;
            }
        }
    }

    public static void editRightLeg(LowerBodyClothes lowerBodyClothes, Material material, Color color, Fit fit) {
        Iterator<ClothingPart> clothingPartIterator = lowerBodyClothes.getIterator();
        while(clothingPartIterator.hasNext()){
            ClothingPart part = clothingPartIterator.next();
            if(part instanceof RightLeg) {
                RightLegService.edit(part, material, color, fit);
                break;
            }
        }
    }

    public static void editButton(LowerBodyClothes lowerBodyClothes, Material material, Color color, Integer amount) {
        Iterator<ClothingPart> clothingPartIterator = lowerBodyClothes.getIterator();
        while(clothingPartIterator.hasNext()){
            ClothingPart part = clothingPartIterator.next();
            if(part instanceof Button) {
                ButtonService.edit(part, material, color, amount);
                break;
            }
        }
    }

}
