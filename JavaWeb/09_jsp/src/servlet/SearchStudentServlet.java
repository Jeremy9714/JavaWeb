package servlet;

import bean.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Chenyang
 * @create 2021-03-18-22:30
 */
public class SearchStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> list = new ArrayList<>();
        for (int i =0;i<10;i++){
            int t = i+1;
            list.add(new Student(t, "name_" + t, 18+t, "phone" + t));
        }
        req.setAttribute("list",list);
        req.getRequestDispatcher("/test/showStudent.jsp").forward(req,resp);
    }
}
