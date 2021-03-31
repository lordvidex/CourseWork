package dev.druid.classwork.classwork13;

/**
 * Created by IntelliJ IDEA
 * Date: 27.03.2021
 * Time: 10:26 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class Car {
    private int carId;
    private Integer horsePower;
    private int year;
    private String carModel;
    private CarMaker carMaker;

    public Car(int carId, Integer horsePower, int year) {
        this.carId = carId;
        this.horsePower = horsePower;
        this.year = year;
    }

    public static Car fromList(String[] dataArr) {
        return new Car(
                Integer.parseInt(dataArr[0]),
                dataArr[4].equals("null") ? null : Integer.parseInt(dataArr[4]),
                Integer.parseInt(dataArr[7]));
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public int getCarId() {
        return carId;
    }

    public Integer getHorsePower() {
        return horsePower;
    }

    public int getYear() {
        return year;
    }

    public CarMaker getCarMaker(){
        return carMaker;
    }

    public void setCarMaker(CarMaker carMaker) {
        this.carMaker = carMaker;
    }

    public String getCarModel() {
        return carModel;
    }
}
