package javaiostream_example;

import java.nio.file.Paths;
import java.nio.file.Path;


public class NewIO {
	
	public static void main(String[] args) {
		
		// Path 는 경로를 나타내는 인터페이스고 Paths 클래스로 구현한다.
		// "" 빈 문자열은 현재 디렉토리를 상대 경로로 표시한다.
		Path path  = Paths.get("").toAbsolutePath();
		Path path1 = path.toAbsolutePath(); // 절대 경로 반환
		Path path2 = path.getParent(); // 부모 디렉토리 반환
		Path path3 = path.getRoot(); // 루트 디렉토리 반환
		Path path4 = path.getFileName(); // 파일 이름 반환
		
		System.out.println("path = " + path);
		System.out.println("path1 = " + path1);
		System.out.println("path2 = " + path2);
		System.out.println("path3 = " + path3);
		System.out.println("path4 = " + path4);
		
		
	}
}
