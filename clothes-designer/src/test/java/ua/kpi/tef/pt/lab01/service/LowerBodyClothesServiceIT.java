package ua.kpi.tef.pt.lab01.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.kpi.tef.pt.lab01.entity.*;
import ua.kpi.tef.pt.lab01.entity.parts.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class LowerBodyClothesServiceIT {

    final String defTitle = "Default Title";
    final Type defType = Type.CHILDREN;
    final Name defName = Name.JEANS;
    final Size defSize = Size.L;
    final Double defPrice = 80.;
    final LeftLeg defLeftLeg = new LeftLeg(Material.COTTON, Color.BLUE, Fit.CLASSIC);
    final RightLeg defRightLeg = new RightLeg(Material.COTTON, Color.BLUE, Fit.CLASSIC);
    final Button defButton = new Button(Material.COTTON, Color.BLUE, 10);

    @Mock
    LeftLegService leftLegService;

    @Mock
    RightLegService rightLegService;

    @Mock
    ButtonService buttonService;

    @InjectMocks
    LowerBodyClothesService lowerBodyClothesService;

    @Test
    public void When_EditLeftLeg_Expect_ValueChanged() {
        LowerBodyClothes lowerBodyClothes = new LowerBodyClothesService(null, null, null)
                .create(defTitle, defType, defName, defSize, defPrice, defLeftLeg, defRightLeg, defButton); // all data
        Mockito.doAnswer(invocationOnMock -> {
            Object[] args = invocationOnMock.getArguments();
            ((LeftLeg) args[0]).setMaterial(Material.METAL);
            ((LeftLeg) args[0]).setColor(Color.GREEN);
            ((LeftLeg) args[0]).setFit(Fit.REGULAR);
            return null;
        }).when(leftLegService).edit(defLeftLeg, Material.METAL, Color.GREEN, Fit.REGULAR);

        lowerBodyClothesService.editLeftLeg(lowerBodyClothes, Material.METAL, Color.GREEN, Fit.REGULAR);

        Mockito.verify(leftLegService).edit(defLeftLeg, Material.METAL, Color.GREEN, Fit.REGULAR); // count
        assertEquals("Left Leg\n" +
                "\tmaterial: Metal\n" +
                "\tcolor: Green\n" +
                "\tfit: Regular",
                lowerBodyClothes.getPart(0).toString()); // check result
    }

    @Test
    public void When_EditLeftLegOnEmpty_Expect_ValueAdded() {
        LowerBodyClothes lowerBodyClothes = new LowerBodyClothesService(null, null, null)
                .create(defTitle, defType, defName, defSize, defPrice); // no left leg
        Mockito.when(leftLegService.create(Material.METAL, Color.GREEN, Fit.REGULAR))
                .thenReturn(new LeftLeg(Material.METAL, Color.GREEN, Fit.REGULAR));

        lowerBodyClothesService.editLeftLeg(lowerBodyClothes, Material.METAL, Color.GREEN, Fit.REGULAR);

        Mockito.verify(leftLegService).create(Material.METAL, Color.GREEN, Fit.REGULAR); // count
        assertEquals("Left Leg\n" +
                        "\tmaterial: Metal\n" +
                        "\tcolor: Green\n" +
                        "\tfit: Regular",
                lowerBodyClothes.getPart(0).toString()); // check result
    }

    @Test
    public void When_EditRightLeg_Expect_ValueChanged() {
        LowerBodyClothes lowerBodyClothes = new LowerBodyClothesService(null, null, null)
                .create(defTitle, defType, defName, defSize, defPrice, defLeftLeg, defRightLeg, defButton); // all data
        Mockito.doAnswer(invocationOnMock -> {
            Object[] args = invocationOnMock.getArguments();
            ((RightLeg) args[0]).setMaterial(Material.METAL);
            ((RightLeg) args[0]).setColor(Color.GREEN);
            ((RightLeg) args[0]).setFit(Fit.REGULAR);
            return null;
        }).when(rightLegService).edit(defRightLeg, Material.METAL, Color.GREEN, Fit.REGULAR);

        lowerBodyClothesService.editRightLeg(lowerBodyClothes, Material.METAL, Color.GREEN, Fit.REGULAR);

        Mockito.verify(rightLegService).edit(defRightLeg, Material.METAL, Color.GREEN, Fit.REGULAR); // count
        assertEquals("Right Leg\n" +
                        "\tmaterial: Metal\n" +
                        "\tcolor: Green\n" +
                        "\tfit: Regular",
                lowerBodyClothes.getPart(1).toString()); // check result
    }

    @Test
    public void When_EditRightLegOnEmpty_Expect_ValueAdded() {
        LowerBodyClothes lowerBodyClothes = new LowerBodyClothesService(null, null, null)
                .create(defTitle, defType, defName, defSize, defPrice); // no right leg
        Mockito.when(rightLegService.create(Material.METAL, Color.GREEN, Fit.REGULAR))
                .thenReturn(new RightLeg(Material.METAL, Color.GREEN, Fit.REGULAR));

        lowerBodyClothesService.editRightLeg(lowerBodyClothes, Material.METAL, Color.GREEN, Fit.REGULAR);

        Mockito.verify(rightLegService).create(Material.METAL, Color.GREEN, Fit.REGULAR); // count
        assertEquals("Right Leg\n" +
                        "\tmaterial: Metal\n" +
                        "\tcolor: Green\n" +
                        "\tfit: Regular",
                lowerBodyClothes.getPart(0).toString()); // check result
    }

    @Test
    public void When_EditButton_Expect_ValueChanged() {
        LowerBodyClothes lowerBodyClothes = new LowerBodyClothesService(null, null, null)
                .create(defTitle, defType, defName, defSize, defPrice, defLeftLeg, defRightLeg, defButton); // all data
        Mockito.doAnswer(invocationOnMock -> {
            Object[] args = invocationOnMock.getArguments();
            ((Button) args[0]).setMaterial(Material.METAL);
            ((Button) args[0]).setColor(Color.GREEN);
            ((Button) args[0]).setAmount(15);
            return null;
        }).when(buttonService).edit(defButton, Material.METAL, Color.GREEN, 15);

        lowerBodyClothesService.editButton(lowerBodyClothes, Material.METAL, Color.GREEN, 15);

        Mockito.verify(buttonService).edit(defButton, Material.METAL, Color.GREEN, 15); // count
        assertEquals("Button\n" +
                        "\tmaterial: Metal\n" +
                        "\tcolor: Green\n" +
                        "\tamount: 15",
                lowerBodyClothes.getPart(2).toString()); // check result
    }

    @Test
    public void When_EditButtonOnEmpty_Expect_ValueAdded() {
        LowerBodyClothes lowerBodyClothes = new LowerBodyClothesService(null, null, null)
                .create(defTitle, defType, defName, defSize, defPrice); // no button
        Mockito.when(buttonService.create(Material.METAL, Color.GREEN, 15))
                .thenReturn(new Button(Material.METAL, Color.GREEN, 15));

        lowerBodyClothesService.editButton(lowerBodyClothes, Material.METAL, Color.GREEN, 15);

        Mockito.verify(buttonService).create(Material.METAL, Color.GREEN, 15); // count
        assertEquals("Button\n" +
                        "\tmaterial: Metal\n" +
                        "\tcolor: Green\n" +
                        "\tamount: 15",
                lowerBodyClothes.getPart(0).toString()); // check result
    }
}