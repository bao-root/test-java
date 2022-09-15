package www.com.proxy;

/**
 * @author YangXu
 * @description Marry 增强行为实现类
 * @date 2022/09/12 20:44
 */
public class MarryProxy implements Marry{

    private Marry marry;
    public MarryProxy(Marry marry) {
        this.marry = marry;
    }

    @Override
    public void toMarry() {
        System.out.println("before......");
        marry.toMarry();
        System.out.println("after.......");
    }
}
