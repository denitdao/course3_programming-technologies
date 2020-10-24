package ua.kpi.tef.pt.lab01.model;

import ua.kpi.tef.pt.lab01.model.parts.Color;
import ua.kpi.tef.pt.lab01.model.parts.Material;

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
