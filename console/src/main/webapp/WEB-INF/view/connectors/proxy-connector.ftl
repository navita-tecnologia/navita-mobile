<#import "_connector.ftl" as ct />

<@ct.ctpl label="Proxy" connectoraction="proxyconnector">
	<tr valign="middle" class="active">
		<td>URL</td>
		<td align="left"><@s.textfield name="url" theme="simple" value="${connector.url!}"/></td>	
	</tr>
	<tr valign="middle" >
		<td>&nbsp;</td>
		<td>&nbsp;</td>	
	</tr>

</@ct.ctpl>