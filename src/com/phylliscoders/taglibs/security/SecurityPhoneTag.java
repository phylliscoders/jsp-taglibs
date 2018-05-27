package com.phylliscoders.taglibs.security;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SecurityPhoneTag extends SimpleTagSupport {
	private String value;

	public SecurityPhoneTag() {

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
			
			value = value.replaceAll("-", "");
			
			if (value.length() != 11) {
				throw new SkipPageException("휴대전화 번호와 형식이 다릅니다.");
			}
			
			String areaNo = value.substring(0, 3);
			String exchNo = "****";
			String seqNo  = value.substring(7);
			
			result.append(String.join("-", areaNo, exchNo, seqNo));

			getJspContext().getOut().write(result.toString());
		} catch (Exception e) {
			e.printStackTrace();
			throw new SkipPageException("Exception in formatting " + value);
		}
	}
}
