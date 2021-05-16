package dev.druid.classwork.classwork24;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA
 * Date: 12.05.2021
 * Time: 4:24 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class App {
    public static void main(String[] args) throws IOException{
        Map<String,String> props = readProperties("config.dat");
        try {
            Class<DB> c = (Class<DB>) Class.forName(props.get("db"));
            DB db = c.getDeclaredConstructor().newInstance();
            db.connect();
        }catch(Exception e){
            System.out.println("Failed to find specified DB implementation");
        }
    }

    private static Map<String, String> readProperties(String filename) throws IOException {
        Map<String,String> prop = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader("src/dev/druid/classwork/classwork24/"+filename));
        String line;
        while((line = br.readLine())!=null) {
            String[] arr = line.split("=");
            prop.put(arr[0],arr[1]);
        }
        return prop;
    }
}
