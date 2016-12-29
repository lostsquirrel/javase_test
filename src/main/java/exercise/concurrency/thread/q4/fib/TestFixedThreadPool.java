package exercise.concurrency.thread.q4.fib;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import demo.concurrency.thread.lift.v1.LiftOff;

public class TestFixedThreadPool {
	/**
	 * @param args
	 * 添加10个任务
	 * 预期使用5个线程
	 */
	public static void main(String[] args) {
		ExecutorService exec = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 10; i++) {
			exec.execute(new LiftOff());
		}
		exec.shutdown();
	}
}