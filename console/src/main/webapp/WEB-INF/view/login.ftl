<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
		<title>Navita Mobile</title>

<link type="text/css" rel="stylesheet" href='css/administrador.css' />
<!--[if IE 6]><link rel="stylesheet" type="text/css" href="css/administrador_ie.css" /><![endif]-->
</head>
<body>
	<div id="loginArea">
			<div class="header"><span>Navita Mobile - Administrador</span></div>
			<div class="box">
				<div class="top"></div>
				<div class="content">
					<!-- JAAS -->
					<form method="post" action="j_spring_security_check" name="loginForm" id="loginForm">
						<label for="usuario">Usuário</label>
						<input type="text" class="usuario" id="usuario" name="j_username"/>
						<label for="senha">Senha</label>
						<input type="password" class="senha" id="senha" name="j_password"/>
						<a class="submit" onclick="document.loginForm.submit();" href="#"> </a>
						<br clear="all"/>
						<a title="Esqueci minha senha" class="esqueci" href="xxx">Esqueci minha senha</a>
						<input type="image" style="border: medium none ; background: transparent none repeat scroll 0% 0%; -moz-background-clip: border; -moz-background-origin: padding; -moz-background-inline-policy: continuous; width: 1px; height: 1px;" src="images/blank.gif"/>
						<br/>
						<#if SPRING_SECURITY_LAST_EXCEPTION?exists >
						${SPRING_SECURITY_LAST_EXCEPTION.message}
						</#if>
					</form>
				</div>
				<div class="sidebar">
					<p>Bem-vindo ao <strong>Navita Mobile</strong>. Mobilize seus sistemas corporativos e seus processos para seus BlackBerrys com rapidez e segurança.</p>
					<p><strong>Experimente!</strong></p>
				</div>
				<div class="footer"> </div>
			</div>
			<div class="footer">
				Copyright © 2008 Navita. Todos os direitos reservados.<br/>
				<a title="Política de privacidade" href="#">Política de privacidade</a>
				<span>-</span>
				<a title="Termos de uso" href="#">Termos de uso</a>
					<span>-</span>
					Versão: 1.0.0.0
			</div>
		</div>		
</body>
</html>		