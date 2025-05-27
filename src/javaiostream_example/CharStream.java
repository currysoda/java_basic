package javaiostream_example;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class CharStream {
	
	public static void main(String[] args) throws IOException {
		
		// 문자 단위로 입출력 스트림
		Writer writer = new FileWriter("data.txt");
		Reader reader = new FileReader("data.txt");
		
		writer.write('s');
		writer.flush();
		int i  = reader.read();
		int i2 = reader.read(); // 읽을 내용이 더 없으면 -1 반환한다.
		
		System.out.println("i = " + (char) i); // s
		// 읽을 내용이 더 없으면 -1 반환한다.
		System.out.println("i2 = " + i2); // -1
		
		writer.close();
		reader.close();
	}
}
