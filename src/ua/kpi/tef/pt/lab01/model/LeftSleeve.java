package ua.kpi.tef.pt.lab01.model;

import ua.kpi.tef.pt.lab01.model.enums.Color;
import ua.kpi.tef.pt.lab01.model.enums.Length;
import ua.kpi.tef.pt.lab01.model.enums.Material;

public class LeftSleeve implements ClothingPart {
    private final String title = "Left Sleeve";
    private Material material;
    private Color color;
    private Length length;

    @Override
    public String getTitle(){
        return title;
    }

    @Override
    public Material getMaterial() {
        return material;
    }

    @Override
    public void setMaterial(Material material) {
        this.material = material;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    public Length getLength() {
        return length;
    }

    public void setLength(Length length) {
        this.length = length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(title)
                .append("\n\tmaterial: ").append(material)
                .append("\n\tcolor: ").append(color)
                .append("\n\tlength: ").append(length);
        return sb.toString();
    }
}
