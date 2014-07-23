<#import "_connector.ftl" as ct />

<@ct.ctpl label="WebService (wsdl)" connectoraction="webserviceconnector">
<tr valign="middle" >
		<td>WSDL</td>
		<td align="left"><@s.textfield name="wsdl" theme="simple" value="${connector.wsdl!}"/></td>	
	</tr>
	
</@ct.ctpl>
