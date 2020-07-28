package com.khanzee.testpackage;
import org.testng.annotations.DataProvider;
import java.text.SimpleDateFormat;
import java.util.Calendar;

//This class provides data to be consumed by other classes.
public class TestDataProvider {
	
	//This method provides data to test "Location Search" method of Meta Weather API
	@DataProvider (name = "locationSearch")
	public Object[] locationSearch() {
		
		return new Object[] {"Nottingham","London"};
	}
	
	//This method provides data to test "Location" method of Meta Weather API
	@DataProvider (name = "location")
	public Object[] location() {
		
		return new Object[] {"30720","44418"};
	}
	
	//This method provides data to test "Location Day" method of Meta Weather API
	@DataProvider (name = "locationDay")
	public Object[][] locationDay() {
		
		//get tomorrow's date in yyyy/mm/dd format
	    Calendar calendar = Calendar.getInstance();    
	    calendar.add(Calendar.DAY_OF_YEAR, 1);
	    SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd");
	    String tomorrow = dateformat.format(calendar.getTime());
	    System.out.println(tomorrow);
		
		return new Object[][] {
			{"30720",tomorrow},
			{"44418",tomorrow}
		};
	}
}
