package com.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="Data")
	public String[][] getAllData() throws IOException
	{
		String path = System.getProperty("user.dir")+"//src//test//java//com//testData//LoginData.xlsx";
		XLUtility xl = new XLUtility(path);
		
		int rownum= xl.getRowCount("Sheet1");
		int colcount = xl.getCellCount("Sheet1", 1);
		
		String logindata[][] = new String[rownum][colcount];
		
		for (int i =1 ; i<=rownum;i++) 
		{
			for (int j=0;j<colcount;j++) 
			{
				logindata[i-1][j] = xl.getCellData("Sheet1", i, j);
			}
		}
		return logindata;
	}
   
	@DataProvider(name ="ContainerNames")
	public String[] getContainerNames() throws IOException
	{
		String path = System.getProperty("user.dir")+"//testData//Userdata.xlsx";
		XLUtility xl = new XLUtility(path);
		int rownum= xl.getRowCount("Sheet2");
		String apidata[] = new String[rownum];
		
		for(int i = 1; i<=rownum;i++) 
		{
			apidata[i-1] = xl.getCellData("Sheet2", i, i);
		}
		return apidata;
		
	}
}
