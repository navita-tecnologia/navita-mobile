<% 
javax.naming.InitialContext ctx = new javax.naming.InitialContext();
out.print(ctx.lookup("com/navita/mobile/ps/psLogin"));
%>