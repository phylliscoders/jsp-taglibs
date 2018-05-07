package com.phylliscoders.taglibs.number;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class NumberToHangeulTag extends SimpleTagSupport {
	private String number;
	private String cc;
	
	public NumberToHangeulTag () {
		
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	@Override
	public void doTag() throws JspException, IOException {
		// 한글, 한자 담을 배열
		String[] han1;
		String[] han2;
		String[] han3;
		
		try {
			if ("Y".equals(cc)) {
				han1 = new String[]{"", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
				han2 = new String[]{"", "十", "百", "千"};
				han3 = new String[]{"", "萬", "億", "兆", "京"};
			} else {
				han1 = new String[]{"", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구"};
				han2 = new String[]{"", "십", "백", "천"};
				han3 = new String[]{"", "만", "억", "조", "경"};
			}
			
			StringBuffer result = new StringBuffer();
			int len = number.length();
			
			for (int i = len - 1; i >= 0; i--) {
				result.append(han1[Integer.parseInt(number.substring(len - i - 1, len - i))]);
				
				if (Integer.parseInt(number.substring(len-i-1, len-i)) > 0) { 
					result.append(han2[i % 4]);
				}
				if (i % 4 == 0) {
					result.append(han3[i / 4]);
				}
			}
			
			getJspContext().getOut().write(result.toString());
		} catch (Exception e) {
			e.printStackTrace();
			// stop page loading : SkipPageException
			throw new SkipPageException("Exception in formatting " + number + " with cc " + cc);
		}
	}
}
