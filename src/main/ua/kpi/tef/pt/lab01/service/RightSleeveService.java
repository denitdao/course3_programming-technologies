package ua.kpi.tef.pt.lab01.service;

import ua.kpi.tef.pt.lab01.model.LeftSleeve;
import ua.kpi.tef.pt.lab01.model.parts.Color;
import ua.kpi.tef.pt.lab01.model.ClothingPart;
import ua.kpi.tef.pt.lab01.model.parts.Length;
import ua.kpi.tef.pt.lab01.model.parts.Material;
import ua.kpi.tef.pt.lab01.model.RightSleeve;

public class RightSleeveService {

    public static RightSleeve create(Material material, Color color, Length length) {
        return new RightSleeve(material, color, length);
    }

    public static void edit(ClothingPart clothingPart, Material material, Color color, Length length) {
        RightSleeve rightSleeve = (RightSleeve) clothingPart;
        if (material != null) rightSleeve.setMaterial(material);
        if (color != null) rightSleeve.setColor(color);
        if (length != null) rightSleeve.setLength(length);
    }

}
