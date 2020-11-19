package ua.kpi.tef.pt.lab01.service;

import ua.kpi.tef.pt.lab01.model.parts.Color;
import ua.kpi.tef.pt.lab01.model.parts.Material;
import ua.kpi.tef.pt.lab01.model.ClothingPart;
import ua.kpi.tef.pt.lab01.model.Body;

public class BodyService {

    public static Body create(Material material, Color color) {
        return new Body(material, color);
    }

    public static void edit(ClothingPart clothingPart, Material material, Color color) {
        Body body = (Body) clothingPart;
        if (material != null) body.setMaterial(material);
        if (color != null) body.setColor(color);
    }

}
