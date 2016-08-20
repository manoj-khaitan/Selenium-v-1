package selenium;
import utilities.excelreader;
import java.lang.reflect.*;
import java.util.ArrayList;
import pageobjects.Report;
public class callingclass extends Report{
	
	//static Report thisreport = new Report();

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// this will be used as driver to run the show!!
		String spath = "C://Users//HP-AC//Desktop//keywordsheet.xlsx";
		try {
			excelreader.setexcelfile(spath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int itotaltestcases = excelreader.getrownumber("Test Cases")-1;
		for(int itestcases=1;itestcases <=itotaltestcases;itestcases++){
			String ineedtoexecute = excelreader.getCellData(itestcases, 2, "Test Cases");
			if(ineedtoexecute.equals("yes")){
				String idescription = excelreader.getCellData(itestcases, 1, "Test Cases");
				int rownumber = excelreader.getrownumber("Test Steps")-1;
				for(int irow =1;irow<=rownumber-1;irow++){
					if(idescription==excelreader.getCellData(irow,1, "Test Steps")){
					try {
						 String keyword = excelreader.getCellData(irow, 2,"Test Steps");
						 String path = excelreader.getCellData(irow, 4,"Test Steps");
						 String methodparam = excelreader.getCellData(irow, 3,"Test Steps");
						 String[] arr_param = methodparam.split(",");
						 Execute_Action(path,keyword,arr_param);

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}
					else{
						System.out.println("ghar jao");
					}
					
				}
				result(getreport());
				//thisreport.result(thisreport.getreport());
			}
		}
	
		
		
		
		//Testcomponents compone = new Testcomponents();
		//compone.first.driverstart();
		//compone.navigation("HOTELS");
		//compone.navigation("FLIGHTS");
		//compone.select_triptype();
		//compone.destination("mumbai");
		//compone.first.closebrowser();
	}

	private static void Execute_Action(String classpath, String methodname,String[] parameter) {
		// TODO Auto-generated method stub
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		try {
			Class classloaded = classLoader.loadClass(classpath);
			Object classinstance = classloaded.newInstance();
			
			Method[] method = classloaded.getMethods();
			for(Method m: method){
				if(m.getName().equals(methodname)){
					int paramlength = m.getParameterCount();
					if(paramlength==0){
						m.invoke(classinstance, null);
						break;
					}
					else{
						m.invoke(classinstance, parameter);
						break;
					}
				}
				
			}
			//method.invoke(classloaded,new Object[]{});
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SecurityException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
