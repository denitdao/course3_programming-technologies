package ua.kpi.tef.pt.main.lab01.model;

import ua.kpi.tef.pt.main.lab01.model.enums.Color;
import ua.kpi.tef.pt.main.lab01.model.enums.Material;

public interface ClothingPart {

    String title = null; // public static final
    Material material = null;
    Color color = null;

    String getTitle(); // public abstract

    Material getMaterial();

    void setMaterial(Material material);

    Color getColor();

    void setColor(Color color);

}
