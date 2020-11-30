package ua.kpi.tef.pt.lab01.service;

import org.junit.jupiter.api.Test;
import ua.kpi.tef.pt.lab01.model.Button;
import ua.kpi.tef.pt.lab01.model.parts.Color;
import ua.kpi.tef.pt.lab01.model.parts.Material;

import static org.junit.jupiter.api.Assertions.*;

class ButtonServiceTest {

    Material defMaterial = Material.COTTON;
    Color defColor = Color.BLUE;
    Integer defAmount = 10;

    Material altMaterial = Material.LEATHER;
    Color altColor = Color.BLACK;
    Integer altAmount = 15;

    @Test
    public void When_CreateNewButton_Expect_ReturnNotNull() {
        Button button = ButtonService.create(defMaterial, defColor, defAmount);

        assertNotNull(button);
        assertNotNull(button.getTitle());
        assertNotNull(button.getMaterial());
        assertNotNull(button.getColor());
        assertNotEquals(button.getAmount(), 0);
    }

    @Test
    public void When_EditButton_Expect_NewValue(){
        Button button = ButtonService.create(defMaterial, defColor, defAmount);

        ButtonService.edit(button, altMaterial, altColor, altAmount);

        assertSame(button.getMaterial(), altMaterial);
        assertSame(button.getColor(), altColor);
        assertSame(button.getAmount(), altAmount);
    }

    @Test
    public void When_EditButtonWithNull_Expect_OldValue(){
        Button button = ButtonService.create(defMaterial, defColor, defAmount);

        ButtonService.edit(button, null, null, null);

        assertSame(button.getMaterial(), defMaterial);
        assertSame(button.getColor(), defColor);
        assertSame(button.getAmount(), defAmount);
    }

}