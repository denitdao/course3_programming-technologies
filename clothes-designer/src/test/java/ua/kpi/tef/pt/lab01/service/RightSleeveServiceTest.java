package ua.kpi.tef.pt.lab01.service;

import org.junit.jupiter.api.Test;
import ua.kpi.tef.pt.lab01.model.RightSleeve;
import ua.kpi.tef.pt.lab01.model.parts.Color;
import ua.kpi.tef.pt.lab01.model.parts.Length;
import ua.kpi.tef.pt.lab01.model.parts.Material;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

class RightSleeveServiceTest {

    RightSleeveService rightSleeveService = new RightSleeveService();

    Material defMaterial = Material.COTTON;
    Color defColor = Color.BLUE;
    Length defLength = Length.SHORT;

    Material altMaterial = Material.LEATHER;
    Color altColor = Color.BLACK;
    Length altLength = Length.LONG;

    @Test
    public void When_CreateNewRightSleeve_Expect_ReturnNotNull() {
        RightSleeve rightSleeve = rightSleeveService.create(defMaterial, defColor, defLength);

        assertNotNull(rightSleeve);
        assertNotNull(rightSleeve.getTitle());
        assertNotNull(rightSleeve.getMaterial());
        assertNotNull(rightSleeve.getColor());
        assertNotNull(rightSleeve.getLength());
    }

    @Test
    public void When_EditRightSleeve_Expect_NewValue(){
        RightSleeve rightSleeve = rightSleeveService.create(defMaterial, defColor, defLength);

        rightSleeveService.edit(rightSleeve, altMaterial, altColor, altLength);

        assertSame(rightSleeve.getMaterial(), altMaterial);
        assertSame(rightSleeve.getColor(), altColor);
        assertSame(rightSleeve.getLength(), altLength);
    }

    @Test
    public void When_EditRightSleeveWithNull_Expect_OldValue(){
        RightSleeve rightSleeve = rightSleeveService.create(defMaterial, defColor, defLength);

        rightSleeveService.edit(rightSleeve, null, null, null);

        assertSame(rightSleeve.getMaterial(), defMaterial);
        assertSame(rightSleeve.getColor(), defColor);
        assertSame(rightSleeve.getLength(), defLength);
    }
}