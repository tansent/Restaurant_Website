package dao.impl;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;

import utils.XMLOrderUtils;
import utils.XMLUtils;
import dao.Orderdao;
import domain.Order;

public class OrderdaoImpl implements Orderdao {

	@Override
	public void add(Order order){
		
		try {
			Document document = XMLOrderUtils.getDocument();
			Element root = document.getRootElement();
			
			Element element = root.addElement("order");
			element.addAttribute("id", order.getId());
			element.addAttribute("hostname", order.getHostname());
			element.addAttribute("telephone", order.getTelephone());
			element.addAttribute("time", order.getTime());
			element.addAttribute("totalPeople", order.getTotalPeople());
			element.addAttribute("note", order.getNote());
			
			XMLOrderUtils.write2XML(document);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	@Override
	public Order find(String hostname){ // find if a user with the name already exist
		try {
			Document document = XMLOrderUtils.getDocument();
			Element element = (Element) document.selectSingleNode("//order[@hostname = '"+hostname+"']");
			if(element==null){
				return null; // no order been made with that name
			}else {
				Order order = new Order();
				order.setHostname(element.attributeValue("hostname"));
				order.setTelephone(element.attributeValue("telephone"));
				order.setTime(element.attributeValue("time"));
				order.setTotalPeople(element.attributeValue("totalPeople"));
				order.setNote(element.attributeValue("note"));
				return order;
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public void delete(String hostname){
		try {
			Document document = XMLOrderUtils.getDocument();
			Element root = document.getRootElement();
			
			Element element = (Element) document.selectSingleNode("//order[@hostname = '"+hostname+"']");
			root.remove(element);
			
			XMLOrderUtils.write2XML(document);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
