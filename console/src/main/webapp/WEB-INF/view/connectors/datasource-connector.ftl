<#import "_connector.ftl" as ct />

<@ct.ctpl label="Datasource" connectoraction="datasourceconnector">
	<tr valign="middle" >
		<td>Nome do datasource</td>
		<td align="left"><@s.textfield name="dataSource" theme="simple" value="${connector.dataSource!}"/></td>	
	</tr>
	
</@ct.ctpl>