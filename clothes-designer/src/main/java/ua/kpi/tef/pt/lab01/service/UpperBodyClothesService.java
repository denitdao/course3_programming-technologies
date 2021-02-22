package ua.kpi.tef.pt.lab01.service;

import ua.kpi.tef.pt.lab01.entity.*;
import ua.kpi.tef.pt.lab01.entity.parts.*;

import java.util.Iterator;

/**
 * Used as a builder for {@link UpperBodyClothes}.
 * Create and edit instances of {@link UpperBodyClothes}.
 */
public class UpperBodyClothesService {

    private final BodyService bodyService;
    private final ButtonService buttonService;
    private final LeftSleeveService leftSleeveService;
    private final RightSleeveService rightSleeveService;

    public UpperBodyClothesService(BodyService bodyService, ButtonService buttonService, LeftSleeveService leftSleeveService, RightSleeveService rightSleeveService) {
        this.bodyService = bodyService;
        this.buttonService = buttonService;
        this.leftSleeveService = leftSleeveService;
        this.rightSleeveService = rightSleeveService;
    }

    /**
     * Used to create any Upper body clothes.
     * Receives general parameters and {@link ClothingPart}s to be added.
     * @return a {@link UpperBodyClothes} object
     */
    public UpperBodyClothes create(String title, Type type, Name name, Size size, Double price, ClothingPart... clothingParts) {
        UpperBodyClothes upperBodyClothes = new UpperBodyClothes(title, type, name, size, price);
        for(ClothingPart clothingPart: clothingParts) {
            upperBodyClothes.add(clothingPart);
        }
        return upperBodyClothes;
    }

    /**
     * Used to edit general information any Upper body clothes.
     * Receives {@link UpperBodyClothes} to edit and new general parameters.
     * Pass {@code null} instead of parameter to not edit it.
     */
    public void editGeneral(UpperBodyClothes upperBodyClothes, String title, Type type, Name name, Size size, Double price) {
        if(title != null) upperBodyClothes.setTitle(title);
        if(type != null) upperBodyClothes.setType(type);
        if(name != null) upperBodyClothes.setName(name);
        if(size != null) upperBodyClothes.setSize(size);
        if(price != null) upperBodyClothes.setPrice(price);
    }

    /**
     * Used to edit Upper body clothes Body.
     * Receives {@link UpperBodyClothes} to edit and Enums for the Body.
     * Pass {@code null} instead of {@code Enum} to not edit it.
     */
    public void editBody(UpperBodyClothes upperBodyClothes, Material material, Color color) {
        Iterator<ClothingPart> clothingPartIterator = upperBodyClothes.getIterator();
        while(clothingPartIterator.hasNext()){
            ClothingPart part = clothingPartIterator.next();
            if(part instanceof Body) {
                bodyService.edit(part, material, color);
                return;
            }
        }
        upperBodyClothes.add(bodyService.create(material, color));
    }

    /**
     * Used to edit Upper body clothes Button.
     * Receives {@link UpperBodyClothes} to edit and Enums for the Button.
     * Pass {@code null} instead of {@code Enum} to not edit it.
     */
    public void editButton(UpperBodyClothes upperBodyClothes, Material material, Color color, Integer amount) {
        Iterator<ClothingPart> clothingPartIterator = upperBodyClothes.getIterator();
        while(clothingPartIterator.hasNext()){
            ClothingPart part = clothingPartIterator.next();
            if(part instanceof Button) {
                buttonService.edit(part, material, color, amount);
                return;
            }
        }
        upperBodyClothes.add(buttonService.create(material, color, amount));
    }

    /**
     * Used to edit Upper body clothes LeftSleeve.
     * Receives {@link UpperBodyClothes} to edit and Enums for the LeftSleeve.
     * Pass {@code null} instead of {@code Enum} to not edit it.
     */
    public void editLeftSleeve(UpperBodyClothes upperBodyClothes, Material material, Color color, Length length) {
        Iterator<ClothingPart> clothingPartIterator = upperBodyClothes.getIterator();
        while(clothingPartIterator.hasNext()){
            ClothingPart part = clothingPartIterator.next();
            if(part instanceof LeftSleeve) {
                leftSleeveService.edit(part, material, color, length);
                return;
            }
        }
        upperBodyClothes.add(leftSleeveService.create(material, color, length));
    }

    /**
     * Used to edit Upper body clothes RightSleeve.
     * Receives {@link UpperBodyClothes} to edit and Enums for the RightSleeve.
     * Pass {@code null} instead of {@code Enum} to not edit it.
     */
    public void editRightSleeve(UpperBodyClothes upperBodyClothes, Material material, Color color, Length length) {
        Iterator<ClothingPart> clothingPartIterator = upperBodyClothes.getIterator();
        while(clothingPartIterator.hasNext()){
            ClothingPart part = clothingPartIterator.next();
            if(part instanceof RightSleeve) {
                rightSleeveService.edit(part, material, color, length);
                return;
            }
        }
        upperBodyClothes.add(rightSleeveService.create(material, color, length));
    }

}
