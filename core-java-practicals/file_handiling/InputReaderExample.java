import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class InputReaderExample {
	
	public static void main(String[] args) {
		try {
			FileReader fileReader = new FileReader("G:\\nitin_pd_data\\training\\repository\\core-java-practicals\\file_handiling\\input1.txt");
			int i;
			while ((i=fileReader.read())!=-1) {
				
				System.out.print((char)i);
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch ( IOException e) {
			e.printStackTrace();
		}
	}
}
