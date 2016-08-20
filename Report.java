package pageobjects;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class Report {
	private  static   List<String>  report = new ArrayList<String>();

	@SuppressWarnings("rawtypes")
	public final void  setreport(String content){
		this.report=report;
		report.add(content);
		
	}
	//getmethod name - used for fetching the value from a method at run time.
	//setmethod name - used for setting the value of a method at run time.
	public final static List getreport(){
		return report;
	}
	
	public static void result(List<String> list) throws IOException{
		//declared as string as while iterating the list was getting identified as a object instead of list.
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
			
				for(String listelement : list){
					bw.write(listelement);
					bw.newLine();
				}
				
			
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
