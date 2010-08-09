<#import "_connector.ftl" as ct />

<@ct.ctpl label="Datasource" connectoraction="ejbconnector">
	<tr valign="middle" class="active">
		<td>Nome do EJB</td>
		<td align="left"><@s.textfield name="ejbName" theme="simple" value="${connector.ejbName!}"/></td>	
	</tr>
	<tr valign="middle" >
		<td>&nbsp;</td>
		<td>&nbsp;</td>	
	</tr>
</@ct.ctpl>