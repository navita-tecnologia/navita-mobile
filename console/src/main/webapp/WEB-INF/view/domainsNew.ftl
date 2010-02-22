	<#import "template-geral.ftl" as t >
	<@t.template>
	
		<h1>Dom&iacute;nios</h1>
		<br clear="all" />
	    <div class="contentArea">
	<@s.actionmessage/>
	    	<div class="content" id="contentFull">
				<b class="bt"><b></b></b>
				<div class="body">
		            <strong>Dom&iacute;nio</strong>
		            <@s.form action="domains!create.action">		            
					<table class="gridContent">						
							<tr valign="middle" >
								<td width="350">Nome</td>
								<td align="center"><@s.textfield name="ldapConfig.name" theme="simple"/></td>	
							</tr>							
							<tr class="active" valign="middle">
								<td>Usuario</td>
								<td align="center"><@s.textfield name="ldapConfig.user" theme="simple"/></td>	
							</tr>
							<tr valign="middle">
								<td>Senha</td>
								<td align="center"><@s.password name="ldapConfig.password" theme="simple" value=""/></td>
							</tr>
							<tr class="active" valign="middle">
								<td>Nome Dominio</td>
								<td align="center"><@s.textfield name="ldapConfig.domainName" theme="simple"/></td>
							</tr>
							<tr valign="middle">
								<td>Resolver IP via DNS</td>
								<td align="center"><@s.select value="ldapConfig.autoIp" name="ldapConfig.autoIp" 
								theme="simple" list="# {'true':'Sim','false':'Não'}"/></td>
							</tr>
							<tr class="active" valign="middle">
								<td>IP</td>
								<td align="center"><@s.textfield name="ldapConfig.ip" theme="simple"/></td>
							</tr>
							<tr valign="middle">
								<td>URL</td>
								<td align="center"><@s.textfield name="ldapConfig.url" theme="simple"/></td>	
							</tr>
							<tr class="active" valign="middle">
								<td>Search Base</td>
								<td align="center"><@s.textfield name="ldapConfig.searchBase" theme="simple"/></td>
							</tr>
							<tr valign="middle">
								<td>Search Filter</td>
								<td align="center"><@s.textfield name="ldapConfig.searchFilter" theme="simple"/></td>	
							</tr>
							<tr class="active" valign="middle">
								<td>Group Attribute</td>
								<td align="center"><@s.textfield name="ldapConfig.groupAttribute" theme="simple"/></td>
							</tr>
							<tr valign="middle">
								
								<td>&nbsp;</td>
								<td align="center"><input type="submit" value="Criar" style="width: 150px;"/></td>
							</tr>
					</table></@s.form>
	        	</div>
				<b class="bb"><b></b></b>
	
			</div>
		</div>
		
		</@t.template>
