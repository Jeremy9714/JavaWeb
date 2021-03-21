package project.utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author Chenyang
 * @create 2021-03-21-14:45
 */
public class WebUtils {
    //将参数改为Map类型而不是HttpServletRequest类型，可以降低耦合度，使得此方法可以在三个层中使用
    public static <T> T copyParamToBean(Map value, T bean) {
        //使用BeanUtils工具类，一次性将所有请求参数注入JavaBean
        try {
            System.out.println("注入之前的对象: " + bean);
            BeanUtils.populate(bean, value);
            System.out.println("注入之后的对象: " + bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    //将字符串转换为整数
    public static int parseInt(String intStr){
        try {
            return Integer.parseInt(intStr);
        }catch(Exception e){
            e.printStackTrace();
        }
        //字符串转换失败，则返回默认值0
        return 0;
    }
}
