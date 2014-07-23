<#import "template-geral.ftl" as t >
<@t.template>
<h1>Pacote de Licen&ccedil;a</h1>
<br clear="all" />
<div class="contentArea">
<@s.actionmessage/>
	    	<div class="content" id="contentFull">
				<b class="bt"><b></b></b>
				<div class="body">
		            <strong>Pacotes de Licen&ccedil;as</strong>
		            <@s.form action="licenses!${acao}Bundle.action">		            
		            <@s.hidden name="id" value="${licenseBundle.id}"/>
					<table class="gridContent">						
							<tr valign="middle" >
								<td width="350">Nome</td>
								<td align="left"><@s.textfield name="name" theme="simple" value="${licenseBundle.name!}"/></td>	
							</tr>
							<tr valign="middle" >
								<td width="350">Tipo</td>
								<td align="left"><@s.select value="licenseBundleTypeId" name="licenseBundleTypeId" 
								theme="simple" list="licenseBundleTypes" listKey="id" listValue="name"/></td>	
							</tr>
							<tr valign="middle" >
								<td width="350">Período padrão em dias (-1 para Ilimitado)</td>
								<td align="left"><@s.textfield name="period" theme="simple" value="${licenseBundle.period}"/></td>	
							</tr>							
							<tr valign="middle" >
								<td width="350">Habilitado</td>
								<td align="left"><@s.select value="${licenseBundle.enabled?string}" name="enabled" 
								theme="simple" list="# {'false':'Não','true':'Sim'}" /></td>	
							</tr>
							<tr class="active" valign="middle">
								
								<td>&nbsp;</td>
								<td align="left"><input type="submit" value="Salvar" style="width: 150px;"/></td>
							</tr>
							
							
					</table></@s.form>
	        	</div>
				<b class="bb"><b></b></b>
	
			</div>
		</div>
		
		
		</@t.template>
