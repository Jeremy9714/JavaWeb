package servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Chenyang
 * @create 2021-06-09-16:31
 */
public class UploadBetaServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletInputStream inputStream = req.getInputStream();
        byte[] buffer = new byte[10240000];
        int read = inputStream.read(buffer);
        System.out.println(new String(buffer, 0, read));
    }
}
