package ua.kpi.tef.pt.lab01.service;

import ua.kpi.tef.pt.lab01.model.ClothingPart;
import ua.kpi.tef.pt.lab01.model.LeftSleeve;
import ua.kpi.tef.pt.lab01.model.parts.Color;
import ua.kpi.tef.pt.lab01.model.parts.Length;
import ua.kpi.tef.pt.lab01.model.parts.Material;

public class LeftSleeveService {

    public LeftSleeve create() {
        LeftSleeve leftSleeve = new LeftSleeve();
        leftSleeve.setColor(findColor());
        leftSleeve.setMaterial(findMaterial());
        leftSleeve.setLength(findLength());
        return leftSleeve;
    }

    public void edit(ClothingPart clothingPart) {
        LeftSleeve leftSleeve = (LeftSleeve) clothingPart;
        leftSleeve.setColor(findColor());
        leftSleeve.setMaterial(findMaterial());
        leftSleeve.setLength(findLength());
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
