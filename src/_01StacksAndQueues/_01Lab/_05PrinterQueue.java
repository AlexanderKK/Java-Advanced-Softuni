package _01StacksAndQueues._01Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _05PrinterQueue {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		//1 Въвеждаме файлове за принтиране и ги добавяме в опашка
		//2 Ако въведем cancel премахваме първия файл в опашката и го извеждаме | ако няма файлове -> съотв съобщение
		//3 Ако въведем документ -> добавяме го в опашката
		//4 Принтираме файловете при получаване на команда print
		ArrayDeque<String> printerQueue = new ArrayDeque<>();

		String command;
		while(!(command = scanner.nextLine()).equals("print")) {
			if(command.equals("cancel")) {
				if(printerQueue.isEmpty()) {
					System.out.println("Printer is on standby");
				} else {
					System.out.printf("Canceled %s%n", printerQueue.poll());
				}
			} else {
				String document = command;
				printerQueue.offer(document);
			}
		}

		for (String doc : printerQueue) {
			System.out.println(doc);
		}
	}
}
