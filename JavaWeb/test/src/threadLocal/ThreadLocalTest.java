package threadLocal;

import java.util.Hashtable;
import java.util.Map;
import java.util.Random;

import static java.lang.Thread.sleep;

/**
 * @author Chenyang
 * @create 2021-03-25-11:57
 */
public class ThreadLocalTest {

    //public static Map<String, Object> data = new Hashtable<>();
    public static ThreadLocal threadLocal1 = new ThreadLocal();
    public static ThreadLocal threadLocal2 = new ThreadLocal();
    public static Random random = new Random();

    public class Task implements Runnable {

        @Override
        public void run() {
            //随机生成一个变量，并以当前线程名为key，保存到data中
            Integer i = random.nextInt(1000);
            String name = Thread.currentThread().getName();
            System.out.println("线程【" + name + "】生成的随机数为: " + i);
            //data.put(name, i);

            //ThreadLocal对象可以为当前线程关联一个数据，key是线程名，value是关联数据
            threadLocal1.set(i);
            //若关联了多个数据，则指挥官连最后一个数据，其他的会被覆盖
            threadLocal1.set(i + 1);
            //若要为当前线程关联多个数据，就需要使用多个ThreadLocal对象实例
            threadLocal2.set(i + 2);

            //该线程进入阻塞状态
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //其他程序获取线程的关联值
            new OrderTest().createOrder();

            //在线程结束前，以当前线程名，去除保存的数据并打印到控制台
            Object value1 = threadLocal1.get();
            System.out.println("在线程【" + name + "】结束前取出关联的第一个数据是: " + value1);
            Object value2 = threadLocal2.get();
            System.out.println("在线程【" + name + "】结束前取出关联的第二个数据是: " + value2);
        }
    }

    public static void main(String[] args) {
        ThreadLocalTest test = new ThreadLocalTest();
        for (int i = 0; i < 3; i++) {
            new Thread(test.new Task()).start();
        }
    }
}
