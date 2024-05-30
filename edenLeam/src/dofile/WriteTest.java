package dofile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class WriteTest {

	public static void main(String[] args) throws IOException {
		
		String[] arr= {"Hello ","你好","こんにちは"};
		
		List<String> strList=new ArrayList<>();
		strList.add("Hello ");
		strList.add("你好");
		strList.add("こんにちは");
		
		System.out.println(arr);
		
		for (String str :arr) {
			System.out.println(str);
		}
		System.out.println(strList);
		
		File f=new File("c:\\TESUTO");
		f.mkdir();
		
		
		File f1=new File("c:\\TESUTO\\aa");
		f1.mkdir();
		
		String filePath="c:\\TESUTO\\aa\\1.txt";
		File fileBuild=new File(filePath);
		
		fileBuild.createNewFile();
		
		//String userContract="我勒个骚刚啊";
		
		FileOutputStream fos =new FileOutputStream(filePath);
		
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		
		BufferedWriter bw=new BufferedWriter(osw);
		
		bw.write(strList.toString()+"\n\n");
		
		for(int i=0;i<arr.length;i++) {
			bw.write(arr[i]);
		}
		
		//bw.write(userContract);
		
		//bw.write("aaa");
		
		//bw.flush();
		bw.close();
	}

}
