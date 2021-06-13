package servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 使用fileupload解析上传的数据
 * @author Chenyang
 * @create 2021-03-20-9:27
 */
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //判断上传的数据是否为多段的格式(只有多段的数据，才是文件上传的)
        if (ServletFileUpload.isMultipartContent(req)){

            //创建FileItemFactory工厂实现类
            FileItemFactory factory = new DiskFileItemFactory();
            //创建用于解析上传的数据的工具类ServletFileUpload对象
            ServletFileUpload fileUpload = new ServletFileUpload(factory);

            //解析上传的数据, 并得到每一个表单项
            try {
                List<FileItem> list = fileUpload.parseRequest(req);

                //判断每一个表单项是普通表单项，还是上传的文件
                for (FileItem fileItem : list) {
                    if (fileItem.isFormField()){
                        //普通表单项
                        //获取表单项的name属性值
                        System.out.println("表单项的name属性值: " + fileItem.getFieldName());
                        //获取表单项的值，参数为指定的字符集
                        System.out.println("表单项的value属性值: " + fileItem.getString("UTF-8"));
                    }else{
                        //上传的文件
                        System.out.println("表单项的name属性值: " + fileItem.getFieldName());
                        //获取上传的文件名
                        System.out.println("上传的文件名: " + fileItem.getName());

                        //将上传的文件写入指定的位置
                        fileItem.write(new File("d:\\desktop\\" + fileItem.getName() + "1.txt"));
                    }
                    System.out.println();
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
