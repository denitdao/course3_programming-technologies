package ua.kpi.tef.pt.lab01.service;

import org.junit.jupiter.api.Test;
import ua.kpi.tef.pt.lab01.model.Body;
import ua.kpi.tef.pt.lab01.model.parts.Material;
import ua.kpi.tef.pt.lab01.model.parts.Color;

import static org.junit.jupiter.api.Assertions.*;

class BodyServiceTest {

    Material defMaterial = Material.COTTON;
    Color defColor = Color.BLUE;

    Material altMaterial = Material.LEATHER;
    Color altColor = Color.BLACK;

    @Test
    public void When_CreateNewBody_Expect_ReturnNotNull() {
        Body body = BodyService.create(defMaterial, defColor);

        assertNotNull(body);
        assertNotNull(body.getTitle());
        assertNotNull(body.getMaterial());
        assertNotNull(body.getColor());

    }

    @Test
    public void When_EditBody_Expect_NewValue(){
        Body body = BodyService.create(defMaterial, defColor);

        BodyService.edit(body, altMaterial, altColor);

        assertSame(body.getMaterial(), altMaterial);
        assertSame(body.getColor(), altColor);
    }

    @Test
    public void When_EditBodyWithNull_Expect_OldValue(){
        Body body = BodyService.create(defMaterial, defColor);

        BodyService.edit(body, null, null);

        assertSame(body.getMaterial(), defMaterial);
        assertSame(body.getColor(), defColor);
    }

}