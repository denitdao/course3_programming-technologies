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
class UpperBodyClothesServiceIT {

    final String defTitle = "Default Title";
    final Type defType = Type.CHILDREN;
    final Name defName = Name.JACKET;
    final Size defSize = Size.L;
    final Double defPrice = 80.;
    final LeftSleeve defLeftSleeve = new LeftSleeve(Material.COTTON, Color.BLUE, Length.LONG);
    final RightSleeve defRightSleeve = new RightSleeve(Material.COTTON, Color.BLUE, Length.LONG);
    final Button defButton = new Button(Material.COTTON, Color.BLUE, 10);

    @Mock
    LeftSleeveService leftSleeveService;

    @Mock
    RightSleeveService rightSleeveService;

    @Mock
    ButtonService buttonService;

    @InjectMocks
    UpperBodyClothesService upperBodyClothesService;

    @Test
    public void When_EditLeftSleeve_Expect_ValueChanged() {
        UpperBodyClothes upperBodyClothes = new UpperBodyClothesService(null, null, null, null)
                .create(defTitle, defType, defName, defSize, defPrice, defLeftSleeve, defRightSleeve, defButton); // all data
        Mockito.doAnswer(invocationOnMock -> {
            Object[] args = invocationOnMock.getArguments();
            ((LeftSleeve) args[0]).setMaterial(Material.LEATHER);
            ((LeftSleeve) args[0]).setColor(Color.GREEN);
            ((LeftSleeve) args[0]).setLength(Length.SHORT);
            return null;
        }).when(leftSleeveService).edit(defLeftSleeve, Material.LEATHER, Color.GREEN, Length.SHORT);

        upperBodyClothesService.editLeftSleeve(upperBodyClothes, Material.LEATHER, Color.GREEN, Length.SHORT);

        Mockito.verify(leftSleeveService).edit(defLeftSleeve, Material.LEATHER, Color.GREEN, Length.SHORT); // count
        assertEquals("Left Sleeve\n" +
                        "\tmaterial: Leather\n" +
                        "\tcolor: Green\n" +
                        "\tlength: Short",
                upperBodyClothes.getPart(0).toString()); // check result
    }

    @Test
    public void When_EditLeftSleeveOnEmpty_Expect_ValueAdded() {
        UpperBodyClothes upperBodyClothes = new UpperBodyClothesService(null, null, null, null)
                .create(defTitle, defType, defName, defSize, defPrice); // no button
        Mockito.when(leftSleeveService.create(Material.LEATHER, Color.GREEN, Length.SHORT))
                .thenReturn(new LeftSleeve(Material.LEATHER, Color.GREEN, Length.SHORT));

        upperBodyClothesService.editLeftSleeve(upperBodyClothes, Material.LEATHER, Color.GREEN, Length.SHORT);

        Mockito.verify(leftSleeveService).create(Material.LEATHER, Color.GREEN, Length.SHORT); // count
        assertEquals("Left Sleeve\n" +
                        "\tmaterial: Leather\n" +
                        "\tcolor: Green\n" +
                        "\tlength: Short",
                upperBodyClothes.getPart(0).toString()); // check result
    }

    @Test
    public void When_EditRightSleeve_Expect_ValueChanged() {
        UpperBodyClothes upperBodyClothes = new UpperBodyClothesService(null, null, null, null)
                .create(defTitle, defType, defName, defSize, defPrice, defLeftSleeve, defRightSleeve, defButton); // all data
        Mockito.doAnswer(invocationOnMock -> {
            Object[] args = invocationOnMock.getArguments();
            ((RightSleeve) args[0]).setMaterial(Material.LEATHER);
            ((RightSleeve) args[0]).setColor(Color.GREEN);
            ((RightSleeve) args[0]).setLength(Length.SHORT);
            return null;
        }).when(rightSleeveService).edit(defRightSleeve, Material.LEATHER, Color.GREEN, Length.SHORT);

        upperBodyClothesService.editRightSleeve(upperBodyClothes, Material.LEATHER, Color.GREEN, Length.SHORT);

        Mockito.verify(rightSleeveService).edit(defRightSleeve, Material.LEATHER, Color.GREEN, Length.SHORT); // count
        assertEquals("Right Sleeve\n" +
                        "\tmaterial: Leather\n" +
                        "\tcolor: Green\n" +
                        "\tlength: Short",
                upperBodyClothes.getPart(1).toString()); // check result
    }

    @Test
    public void When_EditRightSleeveOnEmpty_Expect_ValueAdded() {
        UpperBodyClothes upperBodyClothes = new UpperBodyClothesService(null, null, null, null)
                .create(defTitle, defType, defName, defSize, defPrice); // no button
        Mockito.when(rightSleeveService.create(Material.LEATHER, Color.GREEN, Length.SHORT))
                .thenReturn(new RightSleeve(Material.LEATHER, Color.GREEN, Length.SHORT));

        upperBodyClothesService.editRightSleeve(upperBodyClothes, Material.LEATHER, Color.GREEN, Length.SHORT);

        Mockito.verify(rightSleeveService).create(Material.LEATHER, Color.GREEN, Length.SHORT); // count
        assertEquals("Right Sleeve\n" +
                        "\tmaterial: Leather\n" +
                        "\tcolor: Green\n" +
                        "\tlength: Short",
                upperBodyClothes.getPart(0).toString()); // check result
    }

    @Test
    public void When_EditButton_Expect_ValueChanged() {
        UpperBodyClothes upperBodyClothes = new UpperBodyClothesService(null, null, null, null)
                .create(defTitle, defType, defName, defSize, defPrice, defLeftSleeve, defRightSleeve, defButton); // all data
        Mockito.doAnswer(invocationOnMock -> {
            Object[] args = invocationOnMock.getArguments();
            ((Button) args[0]).setMaterial(Material.METAL);
            ((Button) args[0]).setColor(Color.GREEN);
            ((Button) args[0]).setAmount(15);
            return null;
        }).when(buttonService).edit(defButton, Material.METAL, Color.GREEN, 15);

        upperBodyClothesService.editButton(upperBodyClothes, Material.METAL, Color.GREEN, 15);

        Mockito.verify(buttonService).edit(defButton, Material.METAL, Color.GREEN, 15); // count
        assertEquals("Button\n" +
                        "\tmaterial: Metal\n" +
                        "\tcolor: Green\n" +
                        "\tamount: 15",
                upperBodyClothes.getPart(2).toString()); // check result
    }

    @Test
    public void When_EditButtonOnEmpty_Expect_ValueAdded() {
        UpperBodyClothes upperBodyClothes = new UpperBodyClothesService(null, null, null, null)
                .create(defTitle, defType, defName, defSize, defPrice); // no button
        Mockito.when(buttonService.create(Material.METAL, Color.GREEN, 15))
                .thenReturn(new Button(Material.METAL, Color.GREEN, 15));

        upperBodyClothesService.editButton(upperBodyClothes, Material.METAL, Color.GREEN, 15);

        Mockito.verify(buttonService).create(Material.METAL, Color.GREEN, 15); // count
        assertEquals("Button\n" +
                        "\tmaterial: Metal\n" +
                        "\tcolor: Green\n" +
                        "\tamount: 15",
                upperBodyClothes.getPart(0).toString()); // check result
    }
}