<#import "_operation.ftl" as ct />

<@ct.ctpl label="Datasource Query" operationaction="datasourcequeryoperation">
	<tr valign="top">
		<td>Query</td>
		<td align="left"><@s.textarea id="query" name="query" theme="simple" value="${operation.query!}"/></td>	
	</tr>
	<tr valign="middle" class="active">
		<td>&nbsp;</td>
		<td align="left">&nbsp;</td>	
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
