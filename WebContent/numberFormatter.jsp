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

	<h2>Number Formatting Example</h2>
	
	<pc:numberFormat number="100050.574" format="#,###.00"/><br><br>
	
	<pc:numberFormat number="1938270" format="# ###.00 Won"/><br><br>
	
</body>
</html>