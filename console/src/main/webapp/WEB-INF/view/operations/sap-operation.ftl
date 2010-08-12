<#import "_operation.ftl" as ct />

<@ct.ctpl label="Sap Function" operationaction="sapfunctionoperation">
	<tr valign="middle">
		<td>Function</td>
		<td align="left"><@s.textfield name="functionName" theme="simple" value="${operation.functionName!}"/></td>	
	</tr>
	<#if operation.name?exists>
	<tr valign="top" class="active">
		<td>Input Parameters</td>
		<td align="left">
		<table>
			<tr>
				<td>Nome</td>
				<td colspan="3">Valor</td>
				
			</tr>
			<#list operation.inputParameters as inparam>
			<tr>
				<td><input type="text" value="${inparam.name}"/></td>
				<td><input type="text" value="${inparam.value}" /></td>				
				<td><a href="javascript:void(0)" onclick="removeParameter('${inparam.id}','${inparam.name}','input')"><img src="images/close.gif" alt="Excluir" border="0" /></a></td>
			</tr>
			</#list>
			<tr>
				<td><input type="text" name="inputParameterName" id="inputParameterName"/></td>
				<td><input type="text" name="inputParameterValue" id="inputParameterValue"/></td>
				<td><a href="javascript:void(0)" onclick="addParameter('input')" ><img src="images/ico_add.gif" alt="Inserir" border="0" /></a></td>
				
			</tr>
		</table>
		</td>	
	</tr>
	<tr valign="top">
		<td>Input Tables</td>
		<td align="left">			
			<table>	
				<tr>
					<td colspan"2">Table name</td>					
					<td><a href="">&nbsp;</a></td>
				</tr>		
			<#list operation.inputTables as intable>		
				<tr>
					<td>TB_XXX1</td>
					<td><a href=""><img src="images/edit.gif" alt="Alterar" border="0" /></a></td>
					<td><a href=""><img src="images/close.gif" alt="Excluir" border="0" /></a></td>
				</tr>
			</#list>			
				<tr>
					<td colspan"2"><input type="text" name="inputTableName" id="inputTableName"/></td>					
					<td><a href=""><img src="images/ico_add.gif" alt="inserir" border="0" /></a></td>
				</tr>					
			</table>
				
		</td>	
	</tr>
	<tr valign="top" class="active">
		<td>Output Parameters</td>
		<td align="left">
		<table>
			<tr>
				<td>Nome</td>
				<td colspan="2">Valor</td>
				
			</tr>
			<#list operation.outputParameters as outparam>
			<tr>
				<td><input type="text" value="${outparam.name}"/></td>
				<td><input type="text" value="${outparam.value}" /></td>
				
				<td><a href="javascript:void(0)" onclick="removeParameter('${outparam.id}','${outparam.name}','output')"><img src="images/close.gif" alt="Inserir" border="0" /></a></td>
			</tr>
			</#list>
			<tr>
				<td><input type="text" name="outputParameterName" id="outputParameterName"/></td>
				<td><input type="text" name="outputParameterValue" id="outputParameterValue"/></td>
				<td><a href="javascript:void(0)" onclick="addParameter('output')" ><img src="images/ico_add.gif" alt="Inserir" border="0" /></a></td>
				
			</tr>
		</table>
	</td>	
	</tr>
	<tr valign="middle">
		<td>Output Tables</td>
		<td align="left">
					
			<table>		
			<tr>
					<td colspan"2">Table name</td>					
					<td><a href="">&nbsp;</a></td>
				</tr>
			<#list operation.outputTables as outtable>		
				<tr>
					<td>TB_XXX1</td>
					<td><a href=""><img src="images/edit.gif" alt="Alterar" border="0" /></a></td>
					<td><a href=""><img src="images/close.gif" alt="Excluir" border="0" /></a></td>
				</tr>
			</#list>	
			<tr>
					<td colspan"2"><input type="text" name="outputTableName" id="outputTableName"/></td>					
					<td><a href=""><img src="images/ico_add.gif" alt="inserir" border="0" /></a></td>
				</tr>			
			</table>
				
		</td>	
	</tr>
	</#if>
	<tr valign="middle" class="active">
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	
	
	<script>
	function addParameter(type){		
		var parameterName = document.getElementById(type  + 'ParameterName').value;
		var parameterValue = document.getElementById(type  + 'ParameterValue').value;
		if(parameterName == null || parameterName == ''){
			alert('Digite um nome para o parâmetro');
			document.getElementById(type  + 'ParameterName').focus();
			return;
		}
		if(parameterValue == null || parameterValue == ''){
			alert('Digite um valor para o parâmetro');
			document.getElementById(type  + 'ParameterValue').focus();
			return;
		}
		
		window.location = 'sapfunctionoperation!addParameter.action?paramType=' + type + '&id=${operation.id}&parameterName=' + parameterName + 
		'&parameterValue='+parameterValue;			
	}
	
	function removeParameter(id,name,type){
		if(!confirm('Tem certeza que quer excluir o parametro '+name+'?')){
			return;
		}
		window.location = 'sapfunctionoperation!removeParameter.action?paramType='+type+'&id=${operation.id}&sapParameterId=' + id;
	}
	</script>
	
</@ct.ctpl>