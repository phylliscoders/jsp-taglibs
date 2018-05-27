package com.phylliscoders.taglibs.security;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SecurityNoTag extends SimpleTagSupport {
	
	private String value;

	public SecurityNoTag() {

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
			StringBuilder result = new StringBuilder(value);
			
			for (int i = 0; i < value.length(); i++) {
				if ( isStringInteger(String.valueOf(value.charAt(i))) ) {
					result.setCharAt(i, '*');
				}
			}

			getJspContext().getOut().write(result.toString());
		} catch (Exception e) {
			e.printStackTrace();
			throw new SkipPageException("Exception in formatting " + value);
		}
	}

	public static boolean isStringInteger(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
