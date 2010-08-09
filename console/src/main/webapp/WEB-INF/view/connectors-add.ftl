	<#import "template-geral.ftl" as t >
	<@t.template>
	
		<h1>Configure um  novo conector</h1>
		<br clear="all" />
	    <div class="contentArea">
	<@s.actionmessage/>
	    	<div class="content" id="contentFull">
				<b class="bt"><b></b></b>
				<div class="body">
		            <strong>Escolha o tipo de conector</strong>
					<table class="gridContent">
						<tr>
							<th class="left" >Tipo</th>
							<th  class="left">Descrição</th>							
						</tr>						
						<tr>
							<td><a href="connectors!preCreate.action?type=StaticConnector"><img src="images/ico_add.gif" alt="Adicionar" border="0" /> Estático</a></td>
							<td >Devolve dados estáticos no formato JSON</td>							
						</tr>	
						<tr>
							<td ><a href="connectors!preCreate.action?type=DataSourceConnector"><img src="images/ico_add.gif" alt="Adicionar" border="0" /> Datasource</a></td>
							<td >Utilize um datasource configurado neste servidor de aplicação para exportar os dados a partir de queries SQL</td>							
						</tr>
						<tr>
							<td ><a href="connectors!preCreate.action?type=SapConnector"><img src="images/ico_add.gif" alt="Adicionar" border="0" /> SAP</a></td>
							<td >Exporte dados de funções RFC do SAP</td>							
						</tr>
						<tr>
							<td ><a href="connectors!preCreate.action?type=ProxyConnector"><img src="images/ico_add.gif" alt="Adicionar" border="0" /> Proxy</a></td>
							<td >Conecte fontes externas de JSON</td>							
						</tr>
						<tr>
							<td ><a href="connectors!preCreate.action?type=EjbConnector"><img src="images/ico_add.gif" alt="Adicionar" border="0" /> EJB</a></td>
							<td >Conecte um EJB Remoto ou Local</td>							
						</tr>
						<tr>
							<td ><a href="connectors!preCreate.action?type=WebServiceConnector"><img src="images/ico_add.gif" alt="Adicionar" border="0" /> Web Service</a></td>
							<td >Conecte a um web-service definido por um wsdl</td>							
						</tr>
					</table>
	        	</div>
				<b class="bb"><b></b></b>
	
			</div>
		</div>
	
		</@t.template>
