package ua.kpi.tef.pt.main.lab01.controller;

import ua.kpi.tef.pt.main.lab01.model.LowerBodyClothes;
import ua.kpi.tef.pt.main.lab01.model.UpperBodyClothes;
import ua.kpi.tef.pt.main.lab01.service.LowerBodyClothesService;
import ua.kpi.tef.pt.main.lab01.service.UpperBodyClothesService;

import java.util.HashMap;

public class ClothesController {
    private HashMap<Integer, UpperBodyClothes> upperBodyClothes;
    private HashMap<Integer, LowerBodyClothes> lowerBodyClothes;
    private final UpperBodyClothesService upperBodyClothesService;
    private final LowerBodyClothesService lowerBodyClothesService;

    public ClothesController() {
        upperBodyClothes = new HashMap<>();
        lowerBodyClothes = new HashMap<>();
        upperBodyClothesService = new UpperBodyClothesService();
        lowerBodyClothesService = new LowerBodyClothesService();
    }

    // todo ask about the section of clothes (lower, upper)
    public void createClothes() {
        System.out.println("Creating clothes.");
        System.out.println("Type number of clothing section you want to create:");

        int section = 2;
        switch(section){
            case 1: {
                LowerBodyClothes item = lowerBodyClothesService.create();
                lowerBodyClothes.put(item.getId(), item);
                break;
            }
            case 2: {
                UpperBodyClothes item = upperBodyClothesService.create();
                upperBodyClothes.put(item.getId(), item);
                break;
            }
            default: {
                System.out.println("Wrong clothing section number");
            }
        }
    }

    // todo ask about the id of the clothes
    public void editClothes() {
        System.out.println("Editing clothes.");
        System.out.println("Type id of the clothing you want to edit:");

        int id = 1;
        if(lowerBodyClothes.containsKey(id)){
            lowerBodyClothesService.edit(lowerBodyClothes.get(id));
        }
        else if(upperBodyClothes.containsKey(id)) {
            upperBodyClothesService.edit(upperBodyClothes.get(id));
        } else {
            System.out.println("Wrong id");
        }
    }

    // todo ask about the id of the clothes
    public void showClothes() {
        System.out.println("Showing clothes.");
        System.out.println("Type id of the clothing you want to show:");

        int id = 1;
        if(lowerBodyClothes.containsKey(id)){
            lowerBodyClothesService.show(lowerBodyClothes.get(id));
        }
        else if(upperBodyClothes.containsKey(id)) {
            upperBodyClothesService.show(upperBodyClothes.get(id));
        } else {
            System.out.println("Wrong id");
        }
    }

    // todo ask about the id of the clothes
    public void deleteClothes() {
        System.out.println("Deleting clothes.");
        System.out.println("Type id of the clothing you want to delete:");

        int id = 1;
        if(lowerBodyClothes.containsKey(id)){
            lowerBodyClothes.remove(id);
        }
        else if(upperBodyClothes.containsKey(id)) {
            upperBodyClothes.remove(id);
        } else {
            System.out.println("Wrong id");
        }
    }
}
