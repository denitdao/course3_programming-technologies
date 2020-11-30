package ua.kpi.tef.pt.lab01.controller;

import ua.kpi.tef.pt.lab01.exceptions.InvalidClothesIdException;
import ua.kpi.tef.pt.lab01.model.LowerBodyClothes;
import ua.kpi.tef.pt.lab01.model.UpperBodyClothes;

import java.util.HashMap;
import java.util.Map;

/**
 * Used as a storage to {@link UpperBodyClothes} and {@link LowerBodyClothes}.
 * Operate with the stored clothes. Add, edit, show, delete them.
 */
public class ClothesController {
    private final Map<Long, UpperBodyClothes> upperBodyClothes;
    private final Map<Long, LowerBodyClothes> lowerBodyClothes;

    public ClothesController() {
        upperBodyClothes = new HashMap<>();
        lowerBodyClothes = new HashMap<>();
    }

    /**
     * Used to add created Upper body clothes object to the collection.
     * @param upperBodyClothes object to add.
     * @return unique id of the recently added object.
     */
    public long addUpperBody(UpperBodyClothes upperBodyClothes) {
        this.upperBodyClothes.put(upperBodyClothes.getId(), upperBodyClothes);
        return upperBodyClothes.getId();
    }

    /**
     * Used to add created Lower body clothes object to the collection.
     * @param lowerBodyClothes object to add.
     * @return unique id of the recently added object.
     */
    public long addLowerBody(LowerBodyClothes lowerBodyClothes) {
        this.lowerBodyClothes.put(lowerBodyClothes.getId(), lowerBodyClothes);
        return lowerBodyClothes.getId();
    }

    /**
     * Used to get the Upper body clothes by id.
     * @param id unique id of the object.
     * @return {@link UpperBodyClothes} object.
     * @throws InvalidClothesIdException if object doesn't exist.
     */
    public UpperBodyClothes getUpperBody(long id) throws InvalidClothesIdException {
        if(this.upperBodyClothes.containsKey(id)) {
            return upperBodyClothes.get(id);
        } else {
            throw(new InvalidClothesIdException("Wrong upper body clothes id."));
        }
    }

    /**
     * Used to get the Lower body clothes by id.
     * @param id unique id of the object.
     * @return {@link LowerBodyClothes} object.
     * @throws InvalidClothesIdException if object doesn't exist.
     */
    public LowerBodyClothes getLowerBody(long id) throws InvalidClothesIdException {
        if(this.lowerBodyClothes.containsKey(id)) {
            return lowerBodyClothes.get(id);
        } else {
            throw(new InvalidClothesIdException("Wrong lower body clothes id."));
        }
    }

    /**
     * Used to print information about the Upper and Lower body clothes by id.
     * @param id unique id of the object.
     * @throws InvalidClothesIdException if object doesn't exist.
     */
    public void showClothes(long id) throws InvalidClothesIdException {
        if(lowerBodyClothes.containsKey(id)){
            System.out.println(lowerBodyClothes.get(id));
        } else if(upperBodyClothes.containsKey(id)) {
            System.out.println(upperBodyClothes.get(id));
        } else {
            throw(new InvalidClothesIdException("Wrong clothes id."));
        }
    }

    /**
     * Used to add delete Lower and Upper body clothes object from the collection.
     * @param id unique id of the object.
     * @throws InvalidClothesIdException if object doesn't exist.
     */
    public void deleteClothes(long id) throws InvalidClothesIdException {
        if(lowerBodyClothes.containsKey(id)){
            lowerBodyClothes.remove(id);
        } else if(upperBodyClothes.containsKey(id)) {
            upperBodyClothes.remove(id);
        } else {
            throw(new InvalidClothesIdException("Wrong clothes id."));
        }
    }
}
