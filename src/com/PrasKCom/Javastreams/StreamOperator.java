/**
 * perform operations on Streams
 * Stream Operations are divided into intermediate and terminal operations
 * Stream pipeline consists of Stream source followed by zero or more intermediate operations and a terminal operation
 */
package com.PrasKCom.Javastreams;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.PrasKCom.Javastreams.Model.Employee;

/**
 * @author pkanvin
 *
 */
public class StreamOperator {
	
	public void streamOperator(Stream st) throws IOException {
		
		
		//Use for each operator
		st.forEach(e -> System.out.println(e));
		//for each is terminal operation and stream pipeline is considered consumed 
		
		
		
		//Apply for each on a list
		List<Employee> empList2 = new ArrayList<Employee> (Arrays.asList( 
				
				new Employee ( "Krasad3", 5 , "Captain"),
				new Employee ( "Krasad1", 6, "Supervisor"),
				new Employee ( "Mrasad2", 4 , "Lieutanant")
				));
		
		List<Employee> empList4 = new ArrayList<Employee> (Arrays.asList( 
				
				new Employee ( "Mrasad3", 1 , "Captain"),
				new Employee ( "Mrasad4", 2, "Supervisor"),
				new Employee ( "Mrasad5", 3 , "Lieutanant")
				));
		
		
		/*map operation
		 * map produces a new stream after applying a function to each element of the original stream
		 */
		System.out.println("*********** Usage of map  **************** " );
		List<Employee> empList3 = empList2.stream().map( e -> { Employee s = new Employee(e.getName(), e.getId(), e.getDesignation());
							s.setDesignation("Colonel");
							return s;
							
		}).collect(Collectors.toList());
		
		System.out.println("List2 ");
		empList2.forEach(e -> System.out.println(e));
		System.out.println("List3 ");
		empList3.forEach(e -> System.out.println(e));
		
		
	
		/*filter operation - Filter employees with id = 4
		 * this produces a new stream that contains elements of the original stream that pass a given test (specified by a Predicate)
		 * Collect operation : collect() performs mutable fold operations (repackaging elements to some data structures and applying 
		 * some additional logic, concatenating them, etc.) on data elements held in the Stream instance.
		 */
		System.out.println("*********** Usage of Filter **************** " );
		empList2.stream()
			.filter( e -> e.getName().startsWith("Krasad"))
			.filter(e -> e.getId() == 5)
			.forEach(e -> System.out.println(e));;
		
			
		/*
		 * findFirst() returns an Optional for the first entry in the stream; the Optional can, of course, be empty:
		 */
		System.out.println("*********** Usage of findFirst **************** " );
		Employee emp = empList2.stream()
		.filter(e -> e.getName().startsWith("Kr"))
		.findFirst()
		.orElse(null);
		
		System.out.println(emp);
		
		//toArray   Employee[] employees = empList.stream().toArray(Employee[]::new);
		//FlatMap - A stream can hold complex data structures like Stream<List<String>>. 
		//In cases like this, flatMap() helps us to flatten the data structure to simplify further operations:
		
		System.out.println("****** Usage of FlatMap to list/merge two streams after processing **************** " );
		List<Employee> collEmp = Stream.of(empList3,empList2)
			.flatMap(Collection :: stream)
			.collect(Collectors.toList());
		
		for( Employee e : collEmp) {
			System.out.println(e);
		}
		
		/*
		 * Peek - For is a terminal operation. Peek allows you to perform multiple operations on each element of the stream before 
		 * any terminal operation is applied
		 * UNLESS TERMINAL OPERATION IS APPLIED - STREAMS WONT IMPACT THE PASSED SEQUENCE OF OBJECTS
		 */
		System.out.println("************** Usage of Peek (non terminal for each ) *********************");
		empList2.stream()
			.peek(e -> e.setDesignation("Pirate"))
			.peek(System.out :: println)
			.count();
		/*
		 * Comparator class from util could either by overridden or you can pass a function which returns negative if no swapping is needed
		 * and positive if swapping is needed
		 */
		System.out.println("************** Usage of Sorted with comparator - if Ascending need output of comparator as negative *********************");
		empList2.stream()
			.sorted((e1, e2) -> e2.getId() - e1.getId())
			.forEach(System.out :: println );
		/*
		 * distinct - does not take any argument , just the received stream and returns distinct element using equals methods
		 * allMatch, anyMatch, noneMatch  - take predicate and return booleans
		 */
		//Will return true because there are two employees which meet the criteria
		System.out.println("************** Any match and all match *********************");
		System.out.println (empList2.stream().anyMatch(e -> e.getId() % 2 == 0));
		//Will return false as all dont meet the criteria
		System.out.println (empList2.stream().allMatch(e -> e.getId() % 2 == 0));
		
			
	/*
	 * Specialized operations  - Sum average  , range
	 */
		System.out.println("************** Specialized Operations *********************");
		System.out.println("Sum is " + empList2.stream().mapToInt(Employee :: getId).sum());
		
		/*
		 * Specialized operations  - joining , set (Collectors.toSet) , Collection ( Collectors.toCollection)
		 */	
		System.out.println("************** Specialized Operations - Joining *********************");
		System.out.println("Joining by name " + empList2.stream().map(Employee :: getName).collect(Collectors.joining(";")));
		
	/*
	 * Parallel Streams 
	 * empList.stream().parallel().forEach(e -> e.setDesignation("SuperMan");
	 * Care with parallel streams - Need to ensure shared state is not being accessed, output is not expected in specific order
	 */
		
	/*FileStream
	 * 
	 */
	String[] words = {
			      "hello", 
			      "refer",
			      "world",
			      "level"
			    };
			   
	try (PrintWriter pw = new PrintWriter(
			      Files.newBufferedWriter(Paths.get("newFile")))) {
			        	Stream.of(words).forEach(pw::println);
    }
	catch(IOException e) {
		System.out.println("Exception is " + e);
	}
		
		
	}

}
