
package exercise.concurrency.q14.timer;

public class TimerFactoryExercise {
	
	/**
	 * 在定时时间到了以后，执行指定任务
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TimerFactory.createTimer(new MyTimerTask());
		for (int i = 0; i < 500; i++) {
			TimerFactory.createTimer(new MyTimerTask() ,500L);
		}
	}
}
