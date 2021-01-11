package ua.kpi.tef.pt.lab01.service;

import org.junit.jupiter.api.Test;
import ua.kpi.tef.pt.lab01.model.Button;
import ua.kpi.tef.pt.lab01.model.parts.Color;
import ua.kpi.tef.pt.lab01.model.parts.Material;

import static org.junit.jupiter.api.Assertions.*;

class ButtonServiceTest {

    final ButtonService buttonService = new ButtonService();

    final Material defMaterial = Material.COTTON;
    final Color defColor = Color.BLUE;
    final Integer defAmount = 10;

    final Material altMaterial = Material.LEATHER;
    final Color altColor = Color.BLACK;
    final Integer altAmount = 15;

    @Test
    public void When_CreateNewButton_Expect_ReturnNotNull() {
        Button button = buttonService.create(defMaterial, defColor, defAmount);

        assertNotNull(button);
        assertNotNull(button.getTitle());
        assertNotNull(button.getMaterial());
        assertNotNull(button.getColor());
        assertNotEquals(button.getAmount(), 0);
    }

    @Test
    public void When_EditButton_Expect_NewValue(){
        Button button = buttonService.create(defMaterial, defColor, defAmount);

        buttonService.edit(button, altMaterial, altColor, altAmount);

        assertSame(button.getMaterial(), altMaterial);
        assertSame(button.getColor(), altColor);
        assertSame(button.getAmount(), altAmount);
    }

    @Test
    public void When_EditButtonWithNull_Expect_OldValue(){
        Button button = buttonService.create(defMaterial, defColor, defAmount);

        buttonService.edit(button, null, null, null);

        assertSame(button.getMaterial(), defMaterial);
        assertSame(button.getColor(), defColor);
        assertSame(button.getAmount(), defAmount);
    }

}