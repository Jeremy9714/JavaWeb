package servlet;

import org.apache.commons.io.IOUtils;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * 文件下载
 *
 * @author Chenyang
 * @create 2021-03-20-11:42
 */
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1.获取要下载的文件名
        String fileName = "b.jpg";

        //2.读取要下载的文件内容
        ServletContext servletContext = getServletContext();

        //3.回传前，通过响应头告诉客户端返回的数据类型
        //获取要下载的文件的类型
        String mimeType = servletContext.getMimeType("/file/" + fileName);
        System.out.println("下载的文件类型为: " + mimeType);
        resp.setContentType(mimeType);

        //4.还要通过响应头告诉客户端，收到的数据是用于下载使用
        /*
         * Content-Disposition响应头设置收到的数据的处理方式
         * attachment表示用于下载的附件
         * filename表示下载的文件名
         * 若下载名包含中文，则需要对其进行编码
         * */
        //通过User-Agent请求头，动态切换不同的方案解决所有浏览器的附件中文名问题
        if (req.getHeader("User-Agent").contains("Firefox")) {
            //BASE64编码可以解决火狐浏览器的附件中文名问题
            resp.setHeader("Content-Disposition", "attachment; filename=?UTF-8?B?" +
                    new BASE64Encoder().encode("中文名".getBytes("UTF-8")) + "?=");
        } else {
            //URLEncoder.encode(name,charset)对字符串进行url编码(适用于IE和Chrome浏览器)
            resp.setHeader("Content-Disposition", "attachment; filename="
                    + URLEncoder.encode("中文名.jpg", "UTF-8"));
        }

        //5.把要下载的内容回传给客户端
        //以输入流的形式获取要下载的内容
        InputStream is = servletContext.getResourceAsStream("/file/" + fileName);
        //设置响应流
        ServletOutputStream os = resp.getOutputStream();
        //通过commons-io.jar包的IOUtils工具类方法将输入流内容复制到输出流
        IOUtils.copy(is, os);
    }
}
