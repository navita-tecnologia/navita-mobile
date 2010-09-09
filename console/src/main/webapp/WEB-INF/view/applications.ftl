	<#import "template-geral.ftl" as t >
	<@t.template>
	
		<h1>Aplica&ccedil;&otilde;es</h1>
		<br clear="all" />
	    <div class="contentArea">
	<@s.actionmessage/>
	    	<div class="content" id="contentFull">
				<b class="bt"><b></b></b>
				<div class="body">
		            <strong>Aplica&ccedil;&otilde;es cadastradas</strong>
					<table class="gridContent">
						<tr>
							<th class="left" width="150px">Nome&nbsp;&nbsp;<a href="<@s.url action="applications!prepareCreate.action"/>" title="Cadastrar Aplica&ccedil;&atilde;o" >&nbsp;<img src="images/ico_add.gif" alt="Adicionar" border="0" /></a></th>
							<th width="70px" >Aç&atilde;o</th>
							<th width="70px" >Aç&atilde;o</th>
							<th width="70px" >Aç&atilde;o</th>
						</tr>
						
							<@s.iterator value="applications" status="stat">
							<tr class="active" valign="middle" <#if stat.odd>class="active"</#if>>
								<td ><a href='applications!edit.action?id=<@s.property value="id"/>' title="Editar" ><@s.property value="name"/></a></td>
								<td align="center">
									<a href="connectors.action?applicationId=${id}">Conectores [${action.getCountConnectors("${id}")}]</a>
								</td>
								<td align="center">
									<a href="pushservers.action?applicationId=${id}">Push Servers [${action.getCountPushServers("${id}")}]</a>
								</td>
								<td align="center">
									<a href="#" onclick='removeApplication("<@s.property value="name"/>","<@s.property value="id"/>")'>remover</a>
								</td>
								
							</tr>
							</@s.iterator>
					</table>
	        	</div>
				<b class="bb"><b></b></b>
	
			</div>
		</div>
		<script>
		function removeApplication(nome,id){
			if(confirm('Tem certeza que quer remover a aplicacao '+nome+'?')){
				window.location='<@s.url action="applications!delete.action"  includeParams="none"/>?id='+id	
			}
		}
		</script>
		</@t.template>
