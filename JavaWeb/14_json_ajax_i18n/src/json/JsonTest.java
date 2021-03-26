package json;

import bean.Person;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Chenyang
 * @create 2021-03-26-16:29
 */
public class JsonTest {

    //JavaBean与json的互相转换
    @Test
    public void test1() {
        Person person = new Person(1, "person_1");
        //创建gson对象实例
        Gson gson = new Gson();
        //toJson(Object): 此方法将javabean对象直接转换为json字符串
        String personJsonStr = gson.toJson(person);
        System.out.println(personJsonStr);

        //fromJson(String,Class): 此方法将json字符串转换回javabean对象
        //第一个参数是json字符串，第二个对象是要转换的javabean对象类型
        Person person1 = gson.fromJson(personJsonStr, Person.class);
        System.out.println(person1);
    }

    //List与json的互相转换
    @Test
    public void test2() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "person_1"));
        personList.add(new Person(2, "person_2"));
        personList.add(new Person(3, "person_3"));

        Gson gson = new Gson();
        //将List转换为json字符串
        String personListJsonStr = gson.toJson(personList);
        System.out.println(personListJsonStr);

        //将json字符串转换为List
        //需要创建一个类继承TypeToken，并设置一个泛型类型(要转换的List类型)
        //实例化该类，并通过getType()方法将返回的Type对象传入fromJson方法中
        List<Person> personlist1 = gson.fromJson(personListJsonStr, new PersonListType().getType());
        System.out.println(personlist1);
    }

    //Map与json的互相转换
    @Test
    public void test3() {
        Map<Integer, Person> personMap = new HashMap<>();
        personMap.put(1, new Person(1, "Person_1"));
        personMap.put(2, new Person(2, "Person_2"));
        personMap.put(3, new Person(3, "Person_3"));

        Gson gson = new Gson();
        //将Map转换为json字符串
        String personMapJsonStr = gson.toJson(personMap);
        System.out.println(personMapJsonStr);

        //将json字符串转换为Map
        //使用匿名类对象
        Map<Integer, Person> personMap1 = gson.fromJson(personMapJsonStr,
                new TypeToken<Map<Integer, Person>>() {}.getType());
        System.out.println(personMap1);
    }

}
