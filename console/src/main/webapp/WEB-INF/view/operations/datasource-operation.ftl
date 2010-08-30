<#import "_operation.ftl" as ct />

<@ct.ctpl label="Datasource Query" operationaction="datasourcequeryoperation">
	<tr valign="middle">
		<td>Retornar ResutSet</td>
		<td align="left"><@s.select value="${operation.returnResultSet?string}"  name="returnResultSet" 
		theme="simple" list="# {'true':'Sim','false':'Não'}"/></td>
	</tr>
	<tr valign="top" class="active">
		<td>Query</td>
		<td align="left"><@s.textarea id="query" name="query" theme="simple" value="${operation.query!}"/></td>	
	</tr>
	
	
	<script>
	editAreaLoader.init({
			id: "query"	
			,start_highlight: true	
			,allow_resize: "none"
			,allow_toggle: false
			,word_wrap: true
			,language: "pt"
			,syntax: "sql"
			
			
				
		});	
	
	</script>
</@ct.ctpl>
