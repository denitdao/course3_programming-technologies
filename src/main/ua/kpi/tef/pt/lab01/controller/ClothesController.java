package ua.kpi.tef.pt.lab01.controller;

import ua.kpi.tef.pt.lab01.exceptions.InvalidClothesIdException;
import ua.kpi.tef.pt.lab01.exceptions.InvalidClothingSectionException;
import ua.kpi.tef.pt.lab01.model.LowerBodyClothes;
import ua.kpi.tef.pt.lab01.model.UpperBodyClothes;
import ua.kpi.tef.pt.lab01.service.LowerBodyClothesService;
import ua.kpi.tef.pt.lab01.service.UpperBodyClothesService;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

public class ClothesController {
    private final Map<Long, UpperBodyClothes> upperBodyClothes; // + todo generalized (HashMap -> Map) (19)
    private final Map<Long, LowerBodyClothes> lowerBodyClothes;

    public ClothesController() {
        upperBodyClothes = new HashMap<>();
        lowerBodyClothes = new HashMap<>();
    }

    public long addUpperBody(UpperBodyClothes upperBodyClothes) {
        this.upperBodyClothes.put(upperBodyClothes.getId(), upperBodyClothes);
        return upperBodyClothes.getId();
    }

    public long addLowerBody(LowerBodyClothes lowerBodyClothes) {
        this.lowerBodyClothes.put(lowerBodyClothes.getId(), lowerBodyClothes);
        return lowerBodyClothes.getId();
    }

    public UpperBodyClothes getUpperBody(long id) throws InvalidClothesIdException {
        if(this.upperBodyClothes.containsKey(id)) {
            return upperBodyClothes.get(id);
        } else {
            throw(new InvalidClothesIdException("Wrong clothes id."));
        }
    }

    public LowerBodyClothes getLowerBody(long id) throws InvalidClothesIdException {
        if(this.lowerBodyClothes.containsKey(id)) {
            return lowerBodyClothes.get(id);
        } else {
            throw(new InvalidClothesIdException("Wrong clothes id."));
        }
    }

    public void showClothes(long id) throws InvalidClothesIdException {
        if(lowerBodyClothes.containsKey(id)){
            System.out.println(lowerBodyClothes.get(id));
        } else if(upperBodyClothes.containsKey(id)) {
            System.out.println(upperBodyClothes.get(id));
        } else {
            throw(new InvalidClothesIdException("Wrong clothes id."));
        }
    }

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
