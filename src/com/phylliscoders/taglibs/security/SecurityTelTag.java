package com.phylliscoders.taglibs.security;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SecurityTelTag extends SimpleTagSupport {
	private String value;

	public SecurityTelTag() {

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
			
			String areaNo = "";
			String exchNo = "";
			String seqNo  = "";
			
			if (value.startsWith("02")) { // 서울
				if (!value.matches("^\\d{2}\\d{3,4}\\d{4}$")) {
					throw new SkipPageException("전화번호 형식이 다릅니다.");
				}

				areaNo = value.substring(0, 2);
				
				// 국번 길이 따라 값 할당
				if (value.length() == 10) {
					exchNo = new String(new char[4]).replace("\0", "*");;
				} else
				if (value.length() == 9) {
					exchNo = new String(new char[3]).replace("\0", "*");;
				}
				
			} else { // 그 외
				if (!value.matches("^\\d{3}\\d{3,4}\\d{4}$")) {
					throw new SkipPageException("전화번호 형식이 다릅니다.");
				}
				
				areaNo = value.substring(0, 3);
				
				// 국번 길이 따라 값 할당
				if (value.length() == 11) {
					exchNo = new String(new char[4]).replace("\0", "*");;
				} else
				if (value.length() == 10) {
					exchNo = new String(new char[3]).replace("\0", "*");;
				}
			}
			
			seqNo  = value.substring(value.length() - 4, value.length());
			
			result.append(String.join("-", areaNo, exchNo, seqNo));

			getJspContext().getOut().write(result.toString());
		} catch (Exception e) {
			e.printStackTrace();
			throw new SkipPageException("Exception in formatting " + value);
		}
	}
}
