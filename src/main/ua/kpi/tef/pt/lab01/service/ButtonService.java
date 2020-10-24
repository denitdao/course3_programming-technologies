package ua.kpi.tef.pt.lab01.service;

import ua.kpi.tef.pt.lab01.model.Button;
import ua.kpi.tef.pt.lab01.model.ClothingPart;
import ua.kpi.tef.pt.lab01.model.parts.Color;
import ua.kpi.tef.pt.lab01.model.parts.Material;

public class ButtonService {

    public Button create() {
        Button leftSleeve = new Button();
        leftSleeve.setColor(findColor());
        leftSleeve.setMaterial(findMaterial());
        leftSleeve.setAmount(findAmount());
        return leftSleeve;
    }

    public void edit(ClothingPart clothingPart) {
        Button button = (Button) clothingPart;
        button.setColor(findColor());
        button.setMaterial(findMaterial());
        button.setAmount(findAmount());
    }

    // implement user input recognition
    private Color findColor() {
        return Color.BLACK;
    }

    private Material findMaterial() {
        return Material.PLASTIC;
    }

    private int findAmount(){
        return 10;
    }
}
