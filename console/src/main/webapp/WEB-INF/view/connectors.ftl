	<#import "template-geral.ftl" as t >
	<@t.template>
	
		<h1>Conectores da aplicação <a href='applications!edit.action?id=${app.id}' title="Editar" >${app.name!}</a></h1>
		<br clear="all" />
	    <div class="contentArea">
	<@s.actionmessage/>
	    	<div class="content" id="contentFull">
				<b class="bt"><b></b></b>
				<div class="body">
		            <strong>Conectores configurados</strong>
					<table class="gridContent">
						<tr>
							<th class="left" width="150px">Nome&nbsp;&nbsp;<a href="<@s.url action="connectors!prepareCreate.action"/>" title="Cadastrar Conector" >&nbsp;<img src="images/ico_add.gif" alt="Adicionar" border="0" /></a></th>
							<th width="100px" class="left">Tipo</th>
							<th width="100px">Tag</th>
							<th width="100px">Habilitado</th>
							<th width="70px" >Aç&atilde;o</th>
							<th width="70px" >Aç&atilde;o</th>
						</tr>						
							<@s.iterator value="allConnectors" status="stat" id="conn">
							<tr valign="middle" <#if stat.odd>class="active"</#if>>
								<td>								
								<a href='connectors!edit.action?id=<@s.property value="id"/>' title="Editar" ><@s.property value="name"/></a></td>
								<td align="left" ><@s.property value="class.simpleName"/></td>
								<td align="center" ><@s.property value="tag"/></td>
								<td align="center" ><#if enabled>Sim<#else>Não</#if></td>
								<td align="center">
									<a href="#" onclick='removeConnector("<@s.property value="name"/>","<@s.property value="id"/>","<@s.property value="applicationId"/>")'>remover</a>
								</td>
								<td align="center">-</td>
							</tr>							
							</@s.iterator>
					</table>
	        	</div>
				<b class="bb"><b></b></b>
	
			</div>
		</div>
		<script>
		function removeConnector(nome,id,appId){
			if(confirm('Tem certeza que quer remover o conector '+nome+'?')){
				window.location='<@s.url action="connectors!remove.action" includeParams="none"/>?id='+id+'&applicationId='+appId	
			}
		}
		</script>
		</@t.template>
