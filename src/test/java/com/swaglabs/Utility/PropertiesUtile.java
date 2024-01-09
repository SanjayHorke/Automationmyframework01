package com.swaglabs.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtile {
	public Properties p1;
	public PropertiesUtile() {
	 p1=new Properties();

		File fs=new File("./"+"\\Config.properties");

		FileInputStream f1;
		try {
			f1 = new FileInputStream(fs);
			
			p1.load(f1);
		} catch (FileNotFoundException e) {


			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		//  Properties p1=new Properties();

		//  p1.load(f1);
	}
	public String getData(String key) {
		return p1.getProperty(key);
	}
}
