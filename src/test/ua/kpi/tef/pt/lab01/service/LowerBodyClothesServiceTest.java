package ua.kpi.tef.pt.lab01.service;

import org.junit.jupiter.api.Test;
import ua.kpi.tef.pt.lab01.model.*;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class LowerBodyClothesServiceTest {


    /*@Test
    public void createNewLowerBodyClothesShouldReturnLowerBodyClothes() {
        LowerBodyClothes lowerBodyClothes = lowerBodyClothesService.create();

        assertNotNull(lowerBodyClothes);
    }

    @Test
    public void editLowerBodyClothesShouldSetNotNull(){
        LowerBodyClothes lowerBodyClothes = new LowerBodyClothes();

        lowerBodyClothesService.edit(lowerBodyClothes);

        assertNotNull(lowerBodyClothes.getType());
        assertNotNull(lowerBodyClothes.getName());
        assertNotNull(lowerBodyClothes.getSize());
        assertNotNull(lowerBodyClothes.getTitle());

        Iterator<ClothingPart> clothingPartIterator = lowerBodyClothes.getIterator();
        while(clothingPartIterator.hasNext()){
            assertNotNull(clothingPartIterator.next());
        }
    }*/

    /*public void generateIdShouldDifferByOne(){
        LowerBodyClothes lowerBodyClothes1 = new LowerBodyClothes();
        LowerBodyClothes lowerBodyClothes2 = new LowerBodyClothes();

        assertEquals(lowerBodyClothes2.getId() - lowerBodyClothes1.getId(), 1);
    }*/
}