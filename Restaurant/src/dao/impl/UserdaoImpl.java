package dao.impl;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;

import utils.EncrptDataUtils;
import utils.XMLUtils;
import dao.Userdao;
import domain.User;

public class UserdaoImpl implements Userdao {
	
	

	@Override
	public void add(User user){
		try {
			Document document = XMLUtils.getDocument();
			Element root = document.getRootElement();
			Element element = root.addElement("user");
			element.addAttribute("username", user.getUsername());
			element.addAttribute("password", EncrptDataUtils.encrpt(user.getPassword()));
			element.addAttribute("email", user.getEmail());
			element.addAttribute("id", user.getId());
			XMLUtils.write2XML(document);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public boolean find(String username){ // find if a user with the name already exist
		try {
			Document document = XMLUtils.getDocument();
			Element element = (Element) document.selectSingleNode("//user[@username = '"+username+"']");
			if(element==null){
				return false; // represents that no such username exist
			}else {
				return true;  // there is a user with that name already
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public User find(String username, String password){ //check login use 
		try {
			password = EncrptDataUtils.encrpt(password);
			
			Document document = XMLUtils.getDocument();
			Element element = (Element) document.selectSingleNode("//user[@username='"+username+"' and @password='"+password+"']");
			if(element==null){
				return null;   //no such user
			}
			User user = new User();
			user.setId(element.attributeValue("id"));
			user.setEmail(element.attributeValue("email"));
			user.setUsername(element.attributeValue("username"));
			user.setPassword(element.attributeValue("password"));
			return user;     // return the user's information if found
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
