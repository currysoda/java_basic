package javaiostream_example;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferedStream_example {
	
	public static void main(String[] args) throws IOException {
		
		// input output 에 buffer를 붙인 stream
		BufferedInputStream  br = new BufferedInputStream(new FileInputStream("data.dat"));
		BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream("data.dat"));
		
		// write 메소드와 read 메소드는 int 형을 매개변수로 받지만 실제로는 byte type 으로 처리된다.
		bw.write(Byte.MAX_VALUE);
		bw.write(Byte.MIN_VALUE);
		bw.write(300);
		
		// 버퍼를 비우도록 명령한다. == 버퍼의 내용을 반영하도록 명령한다.
		bw.flush();
		
		int b1 = br.read();
		int b2 = br.read();
		int b3 = br.read();
		
		System.out.println("b1 = " + b1); // 127
		System.out.println("b2 = " + b2); // 128
		System.out.println("b3 = " + b3); // 44
		
		System.out.println("b1 = " + (byte) b1); // 127
		System.out.println("b2 = " + (byte) b2); // -128
		System.out.println("b3 = " + (byte) b3); // 44
		
		br.close();
		bw.close();
	}
}
