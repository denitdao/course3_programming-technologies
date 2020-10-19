package ua.kpi.tef.pt.lab01.service;

import ua.kpi.tef.pt.lab01.model.ClothingPart;
import ua.kpi.tef.pt.lab01.model.enums.Material;
import ua.kpi.tef.pt.lab01.model.enums.Color;

public class ClothingPartService {

    /**
     * Used to modify any part of the clothing. Asks user by itself
     */
    public void modify(ClothingPart clothingPart) {
        clothingPart.setMaterial(getClothingPartMaterial());
        clothingPart.setColor(getClothingPartColor());
    }

    private Material getClothingPartMaterial(){ //todo implement user input
        return Material.COTTON;
    }

    private Color getClothingPartColor(){ //todo implement user input
        return Color.BLUE;
    }
}
