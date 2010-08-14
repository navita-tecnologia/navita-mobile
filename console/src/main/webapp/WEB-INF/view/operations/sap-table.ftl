<#import "../template-geral.ftl" as t >
<@t.template>
<script language="Javascript" type="text/javascript" src="edit_area/edit_area_full.js"></script>
<h1><a href="connectors.action">Conectors</a> :: <a href="connectors!edit.action?id=${operation.connector.id}">${operation.connector.name}</a> :: ${operation.name} :: ${sapTable.name}</h1>
<br clear="all" />
<div class="contentArea">
<@s.actionmessage/>
	<div class="content" id="contentFull">
				<b class="bt"><b></b></b>
				<div class="body">
				<strong>Editar uma tabela</strong>	
				<@s.form action="saptable!save.action">
		            <@s.hidden name="sapTableId" value="${sapTable.id}"/>
		            <@s.hidden name="id" value="${operation.id}"/>		            
					<table class="gridContent">						
							<tr valign="middle" >
								<td width="150">Nome</td>
								<td align="left"><@s.textfield name="sapTableName" theme="simple" value="${sapTable.name!}"/></td>	
							</tr>							
							<tr valign="top" class="active" >
								<td width="150">Elementos</td>
								<td align="left">
								<table>
									<tr>
										<#list sapTable.fieldNames as td>
											<td>${td.name}</td>
											<td align="center"><a title="Remove este campo da tablea" href="javascript:void(0)" onclick="removeTableField('${td.name}','${td.id}')"><img src="images/close.gif" alt="Excluir" border="0" /></a></td>
										</#list>
										<td colspan="2"><a title="Incluir um campo na tablea" href="javascript:void(0)" onclick="addTableField()"><img src="images/ico_add.gif" alt="Inserir" border="0" /></a></td>											
									</tr>
									<#list sapTable.sapRows as tr>
									<tr>
										<#list tr.attributes as td>
											<td colspan="2"><input type="text" value="${td.name} ${td.value}"/></td>
										</#list>										
										<td><a title="Remove esta linha" href="javascript:void(0)" onclick="deleteRow('${tr.id}')" ><img src="images/close.gif" alt="Excluir" border="0" /></a></td>
									</tr>
									</#list>
									<#if sapTable.fieldNames.size() gt 0>
									<tr>
										<#list sapTable.fieldNames as td>
											<td colspan="2"><input type="text" value="" id="att${td.name}"/></td>
										</#list>
										<td><a title="Adiciona uma linha" href="javascript:void(0)" onclick="addRow()" ><img src="images/ico_add.gif" alt="Inserir" border="0" /></a></td>
									</tr>
									</#if>	
								</table>
								
								</td>	
							</tr>	
							
							<tr valign="middle">								
								<td>&nbsp;</td>
								<td align="left"><input type="submit" value="Salvar" style="width: 150px;"/></td>
							</tr>
							
							
							
							
					</table></@s.form>			

			

	</div>
				<b class="bb"><b></b></b>
	
			</div>
</div>

<script>
var names = [];
var idx = 0;
<#list sapTable.fieldNames as td>
	names[idx++] = '${td.name}';
</#list>
function addTableField(){
	var fname = prompt('Nome do campo');
	if(fname == null || fname == ''){
		return;
	}
	window.location = 'saptable!addField.action?sapTableId=${sapTable.id}&id=${operation.id}&sapTableFieldName='+fname;
}

function removeTableField(name, id){
	if(! confirm('Tem certeza que quer excluir o campo ' + name + '?')){
		return;
	}
	window.location = 'saptable!removeField.action?sapTableId=${sapTable.id}&id=${operation.id}&sapTableFieldId='+id;
}

function addRow(){	
	var rowData = '';
	for(var i = 0; i < names.length; i++){
		if(i > 0){rowData += '|';}
		var obj = names[i];
		value = document.getElementById('att'+obj).value;
		rowData += obj + ':' + value 		
	}		
	window.location = 'saptable!addRow.action?sapTableId=${sapTable.id}&id=${operation.id}&rowData='+rowData;
}

function deleteRow(id){
	if(! confirm('Tem certeza que quer excluir esta linha?')){
		return;
	}
	window.location = 'saptable!removeRow.action?sapTableId=${sapTable.id}&id=${operation.id}&sapRowId='+id;

}
</script>

</@t.template>

