package ua.kpi.tef.pt.lab01.service;

import org.junit.jupiter.api.Test;
import ua.kpi.tef.pt.lab01.entity.LeftLeg;
import ua.kpi.tef.pt.lab01.entity.parts.Color;
import ua.kpi.tef.pt.lab01.entity.parts.Fit;
import ua.kpi.tef.pt.lab01.entity.parts.Material;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

class LeftLegServiceTest {

    final LeftLegService leftLegService = new LeftLegService();

    final Material defMaterial = Material.COTTON;
    final Color defColor = Color.BLUE;
    final Fit defFit = Fit.CLASSIC;

    final Material altMaterial = Material.LEATHER;
    final Color altColor = Color.BLACK;
    final Fit altFit = Fit.REGULAR;

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