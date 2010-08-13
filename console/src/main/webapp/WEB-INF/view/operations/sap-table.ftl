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
										<td>CAMPO1</td><td align="center"><img src="images/close.gif" alt="Excluir" border="0" /></td>
										<td>CAMPO2</td><td align="center"><img src="images/close.gif" alt="Excluir" border="0" /></td>	
										<td colspan="2"><a title="Incluir um campo na tablea" href="javascript:void(0)" onclick="addTableField()"><img src="images/ico_add.gif" alt="Inserir" border="0" /></a></td>											
									</tr>
									<tr>
										<td colspan="2"><input type="text" value="xxx"/></td>
										<td colspan="2"><input type="text" value="zzz" /></td>
										<td><a title="Remove o parâmetro"  ><img src="images/close.gif" alt="Excluir" border="0" /></a></td>
									</tr>
									<tr>
										<td colspan="2"><input type="text" value="yyy"/></td>
										<td colspan="2"><input type="text" value="aaa" /></td>
										<td><a title="Remove o parâmetro"  ><img src="images/close.gif" alt="Excluir" border="0" /></a></td>
									</tr>
									<tr>
										<td colspan="2"><input type="text" value=""/></td>
										<td colspan="2"><input type="text" value="" /></td>
										<td><a href=""><img src="images/ico_add.gif" alt="Inserir" border="0" /></a></td>
									</tr>	
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
function addTableField(){
	var fname = prompt('Nome do campo');
	if(fname == null || fname == ''){
		return;
	}
	window.location = 'saptable!addField.action?sapTableId=${sapTable.id}&id=${operation.id}&sapTableFieldName='+fname;
}

</script>

</@t.template>

