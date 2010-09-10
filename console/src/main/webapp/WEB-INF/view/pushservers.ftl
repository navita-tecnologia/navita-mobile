	<#import "template-geral.ftl" as t >
	<@t.template>
	
		<h1>Servidores de Push da aplicação <a href='applications!edit.action?id=${application.id}' title="Editar" >${application.name}</a></h1>
		<br clear="all" />
	    <div class="contentArea">
	<@s.actionmessage/>
	    	<div class="content" id="contentFull">
				<b class="bt"><b></b></b>
				<div class="body">
		            <strong>Servidores cadastrados</strong>
					<table class="gridContent">
						<tr>
							<th class="left" width="150px">Nome&nbsp;&nbsp;<a href="<@s.url action="pushservers!prepareCreate.action"/>" title="Cadastrar Servidor" >&nbsp;<img src="images/ico_add.gif" alt="Adicionar" border="0" /></a></th>
							<th class="left">Url</th>
							<th  >Port</th>
							<th >Tag (applicationId)</th>
							<th  >Aç&atilde;o</th>
						</tr>
						
							<@s.iterator value="pushServers" status="stat">
							<tr class="active" valign="middle" <#if stat.odd>class="active"</#if>>
								<td ><a href='pushservers!edit.action?applicationId=${application.id}&id=<@s.property value="id"/>' title="Editar" ><@s.property value="name"/></a></td>
								<td align="left">
									<a href="${url}">${url}</a>
								</td>
								<td align="center">
									${port}
								</td>
								<td align="center">
									${tag}
								</td>
								<td align="center">
									<a href="#" onclick='removeServer("<@s.property value="name"/>","<@s.property value="id"/>","${application.id}")'>remover</a>
								</td>
								
							</tr>
							</@s.iterator>
					</table>
	        	</div>
				<b class="bb"><b></b></b>
	
			</div>
		</div>
		<script>
		function removeServer(nome,id,appId){
			if(confirm('Tem certeza que quer remover o servidor '+nome+'?')){
				window.location='<@s.url action="pushservers!delete.action"  includeParams="none"/>?id='+id	+'&applicationId='+appId;
			}
		}
		</script>
		</@t.template>
