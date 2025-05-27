package javaiostream_example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class StringStream {
	
	public static void main(String[] args) throws IOException {
		
		// 문자 스트림을 이용해서 문자열 단위로 파일입출력
		BufferedWriter bw = new BufferedWriter(new FileWriter("data.txt"));
		BufferedReader br = new BufferedReader(new FileReader("data.txt"));
		
		// 표준 입출력
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw1 = new BufferedWriter(new OutputStreamWriter(System.out));
		
		bw.write("dadsfasdfasd");
		bw.flush();
		
		String str  = br.readLine();
		String str2 = br.readLine(); // 읽을 내용이 없으면 null 반환
		
		System.out.println("str = " + str); // dadsfasdfasd
		System.out.println("str2 = " + str2); // null
		
		bw.close();
		br.close();
		br1.close();
		bw1.close();
	}
}
