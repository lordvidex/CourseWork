package dev.druid.classwork.classwork13;

import java.util.HashMap;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * Date: 25.03.2021
 * Time: 4:11 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class Country {
    private int countryId;
    private String countryName;
    private int continentId;

    private static final HashMap<Integer, Country> countries = new HashMap<>();

    public Country(int countryId, String countryName, int continentId) {
        this.countryId = countryId;
        this.countryName = countryName;
        this.continentId = continentId;
    }

    /**
     * @param countryId id of the country needed
     * @return Country with countryId
     */
    public static Country parseCountryFromId(int countryId) {
        return countries.getOrDefault(countryId, null);
    }

    /**
     * adds Country data to the countries map
     * @param readData String array containing id,name and continent id
     */
    public static void loadCountries(List<String[]> readData) {
        for (String[] s : readData) {
            int countryId = Integer.parseInt(s[0]);
            String countryName = s[1];
            int continentId = Integer.parseInt(s[2]);
            countries.put(countryId, new Country(countryId, countryName, continentId));
        }
    }

    public int getContinentId() {
        return continentId;
    }

    @Override
    public String toString() {
        return countryName;
    }
}
