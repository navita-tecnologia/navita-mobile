	<#import "template-geral.ftl" as t >
	<@t.template>
		
		<h1>Servidor de Push da aplicação <a href='applications!edit.action?id=${application.id}' title="Editar" >${application.name}</a></h1>
		<br clear="all" />
	    <div class="contentArea">
	<@s.actionmessage/>
	    	<div class="content" id="contentFull">
				<b class="bt"><b></b></b>
				<div class="body">		            
		            <#if pushServer.name?exists>
						<#assign act = "save"/>
						<#assign btLabel = "Salvar"/>
					<#else>
						<#assign act = "create"/>
						<#assign btLabel = "Criar"/>
					</#if>
					<strong>${btLabel} Servidor de Push</strong>
		            <@s.form action="pushservers!${act}.action">		            
		            <@s.hidden name="id" value="${id}"/>
		            <#if pushServer.application?exists>
		            <@s.hidden name="applicationId" value="${pushServer.application.id}"/>
		            <#else>
		            	<@s.hidden name="applicationId" value="${applicationId}"/>
		            </#if>
					<table class="gridContent">						
							<tr valign="middle" class="active">
								<td width="350">Nome</td>
								<td align="left"><@s.textfield name="name" value="${pushServer.name!}" theme="simple"/></td>	
							</tr>							
							<tr valign="middle">
								<td>URL</td>
								<td align="left"><@s.textfield value="${pushServer.url!}"  name="url" 
								theme="simple" /></td>
							</tr>							
							<tr valign="middle" class="active">
								<td>Port</td>
								<td align="left"><@s.textfield value="${pushServer.port!}"  name="port" 
								theme="simple" /></td>
							</tr>	
							<tr valign="middle">
								<td>&nbsp;</td>
								<td align="left">&nbsp;</td>
							</tr>							
							<tr valign="middle"  class="active">								
								<td>&nbsp;</td>
								<td align="left"><input type="submit" value="${btLabel}" style="width: 150px;"/></td>
							</tr>
							
							
					</table></@s.form>
	        	</div>
				<b class="bb"><b></b></b>
	
			</div>
		</div>
		<script>
		<!--
		
		-->
		</script>
		
				
		</@t.template>
