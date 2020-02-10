/**
 * 
 */
package com.PrasKCom.Javastreams;

import java.io.IOException;
import java.util.stream.Stream;

/**
 * @author Prasad Kanvinde
 *
 */
public class StreamsKickStart {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		
		// TODO Auto-generated method stub
		//Call Stream Generator
		StreamGenerator sg = new StreamGenerator();
		Stream st = sg.GenerateStreams();
		
		//Perform operations on Stream
		StreamOperator so = new StreamOperator();
		so.streamOperator(st);
		
		
	}

}
