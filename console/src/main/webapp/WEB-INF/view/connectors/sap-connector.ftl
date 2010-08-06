<#import "_connector.ftl" as ct />

<@ct.ctpl label="SAP" connectoraction="sapconnector">
<tr valign="middle" class="active">
		<td>Client</td>
		<td align="left"><@s.textfield name="client" theme="simple" value="${connector.client!}"/></td>	
</tr>
<tr valign="middle" >
		<td>SYSNR</td>
		<td align="left"><@s.textfield name="sysnr" theme="simple" value="${connector.sysnr!}"/></td>	
</tr>
<tr valign="middle" class="active">
		<td>Server I.P.</td>
		<td align="left"><@s.textfield name="ip" theme="simple" value="${connector.ip!}"/></td>	
</tr>
<tr valign="middle" >
		<td>Sap Router</td>
		<td align="left"><@s.textfield name="router" theme="simple" value="${connector.router!}"/></td>	
</tr>
</@ct.ctpl>