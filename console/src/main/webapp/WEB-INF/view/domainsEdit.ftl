	<#import "template-geral.ftl" as t >
	<@t.template>
	<#if adAuthContainer.name?exists>
		<#assign act = "save"/>
		<#assign btLabel = "Salvar"/>
	<#else>
		<#assign act = "create"/>
		<#assign btLabel = "Inserir"/>
	</#if>
	
		<h1>Dom&iacute;nios</h1>
		<br clear="all" />
	    <div class="contentArea">
		<@s.actionmessage/><@s.actionerror/>
	    	<div class="content" id="contentFull">
				<b class="bt"><b></b></b>
				<div class="body">
		            <strong>Dom&iacute;nio</strong>
		            <@s.form action="domains!${act}.action">
		            <@s.hidden name="id" value="${adAuthContainer.id}"/>
					<table class="gridContent">						
							<tr valign="middle" >
								<td width="200">Nome</td>
								<td align="left"><@s.textfield name="name" value="${adAuthContainer.name!}" theme="simple"/></td>	
							</tr>							
							<tr class="active" valign="middle">
								<td>Usuario</td>
								<td align="left"><@s.textfield name="domainUser"  value="${adAuthContainer.domainUser!}" theme="simple"/></td>	
							</tr>
							<tr valign="middle">
								<td valign="top">Senha<br/>(Deixe em branco para não alterar)</td>
								<td align="left" valign="top"><@s.password name="domainUserPassword"  value="" theme="simple" value=""/></td>
							</tr>
							<tr class="active" valign="middle">
								<td>Nome Dominio</td>
								<td align="left"><@s.textfield name="domainName"  value="${adAuthContainer.domainName!}"theme="simple"/></td>
							</tr>
							<tr valign="middle">
								<td>Resolver IP via DNS</td>
								<td align="left"><@s.select value="${adAuthContainer.dnsResolving?string}" name="dnsResolving" 
								theme="simple" list="# {'true':'Sim','false':'Não'}"/></td>
							</tr>
							<tr class="active" valign="middle">
								<td>IP</td>
								<td align="left"><@s.textfield name="ip"  value="${adAuthContainer.ip!}" theme="simple"/></td>
							</tr>
							<tr valign="middle">
								<td>URL</td>
								<td align="left"><@s.textfield name="url"  value="${adAuthContainer.url!}" theme="simple"/></td>	
							</tr>
							<tr class="active" valign="middle">
								<td>Search Base</td>
								<td align="left"><@s.textfield name="searchBase"  value="${adAuthContainer.searchBase!}" theme="simple"/></td>
							</tr>
							<tr valign="middle">
								<td>Search Filter</td>
								<td align="left"><@s.textfield name="searchFilter"  value="${adAuthContainer.searchFilter!}" theme="simple"/></td>	
							</tr>
							<tr class="active" valign="middle">
								<td>Group Attribute</td>
								<td align="left"><@s.textfield name="groupAttribute"  value="${adAuthContainer.groupAttribute!}" theme="simple"/></td>
							</tr>
							<tr class="active">
								<td>Group Filter</td>
								<td align="left"><@s.textfield name="groupFilter"  value="${adAuthContainer.groupFilter!}" theme="simple"/></td>
							</tr>
							<tr valign="middle" valign="middle">								
								<td>&nbsp;</td>
								<td align="left"><input type="submit" value="${btLabel}" style="width: 150px;"/></td>
							</tr>
							
					</table></@s.form>
	        	</div>
				<b class="bb"><b></b></b>	
			</div>
		</div>
		<!--
		<div class="contentArea">
		
	    	<div class="content" id="contentFull">
				<b class="bt"><b></b></b>
				<div class="body">
		            <strong>Testes</strong>
		            <@s.form action="domains!test.action">
		            <@s.hidden name="ldapConfig.id"/>
					<table class="gridContent">						
							<tr valign="middle" >
								<td width="350">User</td>
								<td align="center"><@s.textfield name="testUser" theme="simple"/></td>	
							</tr>						
							
							<tr class="active" valign="middle">
								<td>Senha *</td>
								<td align="center"><@s.password name="testPasswd" theme="simple" value=""/></td>
							</tr>
							
							<tr valign="middle">
								
								<td>&nbsp;</td>
								<td align="center"><input type="submit" value="Testar" style="width: 150px;"/>
								</td>
							</tr>
							
					</table></@s.form>
	        	</div>
				<b class="bb"><b></b></b>	
			</div>
			
		</div>-->
		</@t.template>
