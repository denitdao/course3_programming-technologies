package ua.kpi.tef.pt.lab01.service;

import org.junit.jupiter.api.Test;
import ua.kpi.tef.pt.lab01.model.Body;

import static org.junit.jupiter.api.Assertions.*;

class BodyServiceTest {
    BodyService bodyService = new BodyService();

    @Test
    public void createNewBodyShouldReturnBody() {
        Body body = bodyService.create();

        assertNotNull(body);
    }

    @Test
    public void editBodyShouldSetNotNull(){
        Body body = new Body();

        bodyService.edit(body);

        assertNotNull(body.getTitle());
        assertNotNull(body.getMaterial());
        assertNotNull(body.getColor());
    }

}