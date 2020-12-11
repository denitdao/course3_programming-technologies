package ua.kpi.tef.pt.lab01.controller;

import ua.kpi.tef.pt.lab01.exceptions.InvalidClothesIdException;
import ua.kpi.tef.pt.lab01.exceptions.InvalidClothingSectionException;
import ua.kpi.tef.pt.lab01.exceptions.NoClothesFoundException;
import ua.kpi.tef.pt.lab01.model.Clothes;
import ua.kpi.tef.pt.lab01.model.ClothingPart;
import ua.kpi.tef.pt.lab01.model.LowerBodyClothes;
import ua.kpi.tef.pt.lab01.model.UpperBodyClothes;
import ua.kpi.tef.pt.lab01.model.parts.Material;
import ua.kpi.tef.pt.lab01.model.parts.Name;
import ua.kpi.tef.pt.lab01.model.parts.Type;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Used as a storage to {@link UpperBodyClothes} and {@link LowerBodyClothes}.
 * Operate with the stored clothes. Add, edit, show, delete them.
 */
public class ClothesController {
    private final Map<Long, UpperBodyClothes> upperBodyClothes;
    private final Map<Long, LowerBodyClothes> lowerBodyClothes;

    public ClothesController() {
        upperBodyClothes = new HashMap<>();
        lowerBodyClothes = new HashMap<>();
    }

    /**
     * Used to add created Upper body clothes object to the collection.
     *
     * @param upperBodyClothes object to add.
     * @return unique id of the recently added object.
     */
    public long addUpperBody(UpperBodyClothes upperBodyClothes) {
        this.upperBodyClothes.put(upperBodyClothes.getId(), upperBodyClothes);
        return upperBodyClothes.getId();
    }

    /**
     * Used to add created Lower body clothes object to the collection.
     *
     * @param lowerBodyClothes object to add.
     * @return unique id of the recently added object.
     */
    public long addLowerBody(LowerBodyClothes lowerBodyClothes) {
        this.lowerBodyClothes.put(lowerBodyClothes.getId(), lowerBodyClothes);
        return lowerBodyClothes.getId();
    }

    /**
     * Used to get the Upper body clothes by id.
     *
     * @param id unique id of the object.
     * @return {@link UpperBodyClothes} object.
     * @throws InvalidClothesIdException       if object doesn't exist.
     * @throws InvalidClothingSectionException if object exist in another section.
     */
    public UpperBodyClothes getUpperBody(long id) throws InvalidClothesIdException, InvalidClothingSectionException {
        if (this.upperBodyClothes.containsKey(id)) {
            return upperBodyClothes.get(id);
        } else {
            if (this.lowerBodyClothes.containsKey(id))
                throw (new InvalidClothingSectionException("Wrong clothing section. Try Lower Body."));
            throw (new InvalidClothesIdException("Wrong upper body clothes id."));
        }
    }

    /**
     * Used to get the Lower body clothes by id.
     *
     * @param id unique id of the object.
     * @return {@link LowerBodyClothes} object.
     * @throws InvalidClothesIdException       if object doesn't exist.
     * @throws InvalidClothingSectionException if object exist in another section.
     */
    public LowerBodyClothes getLowerBody(long id) throws InvalidClothesIdException, InvalidClothingSectionException {
        if (this.lowerBodyClothes.containsKey(id)) {
            return lowerBodyClothes.get(id);
        } else {
            if (this.upperBodyClothes.containsKey(id))
                throw (new InvalidClothingSectionException("Wrong clothing section. Try Upper Body."));
            throw (new InvalidClothesIdException("Wrong lower body clothes id."));
        }
    }

    /**
     * Used to print information about the Upper and Lower body clothes by id.
     *
     * @param id unique id of the object.
     * @throws InvalidClothesIdException if object doesn't exist.
     */
    public void showClothes(long id) throws InvalidClothesIdException {
        if (lowerBodyClothes.containsKey(id)) {
            System.out.println(lowerBodyClothes.get(id));
        } else if (upperBodyClothes.containsKey(id)) {
            System.out.println(upperBodyClothes.get(id));
        } else {
            throw (new InvalidClothesIdException("Wrong clothes id."));
        }
    }

    /**
     * Used to add delete Lower and Upper body clothes object from the collection.
     *
     * @param id unique id of the object.
     * @throws InvalidClothesIdException if object doesn't exist.
     */
    public void deleteClothes(long id) throws InvalidClothesIdException {
        if (lowerBodyClothes.containsKey(id)) {
            lowerBodyClothes.remove(id);
        } else if (upperBodyClothes.containsKey(id)) {
            upperBodyClothes.remove(id);
        } else {
            throw (new InvalidClothesIdException("Wrong clothes id."));
        }
    }

    /**
     * Used to get the map of merged Lower and Upper body clothes.
     */
    public Map<Long, Clothes> getAllClothesMap() {
        return Stream.of(lowerBodyClothes, upperBodyClothes)
                .flatMap(m -> m.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, m -> (Clothes) m.getValue()));
    }

    /**
     * Used to get the list of merged Lower and Upper body clothes.
     */
    public List<Clothes> getAllClothesList() {
        return Stream.of(lowerBodyClothes.values(), upperBodyClothes.values())
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    /**
     * Used to get the average price of all clothes.
     *
     * @return {@link Double#NaN} if there is no clothes.
     */
    public double calculateAvgPrice() {
        return getAllClothesList().stream()
                .mapToDouble(Clothes::getPrice)
                .average()
                .orElseThrow(NoClothesFoundException::new);
    }

    /**
     * Used to get the most expensive Upper body clothes.
     *
     * @return {@link Optional<UpperBodyClothes>} empty if no clothes.
     */
    public Optional<UpperBodyClothes> getMostExpensiveUpperBodyClothes() {
        return new ArrayList<>(upperBodyClothes.values()).stream()
                .max(Comparator.comparing(Clothes::getPrice));
    }
    /*upperBodyClothes.entrySet().stream()
                .max(Map.Entry.comparingByValue(Comparator.comparing(Clothes::getPrice)))
                .orElseThrow(NoSuchElementException::new)
                .getValue();*/

    /**
     * Used to get the most expensive Lower body clothes.
     *
     * @return {@link Optional<LowerBodyClothes>} empty if no clothes.
     */
    public Optional<LowerBodyClothes> getMostExpensiveLowerBodyClothes() {
        return new ArrayList<>(lowerBodyClothes.values())
                .stream()
                .max(Comparator.comparing(Clothes::getPrice));
    }

    /**
     * Used to calculate total price of the clothes with the {@link Name}.
     */
    public double calculateTotalPriceOf(Name name) {
        return getAllClothesList().stream()
                .filter(m -> m.getName().equals(name))
                //.map(Clothes::getPrice)
                .mapToDouble(Clothes::getPrice)
                .sum();
                //.reduce(0., Double::sum);
    }

    /**
     * Used to get partitioned UpperBodyClothes by Type and Name.
     *
     * @return {@link Map<Boolean, List<UpperBodyClothes>>} with structure of true - suitable, false - others.
     */
    public Map<Boolean, List<UpperBodyClothes>> getPartitionedUpperBodyClothes(Type type, Name name) {
        return upperBodyClothes.values().stream()
                .collect(Collectors.partitioningBy(
                        m -> (m.getType() == type) && (m.getName() == name),
                        Collectors.toList())
                );
    }

    /**
     * Used to get the most common Material used in Upper Body Clothes Parts.
     */
    public Optional<Material> getMostUsedUpperBodyPartMaterial() {
        return upperBodyClothes.values().stream()
                .flatMap(u -> u.getClothingParts().stream())
                .map(ClothingPart::getMaterial)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
    }

}
