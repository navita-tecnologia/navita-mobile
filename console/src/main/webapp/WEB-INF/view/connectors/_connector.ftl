<#import "../template-geral.ftl" as t >
<#macro ctpl label connectoraction>
<@t.template>
<h1>Conector ${label} da aplicação 
<#if connector.application?exists>
	<a href='applications!edit.action?id=${connector.application.id}' title="Editar" >${connector.application.name}</a>
<#else>
	<a href='applications!edit.action?id=${app.id}' title="Editar" >${app.name}</a>
</#if> </h1>
<br clear="all" />
<div class="contentArea">
<@s.actionmessage/>
<@s.actionerror/>
	<div class="content" id="contentFull">
				<b class="bt"><b></b></b>
				<div class="body">
				<strong>Editar um conector</strong>	
				<#if connector.name?exists>
					<#assign act = "save"/>
					<#assign btLabel = "Salvar"/>
				<#else>
					<#assign act = "create"/>
					<#assign btLabel = "Criar"/>
				</#if>
				
				<@s.form action="${connectoraction}!${act}.action">
		            <@s.hidden name="id" value="${connector.id}"/>
		            <#if connector.application?exists>
		            	<@s.hidden name="applicationId" value="${connector.application.id}"/>
		            <#else>
		            	<@s.hidden name="applicationId" value="${applicationId}"/>
		        	</#if>    
		            
		            <@s.hidden name="type" value="${connector.class.simpleName}"/>
					<table class="gridContent">						
							<tr valign="middle" >
								<td width="150">Nome</td>
								<td align="left"><@s.textfield name="name" theme="simple" value="${connector.name!}"/></td>	
							</tr>							
							<tr class="active" valign="middle">
								<td>Tag</td>
								<td align="left"><@s.textfield name="tag" theme="simple" value="${connector.tag!}"/></td>	
							</tr>
							<tr valign="middle">
								<td>Habilitado</td>
								<td align="left"><@s.select value="${connector.enabled?string}"  name="enabled" 
								theme="simple" list="# {'true':'Sim','false':'Não'}"/></td>
							</tr>
							<tr class="active" valign="middle">
								<td>Autentica&ccedil;ao</td>
								<td align="left"><@s.select value="connector.authContainer.id" name="authContainerId" 
								theme="simple" headerKey="" headerValue="---" theme="simple" list="authContainers" listKey="id" listValue="name"/></td>	
							</tr>
							<tr  valign="middle">
								<td>Pacote de Licen&ccedil;a</td>
								<td align="left"><@s.select value="connector.licenseBundle.id" name="licenseBundleId" 
								theme="simple" headerKey="" headerValue="---" theme="simple" list="licenseBundles" listKey="id" listValue="name"/></td>	
							</tr>
							<tr class="active" valign="middle">
								<td>Chave de liberação</td>
								<td align="left"><@s.textfield name="licenseKey" theme="simple" value="${connector.licenseKey!}"/></td>	
							</tr>
							<#nested>
							<tr class="active" valign="middle">								
								<td>&nbsp;</td>
								<td align="left"><input type="submit" value="${btLabel}" style="width: 150px;"/></td>
							</tr>
							
							<#if act == "save" && connector.operationType?exists>
							<tr valign="middle">
								<td valign="top">Operações <a href="operations!prepareCreate.action?connectorId=${connector.id}&operationType=${connector.operationType.simpleName}"><img src="images/ico_add.gif" alt="Inserir Operação" border="0" /></a></td>
								<td align="left">
								<table border="0">
								<@s.iterator value="connector.operations" status="stat" id="oper">								
									<tr <#if stat.odd>class="active"</#if>>
										<td><a href='operations!edit.action?id=${oper.id}'>${oper.name}</a></td>
										<td>${oper.tag!}</td>	
										<td><a target="_blank"  href="processor.action?retType=json&connectorTag=${connector.tag!}&operationTag=${oper.tag!}&pin=2100000a&device=8520&carrier=Vivo&email=dummie@machine.foo&brand=RIM"><img src="images/drop-yes.gif" alt="Testar Operação" border="0" /></a></td>									
										<td><a href="#" onclick='removeOperation("${oper.name}","${oper.id}")'><img src="images/close.gif" alt="Remover Operação" border="0" /></a></td>
									</tr>
								</@s.iterator>
								
								</table>
								
								
								</td>	
							</tr>
							</#if>
							<#if  ! connector.operationType?exists && connector.name?exists>
							<tr valign="middle">								
								<td>&nbsp;</td>
								<td align="left"><input style="width: 150px;" type="button" value="Testar" onclick="testOperation()"/>
									&nbsp; <input type="text" value="" style="width: 150px;" name="operationTagTest" id="operationTagTest"/></td>
							</tr>
							</#if>
					</table></@s.form>			

			<script>
			function removeOperation(nome,id){
				if(confirm('Tem certeza que quer remover a operação '+nome+'?')){
					window.location='<@s.url action="connectors!removeOperation.action" includeParams="none"/>?operationId='+id+'&id=${connector.id}'	
				}
			}
			
			function testOperation(){
				var oper = document.getElementById('operationTagTest').value;
				if(oper == null || oper == ''){
					alert('Digite uma operação a ser testada');
					document.getElementById('operationTagTest').focus();
					return;
				}
				
				var url = 'processor.action?retType=json&connectorTag=${connector.tag!}&operationTag=' + oper + 
				'&pin=2100000a&device=8520&carrier=Vivo&email=dummie@machine.foo&brand=RIM';
				
				window.open(url);
				
			}
			
		</script>

	</div>
				<b class="bb"><b></b></b>
	
			</div>
</div>
</@t.template>
</#macro>
