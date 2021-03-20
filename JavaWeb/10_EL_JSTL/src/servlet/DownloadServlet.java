package servlet;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * 文件下载
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
        resp.setContentType(mimeType);

        //4.还要通过响应头告诉客户端，收到的数据是用于下载使用
        /*
        * Content-Disposition响应头设置收到的数据的处理方式
        * attachment表示用于下载的附件
        * filename表示下载的文件名
        * */
        resp.setHeader("Content-Disposition","attachment; filename=" + fileName);

        //5.把要下载的内容回传给客户端
        //以输入流的形式获取要下载的内容
        InputStream is = servletContext.getResourceAsStream("/file/" + fileName);
        //设置响应流
        ServletOutputStream os = resp.getOutputStream();
        //通过commons-io.jar包的IOUtils工具类方法将输入流内容复制到输出流
        IOUtils.copy(is,os);
    }
}
