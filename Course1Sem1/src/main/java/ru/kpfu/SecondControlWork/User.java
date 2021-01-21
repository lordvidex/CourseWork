package ru.kpfu.SecondControlWork;

/**
 * Created by IntelliJ IDEA
 * Date: 26.12.2020
 * Time: 17:37
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 *
 * ***********************************
 * 2. Создать класс юзер, с полями из CSV файла. Все геттеры/сеттеры + toString. Пол через Enum.
 * 3. В первой строке файла содержатся заголовки таблицы.
 * Создать метод, позволяющий получить номер столбца, по его названию, например, getColByName("name").
 * 4. Создать boolean метод, возвращающий true если пара название/номер столбца и значение соответствует введенным.
 * Используя его, создать метод в тестовом классе, который получит строки по названию опрделенной должности/стране,
 * и сохранит его в другой файл csv.
 */

//........2 & 5.........
public class User implements Measurable{
    //............ 3............
    public static String[] HEADER;

    private final String[] dataArr;
    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private Gender gender;
    private String money;
    private String country;
    private String job;

    public User(String[] data){
        this.dataArr = data;
        this.id = Integer.parseInt(data[0]);
        this.first_name = data[1];
        this.last_name = data[2];
        this.email = data[3];
        this.gender = data[4].equals("Male")?Gender.MALE:Gender.FEMALE;
        this.money = data[5];
        this.country = data[6];
        this.job = data[7];
    }
    public User(int id, String first_name, String last_name, String email, Gender gender, String money, String country, String job) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.gender = gender;
        this.money = money;
        this.country = country;
        this.job = job;
        this.dataArr = new String[]{String.valueOf(this.id),this.first_name,this.last_name,this.email,this.gender==Gender.MALE?"Male":"Female",this.money,this.country,this.job};
    }

    //...........3........
    public int getColByName(String headerName){
        int notFound = -1;
        for(int i = 0;i<HEADER.length;i++){
            if(HEADER[i].equals(headerName)){
                return i;
            }
        }
        return notFound;
    }

    //.............4.............
    public boolean isNeedleInHaystack(String needle,String haystack){
        int col = getColByName(haystack);
        if(col==-1){
            return false;
        }
        return dataArr[col].equals(needle);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String[] getDataArr() {
        return dataArr;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", money='" + money + '\'' +
                ", country='" + country + '\'' +
                ", job='" + job + '\'' +
                '}';
    }

    @Override
    public double getMeasure() {
        return Double.parseDouble(getMoney().substring(1));
    }

    @Override
    public boolean isGreaterThan(Measurable other) {
        return this.getMeasure() > other.getMeasure();
    }
}
