package readAndwrite;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;




public class Stream {
	private BufferedReader br ;
	
	public Stream() {
		this.br = new BufferedReader(new 
	            InputStreamReader(System.in));
	}
	
	public void readLine() {
		/*
		 * Java 的控制台输入由 System.in 完成。
		 * 
		 * BufferedReader 对象创建后，我们便可以使用 read() 方法
		 * 从控制台读取一个字符，或者用 readLine() 方法读取一个字符串。
		 */
		
		try {
			System.out.println(br.readLine());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void continueRead() throws IOException {
		char c ;
		String res1 = "";
		
		do {
		 c = (char) br.read();//br.readLine();
		 res1 += c;
		}while(c!='q');
		System.out.println("res1: ");
		System.out.println(res1);
		br.close();
	}
	
	
	// 读文件操作
	public void readFile() throws FileNotFoundException {
		File f = new File("D:\\hello.txt");
		System.out.println("Does the file Exsit? "+f.exists());
		InputStream IS = new FileInputStream(f);
		try {
			InputStreamReader isr = 
					new InputStreamReader(new FileInputStream(f),"UTF-8");
			String content="";
			int buffer;
			br = new BufferedReader(isr);
			while((buffer=br.read())!=-1) {
				content += (char)buffer;
			}
			System.out.println(content);
			br.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void writeToFile() {
		String file = "D:\\target.txt";
		try {
			BufferedWriter bw = 
					new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file ),"UTF-8"));
			
			bw.append("十三点！");
			bw.flush();
			bw.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {
			Stream stream = new Stream();
//			stream.readLine();
//			stream.continueRead();
//			stream.readFile();
			stream.writeToFile();
	}
}
