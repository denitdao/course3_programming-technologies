package ua.kpi.tef.pt.lab01.service;

import org.junit.jupiter.api.Test;
import ua.kpi.tef.pt.lab01.entity.LeftSleeve;
import ua.kpi.tef.pt.lab01.entity.parts.Color;
import ua.kpi.tef.pt.lab01.entity.parts.Length;
import ua.kpi.tef.pt.lab01.entity.parts.Material;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

class LeftSleeveServiceTest {

    final LeftSleeveService leftSleeveService = new LeftSleeveService();

    final Material defMaterial = Material.COTTON;
    final Color defColor = Color.BLUE;
    final Length defLength = Length.SHORT;

    final Material altMaterial = Material.LEATHER;
    final Color altColor = Color.BLACK;
    final Length altLength = Length.LONG;

    @Test
    public void When_CreateNewLeftSleeve_Expect_ReturnNotNull() {
        LeftSleeve leftSleeve = leftSleeveService.create(defMaterial, defColor, defLength);

        assertNotNull(leftSleeve);
        assertNotNull(leftSleeve.getTitle());
        assertNotNull(leftSleeve.getMaterial());
        assertNotNull(leftSleeve.getColor());
        assertNotNull(leftSleeve.getLength());
    }

    @Test
    public void When_EditLeftSleeve_Expect_NewValue(){
        LeftSleeve rightSleeve = leftSleeveService.create(defMaterial, defColor, defLength);

        leftSleeveService.edit(rightSleeve, altMaterial, altColor, altLength);

        assertSame(rightSleeve.getMaterial(), altMaterial);
        assertSame(rightSleeve.getColor(), altColor);
        assertSame(rightSleeve.getLength(), altLength);
    }

    @Test
    public void When_EditLeftSleeveWithNull_Expect_OldValue(){
        LeftSleeve rightSleeve = leftSleeveService.create(defMaterial, defColor, defLength);

        leftSleeveService.edit(rightSleeve, null, null, null);

        assertSame(rightSleeve.getMaterial(), defMaterial);
        assertSame(rightSleeve.getColor(), defColor);
        assertSame(rightSleeve.getLength(), defLength);
    }
}