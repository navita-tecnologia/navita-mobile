	<#import "template-geral.ftl" as t >
	<@t.template>
	
		<h1>Aplica&ccedil;&otilde;es</h1>
		<br clear="all" />
	    <div class="contentArea">
	<@s.actionmessage/>
	    	<div class="content" id="contentFull">
				<b class="bt"><b></b></b>
				<div class="body">
		            <strong>Editar Aplica&ccedil;&atilde;o</strong>
		            <@s.form action="applications!create.action"> 
					<table class="gridContent">						
							<tr class="active" valign="middle" >
								<td width="350">Nome</td>
								<td align="center"><@s.textfield name="mobileApplication.name" theme="simple"/></td>	
							</tr>
							<tr valign="middle" >
								<td width="350">Identificador</td>
								<td align="center"><@s.textfield name="mobileApplication.id" theme="simple"/></td>	
							</tr>
							<tr class="active" valign="middle">
								<td>URL</td>
								<td align="center"><@s.textfield name="mobileApplication.url" theme="simple"/></td>
							</tr>
							<tr valign="middle">
								<td>Habilitada</td>
								<td align="center"><@s.select value="mobileApplication.enabled"  name="mobileApplication.enabled" 
								theme="simple" list="# {'true':'Sim','false':'Não'}"/></td>
							</tr>
							<tr class="active" valign="middle">
								<td>Interna</td>
								<td align="center"><@s.select value="mobileApplication.internal" name="mobileApplication.internal" 
								theme="simple" list="# {'true':'Sim','false':'Não'}"/></td>	
							</tr>
							<tr valign="middle">
								<td>Usa login nativo</td>
								<td align="center"><@s.select value="mobileApplication.usingNativeLoginService" 
								name="mobileApplication.usingNativeLoginService" theme="simple" list="# {'true':'Sim','false':'Não'}"/></td>
							</tr>
							<tr class="active" valign="middle">
								<td>Servico Login Nativo</td>
								<td align="center">
								<@s.select headerKey="none" headerValue="---" name="mobileApplication.loginServiceId" theme="simple" list="ldapConfig" listKey="id" listValue="name" >
								
								</@s.select>
								
								</td>	
							</tr>
							<tr valign="middle">
								<td>Private Key *</td>
								<td align="center"><@s.textfield name="mobileApplication.privateKey" theme="simple" value="" readonly="true"/></td>
							</tr>
							
							<tr class="active" valign="middle">
								
								<td>* digite a nova chave para alterar.</td>
								<td align="center"><input type="submit" value="Incluir" style="width: 150px;"/></td>
							</tr>
					</table></@s.form>
	        	</div>
				<b class="bb"><b></b></b>
	
			</div>
		</div>
		
		</@t.template>
