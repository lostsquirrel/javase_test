package demo.concurrency.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import demo.concurrency.lift.v1.LiftOff;

public class RunWithManyThread {

	private static final Logger log = LoggerFactory.getLogger(RunWithManyThread.class);
	
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			Thread thread = new Thread(new LiftOff());
			thread.start();
		}
		log.debug("等待Lift线程执行结束");
	}
}
