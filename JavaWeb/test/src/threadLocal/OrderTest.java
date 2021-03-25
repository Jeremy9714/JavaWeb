package threadLocal;

/**
 * @author Chenyang
 * @create 2021-03-25-13:47
 */
public class OrderTest {

    public void createOrder() {
        String name = Thread.currentThread().getName();
        //System.out.println("OrderTest程序获取当前线程【" + name + "】的关联值为: " + ThreadLocalTest.data.get(name));
        System.out.println("OrderTest程序获取当前线程【" + name + "】的第一个关联值为: " + ThreadLocalTest.threadLocal1.get());
        System.out.println("OrderTest程序获取当前线程【" + name + "】的第二个关联值为: " + ThreadLocalTest.threadLocal2.get());
    }
}
