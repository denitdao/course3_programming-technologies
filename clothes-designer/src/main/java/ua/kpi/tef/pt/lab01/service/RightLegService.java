package ua.kpi.tef.pt.lab01.service;

import ua.kpi.tef.pt.lab01.model.ClothingPart;
import ua.kpi.tef.pt.lab01.model.RightLeg;
import ua.kpi.tef.pt.lab01.model.parts.Color;
import ua.kpi.tef.pt.lab01.model.parts.Fit;
import ua.kpi.tef.pt.lab01.model.parts.Material;

public class RightLegService {

    public RightLeg create(Material material, Color color, Fit fit) {
        return new RightLeg(material, color, fit);
    }

    /**
     * Used to edit Clothing Part.
     * Receives {@link RightLeg} to edit and new Enum values.
     * Pass {@code null} instead of {@code Enum} to not edit it.
     */
    public void edit(ClothingPart clothingPart, Material material, Color color, Fit fit) {
        RightLeg rightLeg = (RightLeg) clothingPart;
        if (material != null) rightLeg.setMaterial(material);
        if (color != null) rightLeg.setColor(color);
        if (fit != null) rightLeg.setFit(fit);
    }

}
