<#import "_connector.ftl" as ct />

<@ct.ctpl label="SAP" connectoraction="sapconnector">
<tr valign="middle" >
		<td>Client</td>
		<td align="left"><@s.textfield name="client" theme="simple" value="${connector.client!}"/></td>	
</tr>
<tr valign="middle" class="active">
		<td>SYSNR</td>
		<td align="left"><@s.textfield name="sysnr" theme="simple" value="${connector.sysnr!}"/></td>	
</tr>
<tr valign="middle" >
		<td>Server I.P.</td>
		<td align="left"><@s.textfield name="asHost" theme="simple" value="${connector.asHost!}"/></td>	
</tr>
<tr valign="middle" class="active">
		<td>Sap Router</td>
		<td align="left"><@s.textfield name="router" theme="simple" value="${connector.router!}"/></td>	
</tr>
<tr valign="middle" >
		<td>Language</td>
		<td align="left"><@s.textfield name="lang" theme="simple" value="${connector.lang!}"/></td>	
</tr>

</@ct.ctpl>