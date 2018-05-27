package com.phylliscoders.taglibs.security;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SecurityIpTag extends SimpleTagSupport {
	
	private String value;

	public SecurityIpTag() {

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
			StringBuilder result = new StringBuilder();
			
			String validIp = "^([1-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])(\\.([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])){3}$";
			
			// IP Address Check
			if (!Pattern.matches(validIp, value)) {
				throw new SkipPageException("IP 주소 형식과 일치하지 않습니다."); 
			}
			
			String[] ipArr = value.split("\\.");
			
			ipArr[2] = "***";
			ipArr[3] = "***";
			
			result.append(String.join(".", ipArr));

			getJspContext().getOut().write(result.toString());
		} catch (Exception e) {
			e.printStackTrace();
			throw new SkipPageException("Exception in formatting " + value);
		}
	}
}
