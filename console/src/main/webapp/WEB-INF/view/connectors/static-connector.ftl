<#import "../template-geral.ftl" as t >
<@t.template>
<h1>Conector estático (JSON)</h1>
<br clear="all" />
<div class="contentArea">
<@s.actionmessage/>
	<div class="content" id="contentFull">
				<b class="bt"><b></b></b>
				<div class="body">
				<strong>Editar um conector estático</strong>	
				
				
				<@s.form action="staticconnector!save.action">
		            <@s.hidden name="id" value="${connector.id}"/>
					<table class="gridContent">						
							<tr valign="middle" >
								<td width="350">Nome</td>
								<td align="left"><@s.textfield name="name" theme="simple" value="${connector.name}"/></td>	
							</tr>							
							<tr class="active" valign="middle">
								<td>Tag</td>
								<td align="left"><@s.textfield name="tag" theme="simple" value="${connector.tag}"/></td>	
							</tr>
							<tr valign="middle">
								<td>Habilitado</td>
								<td align="left"><@s.select value="${connector.enabled?string}"  name="enabled" 
								theme="simple" list="# {'true':'Sim','false':'Não'}"/></td>
							</tr>
							<tr class="active" valign="middle">
								<td>Pacote de Licen&ccedil;a</td>
								<td align="left"><@s.select value="connector.licenseBundle.id" name="licenseBundleId" 
								theme="simple" headerKey="" headerValue="---" theme="simple" list="licenseBundles" listKey="id" listValue="name"/></td>	
							</tr>
							<tr valign="middle">
								<td>Chave de liberação</td>
								<td align="left"><@s.textfield name="licenseKey" theme="simple" value="${connector.licenseKey}"/></td>	
							</tr>
							<tr valign="middle">								
								<td>&nbsp;</td>
								<td align="center"><input type="submit" value="Salvar" style="width: 150px;"/></td>
							</tr>
							
					</table></@s.form>			

			

	</div>
				<b class="bb"><b></b></b>
	
			</div>
</div>
</@t.template>