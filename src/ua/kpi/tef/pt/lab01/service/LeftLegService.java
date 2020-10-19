package ua.kpi.tef.pt.lab01.service;

import ua.kpi.tef.pt.lab01.model.ClothingPart;
import ua.kpi.tef.pt.lab01.model.enums.Color;
import ua.kpi.tef.pt.lab01.model.LeftLeg;
import ua.kpi.tef.pt.lab01.model.enums.Fit;
import ua.kpi.tef.pt.lab01.model.enums.Material;

public class LeftLegService {

    public LeftLeg create() {
        LeftLeg leftLeg = new LeftLeg();
        leftLeg.setColor(findColor());
        leftLeg.setMaterial(findMaterial());
        leftLeg.setFit(findFit());
        return leftLeg;
    }

    public void edit(ClothingPart clothingPart) {
        LeftLeg leftLeg = (LeftLeg) clothingPart;
        leftLeg.setColor(findColor());
        leftLeg.setMaterial(findMaterial());
        leftLeg.setFit(findFit());
    }

    // todo implement user input recognition
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
