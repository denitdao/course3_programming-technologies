package ua.kpi.tef.pt.lab01.service;

import ua.kpi.tef.pt.lab01.model.*;
import ua.kpi.tef.pt.lab01.model.parts.*;

import java.util.Iterator;

public class LowerBodyClothesService {

    /**
    * Used to create any lower body clothes. Asks user by itself
    */
    static public LowerBodyClothes create(String title, Type type, Name name, Size size, double price, ClothingPart... clothingParts) {
        LowerBodyClothes lowerBodyClothes = new LowerBodyClothes(title, type, name, size, price);

        lowerBodyClothes.add(clothingParts[0]);
        //...

        return lowerBodyClothes;
    }

    public static void editGeneral(LowerBodyClothes lowerBodyClothes, String title, Type type, Name name, Size size, Double price) {
        if(type != null) lowerBodyClothes.setType(type);
        if(name != null) lowerBodyClothes.setName(name);
        if(size != null) lowerBodyClothes.setSize(size);
        if(title != null) lowerBodyClothes.setTitle(title);
        if(price != null) lowerBodyClothes.setPrice(price);
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
