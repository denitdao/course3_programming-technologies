package ua.kpi.tef.pt.lab01.service;

import ua.kpi.tef.pt.lab01.entity.ClothingPart;
import ua.kpi.tef.pt.lab01.entity.RightSleeve;
import ua.kpi.tef.pt.lab01.entity.parts.Color;
import ua.kpi.tef.pt.lab01.entity.parts.Length;
import ua.kpi.tef.pt.lab01.entity.parts.Material;

public class RightSleeveService {

    public RightSleeve create(Material material, Color color, Length length) {
        return new RightSleeve(material, color, length);
    }

    /**
     * Used to edit Clothing Part.
     * Receives {@link RightSleeve} to edit and new Enum values.
     * Pass {@code null} instead of {@code Enum} to not edit it.
     */
    public void edit(ClothingPart clothingPart, Material material, Color color, Length length) {
        RightSleeve rightSleeve = (RightSleeve) clothingPart;
        if (material != null) rightSleeve.setMaterial(material);
        if (color != null) rightSleeve.setColor(color);
        if (length != null) rightSleeve.setLength(length);
    }

}
