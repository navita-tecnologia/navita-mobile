<#import "_operation.ftl" as ct />

<@ct.ctpl label="Sap Function" operationaction="sapfunctionoperation">
<tr valign="middle">
		<td>Function</td>
		<td align="left"><@s.textfield name="functionName" theme="simple" value="${operation.functionName!}"/></td>	
	</tr>
</@ct.ctpl>