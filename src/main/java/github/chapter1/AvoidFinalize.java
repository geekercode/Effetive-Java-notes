package github.chapter1;

public class AvoidFinalize {
}

/**
 * 看到方法里面进行调用了 close 方法，这是为了当对象持有者忘记调用前面段落中建议的显式终结方法
 * ：close()的情况下，使用finalize 方法充当“安全网”这是终结方法是用途之一。
 */
class MyObject {
    private boolean isClosed = false;
    //终止方法
    public void close(){
        //资源释放操作...
        isClosed = true;
    }

    //安全网
    protected void finalize() throws Throwable {
        try {
            close();
        } finally {
            super.finalize();
        }
    }
}