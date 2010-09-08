	<#import "template-geral.ftl" as t >
	<@t.template>
	
		<h1>Aplica&ccedil;&otilde;es</h1>
		<br clear="all" />
	    <div class="contentArea">
	<@s.actionmessage/>
	    	<div class="content" id="contentFull">
				<b class="bt"><b></b></b>
				<div class="body">		            
		            <#if app.name?exists>
						<#assign act = "save"/>
						<#assign btLabel = "Salvar"/>
					<#else>
						<#assign act = "create"/>
						<#assign btLabel = "Criar"/>
					</#if>
					<strong>${btLabel} Aplica&ccedil;&atilde;o</strong>
		            <@s.form action="applications!${act}.action">		            
		            <@s.hidden name="id" value="${id}"/>
					<table class="gridContent">						
							<tr valign="middle" >
								<td width="350">Nome</td>
								<td align="left"><@s.textfield name="name" value="${app.name!}" theme="simple"/></td>	
							</tr>							
							<tr valign="middle">
								<td>Habilitada</td>
								<td align="left"><@s.select value="${app.enabled?string}"  name="enabled" 
								theme="simple" list="# {'true':'Sim','false':'Não'}"/></td>
							</tr>							
							<tr class="active" valign="middle">
								<td>Pacote de Licen&ccedil;a</td>
								<td align="left"><@s.select value="app.licenseBundle.id" name="licenseBundleId" 
								theme="simple" headerKey="" headerValue="---" theme="simple" list="licenseBundles" listKey="id" listValue="name"/></td>	
							</tr>
							<tr class="active" valign="middle">
								<td>Chave de liberação</td>
								<td align="left"><@s.textfield name="licenseKey" theme="simple" value="${app.licenseKey!}"/></td>	
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
