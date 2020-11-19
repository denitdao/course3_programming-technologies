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
    private final UpperBodyClothesService upperBodyClothesService;
    private final LowerBodyClothesService lowerBodyClothesService;

    public ClothesController() {
        upperBodyClothes = new HashMap<>();
        lowerBodyClothes = new HashMap<>();
        upperBodyClothesService = new UpperBodyClothesService();
        lowerBodyClothesService = new LowerBodyClothesService();
    }

    public long addUpperBody(UpperBodyClothes upperBodyClothes) {
        this.upperBodyClothes.put(upperBodyClothes.getId(), upperBodyClothes);
        return upperBodyClothes.getId();
    }

    public long addLowerBody(LowerBodyClothes lowerBodyClothes) {
        this.lowerBodyClothes.put(lowerBodyClothes.getId(), lowerBodyClothes);
        return lowerBodyClothes.getId();
    }

    // ask about the id of the clothes
    public void editClothes(long id) throws InvalidClothesIdException {
        System.out.println("Type id of the clothing you want to edit:");
        if(lowerBodyClothes.containsKey(id)){
            lowerBodyClothesService.edit(lowerBodyClothes.get(id));
        }
        else if(upperBodyClothes.containsKey(id)) {
            upperBodyClothesService.edit(upperBodyClothes.get(id));
        } else {
            throw(new InvalidClothesIdException("Wrong clothes id."));
        }
    }

    // ask about the id of the clothes
    public void showClothes(long id) throws InvalidClothesIdException {
        if(lowerBodyClothes.containsKey(id)){
            lowerBodyClothesService.show(lowerBodyClothes.get(id));
        }
        else if(upperBodyClothes.containsKey(id)) {
            upperBodyClothesService.show(upperBodyClothes.get(id));
        } else {
            throw(new InvalidClothesIdException("Wrong clothes id."));
        }
    }

    // ask about the id of the clothes
    public void deleteClothes(long id) throws InvalidClothesIdException {
        if(lowerBodyClothes.containsKey(id)){
            lowerBodyClothes.remove(id);
        }
        else if(upperBodyClothes.containsKey(id)) {
            upperBodyClothes.remove(id);
        } else {
            throw(new InvalidClothesIdException("Wrong clothes id."));
        }
    }
}
