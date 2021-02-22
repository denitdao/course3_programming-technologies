package ua.kpi.tef.pt.lab01.service;

import org.junit.jupiter.api.Test;
import ua.kpi.tef.pt.lab01.entity.*;
import ua.kpi.tef.pt.lab01.entity.parts.*;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class UpperBodyClothesServiceTest {

    final BodyService bodyService = new BodyService();
    final ButtonService buttonService = new ButtonService();
    final LeftSleeveService leftSleeveService = new LeftSleeveService();
    final RightSleeveService rightSleeveService = new RightSleeveService();

    final UpperBodyClothesService upperBodyClothesService = new UpperBodyClothesService(bodyService, buttonService, leftSleeveService, rightSleeveService);

    final String defTitle = "Default Title";
    final Type defType = Type.CHILDREN;
    final Name defName = Name.JACKET;
    final Size defSize = Size.L;
    final Double defPrice = 80.;
    final LeftSleeve defLeftSleeve = leftSleeveService.create(Material.COTTON, Color.BLUE, Length.LONG);
    final RightSleeve defRightSleeve = rightSleeveService.create(Material.COTTON, Color.BLUE, Length.LONG);
    final Button defButton = buttonService.create(Material.COTTON, Color.BLUE, 10);

    final String altTitle = "Alternative Title";
    final Type altType = Type.MAN;
    final Name altName = Name.COAT;
    final Size altSize = Size.M;
    final Double altPrice = 100.;
    final LeftSleeve altLeftSleeve = leftSleeveService.create(Material.LEATHER, Color.BLACK, Length.SHORT);
    final RightSleeve altRightSleeve = rightSleeveService.create(Material.LEATHER, Color.BLACK, Length.SHORT);
    final Button altButton = buttonService.create(Material.LEATHER, Color.BLACK, 15);

    @Test
    public void When_CreateNewUpperBodyClothes_Expect_ReturnNotNull() {
        UpperBodyClothes upperBodyClothes = upperBodyClothesService.create(defTitle, defType, defName,
                defSize, defPrice, defLeftSleeve, defRightSleeve, defButton);

        assertNotNull(upperBodyClothes);
        Iterator<ClothingPart> clothingPartIterator = upperBodyClothes.getIterator();
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