package ua.kpi.tef.pt.main.lab01.service;

import ua.kpi.tef.pt.main.lab01.model.*;
import ua.kpi.tef.pt.main.lab01.model.enums.Color;
import ua.kpi.tef.pt.main.lab01.model.enums.Length;
import ua.kpi.tef.pt.main.lab01.model.enums.Material;

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

    // todo implement user input recognition
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
