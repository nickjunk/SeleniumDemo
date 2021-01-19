package Basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class streams {
	//Count number of names staring with 'A'
	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Alexander");
		names.add("Alecs");
		names.add("Nicholas");
		names.add("Pamela");
		names.add("Hugo");
		names.add("Adam");
		
		ArrayList<String> names2 = new ArrayList<String>();
		names2.add("Donald");
		names2.add("Joseph");
		names2.add("Kamala");
		names2.add("Mother");
		names2.add("Bernie");
		names2.add("Michael");
		
		normal(names);
		streamFilter(names);
		streamFilterPrinting(names);
		streamMaps(names, names2);
		streamCollect(names2);
	}
		
	//Normal way
	public static void normal(ArrayList<String> names) {
		int count = 0;
		for(String name : names) {
			if(name.startsWith("A")) {
				count++;
			}
		}
		System.out.println(count);
		System.out.println("\n");
	}
	
	
	//With Filter and Lambda func
	//In lambda func, left side specifies all required parameters
	//right side is lambda body which specifies actions
	//Converts arraylist to stream via .stream(), then to a new stream with .filter(), 
	//and finally a terminal operation on that new stream with .count()
	public static void streamFilter(ArrayList<String> names) {
		Long count = names.stream().filter(name->name.startsWith("A")).count();
		//If lambda intermediate operation requires more than a single line, use brackets.
		//Returning false will now allow .count() to work
		Long count2 = names.stream().filter(name->{
			name.startsWith("A");
			return false;
		}).count();
		
		System.out.println(count);
		System.out.println("\n");
		System.out.println(count2);
		System.out.println("\n");
	}
	
	//Filter names for names greater than 4, and then print them using forEach()
	//Same thing, but limiting it at 1
	//In .filter(), the lambda expression must always return a boolean value
	public static void streamFilterPrinting(ArrayList<String> names) {
		names.stream().filter(name->name.length()>4).forEach(name->System.out.println(name));
		System.out.println("\n");
		names.stream().filter(name->name.length()>4).limit(1).forEach(name->System.out.println(name));
		System.out.println("\n");
	}
	
	//print names using maps to change them slightly
	//In .map(), the lambda expression will change each element in however way you want
	public static void streamMaps(ArrayList<String> names, ArrayList<String> names2) {
		//print names ending with s with Uppercase
		names.stream().filter(name->name.endsWith("s")).map(name->name.toUpperCase())
		.forEach(name->System.out.println(name));
		System.out.println("\n");
		//print names which have first letter as A, uppercase, and then sorted
		names.stream().filter(name->name.startsWith("A")).map(name->name.toUpperCase())
		.sorted().forEach(name->System.out.println(name));
		System.out.println("\n");
		//Concatenate two streams, sort, and print
		Stream<String> allNames = Stream.concat(names.stream(), names2.stream());
		//allNames.sorted().forEach(name->System.out.println(name));
		//Cannot reuse allNames without commenting out previous operation, Java will not allow to reuse streams.
		//Use concatenated stream, check if something is true with anyMatch(), returns boolean
		boolean flag = allNames.anyMatch(name->name.equalsIgnoreCase("Donald"));
		System.out.println(flag);
		System.out.println("\n");
	}
	
	public static void streamCollect(ArrayList<String> names) {
		//Take a list, convert to stream for operations, and return back to list
		List<String> namesList = names.stream().map(name->name.toUpperCase()).sorted().collect(Collectors.toList());
		//Printing the first one, however you can use .limit(1) and then forEach() to print from stream as well
		System.out.println(namesList.get(0));
		System.out.println("\n");
		//Print unique number using .distinct() (Removes duplicates)
		List<Integer> numbers = Arrays.asList(3,2,4,6,7,5,2,3);
		numbers.stream().distinct().sorted().forEach(number->System.out.println(number));
	}
}
