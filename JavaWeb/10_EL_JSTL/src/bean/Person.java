package bean;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author Chenyang
 * @create 2021-03-19-11:15
 */
public class Person {
    private String name;
    private String[] phones;
    private List<String> cities;
    public Map<String, String> map;

    public Person() {
    }

    public Person(String name, String[] phones, List<String> cities, Map<String, String> map) {
        this.name = name;
        this.phones = phones;
        this.cities = cities;
        this.map = map;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getPhones() {
        return phones;
    }

    public void setPhones(String[] phones) {
        this.phones = phones;
    }

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", phones=" + Arrays.toString(phones) +
                ", cities=" + cities +
                ", map=" + map +
                '}';
    }
}
