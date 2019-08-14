package www.exercises.test8_14;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestProxy {

    public static void main(String[] args) {

        ISubject subject = (ISubject) new ProxySubject().bind(new RealSubject());
        subject.eat();

    }
}


// 回顾代理模式（动态代理）
interface ISubject {
    void eat();
}
class RealSubject implements ISubject {

    @Override
    public void eat() {
        System.out.println("吃饭");
    }
}
class ProxySubject implements InvocationHandler {
    private Object target;

    public Object bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(this.target.getClass().getClassLoader(),
                this.target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object obj;
        before();
        obj = method.invoke(target,args);
        after();
        return obj;
    }

    private void before() {
        System.out.println("买饭！！！");
    }

    private void after() {
        System.out.println("刷碗！！！");
    }
}
