package pageobjects;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class Report {
	
	public static void result(String content) throws IOException{
		BufferedWriter bw = null;
		FileWriter fw = null;
		try{
			
			File file = new File("C://Users//HP-AC//Desktop//result.txt");
			if(!file.exists()){
				file.createNewFile();
			}
			//fw = new FileWriter(file.getName(),true);
			fw = new FileWriter(file.getAbsoluteFile(),true);
			bw = new BufferedWriter(fw);
			
			
			bw.newLine();
			bw.write(content);
			//bw.flush();
			//bw.close();
		}catch(IOException e){
			e.printStackTrace();
		}finally {
			bw.flush();
			bw.close();
		}
		
		//return content;
	}

}
