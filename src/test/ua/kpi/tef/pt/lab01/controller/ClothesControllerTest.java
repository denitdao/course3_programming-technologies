package ua.kpi.tef.pt.lab01.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClothesControllerTest {

    ClothesController clothesController = new ClothesController();

    @Test
    public void createAndDeleteNewLowerBodyClothesShouldShow() {
        clothesController.createClothes(1);

        clothesController.showClothes(1);

    }


}