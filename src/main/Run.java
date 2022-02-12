package main;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Run {

	public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {

		Scanner scanner = new Scanner(System.in);
		int level_number;
		int program_number;

		if (args.length == 2) {

			level_number = Integer.parseInt(args[0]);
			program_number = Integer.parseInt(args[1]);

		} else {

			System.out.print("Enter level number: ");
			level_number = scanner.nextInt();

			System.out.print("Enter program number: ");
			program_number = scanner.nextInt();
		}

		Class<?> lab = Class.forName("solutions.level" + level_number + ".pro" + program_number + ".Level" + level_number + "_Pro" + program_number + "");
		Method main_method = lab.getMethod("main", String[].class);
		main_method.invoke(null, (Object) null);
	}
}
