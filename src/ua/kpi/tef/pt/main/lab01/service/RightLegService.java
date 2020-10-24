package ua.kpi.tef.pt.main.lab01.service;

import ua.kpi.tef.pt.main.lab01.model.ClothingPart;
import ua.kpi.tef.pt.main.lab01.model.parts.Color;
import ua.kpi.tef.pt.main.lab01.model.parts.Fit;
import ua.kpi.tef.pt.main.lab01.model.parts.Material;
import ua.kpi.tef.pt.main.lab01.model.RightLeg;

public class RightLegService {

    public RightLeg create() {
        RightLeg rightLeg = new RightLeg();
        rightLeg.setColor(findColor());
        rightLeg.setMaterial(findMaterial());
        rightLeg.setFit(findFit());
        return rightLeg;
    }

    public void edit(ClothingPart clothingPart) {
        RightLeg rightLeg = (RightLeg) clothingPart;
        rightLeg.setColor(findColor());
        rightLeg.setMaterial(findMaterial());
        rightLeg.setFit(findFit());
    }

    private Color findColor() {
        return Color.BLUE;
    }

    private Material findMaterial() {
        return Material.COTTON;
    }

    private Fit findFit(){
        return Fit.REGULAR;
    }
}
