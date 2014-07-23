<#import "_connector.ftl" as ct />

<@ct.ctpl label="Datasource" connectoraction="ejbconnector">
	<tr valign="middle">
		<td>Nome do EJB</td>
		<td align="left"><@s.textfield name="ejbName" theme="simple" value="${connector.ejbName!}"/></td>	
	</tr>
	
</@ct.ctpl>