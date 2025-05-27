package javaiostream_example;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FilterStream_example {
	
	public static void main(String[] args) throws IOException {
		
		// 필터 스트림
		// 기본형 데이터 입출력 필터 스트림
		// 파일
		DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("data.dat"));
		DataInputStream  dataInputStream  = new DataInputStream(new FileInputStream("data.dat"));
		
		int    i = 10;
		double d = 10.0;
		
		// 기본형 데이터 저장
		dataOutputStream.writeInt(i);
		dataOutputStream.writeDouble(d);
		
		dataOutputStream.flush();
		
		int    result_i = dataInputStream.readInt();
		double result_d = dataInputStream.readDouble();
		
		System.out.println("result_i = " + result_i);
		System.out.println("result_d = " + result_d);
		
		dataOutputStream.close();
		dataInputStream.close();
		
		InputStream  inputStream  = new FileInputStream("data.txt");
		OutputStream outputStream = new FileOutputStream("data.txt");
	}
}
