package utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XMLOrderUtils {

	private static String filePath;
	static{
		filePath= XMLOrderUtils.class.getClassLoader().getResource("order.xml").getPath();;
//		filePath="C:\\Users\\Administrator\\Workspaces\\MyEclipse 10\\Restaurant\\WebRoot\\WEB-INF\\classes\\order.xml";
	}
	
	public static Document getDocument() throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(filePath);
		return document;
	
	}
	
	public static void write2XML(Document document) throws IOException {
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		XMLWriter writer = new XMLWriter(         //problem is here
	              new OutputStreamWriter(new FileOutputStream(filePath), "UTF-8"),format
	          );  
		
        writer.write( document );
        writer.close();

	}
	
}
