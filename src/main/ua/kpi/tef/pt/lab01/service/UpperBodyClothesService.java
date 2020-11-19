package ua.kpi.tef.pt.lab01.service;

import ua.kpi.tef.pt.lab01.model.*;
import ua.kpi.tef.pt.lab01.model.parts.*;

import java.util.Iterator;

public class UpperBodyClothesService {

    /**
     * Used to create any lower body clothes. Asks user by itself
     */
    // todo add all parts
    static public UpperBodyClothes create(Type type, Name name, Size size, String title, ClothingPart... clothingParts) {
        UpperBodyClothes upperBodyClothes = new UpperBodyClothes();
        upperBodyClothes.setType(type);
        upperBodyClothes.setName(name);
        upperBodyClothes.setSize(size);
        upperBodyClothes.setTitle(title);

        upperBodyClothes.add(clothingParts[0]);
        //...

        return upperBodyClothes;
    }

    public static void editGeneral(UpperBodyClothes upperBodyClothes, Type type, Name name, Size size, String title) {
        if(type != null) upperBodyClothes.setType(type);
        if(name != null) upperBodyClothes.setName(name);
        if(size != null) upperBodyClothes.setSize(size);
        if(title != null) upperBodyClothes.setTitle(title);
    }

    public static void editBody(UpperBodyClothes upperBodyClothes, Material material, Color color) {
        Iterator<ClothingPart> clothingPartIterator = upperBodyClothes.getIterator();
        while(clothingPartIterator.hasNext()){
            ClothingPart part = clothingPartIterator.next();
            if(part instanceof Body) {
                BodyService.edit(part, material, color);
                break;
            }
        }
    }

    public static void editButton(UpperBodyClothes upperBodyClothes, Material material, Color color, Integer amount) {
        Iterator<ClothingPart> clothingPartIterator = upperBodyClothes.getIterator();
        while(clothingPartIterator.hasNext()){
            ClothingPart part = clothingPartIterator.next();
            if(part instanceof Button) {
                ButtonService.edit(part, material, color, amount);
                break;
            }
        }
    }

    public static void editLeftSleeve(UpperBodyClothes upperBodyClothes, Material material, Color color, Length length) {
        Iterator<ClothingPart> clothingPartIterator = upperBodyClothes.getIterator();
        while(clothingPartIterator.hasNext()){
            ClothingPart part = clothingPartIterator.next();
            if(part instanceof LeftSleeve) {
                LeftSleeveService.edit(part, material, color, length);
                break;
            }
        }
    }

    public static void editRightSleeve(UpperBodyClothes upperBodyClothes, Material material, Color color, Length length) {
        Iterator<ClothingPart> clothingPartIterator = upperBodyClothes.getIterator();
        while(clothingPartIterator.hasNext()){
            ClothingPart part = clothingPartIterator.next();
            if(part instanceof RightSleeve) {
                RightSleeveService.edit(part, material, color, length);
                break;
            }
        }
    }

}
