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
		            <@s.form action="applications!save.action">		            
		            <@s.hidden name="id" value="${mobileApplication.id}"/>
					<table class="gridContent">						
							<tr valign="middle" >
								<td width="350">Nome</td>
								<td align="left"><@s.textfield name="mobileApplication.name" theme="simple"/></td>	
							</tr>
							<tr valign="middle" >
								<td width="350">Identificador</td>
								<td align="left"><@s.textfield name="mobileApplication.id" readonly="true" theme="simple"/></td>	
							</tr>
							<tr class="active" valign="middle">
								<td>URL</td>
								<td align="left"><@s.textfield name="mobileApplication.url" theme="simple"/></td>
							</tr>
							<tr valign="middle">
								<td>Habilitada</td>
								<td align="left"><@s.select value="mobileApplication.enabled"  name="mobileApplication.enabled" 
								theme="simple" list="# {'true':'Sim','false':'Não'}"/></td>
							</tr>
							<tr valign="middle" class="active">
								<td>Usa login nativo</td>
								<td align="left"><@s.select value="mobileApplication.usingNativeLoginService" 
								name="mobileApplication.usingNativeLoginService" theme="simple" list="# {'true':'Sim','false':'Não'}"/></td>
							</tr>
							<tr valign="middle">
								<td>Servico Login Nativo</td>
								<td align="left">
								<@s.select name="mobileApplication.loginServiceId" headerKey="" headerValue="---" theme="simple" list="ldapConfig" listKey="id" listValue="name"/>
								
								</td>	
							</tr>
							<tr class="active" valign="middle">
								<td>Pacote de Licen&ccedil;a</td>
								<td align="left"><@s.select value="mobileApplication.licenseBundleId" name="mobileApplication.licenseBundleId" 
								theme="simple" headerKey="" headerValue="---" theme="simple" list="licenseBundles" listKey="id" listValue="name"/></td>	
							</tr>
							<tr valign="middle">
								<td>Chave ativa&ccedil;&atilde;o licen&ccedil;a</td>
								<td align="left"><@s.textfield name="mobileApplication.licenseActivationKey" theme="simple"/></td>
							</tr>							
							
							<tr valign="middle" class="active">
								<td>Url Token Login nativo</td>
								<td align="left"><@s.textfield name="mobileApplication.tokenGeneratorUrl" theme="simple"/></td>
							</tr>
							<tr valign="middle">
								<td>&nbsp;</td>
								<td align="left">&nbsp;</td>
							</tr>
							
							<tr valign="middle" class="active">
								<td>Execu&ccedil;&otilde;es</td>
								<td align="left">								
									<table>
										<tr>
											<td>Config</td>
											<td>&nbsp;</td>
										</tr>	
										<@s.iterator value="mobileApplication.executors" >							
										<tr>
											<td valign="top">
											<table border="0">
											<tr><td>Nome:</td><td><a target="_blank" href="gateway.action?app=${mobileApplication.id}&operation=${name}"><@s.property value="name"/></a></td></tr>
											<tr><td>Classe:</td><td><@s.textfield  id="sel_${name}" theme="simple" name="className" /></td></tr>
											<tr><td valign="top">Config:</td><td><textarea theme="simple"  rows="3" cols="80" name='cfg_<@s.property value="name"/>' id='cfg_<@s.property value="name"/>'><@s.property value="configuration"/></textarea></td></tr>										
											</table>
											</td>
											<td align="center">											
											<a href="javascript:void(0)" onclick="updateExtension('<@s.property value="name"/>')">Salvar</a>
											<br/>
											<a href="javascript:void(0)" onclick="confirmDeleteExtension('<@s.property value="name"/>')">Excluir</a>
											</td>
										</tr>
										</@s.iterator>
										<tr>
											<td valign="top">
											<table border="0">
											<tr><td>Nome:</td><td><input type="text" name="extName" id="extName" /></td></tr>
											<tr><td>Classe:</td><td><@s.textfield name="extClassName" id="extClassName" theme="simple" /></td></tr>
											<tr><td valign="top">Config:</td><td><textarea theme="simple"  rows="10" cols="80" name="extConfig" id="extConfig"></textarea></td></tr>
											</table>
											</td>
											<td valign="top"><a href="javascript:void(0)" onclick="createExtension()">Incluir</a></td>
										</tr>
									</table>
								</td>	
							</tr>
							<tr valign="middle">
								<td>&nbsp;</td>
								<td align="left">&nbsp;</td>
							</tr>
							
							<tr valign="middle"  class="active">								
								<td>&nbsp;</td>
								<td align="left"><input type="submit" value="Salvar" style="width: 150px;"/></td>
							</tr>
							
							
					</table></@s.form>
	        	</div>
				<b class="bb"><b></b></b>
	
			</div>
		</div>
		<script>
		<!--
		function createExtension(){
			var f = document.getElementById('extForm');
			f['executor.name'].value = document.getElementById('extName').value;
			var selClass =  document.getElementById('extClassName');
			f['executor.className'].value = selClass.value;
			f['executor.configuration'].value = document.getElementById('extConfig').value;
			f.submit();		
		}
		
		function confirmDeleteExtension(name){
			if(confirm('Tem certeza?')){
			var f = document.getElementById('extFormDelete');
				f['executor.name'].value = name;
				f.submit();	
			}		
		}
		
		function updateExtension(name){
			var f = document.getElementById('saveForm');
			f['executor.name'].value = name;
			var selClass =  document.getElementById('sel_'+name);
			f['executor.className'].value = selClass.value;
			f['executor.configuration'].value = document.getElementById('cfg_'+name).value;
			f.submit();
			
		}
		
		function togle(id){			
			var elem = document.getElementById(id);			
			elem.style.display = ('none' == elem.style.display ? '':'none');  
		}
		-->
		</script>
		
		<@s.form action="applications!createExtension.action" id="extForm">
			<@s.hidden name="executor.name"/>
			<@s.hidden name="executor.className" />
			<@s.hidden name="executor.configuration" />
			<@s.hidden name="id" value="${mobileApplication.id}"/>
		</@s.form>
		<@s.form action="applications!saveExtension.action" id="saveForm">
			<@s.hidden name="executor.name"/>
			<@s.hidden name="executor.className" />
			<@s.hidden name="executor.configuration" />
			<@s.hidden name="id" value="${mobileApplication.id}"/>
		</@s.form>
		<@s.form action="applications!deleteExtension.action" id="extFormDelete">
			<@s.hidden name="executor.name"/>		
			<@s.hidden name="id" value="${mobileApplication.id}"/>
		</@s.form>
		
		</@t.template>
