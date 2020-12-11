package ua.kpi.tef.pt.lab01.controller;

import org.junit.jupiter.api.Test;
import ua.kpi.tef.pt.lab01.exceptions.InvalidClothesIdException;
import ua.kpi.tef.pt.lab01.exceptions.InvalidClothingSectionException;
import ua.kpi.tef.pt.lab01.exceptions.NoClothesFoundException;
import ua.kpi.tef.pt.lab01.model.Body;
import ua.kpi.tef.pt.lab01.model.Button;
import ua.kpi.tef.pt.lab01.model.LowerBodyClothes;
import ua.kpi.tef.pt.lab01.model.UpperBodyClothes;
import ua.kpi.tef.pt.lab01.model.parts.*;
import ua.kpi.tef.pt.lab01.service.LowerBodyClothesService;
import ua.kpi.tef.pt.lab01.service.UpperBodyClothesService;

import java.util.*;

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

    @Test
    public void When_ConvertAllToClothes_Expect_PrintAllData(){
        UpperBodyClothes example = UpperBodyClothesService.create(null, Type.MAN, null, null, 20., new Body(Material.COTTON, Color.BLUE), new Button(Material.METAL, Color.BLUE, 10));
        clothesController.addLowerBody(LowerBodyClothesService.create(null, Type.CHILDREN, null, null, 40., new Button(Material.PLASTIC, Color.BLUE, 30)));

        long first = clothesController.addUpperBody(example);

        assertEquals(clothesController.getAllClothesMap().get(first), example);
        assertEquals(clothesController.getAllClothesMap().get(first).toString(), example.toString());
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
        assertThrows(NoClothesFoundException.class, () -> clothesController.calculateAvgPrice());
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

    @Test
    public void When_GetAllUpperBodyPartitionedByParameter_Expect_Result() {
        UpperBodyClothes def_1 = new UpperBodyClothes(null, Type.CHILDREN, Name.COAT, null, 20);
        UpperBodyClothes def_2 = new UpperBodyClothes(null, Type.MAN, Name.COAT, null, 40);
        UpperBodyClothes def_3 = new UpperBodyClothes(null, Type.CHILDREN, Name.COAT, null, 60);
        UpperBodyClothes def_4 = new UpperBodyClothes(null, null, Name.JACKET, null, 80);
        UpperBodyClothes def_5 = new UpperBodyClothes(null, Type.CHILDREN, Name.SHIRT, null, 100);
        Map<Boolean, List<UpperBodyClothes>> expectedMap = new HashMap<>(2);
        expectedMap.put(Boolean.TRUE, Arrays.asList(def_1, def_3));
        expectedMap.put(Boolean.FALSE, Arrays.asList(def_2, def_4, def_5));

        clothesController.addUpperBody(def_1);
        clothesController.addUpperBody(def_2);
        clothesController.addUpperBody(def_3);
        clothesController.addUpperBody(def_4);
        clothesController.addUpperBody(def_5);

        assertEquals(expectedMap, clothesController.getPartitionedUpperBodyClothes(Type.CHILDREN, Name.COAT));
    }

    @Test
    public void When_GetAllUpperBodyPartitionedByParameter_Expect_EmptyLists() {
        Map<Boolean, List<UpperBodyClothes>> expectedMap = new HashMap<>(2);
        expectedMap.put(Boolean.TRUE, new ArrayList<>());
        expectedMap.put(Boolean.FALSE, new ArrayList<>());

        assertEquals(expectedMap, clothesController.getPartitionedUpperBodyClothes(Type.CHILDREN, Name.COAT));
    }

    @Test
    public void When_GetUpperBodyPartsMostUsedMaterial_Expect_OptionalWithResult() {
        UpperBodyClothes def_1 = UpperBodyClothesService.create(null, Type.MAN, null, null, 20.,
                new Body(Material.COTTON, Color.BLUE),
                new Button(Material.PLASTIC, Color.BLUE, 10));
        UpperBodyClothes def_2 = UpperBodyClothesService.create(null, Type.MAN, null, null, 40.,
                new Body(Material.SILK, Color.BLUE),
                new Button(Material.METAL, Color.BLUE, 15));
        UpperBodyClothes def_3 = UpperBodyClothesService.create(null, Type.MAN, null, null, 60.,
                new Body(Material.COTTON, Color.BLUE),
                new Button(Material.VISCOSE, Color.BLUE, 20));

        clothesController.addUpperBody(def_1);
        clothesController.addUpperBody(def_2);
        clothesController.addUpperBody(def_3);
        Optional<Material> mostCommon = clothesController.getMostUsedUpperBodyPartMaterial();

        assertTrue(mostCommon.isPresent());
        mostCommon.ifPresent(material -> assertEquals(Material.COTTON, material));
    }

    @Test
    public void When_GetUpperBodyPartsMostUsedMaterialWhenNone_Expect_OptionalEmpty() {
        UpperBodyClothes def_1 = UpperBodyClothesService.create(null, Type.MAN, null, null, 20.);
        UpperBodyClothes def_2 = UpperBodyClothesService.create(null, Type.MAN, null, null, 40.);
        UpperBodyClothes def_3 = UpperBodyClothesService.create(null, Type.MAN, null, null, 60.);

        clothesController.addUpperBody(def_1);
        clothesController.addUpperBody(def_2);
        clothesController.addUpperBody(def_3);
        Optional<Material> mostCommon = clothesController.getMostUsedUpperBodyPartMaterial();

        assertFalse(mostCommon.isPresent());
    }

}