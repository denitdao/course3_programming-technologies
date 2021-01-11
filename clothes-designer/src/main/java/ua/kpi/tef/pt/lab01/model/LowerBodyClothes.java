package ua.kpi.tef.pt.lab01.model;

import ua.kpi.tef.pt.lab01.model.parts.Name;
import ua.kpi.tef.pt.lab01.model.parts.Size;
import ua.kpi.tef.pt.lab01.model.parts.Type;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class LowerBodyClothes extends Clothes {
    /*private ClothingPart leftLeg, rightLeg - штанины
    private ClothingPart buttons, pockets, beltLoops, fly - пуговицы, карманы, петли для ремня, ширинка */
    protected final List<ClothingPart> clothingParts = new ArrayList<>();

    public LowerBodyClothes(String title, Type type, Name name, Size size, double price) {
        super(title, type, name, size, price);
    }

    /**
     * Used to add Part to Lower body clothes.
     */
    public void add(ClothingPart part) {
        clothingParts.add(part);
    }

    /**
     * Used to get Part of Lower body clothes by index.
     */
    public ClothingPart getPart(int index) { return clothingParts.get(index); }

    public List<ClothingPart> getClothingParts() { return clothingParts; }

    /**
     * Used to get {@link Iterator<ClothingPart>} over the Lower body clothes Parts.
     */
    public Iterator<ClothingPart> getIterator(){
        return clothingParts.iterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nLower Body - ").append(super.toString()).append("\n");
        for (ClothingPart clothingPart : clothingParts) {
            sb.append(clothingPart.toString()).append("\n");
        }
        return sb.toString();
    }
}
