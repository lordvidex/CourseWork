package dev.druid.classwork.classwork13;

/**
 * Created by IntelliJ IDEA
 * Date: 25.03.2021
 * Time: 4:13 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class CarMaker {
    private int id;
    private String maker;
    private String fullName;
    private Country country;

    public CarMaker(int id, String maker, String fullName, Country country) {
        this.id = id;
        this.maker = maker;
        this.fullName = fullName;
        this.country = country;
    }

    public static CarMaker fromList(String[] list){
        return new CarMaker(
                Integer.parseInt(list[0]),
                list[1],
                list[2],
                list[3].equals("null") ? null : Country.parseCountryFromId(Integer.parseInt(list[3])));
    }

    public Country getCountry() {
        return country;
    }

    public int getId() {
        return id;
    }
    public String getFullName(){
        return fullName;
    }
    @Override
    public String toString() {
        return "CarMaker{" +
                "id=" + id +
                ", maker=" + maker +
                ", fullName=" + fullName +
                ", country=" + country +
                '}';
    }
}
