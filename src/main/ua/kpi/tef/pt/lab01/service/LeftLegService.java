package ua.kpi.tef.pt.lab01.service;

import ua.kpi.tef.pt.lab01.model.parts.Color;
import ua.kpi.tef.pt.lab01.model.parts.Fit;
import ua.kpi.tef.pt.lab01.model.parts.Material;
import ua.kpi.tef.pt.lab01.model.ClothingPart;
import ua.kpi.tef.pt.lab01.model.LeftLeg;

public class LeftLegService {

    public static LeftLeg create(Material material, Color color, Fit fit) {
        return new LeftLeg(material, color, fit);
    }

    public static void edit(ClothingPart clothingPart, Material material, Color color, Fit fit) {
        LeftLeg leftLeg = (LeftLeg) clothingPart;
        if (material != null) leftLeg.setMaterial(material);
        if (color != null) leftLeg.setColor(color);
        if (fit != null) leftLeg.setFit(fit);
    }

}
