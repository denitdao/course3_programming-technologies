package ua.kpi.tef.pt.lab01.service;

import org.junit.jupiter.api.Test;
import ua.kpi.tef.pt.lab01.model.RightLeg;

import static org.junit.jupiter.api.Assertions.*;

class RightLegServiceTest {
    RightLegService rightLegService = new RightLegService();

    @Test
    public void createNewRightLegShouldReturnRightLeg() {
        RightLeg rightLeg = rightLegService.create();

        assertNotNull(rightLeg);
    }

    @Test
    public void editRightLegShouldSetNotNull(){
        RightLeg rightLeg = new RightLeg();

        rightLegService.edit(rightLeg);

        assertNotNull(rightLeg.getTitle());
        assertNotNull(rightLeg.getMaterial());
        assertNotNull(rightLeg.getColor());
        assertNotNull(rightLeg.getFit());
    }
}