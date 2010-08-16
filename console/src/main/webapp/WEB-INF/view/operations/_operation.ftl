<#import "../template-geral.ftl" as t >
<#macro ctpl label operationaction>
<@t.template>
<script language="Javascript" type="text/javascript" src="edit_area/edit_area_full.js"></script>
<h1><a href="connectors.action">Conectors</a> :: <a href="connectors!edit.action?id=${operation.connector.id}">${operation.connector.name}</a> :: ${label}</h1>
<br clear="all" />
<div class="contentArea">
<@s.actionmessage/>
<@s.actionerror/>
	<div class="content" id="contentFull">
				<b class="bt"><b></b></b>
				<div class="body">
				<strong>Editar uma operação</strong>	
				<#if operation.name?exists>
					<#assign act = "save"/>
					<#assign btLabel = "Salvar"/>
				<#else>
					<#assign act = "create"/>
					<#assign btLabel = "Criar"/>
				</#if>
				
				<@s.form action="${operationaction}!${act}.action">
		            <@s.hidden name="id" value="${operation.id}"/>
		            <@s.hidden name="operationType" value="${operation.class.simpleName}"/>
		            <@s.hidden name="connectorId" value="${operation.connector.id}"/>
					<table class="gridContent">						
							<tr valign="middle" >
								<td width="150">Nome</td>
								<td align="left"><@s.textfield name="name" theme="simple" value="${operation.name!}"/></td>	
							</tr>							
							<tr class="active" valign="middle">
								<td>Tag</td>
								<td align="left"><@s.textfield name="tag" theme="simple" value="${operation.tag!}"/></td>	
							</tr>							
							<tr valign="middle">
								<td>Pacote de Licen&ccedil;a</td>
								<td align="left"><@s.select value="operation.licenseBundle.id" name="licenseBundleId" 
								theme="simple" headerKey="" headerValue="---" theme="simple" list="licenseBundles" listKey="id" listValue="name"/></td>	
							</tr>
							<tr class="active" valign="middle">
								<td>Chave de liberação</td>
								<td align="left"><@s.textfield name="licenseKey" theme="simple" value="${operation.licenseKey!}"/></td>	
							</tr>
							<#nested>
							<tr valign="middle">								
								<td>&nbsp;</td>
								<td align="left"><input type="submit" value="${btLabel}" style="width: 150px;"/></td>
							</tr>
							
							
							
							
					</table></@s.form>			

			

	</div>
				<b class="bb"><b></b></b>
	
			</div>
</div>

</@t.template>
</#macro>
