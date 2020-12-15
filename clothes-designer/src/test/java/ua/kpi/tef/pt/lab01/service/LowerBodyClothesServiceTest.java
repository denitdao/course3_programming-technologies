package ua.kpi.tef.pt.lab01.service;

import org.junit.jupiter.api.Test;
import ua.kpi.tef.pt.lab01.model.*;
import ua.kpi.tef.pt.lab01.model.parts.*;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class LowerBodyClothesServiceTest {

    LeftLegService leftLegService = new LeftLegService();
    RightLegService rightLegService = new RightLegService();
    ButtonService buttonService = new ButtonService();

    LowerBodyClothesService lowerBodyClothesService = new LowerBodyClothesService(leftLegService, rightLegService, buttonService);

    String defTitle = "Default Title";
    Type defType = Type.CHILDREN;
    Name defName = Name.JEANS;
    Size defSize = Size.L;
    Double defPrice = 80.;
    LeftLeg defLeftLeg = leftLegService.create(Material.COTTON, Color.BLUE, Fit.CLASSIC);
    RightLeg defRightLeg = rightLegService.create(Material.COTTON, Color.BLUE, Fit.CLASSIC);
    Button defButton = buttonService.create(Material.COTTON, Color.BLUE, 10);

    String altTitle = "Alternative Title";
    Type altType = Type.MAN;
    Name altName = Name.SHORTS;
    Size altSize = Size.M;
    Double altPrice = 100.;
    LeftLeg altLeftLeg = leftLegService.create(Material.LEATHER, Color.BLACK, Fit.REGULAR);
    RightLeg altRightLeg = rightLegService.create(Material.LEATHER, Color.BLACK, Fit.REGULAR);
    Button altButton = buttonService.create(Material.LEATHER, Color.BLACK, 15);

    @Test
    public void When_CreateNewLowerBodyClothes_Expect_ReturnNotNull() {
        LowerBodyClothes lowerBodyClothes = lowerBodyClothesService.create(defTitle, defType, defName,
                defSize, defPrice, defLeftLeg, defRightLeg, defButton);

        assertNotNull(lowerBodyClothes);
        Iterator<ClothingPart> clothingPartIterator = lowerBodyClothes.getIterator();
        while(clothingPartIterator.hasNext()){
            assertNotNull(clothingPartIterator.next());
        }
    }

    @Test
    public void When_EditGeneralLowerBodyClothes_Expect_NewValue(){
        LowerBodyClothes lowerBodyClothes = lowerBodyClothesService.create(defTitle, defType, defName,
                defSize, defPrice, defLeftLeg, defRightLeg, defButton);

        lowerBodyClothesService.editGeneral(lowerBodyClothes, altTitle, altType, altName, altSize, altPrice);

        assertSame(lowerBodyClothes.getTitle(), altTitle);
        assertSame(lowerBodyClothes.getType(), altType);
        assertSame(lowerBodyClothes.getName(), altName);
        assertSame(lowerBodyClothes.getSize(), altSize);
        assertEquals(lowerBodyClothes.getPrice(), altPrice);
    }

    @Test
    public void When_EditLowerBodyClothesClothingPart_Expect_NewValue(){
        LowerBodyClothes lowerBodyClothes = lowerBodyClothesService.create(defTitle, defType, defName,
                defSize, defPrice, defLeftLeg, defRightLeg, defButton);

        lowerBodyClothesService.editLeftLeg(lowerBodyClothes, Material.LEATHER, Color.BLACK, Fit.REGULAR);
        lowerBodyClothesService.editRightLeg(lowerBodyClothes, Material.LEATHER, Color.BLACK, Fit.REGULAR);
        lowerBodyClothesService.editButton(lowerBodyClothes, Material.LEATHER, Color.BLACK, 15);

        assertEquals(lowerBodyClothes.getPart(0).getMaterial(), altLeftLeg.getMaterial());
        assertEquals(lowerBodyClothes.getPart(1).getMaterial(), altRightLeg.getMaterial());
        assertEquals(lowerBodyClothes.getPart(2).getMaterial(), altButton.getMaterial());
    }

    @Test
    public void When_EditGeneralLowerBodyClothesWithNull_Expect_OldValue(){
        LowerBodyClothes lowerBodyClothes = lowerBodyClothesService.create(defTitle, defType, defName,
                defSize, defPrice, defLeftLeg, defRightLeg, defButton);

        lowerBodyClothesService.editGeneral(lowerBodyClothes, null, null, null, null, null);

        assertSame(lowerBodyClothes.getTitle(), defTitle);
        assertSame(lowerBodyClothes.getType(), defType);
        assertSame(lowerBodyClothes.getName(), defName);
        assertSame(lowerBodyClothes.getSize(), defSize);
        assertEquals(lowerBodyClothes.getPrice(), defPrice);
    }

    @Test
    public void When_GenerateLowerBodyClothes_Expect_DifferentHashcode(){
        LowerBodyClothes lowerBodyClothes1 = lowerBodyClothesService.create(defTitle, defType, defName,
                defSize, defPrice, defLeftLeg, defRightLeg, defButton);

        LowerBodyClothes lowerBodyClothes2 = lowerBodyClothesService.create(altTitle, altType, altName,
                altSize, altPrice, altLeftLeg, altRightLeg, altButton);

        assertNotEquals(lowerBodyClothes1.hashCode(), lowerBodyClothes2.hashCode());
    }

}