package base64;


import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Base64编码
 *
 * @author Chenyang
 * @create 2021-03-20-12:45
 */
public class Base64Test {
    public static void main(String[] args) {
        String content = "这是一段中文";
        try {
            //创建一个Base64编码器
            BASE64Encoder base64Encoder = new BASE64Encoder();
            //执行Base64编码操作
            String encodingString = base64Encoder.encode(content.getBytes("UTF-8"));
            System.out.println("base64编码后的字符串: " + encodingString);
            System.out.println();

            //创建一个Base64解码器
            BASE64Decoder base64Decoder = new BASE64Decoder();
            //执行解码操作
            byte[] bytes = base64Decoder.decodeBuffer(encodingString);
            String decodingString = new String(bytes, "UTF-8");
            System.out.println("解码后的字符串: " + decodingString);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
