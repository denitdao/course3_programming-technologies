package ua.kpi.tef.pt.lab01.service;

import org.junit.jupiter.api.Test;
import ua.kpi.tef.pt.lab01.model.RightLeg;
import ua.kpi.tef.pt.lab01.model.parts.Color;
import ua.kpi.tef.pt.lab01.model.parts.Fit;
import ua.kpi.tef.pt.lab01.model.parts.Material;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

class RightLegServiceTest {

    RightLegService rightLegService = new RightLegService();

    Material defMaterial = Material.COTTON;
    Color defColor = Color.BLUE;
    Fit defFit = Fit.CLASSIC;

    Material altMaterial = Material.LEATHER;
    Color altColor = Color.BLACK;
    Fit altFit = Fit.REGULAR;

    @Test
    public void When_CreateNewRightLeg_Expect_ReturnNotNull() {
        RightLeg rightLeg = rightLegService.create(defMaterial, defColor, defFit);

        assertNotNull(rightLeg);
        assertNotNull(rightLeg.getTitle());
        assertNotNull(rightLeg.getMaterial());
        assertNotNull(rightLeg.getColor());
        assertNotNull(rightLeg.getFit());
    }

    @Test
    public void When_EditRightLeg_Expect_NewValue(){
        RightLeg rightLeg = rightLegService.create(defMaterial, defColor, defFit);

        rightLegService.edit(rightLeg, altMaterial, altColor, altFit);

        assertSame(rightLeg.getMaterial(), altMaterial);
        assertSame(rightLeg.getColor(), altColor);
        assertSame(rightLeg.getFit(), altFit);
    }

    @Test
    public void When_EditRightLegWithNull_Expect_OldValue(){
        RightLeg rightLeg = rightLegService.create(defMaterial, defColor, defFit);

        rightLegService.edit(rightLeg, null, null, null);

        assertSame(rightLeg.getMaterial(), defMaterial);
        assertSame(rightLeg.getColor(), defColor);
        assertSame(rightLeg.getFit(), defFit);
    }
}