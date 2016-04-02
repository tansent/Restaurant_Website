package utils;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XMLUtils {

	private static String filePath;
	static{
		filePath = XMLUtils.class.getClassLoader().getResource("user.xml").getPath();
		//filePath="C:\\Users\\Administrator\\Workspaces\\MyEclipse 10\\Restaurant\\WebRoot\\WEB-INF\\classes\\user.xml";
	}
	
	public static Document getDocument() throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(filePath);
		return document;
	
	}

	public static void write2XML(Document document) throws IOException {
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		XMLWriter writer = new XMLWriter(         //在XMLWriter下面指定编码
	              new OutputStreamWriter(new FileOutputStream(filePath), "UTF-8"),format
	          );  
		
        writer.write( document );
        writer.close();

	}
}
