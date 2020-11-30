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

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

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

//    todo: lambdas

    @Test
    public void When_CalculatingAvgPrice_Expect_Result() {
        clothesController.addUpperBody(new UpperBodyClothes(null, null, null, null, 20));
        clothesController.addLowerBody(new LowerBodyClothes(null, null, null, null, 40));
        clothesController.addUpperBody(new UpperBodyClothes(null, null, null, null, 60));
        clothesController.addLowerBody(new LowerBodyClothes(null, null, null, null, 80));
        clothesController.addUpperBody(new UpperBodyClothes(null, null, null, null, 100));

        assertEquals(60, clothesController.calculateAvgPrice());
    }

    @Test
    public void When_CalculatingAvgPriceOfEmpty_Expect_NaN() {
        assertEquals(Double.NaN, clothesController.calculateAvgPrice());
    }

    @Test
    public void When_GetMostExpensiveLowerClothes_Expect_Result() {
        clothesController.addLowerBody(new LowerBodyClothes(null, null, null, null, 40));
        clothesController.addLowerBody(new LowerBodyClothes(null, null, null, null, 80));

        Optional<LowerBodyClothes> opt_mostExpensive = clothesController.getMostExpensiveLowerBodyClothes();

        assertTrue(opt_mostExpensive.isPresent());
        opt_mostExpensive.ifPresent(c -> assertEquals(80, c.getPrice()));
    }

    @Test
    public void When_GetMostExpensiveUpperClothes_Expect_OptionalWithResult() {
        clothesController.addUpperBody(new UpperBodyClothes(null, null, null, null, 20));
        clothesController.addUpperBody(new UpperBodyClothes(null, null, null, null, 100));
        clothesController.addUpperBody(new UpperBodyClothes(null, null, null, null, 60));

        Optional<UpperBodyClothes> opt_mostExpensive = clothesController.getMostExpensiveUpperBodyClothes();

        assertTrue(opt_mostExpensive.isPresent());
        opt_mostExpensive.ifPresent(c -> assertEquals(100, c.getPrice()));
    }

    @Test
    public void When_EmptyAndGetMostExpensiveClothes_Expect_EmptyOptional() {
        assertFalse(clothesController.getMostExpensiveUpperBodyClothes().isPresent());
        assertFalse(clothesController.getMostExpensiveLowerBodyClothes().isPresent());
    }

    @Test
    public void When_CalculateTotalPriceOfClothesWithName_Expect_Result() {
        clothesController.addUpperBody(new UpperBodyClothes(null, null, Name.COAT, null, 20));
        clothesController.addUpperBody(new UpperBodyClothes(null, null, Name.JEANS, null, 100));
        clothesController.addUpperBody(new UpperBodyClothes(null, null, Name.COAT, null, 60));

        assertEquals(80, clothesController.calculateTotalPriceOf(Name.COAT));
        assertEquals(100, clothesController.calculateTotalPriceOf(Name.JEANS));
    }

    @Test
    public void When_EmptyAndCalculateTotalPriceOfClothesWithName_Expect_NaN() {
        assertEquals(0., clothesController.calculateTotalPriceOf(Name.COAT));
    }
}