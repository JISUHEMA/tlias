package dofile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class FileTest {

	public static void main(String[] args) throws IOException {
		// TODO 自動生成されたメソッド・スタブ
		File f=new File("c:\\TESUTO");
		f.mkdir();
		
		
		File f1=new File("c:\\TESUTO\\aa");
		f1.mkdir();
		
		String filePath="c:\\TESUTO\\aa\\1.txt";
		File fileBuild=new File(filePath);
		
		fileBuild.createNewFile();
		
		FileOutputStream fos =new FileOutputStream(filePath);
		
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		
		BufferedWriter bw=new BufferedWriter(osw);
		
		bw.write("aaa");
		
		bw.close();
	}

}
