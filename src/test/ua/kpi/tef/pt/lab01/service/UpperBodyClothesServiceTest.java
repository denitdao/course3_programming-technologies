package ua.kpi.tef.pt.lab01.service;

import org.junit.jupiter.api.Test;
import ua.kpi.tef.pt.lab01.model.*;
import ua.kpi.tef.pt.lab01.model.parts.*;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class UpperBodyClothesServiceTest {

    String defTitle = "Default Title";
    Type defType = Type.CHILDREN;
    Name defName = Name.JACKET;
    Size defSize = Size.L;
    Double defPrice = 80.;
    LeftSleeve defLeftSleeve = LeftSleeveService.create(Material.COTTON, Color.BLUE, Length.LONG);
    RightSleeve defRightSleeve = RightSleeveService.create(Material.COTTON, Color.BLUE, Length.LONG);
    Button defButton = ButtonService.create(Material.COTTON, Color.BLUE, 10);

    String altTitle = "Alternative Title";
    Type altType = Type.MAN;
    Name altName = Name.COAT;
    Size altSize = Size.M;
    Double altPrice = 100.;
    LeftSleeve altLeftSleeve = LeftSleeveService.create(Material.LEATHER, Color.BLACK, Length.SHORT);
    RightSleeve altRightSleeve = RightSleeveService.create(Material.LEATHER, Color.BLACK, Length.SHORT);
    Button altButton = ButtonService.create(Material.LEATHER, Color.BLACK, 15);

    @Test
    public void When_CreateNewUpperBodyClothes_Expect_ReturnNotNull() {
        UpperBodyClothes lowerBodyClothes = UpperBodyClothesService.create(defTitle, defType, defName,
                defSize, defPrice, defLeftSleeve, defRightSleeve, defButton);

        assertNotNull(lowerBodyClothes);
        Iterator<ClothingPart> clothingPartIterator = lowerBodyClothes.getIterator();
        while(clothingPartIterator.hasNext()){
            assertNotNull(clothingPartIterator.next());
        }
    }

    @Test
    public void When_EditGeneralUpperBodyClothes_Expect_NewValue(){
        UpperBodyClothes upperBodyClothes = UpperBodyClothesService.create(defTitle, defType, defName,
                defSize, defPrice, defLeftSleeve, defRightSleeve, defButton);

        UpperBodyClothesService.editGeneral(upperBodyClothes, altTitle, altType, altName, altSize, altPrice);

        assertSame(upperBodyClothes.getTitle(), altTitle);
        assertSame(upperBodyClothes.getType(), altType);
        assertSame(upperBodyClothes.getName(), altName);
        assertSame(upperBodyClothes.getSize(), altSize);
        assertEquals(upperBodyClothes.getPrice(), altPrice);
    }

    @Test
    public void When_EditUpperBodyClothesClothingPart_Expect_NewValue(){
        UpperBodyClothes upperBodyClothes = UpperBodyClothesService.create(defTitle, defType, defName,
                defSize, defPrice, defLeftSleeve, defRightSleeve, defButton);

        UpperBodyClothesService.editLeftSleeve(upperBodyClothes, Material.LEATHER, Color.BLACK, Length.SHORT);
        UpperBodyClothesService.editRightSleeve(upperBodyClothes, Material.LEATHER, Color.BLACK, Length.SHORT);
        UpperBodyClothesService.editButton(upperBodyClothes, Material.LEATHER, Color.BLACK, 15);

        assertEquals(upperBodyClothes.getPart(0).getMaterial(), altLeftSleeve.getMaterial());
        assertEquals(upperBodyClothes.getPart(1).getMaterial(), altRightSleeve.getMaterial());
        assertEquals(upperBodyClothes.getPart(2).getMaterial(), altButton.getMaterial());
    }

    @Test
    public void When_EditGeneralUpperBodyClothesWithNull_Expect_OldValue(){
        UpperBodyClothes upperBodyClothes = UpperBodyClothesService.create(defTitle, defType, defName,
                defSize, defPrice, defLeftSleeve, defRightSleeve, defButton);

        UpperBodyClothesService.editGeneral(upperBodyClothes, null, null, null, null, null);

        assertSame(upperBodyClothes.getTitle(), defTitle);
        assertSame(upperBodyClothes.getType(), defType);
        assertSame(upperBodyClothes.getName(), defName);
        assertSame(upperBodyClothes.getSize(), defSize);
        assertEquals(upperBodyClothes.getPrice(), defPrice);
    }

    @Test
    public void When_GenerateUpperBodyClothes_Expect_DifferentHashcode(){
        UpperBodyClothes upperBodyClothes1 = UpperBodyClothesService.create(defTitle, defType, defName,
                defSize, defPrice, defLeftSleeve, defRightSleeve, defButton);

        UpperBodyClothes upperBodyClothes2 = UpperBodyClothesService.create(altTitle, altType, altName,
                altSize, altPrice, altLeftSleeve, altRightSleeve, altButton);

        assertNotEquals(upperBodyClothes1.hashCode(), upperBodyClothes2.hashCode());
    }

}