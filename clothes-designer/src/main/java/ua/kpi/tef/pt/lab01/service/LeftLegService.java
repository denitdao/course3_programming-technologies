package ua.kpi.tef.pt.lab01.service;

import ua.kpi.tef.pt.lab01.entity.ClothingPart;
import ua.kpi.tef.pt.lab01.entity.LeftLeg;
import ua.kpi.tef.pt.lab01.entity.parts.Color;
import ua.kpi.tef.pt.lab01.entity.parts.Fit;
import ua.kpi.tef.pt.lab01.entity.parts.Material;

public class LeftLegService {

    public LeftLeg create(Material material, Color color, Fit fit) {
        return new LeftLeg(material, color, fit);
    }

    /**
     * Used to edit Clothing Part.
     * Receives {@link LeftLeg} to edit and new Enum values.
     * Pass {@code null} instead of {@code Enum} to not edit it.
     */
    public void edit(ClothingPart clothingPart, Material material, Color color, Fit fit) {
        LeftLeg leftLeg = (LeftLeg) clothingPart;
        if (material != null) leftLeg.setMaterial(material);
        if (color != null) leftLeg.setColor(color);
        if (fit != null) leftLeg.setFit(fit);
    }

}
