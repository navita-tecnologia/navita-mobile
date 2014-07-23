	<#import "template-geral.ftl" as t >
	<@t.template>
	
		<h1>Dom&iacute;nios</h1>
		<br clear="all" />
	    <div class="contentArea">
	<@s.actionmessage/>
	    	<div class="content" id="contentFull">
				<b class="bt"><b></b></b>
				<div class="body">
		            <strong>Dom&iacute;nios</strong>
					<table class="gridContent">
						<tr>
							<th class="left">Nome&nbsp;&nbsp;<a href="<@s.url action="domains!createPrepare.action"/>" title="Cadastrar Dom&iacute;nio" >&nbsp;<img src="images/ico_add.gif" alt="Adicionar" border="0" /></a></th>
							<th width="20%">Domain Name</th>
							<th width="20%">Controler</th>
							<th width="70px">Ações</th>
						</tr>
						<@s.iterator value="authContainers" status="stat">
							<tr valign="middle" <#if stat.odd>class="active"</#if> >
								<td>
									<a href='domains!edit.action?id=<@s.property value="id"/>' title="Editar" ><@s.property value="name"/></a>
								</td>
								<td align="center"><@s.property value="domainName"/></td>
	
								<td align="center"><@s.property value="ip"/></td>
								<td align="center">
									<a href="#" onclick='removeDomain("<@s.property value="domainName"/>","<@s.property value="id"/>")' >remover</a>
								</td>
							</tr>
						</@s.iterator>	
							
					</table>
	        	</div>
				<b class="bb"><b></b></b>
	
			</div>
		</div>
		<script>
		function removeDomain(nome,id){
			if(confirm('Tem certeza que quer remover o dominio '+nome+'?')){
				window.location='<@s.url action="domains!remove.action"/>?serviceId='+id	
			}
		}
		</script>
		
		</@t.template>
