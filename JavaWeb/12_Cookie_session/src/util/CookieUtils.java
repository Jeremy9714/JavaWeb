package util;

import javax.servlet.http.Cookie;

/**
 * @author Chenyang
 * @create 2021-03-23-13:42
 */
public class CookieUtils {
    //获取指定key的Cookie对象
    public static Cookie findCookie(String name, Cookie[] cookies){
        if (name==null||cookies==null||cookies.length==0){
            return null;
        }
        for (Cookie cookie : cookies) {
            if (name.equals(cookie.getName())){
                return cookie;
            }
        }
        return null;
    }
}
