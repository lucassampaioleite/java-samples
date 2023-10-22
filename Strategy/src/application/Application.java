package application;

import strategy.AggressiveBehavior;
import strategy.DefensiveBehavior;
import strategy.RegularBehavior;
import strategy.Robot;

public class Application {

	public static void main(String[] args) {
		
		RegularBehavior regularBehavior = new RegularBehavior();
		AggressiveBehavior aggressiveBehavior = new AggressiveBehavior();
		DefensiveBehavior defensiveBehavior = new DefensiveBehavior();
		
		Robot robot = new Robot();
		robot.setBehavior(regularBehavior);
		robot.move();
		robot.setBehavior(aggressiveBehavior);
		robot.move();
		robot.move();
		robot.setBehavior(defensiveBehavior);
		robot.move();

	}

}
