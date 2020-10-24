package ua.kpi.tef.pt.main.lab01.service;

import ua.kpi.tef.pt.main.lab01.model.ClothingPart;
import ua.kpi.tef.pt.main.lab01.model.parts.Material;
import ua.kpi.tef.pt.main.lab01.model.parts.Color;

public class ClothingPartService {

    /**
     * Used to modify any part of the clothing. Asks user by itself
     */
    public void modify(ClothingPart clothingPart) {
        clothingPart.setMaterial(getClothingPartMaterial());
        clothingPart.setColor(getClothingPartColor());
    }

    private Material getClothingPartMaterial() {
        return Material.COTTON;
    }

    private Color getClothingPartColor() {
        return Color.BLUE;
    }
}
