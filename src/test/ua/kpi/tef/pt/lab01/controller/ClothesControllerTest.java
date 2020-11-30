package ua.kpi.tef.pt.lab01.controller;

import org.junit.jupiter.api.Test;
import ua.kpi.tef.pt.lab01.exceptions.InvalidClothesIdException;
import ua.kpi.tef.pt.lab01.exceptions.InvalidClothingSectionException;
import ua.kpi.tef.pt.lab01.model.LowerBodyClothes;
import ua.kpi.tef.pt.lab01.model.UpperBodyClothes;
import ua.kpi.tef.pt.lab01.model.parts.Name;
import ua.kpi.tef.pt.lab01.model.parts.Size;
import ua.kpi.tef.pt.lab01.model.parts.Type;
import ua.kpi.tef.pt.lab01.service.LowerBodyClothesService;
import ua.kpi.tef.pt.lab01.service.UpperBodyClothesService;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ClothesControllerTest {

    ClothesController clothesController = new ClothesController();
    LowerBodyClothes defLowerBodyClothes = LowerBodyClothesService.create("Def Lower Body", Type.MAN, Name.JEANS,
            Size.L,80.);
    UpperBodyClothes defUpperBodyClothes = UpperBodyClothesService.create("Def Upper Body", Type.MAN, Name.COAT,
            Size.L,90.);

    @Test
    public void When_AddLowerBodyClothes_Expect_ItToBeAdded() {
        long addedId = clothesController.addLowerBody(defLowerBodyClothes);

        assertDoesNotThrow(() -> clothesController.getLowerBody(addedId));
    }

    @Test
    public void When_AddUpperBodyClothes_Expect_ItToBeAdded() {
        long addedId = clothesController.addUpperBody(defUpperBodyClothes);

        assertDoesNotThrow(() -> clothesController.getUpperBody(addedId));
    }

    @Test
    public void When_PassWrongClothesId_Expect_Throw() {
        assertThrows(InvalidClothesIdException.class,() -> clothesController.getLowerBody(-1));
        assertThrows(InvalidClothesIdException.class,() -> clothesController.getUpperBody(-1));
        assertThrows(InvalidClothesIdException.class,() -> clothesController.deleteClothes(-1));
        assertThrows(InvalidClothesIdException.class,() -> clothesController.showClothes(-1));
    }

    @Test
    public void When_CreateAndDeleteLowerBodyClothes_Expect_Throw() {
        long id = clothesController.addLowerBody(defLowerBodyClothes);

        assertDoesNotThrow(() -> clothesController.getLowerBody(id));
        assertDoesNotThrow(() -> clothesController.deleteClothes(id));
        assertThrows(InvalidClothesIdException.class, () -> clothesController.getLowerBody(id));
    }

    @Test
    public void When_CreateAndDeleteUpperBodyClothes_Expect_Throw() {
        long id = clothesController.addUpperBody(defUpperBodyClothes);

        assertDoesNotThrow(() -> clothesController.getUpperBody(id));
        assertDoesNotThrow(() -> clothesController.deleteClothes(id));
        assertThrows(InvalidClothesIdException.class, () -> clothesController.getUpperBody(id));
    }

    @Test
    public void When_SearchingWrongSection_Expect_Throw() {
        long idLower = clothesController.addLowerBody(defLowerBodyClothes);
        long idUpper = clothesController.addUpperBody(defUpperBodyClothes);

        assertThrows(InvalidClothingSectionException.class, () -> clothesController.getLowerBody(idUpper));
        assertThrows(InvalidClothingSectionException.class, () -> clothesController.getUpperBody(idLower));
    }

}