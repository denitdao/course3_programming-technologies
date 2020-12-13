package ua.kpi.tef.pt.lab01.service;

import ua.kpi.tef.pt.lab01.model.*;
import ua.kpi.tef.pt.lab01.model.parts.*;

import java.util.Iterator;

/**
 * Used as a builder for {@link LowerBodyClothes}.
 * Create and edit instances of {@link LowerBodyClothes}.
 */
public class LowerBodyClothesService {
    /**
     * Used to create any Lower body clothes.
     * Receives general parameters and {@link ClothingPart}s to be added.
     * @return a {@link LowerBodyClothes} object
     */
    static public LowerBodyClothes create(String title, Type type, Name name, Size size, Double price, ClothingPart... clothingParts) {
        LowerBodyClothes lowerBodyClothes = new LowerBodyClothes(title, type, name, size, price);
        for(ClothingPart clothingPart: clothingParts) {
            lowerBodyClothes.add(clothingPart);
        }
        return lowerBodyClothes;
    }

    /**
     * Used to edit general information any Lower body clothes.
     * Receives {@link LowerBodyClothes} to edit and new general parameters.
     * Pass {@code null} instead of parameter to not edit it.
     */
    public static void editGeneral(LowerBodyClothes lowerBodyClothes, String title, Type type, Name name, Size size, Double price) {
        if(type != null) lowerBodyClothes.setType(type);
        if(name != null) lowerBodyClothes.setName(name);
        if(size != null) lowerBodyClothes.setSize(size);
        if(title != null) lowerBodyClothes.setTitle(title);
        if(price != null) lowerBodyClothes.setPrice(price);
    }

    /**
     * Used to edit Lower body clothes LeftLeg.
     * Receives {@link LowerBodyClothes} to edit and Enums for the LeftLeg.
     * Pass {@code null} instead of {@code Enum} to not edit it.
     */
    public static void editLeftLeg(LowerBodyClothes lowerBodyClothes, Material material, Color color, Fit fit) {
        Iterator<ClothingPart> clothingPartIterator = lowerBodyClothes.getIterator();
        while(clothingPartIterator.hasNext()){
            ClothingPart part = clothingPartIterator.next();
            if(part instanceof LeftLeg) {
                LeftLegService.edit(part, material, color, fit);
                return;
            }
        }
        lowerBodyClothes.add(LeftLegService.create(material, color, fit));
    }

    /**
     * Used to edit Lower body clothes RightLeg.
     * Receives {@link LowerBodyClothes} to edit and Enums for the RightLeg.
     * Pass {@code null} instead of {@code Enum} to not edit it.
     */
    public static void editRightLeg(LowerBodyClothes lowerBodyClothes, Material material, Color color, Fit fit) {
        Iterator<ClothingPart> clothingPartIterator = lowerBodyClothes.getIterator();
        while(clothingPartIterator.hasNext()){
            ClothingPart part = clothingPartIterator.next();
            if(part instanceof RightLeg) {
                RightLegService.edit(part, material, color, fit);
                return;
            }
        }
        lowerBodyClothes.add(RightLegService.create(material, color, fit));
    }

    /**
     * Used to edit Lower body clothes Button.
     * Receives {@link LowerBodyClothes} to edit and Enums for the Button.
     * Pass {@code null} instead of {@code Enum} to not edit it.
     */
    public static void editButton(LowerBodyClothes lowerBodyClothes, Material material, Color color, Integer amount) {
        Iterator<ClothingPart> clothingPartIterator = lowerBodyClothes.getIterator();
        while(clothingPartIterator.hasNext()){
            ClothingPart part = clothingPartIterator.next();
            if(part instanceof Button) {
                ButtonService.edit(part, material, color, amount);
                return;
            }
        }
        lowerBodyClothes.add(ButtonService.create(material, color, amount));
    }

}
