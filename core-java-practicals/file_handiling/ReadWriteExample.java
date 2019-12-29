
import java.io.*;

public class ReadWriteExample {

	public static void main(String args[])

	{

		try {

			File outfile = new File(
					"G:\\\\nitin_pd_data\\\\training\\\\repository\\\\core-java-practicals\\\\file_handiling\\\\output1.txt");
			if (!outfile.exists()) {
				FileInputStream fin = new FileInputStream(
						"G:\\\\nitin_pd_data\\\\training\\\\repository\\\\core-java-practicals\\\\file_handiling\\\\input1.txt");
				FileOutputStream fout = new FileOutputStream(outfile);

				int i = 0;
				while ((i = fin.read()) != -1)
					fout.write((byte) i);

				fout.close();
			} else {
				System.out.println("File Already Exists");
			}
		} catch (Exception e) {

			System.out.println(e);

		}
	}
}
