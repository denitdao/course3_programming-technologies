package ua.kpi.tef.pt.lab01.service;

import ua.kpi.tef.pt.lab01.model.ClothingPart;
import ua.kpi.tef.pt.lab01.model.LeftSleeve;
import ua.kpi.tef.pt.lab01.model.parts.Color;
import ua.kpi.tef.pt.lab01.model.parts.Length;
import ua.kpi.tef.pt.lab01.model.parts.Material;

public class LeftSleeveService {

    public LeftSleeve create(Material material, Color color, Length length) {
        return new LeftSleeve(material, color, length);
    }

    /**
     * Used to edit Clothing Part.
     * Receives {@link LeftSleeve} to edit and new Enum values.
     * Pass {@code null} instead of {@code Enum} to not edit it.
     */
    public void edit(ClothingPart clothingPart, Material material, Color color, Length length) {
        LeftSleeve leftSleeve = (LeftSleeve) clothingPart;
        if (material != null) leftSleeve.setMaterial(material);
        if (color != null) leftSleeve.setColor(color);
        if (length != null) leftSleeve.setLength(length);
    }

}
