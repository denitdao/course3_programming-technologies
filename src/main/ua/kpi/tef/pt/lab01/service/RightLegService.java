package ua.kpi.tef.pt.lab01.service;

import ua.kpi.tef.pt.lab01.model.parts.Color;
import ua.kpi.tef.pt.lab01.model.parts.Fit;
import ua.kpi.tef.pt.lab01.model.parts.Material;
import ua.kpi.tef.pt.lab01.model.ClothingPart;
import ua.kpi.tef.pt.lab01.model.RightLeg;

public class RightLegService {

    public static RightLeg create(Material material, Color color, Fit fit) {
        return new RightLeg(material, color, fit);
    }

    public static void edit(ClothingPart clothingPart, Material material, Color color, Fit fit) {
        RightLeg rightLeg = (RightLeg) clothingPart;
        if (material != null) rightLeg.setMaterial(material);
        if (color != null) rightLeg.setColor(color);
        if (fit != null) rightLeg.setFit(fit);
    }

}
