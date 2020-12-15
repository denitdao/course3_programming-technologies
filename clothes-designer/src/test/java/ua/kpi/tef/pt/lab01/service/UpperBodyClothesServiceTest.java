package ua.kpi.tef.pt.lab01.service;

import org.junit.jupiter.api.Test;
import ua.kpi.tef.pt.lab01.model.*;
import ua.kpi.tef.pt.lab01.model.parts.*;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class UpperBodyClothesServiceTest {

    BodyService bodyService = new BodyService();
    ButtonService buttonService = new ButtonService();
    LeftSleeveService leftSleeveService = new LeftSleeveService();
    RightSleeveService rightSleeveService = new RightSleeveService();

    UpperBodyClothesService upperBodyClothesService = new UpperBodyClothesService(bodyService, buttonService, leftSleeveService, rightSleeveService);

    String defTitle = "Default Title";
    Type defType = Type.CHILDREN;
    Name defName = Name.JACKET;
    Size defSize = Size.L;
    Double defPrice = 80.;
    LeftSleeve defLeftSleeve = leftSleeveService.create(Material.COTTON, Color.BLUE, Length.LONG);
    RightSleeve defRightSleeve = rightSleeveService.create(Material.COTTON, Color.BLUE, Length.LONG);
    Button defButton = buttonService.create(Material.COTTON, Color.BLUE, 10);

    String altTitle = "Alternative Title";
    Type altType = Type.MAN;
    Name altName = Name.COAT;
    Size altSize = Size.M;
    Double altPrice = 100.;
    LeftSleeve altLeftSleeve = leftSleeveService.create(Material.LEATHER, Color.BLACK, Length.SHORT);
    RightSleeve altRightSleeve = rightSleeveService.create(Material.LEATHER, Color.BLACK, Length.SHORT);
    Button altButton = buttonService.create(Material.LEATHER, Color.BLACK, 15);

    @Test
    public void When_CreateNewUpperBodyClothes_Expect_ReturnNotNull() {
        UpperBodyClothes lowerBodyClothes = upperBodyClothesService.create(defTitle, defType, defName,
                defSize, defPrice, defLeftSleeve, defRightSleeve, defButton);

        assertNotNull(lowerBodyClothes);
        Iterator<ClothingPart> clothingPartIterator = lowerBodyClothes.getIterator();
        while(clothingPartIterator.hasNext()){
            assertNotNull(clothingPartIterator.next());
        }
    }

    @Test
    public void When_EditGeneralUpperBodyClothes_Expect_NewValue(){
        UpperBodyClothes upperBodyClothes = upperBodyClothesService.create(defTitle, defType, defName,
                defSize, defPrice, defLeftSleeve, defRightSleeve, defButton);

        upperBodyClothesService.editGeneral(upperBodyClothes, altTitle, altType, altName, altSize, altPrice);

        assertSame(upperBodyClothes.getTitle(), altTitle);
        assertSame(upperBodyClothes.getType(), altType);
        assertSame(upperBodyClothes.getName(), altName);
        assertSame(upperBodyClothes.getSize(), altSize);
        assertEquals(upperBodyClothes.getPrice(), altPrice);
    }

    @Test
    public void When_EditUpperBodyClothesClothingPart_Expect_NewValue(){
        UpperBodyClothes upperBodyClothes = upperBodyClothesService.create(defTitle, defType, defName,
                defSize, defPrice, defLeftSleeve, defRightSleeve, defButton);

        upperBodyClothesService.editLeftSleeve(upperBodyClothes, Material.LEATHER, Color.BLACK, Length.SHORT);
        upperBodyClothesService.editRightSleeve(upperBodyClothes, Material.LEATHER, Color.BLACK, Length.SHORT);
        upperBodyClothesService.editButton(upperBodyClothes, Material.LEATHER, Color.BLACK, 15);

        assertEquals(upperBodyClothes.getPart(0).getMaterial(), altLeftSleeve.getMaterial());
        assertEquals(upperBodyClothes.getPart(1).getMaterial(), altRightSleeve.getMaterial());
        assertEquals(upperBodyClothes.getPart(2).getMaterial(), altButton.getMaterial());
    }

    @Test
    public void When_EditGeneralUpperBodyClothesWithNull_Expect_OldValue(){
        UpperBodyClothes upperBodyClothes = upperBodyClothesService.create(defTitle, defType, defName,
                defSize, defPrice, defLeftSleeve, defRightSleeve, defButton);

        upperBodyClothesService.editGeneral(upperBodyClothes, null, null, null, null, null);

        assertSame(upperBodyClothes.getTitle(), defTitle);
        assertSame(upperBodyClothes.getType(), defType);
        assertSame(upperBodyClothes.getName(), defName);
        assertSame(upperBodyClothes.getSize(), defSize);
        assertEquals(upperBodyClothes.getPrice(), defPrice);
    }

    @Test
    public void When_GenerateUpperBodyClothes_Expect_DifferentHashcode(){
        UpperBodyClothes upperBodyClothes1 = upperBodyClothesService.create(defTitle, defType, defName,
                defSize, defPrice, defLeftSleeve, defRightSleeve, defButton);

        UpperBodyClothes upperBodyClothes2 = upperBodyClothesService.create(altTitle, altType, altName,
                altSize, altPrice, altLeftSleeve, altRightSleeve, altButton);

        assertNotEquals(upperBodyClothes1.hashCode(), upperBodyClothes2.hashCode());
    }

}