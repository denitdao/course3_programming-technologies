package ua.kpi.tef.pt.lab01.service;

import org.junit.jupiter.api.Test;
import ua.kpi.tef.pt.lab01.model.ClothingPart;
import ua.kpi.tef.pt.lab01.model.UpperBodyClothes;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class UpperBodyClothesServiceTest {

    /*@Test
    public void createNewUpperBodyClothesShouldReturnUpperBodyClothes() {
        UpperBodyClothes upperBodyClothes = upperBodyClothesService.create();

        assertNotNull(upperBodyClothes);
    }

    @Test
    public void editUpperBodyClothesShouldSetNotNull(){
        UpperBodyClothes upperBodyClothes = new UpperBodyClothes();

        upperBodyClothesService.edit(upperBodyClothes);

        assertNotNull(upperBodyClothes.getType());
        assertNotNull(upperBodyClothes.getName());
        assertNotNull(upperBodyClothes.getSize());
        assertNotNull(upperBodyClothes.getTitle());

        Iterator<ClothingPart> clothingPartIterator = upperBodyClothes.getIterator();
        while(clothingPartIterator.hasNext()){
            assertNotNull(clothingPartIterator.next());
        }
    }*/

}