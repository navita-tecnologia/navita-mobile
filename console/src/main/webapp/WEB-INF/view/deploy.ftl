	<#import "template-geral.ftl" as t >
	<@t.template>
	
		<h1>Dom&iacute;nios</h1>
		<br clear="all" />
	    <div class="contentArea">
	<@s.actionmessage/><@s.actionerror/>
	    	<div class="content" id="contentFull">
				<b class="bt"><b></b></b>
				<div class="body">
		            <strong>Deploys</strong>
					<table class="gridContent">
						<tr>
							<th class="left">Arquivo </th>
							<th width="20%">URL</th>
							<th width="20%">Ultima atualizacao</th>
							
							<th width="70px">Ações</th>
						</tr>
						
						<@s.iterator value="deploys" status="stat">
							<tr valign="middle" <#if stat.odd>class="active"</#if> >
								<td><@s.property value="absolutePath"/></td>
								<td align="center"><@s.property value="url"/></td>
								<td align="center">${lastModified?string('dd/MM/yyyy kk:mm:ss')}</td>									
								<td align="center"><a href="#" onclick='removeFile("<@s.property value="escapeAbsolutePath"/>")' >remover</a></td>
							</tr>
						</@s.iterator>
						
							
					</table><br/>
					<@s.form action="deployable!deploy.action" theme="simple" enctype="multipart/form-data" method="post">
						<@s.file name="file" theme="simple" cssStyle="width: 250px;" />
						<@s.submit theme="simple" cssStyle="width: 100px;" value="Upload"/></@s.form>
	        	</div>
				<b class="bb"><b></b></b>
	
			</div>
		</div>
		<script>
		function removeFile(nome){
			if(confirm('Tem certeza que quer remover o arquivo '+nome+'?')){
				window.location='<@s.url action="deployable!remove.action"/>?fileName='+nome	
			}
		}
		</script>
		
		</@t.template>
