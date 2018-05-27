<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="https://phylliscoders.github.io/jsp/tlds/pc" prefix="pc"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jsp-taglibs Examples</title>
</head>
<body>

	<h2>Security Formatting Example</h2>
	
	<pc:secSsn value="9001011009807" />
	
	<br /><br />
	
	<pc:secName value="홍길동이야" />
	
	<br /><br />
	
	<pc:secPhone value="01012345678" />
	
	<br /><br />
	
	<pc:secTel value="02-1111-2222" /><br />
	<pc:secTel value="02-111-2222" /><br />
	<pc:secTel value="031-1111-2222" /><br />
	<pc:secTel value="031-111-2222" />
	
	<br /><br />
	
	<pc:secNo value="서대문구 거북골로 33" />

	<br /><br />
	
	<pc:secIp value="192.168.0.1" />
	
</body>
</html>