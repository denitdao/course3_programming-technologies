package ua.kpi.tef.pt.lab01.service;

import ua.kpi.tef.pt.lab01.model.parts.Color;
import ua.kpi.tef.pt.lab01.model.ClothingPart;
import ua.kpi.tef.pt.lab01.model.parts.Length;
import ua.kpi.tef.pt.lab01.model.parts.Material;
import ua.kpi.tef.pt.lab01.model.RightSleeve;

public class RightSleeveService {

    public RightSleeve create() {
        RightSleeve rightSleeve = new RightSleeve();
        rightSleeve.setColor(findColor());
        rightSleeve.setMaterial(findMaterial());
        rightSleeve.setLength(findLength());
        return rightSleeve;
    }

    public void edit(ClothingPart clothingPart) {
        RightSleeve rightSleeve = (RightSleeve) clothingPart;
        rightSleeve.setColor(findColor());
        rightSleeve.setMaterial(findMaterial());
        rightSleeve.setLength(findLength());
    }

    private Color findColor() {
        return Color.YELLOW;
    }

    private Material findMaterial() {
        return Material.COTTON;
    }

    private Length findLength(){
        return Length.LONG;
    }

}
