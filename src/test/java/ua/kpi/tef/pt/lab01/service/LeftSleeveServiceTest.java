package ua.kpi.tef.pt.lab01.service;

import org.junit.jupiter.api.Test;
import ua.kpi.tef.pt.lab01.model.LeftSleeve;
import ua.kpi.tef.pt.lab01.model.parts.Color;
import ua.kpi.tef.pt.lab01.model.parts.Length;
import ua.kpi.tef.pt.lab01.model.parts.Material;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

class LeftSleeveServiceTest {

    Material defMaterial = Material.COTTON;
    Color defColor = Color.BLUE;
    Length defLength = Length.SHORT;

    Material altMaterial = Material.LEATHER;
    Color altColor = Color.BLACK;
    Length altLength = Length.LONG;

    @Test
    public void When_CreateNewLeftSleeve_Expect_ReturnNotNull() {
        LeftSleeve leftSleeve = LeftSleeveService.create(defMaterial, defColor, defLength);

        assertNotNull(leftSleeve);
        assertNotNull(leftSleeve.getTitle());
        assertNotNull(leftSleeve.getMaterial());
        assertNotNull(leftSleeve.getColor());
        assertNotNull(leftSleeve.getLength());
    }

    @Test
    public void When_EditLeftSleeve_Expect_NewValue(){
        LeftSleeve rightSleeve = LeftSleeveService.create(defMaterial, defColor, defLength);

        LeftSleeveService.edit(rightSleeve, altMaterial, altColor, altLength);

        assertSame(rightSleeve.getMaterial(), altMaterial);
        assertSame(rightSleeve.getColor(), altColor);
        assertSame(rightSleeve.getLength(), altLength);
    }

    @Test
    public void When_EditLeftSleeveWithNull_Expect_OldValue(){
        LeftSleeve rightSleeve = LeftSleeveService.create(defMaterial, defColor, defLength);

        LeftSleeveService.edit(rightSleeve, null, null, null);

        assertSame(rightSleeve.getMaterial(), defMaterial);
        assertSame(rightSleeve.getColor(), defColor);
        assertSame(rightSleeve.getLength(), defLength);
    }
}