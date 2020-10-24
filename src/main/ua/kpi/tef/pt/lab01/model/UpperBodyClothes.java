package ua.kpi.tef.pt.lab01.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UpperBodyClothes extends Clothes {
    /* body, leftSleeve, rightSleeve; // тело и рукава
    collar, buttons, pockets; // воротник, пуговицы, карманы*/

    protected List<ClothingPart> clothingParts = new ArrayList<>(); // + todo generalize (ArrayList -> List)

    public void add(ClothingPart part) {
        clothingParts.add(part);
    }

    public ClothingPart get(int id) {
        return clothingParts.get(id);
    }

    public Iterator<ClothingPart> getIterator(){
        return clothingParts.iterator();
    }

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
