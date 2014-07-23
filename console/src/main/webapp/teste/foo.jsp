<%@page import="java.util.Enumeration"%>
<%
System.out.println("LocalIP : " + request.getLocalAddr());
System.out.println("LocalName : " + request.getLocalName());
System.out.println("RemoteAdress : " + request.getRemoteAddr());
System.out.println("RemoteHost : " + request.getRemoteHost());
System.out.println("RequestURI : " + request.getRequestURI());
System.out.println("RequesURL : " + request.getRequestURL());
Enumeration<String> headers = request.getHeaderNames();
while (headers.hasMoreElements()) {
String valor = headers.nextElement();
System.out.println(valor + ": " + request.getHeader(valor));
}
%>