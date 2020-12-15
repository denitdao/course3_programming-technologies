package ua.kpi.tef.pt.lab01.service;

import ua.kpi.tef.pt.lab01.model.Body;
import ua.kpi.tef.pt.lab01.model.ClothingPart;
import ua.kpi.tef.pt.lab01.model.parts.Color;
import ua.kpi.tef.pt.lab01.model.parts.Material;

public class BodyService {

    public Body create(Material material, Color color) {
        return new Body(material, color);
    }

    /**
     * Used to edit Clothing Part.
     * Receives {@link Body} to edit and new Enum values.
     * Pass {@code null} instead of {@code Enum} to not edit it.
     */
    public void edit(ClothingPart clothingPart, Material material, Color color) {
        Body body = (Body) clothingPart;
        if (material != null) body.setMaterial(material);
        if (color != null) body.setColor(color);
    }

}
