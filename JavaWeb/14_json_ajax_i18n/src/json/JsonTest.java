package json;

import bean.Person;
import com.google.gson.Gson;
import org.junit.Test;

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


    //Map与json的互相转换


}
