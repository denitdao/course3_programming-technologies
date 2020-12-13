package ua.kpi.tef.pt.lab01.model;

import ua.kpi.tef.pt.lab01.model.parts.Name;
import ua.kpi.tef.pt.lab01.model.parts.Size;
import ua.kpi.tef.pt.lab01.model.parts.Type;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UpperBodyClothes extends Clothes {
    /* body, leftSleeve, rightSleeve - тело и рукава
    collar, buttons, pockets - воротник, пуговицы, карманы*/
    protected List<ClothingPart> clothingParts = new ArrayList<>();

    public UpperBodyClothes(String title, Type type, Name name, Size size, double price) {
        super(title, type, name, size, price);
    }

    /**
     * Used to add Part to Upper body clothes.
     */
    public void add(ClothingPart part) {
        clothingParts.add(part);
    }

    /**
     * Used to get Part of Lower body clothes by index.
     */
    public ClothingPart getPart(int index) { return clothingParts.get(index); }

    /**
     * Used to get {@link Iterator<ClothingPart>} over the Upper body clothes Parts.
     */
    public Iterator<ClothingPart> getIterator(){
        return clothingParts.iterator();
    }

    public List<ClothingPart> getClothingParts() { return clothingParts; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nUpper Body - ").append(super.toString()).append("\n"); // general info
        for (ClothingPart clothingPart : clothingParts) {
            sb.append(clothingPart.toString()).append("\n");
        }
        return sb.toString();
    }
}
