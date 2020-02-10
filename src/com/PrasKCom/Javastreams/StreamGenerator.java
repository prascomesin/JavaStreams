/**
 * Different methods of generating streams from list or arrays
 */
package com.PrasKCom.Javastreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.PrasKCom.Javastreams.Model.Employee;

/**
 * @author pkanvin
 *
 */
public class StreamGenerator {
	
	public Stream GenerateStreams() {
		
		Employee[] empList1 = {
				new Employee ( "Prasad3", 1 , "Captain"),
				new Employee ( "Prasad1", 2, "Supervisor"),
				new Employee ( "Prasad2", 3 , "Lieutanant")
		};
		
		Employee[] empList2 = {
				new Employee ( "Krasad3", 4 , "Captain"),
				new Employee ( "Krasad1", 5, "Supervisor"),
				new Employee ( "Krasad2", 6 , "Lieutanant")
		};
		
		Employee[] empList3 = {
				new Employee ( "Trasad3", 7 , "Captain"),
				new Employee ( "Trasad1", 8, "Supervisor"),
				new Employee ( "Trasad2", 9 , "Lieutanant")
		};
		
		//Create a stream of employees
		Stream.of(empList1);
		
		
	  //Create a list
		List<Employee> EmpList = Arrays.asList(empList1);
		EmpList.stream();
		
		Stream<Employee[]> myStream = Stream.of(empList1,empList2,empList3);
		
		Stream.Builder<Employee> empStreamBuilder = Stream.builder();
		
		empStreamBuilder.accept(new Employee("Orasad1", 10, "Lawyer" ));
		empStreamBuilder.accept(new Employee("Orasad2", 11, "Lawyer" ));
		
		Stream<Employee> st = empStreamBuilder.build();
		
		
		
		//Create a stream from multiple lists
		System.out.println(Stream.of(empList1,empList2,empList3).count());
		
		return st;
		
		
			
		}
	
	
	
	
	
	
	
	
	

}
