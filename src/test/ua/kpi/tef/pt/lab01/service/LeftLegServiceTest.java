package ua.kpi.tef.pt.lab01.service;

import org.junit.jupiter.api.Test;
import ua.kpi.tef.pt.lab01.model.LeftLeg;

import static org.junit.jupiter.api.Assertions.*;

class LeftLegServiceTest {
    LeftLegService leftLegService = new LeftLegService();

    @Test
    public void createNewLeftLegShouldReturnLeftLeg() {
        LeftLeg leftLeg = leftLegService.create();

        assertNotNull(leftLeg);
    }

    @Test
    public void editLeftLegShouldSetNotNull(){
        LeftLeg leftLeg = new LeftLeg();

        leftLegService.edit(leftLeg);

        assertNotNull(leftLeg.getTitle());
        assertNotNull(leftLeg.getMaterial());
        assertNotNull(leftLeg.getColor());
        assertNotNull(leftLeg.getFit());
    }
}