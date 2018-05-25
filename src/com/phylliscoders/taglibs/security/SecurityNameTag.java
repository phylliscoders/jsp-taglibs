package com.phylliscoders.taglibs.security;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SecurityNameTag extends SimpleTagSupport {
	private String value;
	
	public SecurityNameTag() {

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
			StringBuffer result = new StringBuffer();
			
			result.append(value.replaceAll(String.valueOf(value.charAt(1)), "*"));			

			getJspContext().getOut().write(result.toString());
		} catch (Exception e) {
			e.printStackTrace();
			throw new SkipPageException("Exception in formatting " + value);
		}
	}
}
