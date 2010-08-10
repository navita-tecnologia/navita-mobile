<#import "_operation.ftl" as ct />

<@ct.ctpl label="Estática" operationaction="staticoperation">
	<tr valign="middle">
		<td>Object</td>
		<td align="left"><@s.textfield name="object" theme="simple" value="${operation.object!}"/></td>	
	</tr>
	<tr valign="middle"  class="active">
		<td>List</td>
		<td align="left"><@s.textfield name="list" theme="simple" value="${operation.list!}"/></td>	
	</tr>
	<tr valign="middle">
		<td>ResultCode</td>
		<td align="left"><@s.textfield name="resultCode" theme="simple" value="${operation.resultCode!}"/></td>	
	</tr>
	<tr valign="middle" class="active">
		<td>Message</td>
		<td align="left"><@s.textfield name="message" theme="simple" value="${operation.message!}"/></td>	
	</tr>
	<tr valign="middle">
		<td>Token</td>
		<td align="left"><@s.textfield name="token" theme="simple" value="${operation.token!}"/></td>	
	</tr>
	<tr valign="middle" class="active">
		<td>&nbsp;</td>
		<td align="left">&nbsp;</td>	
	</tr>
</@ct.ctpl>