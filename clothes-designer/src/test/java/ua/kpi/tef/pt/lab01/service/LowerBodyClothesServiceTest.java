package ua.kpi.tef.pt.lab01.service;

import org.junit.jupiter.api.Test;
import ua.kpi.tef.pt.lab01.entity.*;
import ua.kpi.tef.pt.lab01.entity.parts.*;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class LowerBodyClothesServiceTest {

    final LeftLegService leftLegService = new LeftLegService();
    final RightLegService rightLegService = new RightLegService();
    final ButtonService buttonService = new ButtonService();

    final LowerBodyClothesService lowerBodyClothesService = new LowerBodyClothesService(leftLegService, rightLegService, buttonService);

    final String defTitle = "Default Title";
    final Type defType = Type.CHILDREN;
    final Name defName = Name.JEANS;
    final Size defSize = Size.L;
    final Double defPrice = 80.;
    final LeftLeg defLeftLeg = leftLegService.create(Material.COTTON, Color.BLUE, Fit.CLASSIC);
    final RightLeg defRightLeg = rightLegService.create(Material.COTTON, Color.BLUE, Fit.CLASSIC);
    final Button defButton = buttonService.create(Material.COTTON, Color.BLUE, 10);

    final String altTitle = "Alternative Title";
    final Type altType = Type.MAN;
    final Name altName = Name.SHORTS;
    final Size altSize = Size.M;
    final Double altPrice = 100.;
    final LeftLeg altLeftLeg = leftLegService.create(Material.LEATHER, Color.BLACK, Fit.REGULAR);
    final RightLeg altRightLeg = rightLegService.create(Material.LEATHER, Color.BLACK, Fit.REGULAR);
    final Button altButton = buttonService.create(Material.LEATHER, Color.BLACK, 15);

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