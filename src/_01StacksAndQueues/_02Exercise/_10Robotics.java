package _01StacksAndQueues._02Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class _10Robotics {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		//1. Докато има елементи в опашката с продукти взимай първия продукт на опашката и първия робот

		//Add to robots queue
		String[] robotsArr = scanner.nextLine().split(";");

		ArrayDeque<String> robotsQueue = new ArrayDeque<>();
		Arrays.stream(robotsArr).forEach(e -> robotsQueue.offer(e));

		//Get time in seconds from a string hh:mm:ss
		int[] timeArr = Arrays.stream(scanner.nextLine().split(":")).mapToInt(e -> Integer.parseInt(e)).toArray();

		int hours = timeArr[0];
		int minutes = timeArr[1];
		int seconds = timeArr[2];

		int timeInSec = hours * 3600 + minutes * 60 + seconds;

		//Add to products queue
		ArrayDeque<String> productsQueue = new ArrayDeque<>();

		String command;
		while(!"End".equals(command = scanner.nextLine())) {
			String product = command;
			productsQueue.offer(product);
		}

		int lastProcessing = 0;

		//Update products queue and robots queue
		while(!productsQueue.isEmpty()) {
			//Get current robot on queue
			String currentRobot = "";
			boolean isOneLeft = false;

			if(robotsQueue.size() > 1) {   //If there are more than one robot in queue
				currentRobot = robotsQueue.poll();   //use that robot and remove from queue
			} else {
				currentRobot = robotsQueue.peek();   //otherwise just take last without removing
				isOneLeft = true;
			}

			timeInSec++;
			String robotName = currentRobot.split("-")[0];

			if(!isOneLeft) {
				System.out.printf("%s - %s [%s]%n", robotName, productsQueue.poll(), getTime(timeInSec));
			} else {
				lastProcessing++;

				if(lastProcessing > 1) {
					int processTime = Integer.parseInt(currentRobot.split("-")[1]);

					for (int i = 1; i < processTime; i++) {
						productsQueue.offer(Objects.requireNonNull(productsQueue.poll()));
					}

					timeInSec += (processTime - 1);
				}

				System.out.printf("%s - %s [%s]%n", robotName, productsQueue.poll(), getTime(timeInSec));
			}
		}
	}

	private static String getTime(int timeInSec) {
		int hoursNew = timeInSec / 3600;
		int minutesNew = timeInSec % 3600 / 60;
		int secondsNew = timeInSec % 3600 % 60;

		return String.format("%02d:%02d:%02d", hoursNew, minutesNew, secondsNew);
	}
}
