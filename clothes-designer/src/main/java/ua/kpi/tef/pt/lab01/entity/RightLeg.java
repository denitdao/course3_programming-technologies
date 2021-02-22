package ua.kpi.tef.pt.lab01.entity;

import ua.kpi.tef.pt.lab01.entity.parts.Color;
import ua.kpi.tef.pt.lab01.entity.parts.Fit;
import ua.kpi.tef.pt.lab01.entity.parts.Material;

public class RightLeg implements ClothingPart {
    private final String title = "Right Leg";
    private Material material;
    private Color color;
    private Fit fit;

    public RightLeg(Material material, Color color, Fit fit) {
        this.material = material;
        this.color = color;
        this.fit = fit;
    }

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

    public Fit getFit() {
        return fit;
    }

    public void setFit(Fit fit) {
        this.fit = fit;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(title)
                .append("\n\tmaterial: ").append(material)
                .append("\n\tcolor: ").append(color)
                .append("\n\tfit: ").append(fit);
        return sb.toString();
    }
}
