package com.phylliscoders.taglibs.security;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SecuritySsnTag extends SimpleTagSupport {
	private String value;
	
	public SecuritySsnTag () {
		
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		try {
			String ssnFront = value.substring(0, 6);
			String ssnBack = value.substring(6);
			
			ssnBack = ssnBack.substring(0, 1).concat("******");
			
			StringBuffer result = new StringBuffer();
			
			result.append(ssnFront);
			result.append("-");
			result.append(ssnBack);
			
			getJspContext().getOut().write(result.toString());
		} catch (Exception e) {
			e.printStackTrace();
			throw new SkipPageException("Exception in formatting " + value);
		}
	}
}
