package academy.elqoo.java8.lambda;

import java.util.Collections;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Lambda {

	public static List<String> filter(List<String> strings, Predicate<String> condition) {
		return strings.stream().filter(condition).collect(Collectors.toList());
	}

	public static void processWithinTransaction(TransactionLambda lambda/* Runnable runnable */) {
		Transaction transaction = new Transaction();
		Thread t = new Thread(() -> {
			transaction.start();
			lambda.run();
			transaction.stop();
		});
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String create(Supplier<String> s) {
		return s.get();
	}

	public static Integer getStringLength(String s,Function<String,Integer> func /* place a function here */) {
		return func.apply(s);
	}

	public static int multiply(int a, int b,BinaryOperator<Integer> bo) {
		return bo.apply(a, b);
	}

	public static List<String> sortStrings(List<String> strings /* sorting can be done using a comparator */) {
		 Collections.sort(strings,(x,y)->x.compareTo(y));
		 return strings;
	}

}
