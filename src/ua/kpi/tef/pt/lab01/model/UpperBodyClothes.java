package ua.kpi.tef.pt.lab01.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UpperBodyClothes extends Clothes {
    /* body, leftSleeve, rightSleeve; // тело и рукава
    collar, buttons, pockets; // воротник, пуговицы, карманы*/

    protected List<ClothingPart> clothingParts = new ArrayList<>(); // todo generalize (use List instead of ArrayList)

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
    public String toString() { // todo generalize within parent class
        StringBuilder sb = new StringBuilder();
        sb.append("\n").append(super.toString()).append("\n");
        String[] parts = clothingParts.toString().split(",");
        for(String part: parts) {
            sb.append(part).append("\n");
        }
        return sb.toString();
    }

}
