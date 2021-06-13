package xmltest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

/**
 * @author Chenyang
 * @create 2021-03-08-16:59
 */
public class Dom4jTest {

    @Test
    public void test1() throws Exception {
        //创建一个SAXReader输入流，去读取xml配置文件，生成Document文件
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("src/books.xml");
        System.out.println(document);
    }

    /**
     读取books.xml文件生成Book类
     */
    @Test
    public void test2() throws Exception {
        //读取books.xml文件
        SAXReader saxReader = new SAXReader();
        //通过文档对象获取根元素
        Document document = saxReader.read("src/books.xml");
        //通过根元素获取book标签对象
        Element rootElement = document.getRootElement();
        //遍历，并将每个book标签转换为book类
        List<Element> books = rootElement.elements("book");
        for (Element book : books) {
//            //asXML(): 用于把标签对象转换为标签字符串
//            System.out.println(book.asXML());
            //获取指定标签对象
            Element name = book.element("name");
            //通过标签对象获取标签中的文本内容
            String nameText = name.getText();
            //element(String): 用于直接获取指定标签对象的文本内容
            String authorText = book.elementText("author");
            String priceText = book.elementText("price");

            //attributeValue(String): 用于获取标签的指定属性值
            String snValue = book.attributeValue("sn");

            //创建Book类对象
            Book bookObj = new Book(snValue, nameText, Double.parseDouble(priceText), authorText);
            System.out.println(bookObj);
        }

    }
}
