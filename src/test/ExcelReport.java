package test;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.common.excelreport.ExcelReportGenerator;

public class ExcelReport {

	public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
		
		
	ExcelReportGenerator.generateExcelReport("ExcelReport.xslx", "/home/ashwini1065gmai/eclipse-workspace/TestNG_Example/");
		
	}
	
}
