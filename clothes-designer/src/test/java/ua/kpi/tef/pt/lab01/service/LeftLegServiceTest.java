package ua.kpi.tef.pt.lab01.service;

import org.junit.jupiter.api.Test;
import ua.kpi.tef.pt.lab01.model.LeftLeg;
import ua.kpi.tef.pt.lab01.model.parts.Color;
import ua.kpi.tef.pt.lab01.model.parts.Fit;
import ua.kpi.tef.pt.lab01.model.parts.Material;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

class LeftLegServiceTest {

    LeftLegService leftLegService = new LeftLegService();

    Material defMaterial = Material.COTTON;
    Color defColor = Color.BLUE;
    Fit defFit = Fit.CLASSIC;

    Material altMaterial = Material.LEATHER;
    Color altColor = Color.BLACK;
    Fit altFit = Fit.REGULAR;

    @Test
    public void When_CreateNewLeftLeg_Expect_ReturnNotNull() {
        LeftLeg leftLeg = leftLegService.create(defMaterial, defColor, defFit);

        assertNotNull(leftLeg);
        assertNotNull(leftLeg.getTitle());
        assertNotNull(leftLeg.getMaterial());
        assertNotNull(leftLeg.getColor());
        assertNotNull(leftLeg.getFit());
    }

    @Test
    public void When_EditLeftLeg_Expect_NewValue(){
        LeftLeg leftLeg = leftLegService.create(defMaterial, defColor, defFit);

        leftLegService.edit(leftLeg, altMaterial, altColor, altFit);

        assertSame(leftLeg.getMaterial(), altMaterial);
        assertSame(leftLeg.getColor(), altColor);
        assertSame(leftLeg.getFit(), altFit);
    }

    @Test
    public void When_EditLeftLegWithNull_Expect_OldValue(){
        LeftLeg leftLeg = leftLegService.create(defMaterial, defColor, defFit);

        leftLegService.edit(leftLeg, null, null, null);

        assertSame(leftLeg.getMaterial(), defMaterial);
        assertSame(leftLeg.getColor(), defColor);
        assertSame(leftLeg.getFit(), defFit);
    }
}