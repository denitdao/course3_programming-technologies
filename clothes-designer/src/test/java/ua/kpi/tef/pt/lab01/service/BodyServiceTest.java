package ua.kpi.tef.pt.lab01.service;

import org.junit.jupiter.api.Test;
import ua.kpi.tef.pt.lab01.model.Body;
import ua.kpi.tef.pt.lab01.model.parts.Material;
import ua.kpi.tef.pt.lab01.model.parts.Color;

import static org.junit.jupiter.api.Assertions.*;

class BodyServiceTest {

    static final BodyService bodyService = new BodyService();

    static final Material defMaterial = Material.COTTON;
    static final Color defColor = Color.BLUE;

    static final Material altMaterial = Material.LEATHER;
    static final Color altColor = Color.BLACK;

    @Test
    public void When_CreateNewBody_Expect_ReturnNotNull() {
        Body body = bodyService.create(defMaterial, defColor);

        assertNotNull(body);
        assertNotNull(body.getTitle());
        assertNotNull(body.getMaterial());
        assertNotNull(body.getColor());

    }

    @Test
    public void When_EditBody_Expect_NewValue(){
        Body body = bodyService.create(defMaterial, defColor);

        bodyService.edit(body, altMaterial, altColor);

        assertSame(body.getMaterial(), altMaterial);
        assertSame(body.getColor(), altColor);
    }

    @Test
    public void When_EditBodyWithNull_Expect_OldValue(){
        Body body = bodyService.create(defMaterial, defColor);

        bodyService.edit(body, null, null);

        assertSame(body.getMaterial(), defMaterial);
        assertSame(body.getColor(), defColor);
    }

}