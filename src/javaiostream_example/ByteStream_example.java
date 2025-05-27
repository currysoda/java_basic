package javaiostream_example;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.imageio.IIOException;

public class ByteStream_example {
	
	public static void main(String[] args) throws IOException {
		
		// 입출력의 기본
		InputStream  inputStream  = System.in;
		OutputStream outputStream = System.out;
		System.out.println("inputStream = " + inputStream);
		System.out.println("outputStream = " + outputStream);
		System.out.println("입력하세요 (엔터시 종료)");
		
		int bytedata;
		while ((bytedata = inputStream.read()) != -1) {
			if (bytedata == '\n') {
				break;
			}
			if (bytedata != '\n') {
				outputStream.write(bytedata);
				outputStream.write('\n');
				outputStream.flush();
			}
		}
		System.out.println("입력 종료");
		
		inputStream.close();
		outputStream.close();
	}
}
