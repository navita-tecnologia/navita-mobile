<#import "_connector.ftl" as ct />

<@ct.ctpl label="WebService (wsdl)" connectoraction="webserviceconnector">
<tr valign="middle" class="active">
		<td>WSDL</td>
		<td align="left"><@s.textfield name="wsdl" theme="simple" value="${connector.wsdl!}"/></td>	
	</tr>
	<tr valign="middle" >
		<td>&nbsp;</td>
		<td>&nbsp;</td>	
	</tr>

</@ct.ctpl>
