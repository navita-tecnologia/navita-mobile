<#import "_operation.ftl" as ct />

<@ct.ctpl label="Sap Function" operationaction="sapfunctionoperation">
	<tr valign="middle">
		<td>Function</td>
		<td align="left"><@s.textfield name="functionName" theme="simple" value="${operation.functionName!}"/></td>	
	</tr>
	<tr valign="top" class="active">
		<td>Input Parameters</td>
		<td align="left">
		<table>
			<tr>
				<td>Nome</td>
				<td colspan="3">Valor</td>
				
			</tr>
			<tr>
				<td><input type="text" value="FOO"/></td>
				<td><input type="text" value="123" /></td>
				<td><img src="images/drop-yes.gif" alt="Inserir" border="0" /></td>
				<td><img src="images/close.gif" alt="Inserir" border="0" /></td>
			</tr>
			<tr>
				<td><input type="text"/></td>
				<td><input type="text"/></td>
				<td colspan="2"><img src="images/ico_add.gif" alt="Inserir" border="0" /></td>
				
			</tr>
		</table>
		</td>	
	</tr>
	<tr valign="top">
		<td>Input Tables</td>
		<td align="left">


		
		
		
		
		</td>	
	</tr>
	<tr valign="top" class="active">
		<td>Output Parameters</td>
		<td align="left">
		<table>
			<tr>
				<td>Nome</td>
				<td colspan="3">Valor</td>
				
			</tr>
			<tr>
				<td><input type="text" value="FOO"/></td>
				<td><input type="text" value="123" /></td>
				<td><img src="images/drop-yes.gif" alt="Inserir" border="0" /></td>
				<td><img src="images/close.gif" alt="Inserir" border="0" /></td>
			</tr>
			<tr>
				<td><input type="text"/></td>
				<td><input type="text"/></td>
				<td colspan="2"><img src="images/ico_add.gif" alt="Inserir" border="0" /></td>
				
			</tr>
		</table>
</td>	
	</tr>
	<tr valign="middle">
		<td>Output Tables</td>
		<td align="left">-</td>	
	</tr>
</@ct.ctpl>