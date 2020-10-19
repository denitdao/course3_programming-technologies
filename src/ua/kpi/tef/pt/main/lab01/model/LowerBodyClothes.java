package ua.kpi.tef.pt.main.lab01.model;

import java.util.ArrayList;
import java.util.Iterator;


public class LowerBodyClothes extends Clothes {
    //private ClothingPart leftLeg, rightLeg; // штанины
    //private ClothingPart buttons, pockets, beltLoops, fly; // пуговицы, карманы, петли для ремня, ширинка

    protected ArrayList<ClothingPart> clothingParts = new ArrayList<>();

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
        sb.append("\n").append(super.toString()).append("\n");
        String[] parts = clothingParts.toString().split(",");
        for(String part: parts) {
            sb.append(part).append("\n");
        }
        return sb.toString();
    }
}
