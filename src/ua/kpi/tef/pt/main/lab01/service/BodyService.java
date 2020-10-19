package ua.kpi.tef.pt.main.lab01.service;

import ua.kpi.tef.pt.main.lab01.model.ClothingPart;
import ua.kpi.tef.pt.main.lab01.model.enums.Color;
import ua.kpi.tef.pt.main.lab01.model.enums.Material;
import ua.kpi.tef.pt.main.lab01.model.Body;

public class BodyService {

    public Body create() {
        Body body = new Body();
        body.setColor(findColor());
        body.setMaterial(findMaterial());
        return body;
    }

    public void edit(ClothingPart clothingPart) {
        Body body = (Body) clothingPart;
        body.setColor(findColor());
        body.setMaterial(findMaterial());
    }

    // todo implement user input recognition
    private Color findColor() {
        return Color.BLUE;
    }

    private Material findMaterial() {
        return Material.WOOL;
    }

}
