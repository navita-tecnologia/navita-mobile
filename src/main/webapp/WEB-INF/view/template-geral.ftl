<#macro template>
<html >
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
		<title>Navita Mobile :: Navita Tecnologia Ltda</title>
		<link rel="shortcut icon" href="images/favicon.ico" />
		<link rel="icon" href="images/favicon.ico" />

		<link type="text/css" rel="stylesheet" href="css/administrador.css" />

		<!--[if gte IE 6]><link rel="stylesheet" type="text/css" href="css/administrador_ie.css" /><![endif]-->
		
				
	</head>
	<body>
		<div id="mainHeader">
			<a href="index.action" title="Acessar o Dashboard" class="logo">&nbsp;</a>
		</div>
		
		<div id="mainMenu">
			<ul>
				<li class="sites">
					<form name="box_sites" id="box_sites">
			     		<select id="applicationSelect" name="applicationSelect" onchange="window.location=this.options[this.options.selectedIndex].value">
			     			<option value="#">Navegue...</option>
			     			<option value="applications.action">Aplicativos Blackberry</option>
			     			<option value="domains.action" >Dom&iacute;nios</option> 
			     		</select>
			     	</form>
			     </li>
	        	<li class="group" id="group1"><a href="applications.action"  title="Aplica&ccedil;&otilde;es">Aplica&ccedil;&otilde;es</a></li>
		        <li class="group" id="group1"><a href="licenses.action"  title="Licen&ccedil;as">Licen&ccedil;as</a></li>
		        <li class="group" id="group2"><a href="domains.action" title="Dom&iacute;nios">Dom&iacute;nios</a></li>
		        <li class="group" id="group3"><a href="admin.action" title="Senha Admin">Senha Admin</a></li>
		  </ul>
		</div>
		
		
		<div id="mainContent">			
			<#nested>
		</div>
	<br clear="all" />
		<div id="mainFooter">Copyright &copy; 2009 Navita. Todos os direitos reservados.</div>
	</body>
</html>
</#macro>
