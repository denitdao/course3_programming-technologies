package ua.kpi.tef.pt.lab01.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class LowerBodyClothes extends Clothes {
    /*private ClothingPart leftLeg, rightLeg; // штанины
    private ClothingPart buttons, pockets, beltLoops, fly; // пуговицы, карманы, петли для ремня, ширинка */

    protected List<ClothingPart> clothingParts = new ArrayList<>(); // + todo generalize (ArrayList -> List) (19)

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
        sb.append("\nLower Body - ").append(super.toString()).append("\n");
        for (ClothingPart clothingPart : clothingParts) {
            sb.append(clothingPart.toString()).append("\n");
        }
        return sb.toString();
    }
}
