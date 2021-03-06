package demo.concurrency.thread.sync.block.change.lock;

import demo.concurrency.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 修改lock 值会引发锁变化，导致其它线程进入
 * TODO 预测不可变(immutable)类型都有类似问题，待验证
 * 如果锁生效： 一个线程结束后第二个线各才会开始
 */
public class ChangeStringLock {
    private static final Logger log = LoggerFactory.getLogger(ChangeStringLock.class);
    private String lock = "lock";

    private void method() {
        synchronized (lock) {
            log.info("当前线程 : " + Thread.currentThread().getName() + "开始");
            lock = "change lock";
            Utils.doWork(Utils.TIMEOUT_2S);
            log.info("当前线程 : " + Thread.currentThread().getName() + "结束");
        }

    }

    public static void main(String[] args) {

        final ChangeStringLock changeLock = new ChangeStringLock();
        Thread t1 = new Thread(changeLock::method);
        Thread t2 = new Thread(changeLock::method);
        t1.start();
        Utils.doWork(Utils.TIMEOUT_100MS);
        t2.start();


    }
}
