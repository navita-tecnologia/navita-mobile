<#import "template-geral.ftl" as t >
<@t.template>
<h1>Pacotes de Licen&ccedil;as</h1>
<br clear="all" />
<div class="contentArea">
<@s.actionmessage/>
	    	<div class="content" id="contentFull">
				<b class="bt"><b></b></b>
				<div class="body">
		            <strong>Pacotes de Licen&ccedil;as</strong>
					<table class="gridContent">
						<tr>
							<th class="left">Nome&nbsp;&nbsp;<a href='licenses!createBundlePrepare.action' title="Cadastrar Pacote" >&nbsp;<img src="images/ico_add.gif" alt="Adicionar" border="0" /></a></th>
							<th class="left" width="20%">Tipo</th>
							<th  width="20%">Per&iacute;odo padr&atilde;o em dias</th>							
							<th  width="20%">Ativações</th>
							<th width="70px">Ação</th>
							<th width="70px">Ação</th>
						</tr>
						<#list bundles as bundle>
							<tr valign="middle">
								<td>
									<a href='licenses!viewLicenseBundleUse.action?bundle.id=${bundle.id}&pageNumber=1'title="Lista utilizações do pacote ${bundle.name}" >${bundle.name}</a>
								</td>
								<td class="left">${bundle.licenseBundleType.name}</td>	
								<td align="center">${bundle.defaultPeriodInDaysLabel!}</td>	
								<td align="center">${bundle.usageNumber!}</td>	
								<td align="center">
									<a href='licenses!viewBundle.action?bundle.id=${bundle.id}'title="Editar" >editar</a>
								</td>							
								<td align="center">
									<a href="#" onclick='removeBundle("${bundle.name}","${bundle.id}")' >remover</a>
								</td>
							</tr>
						</#list>	
							
					</table>
	        	</div>
				<b class="bb"><b></b></b>
	
			</div>
			<script>
		function removeBundle(nome,id){
			if(confirm('Tem certeza que quer remover o pacote '+nome+'?')){
				window.location='licenses!removeBundle.action?bundle.id='+id;	
			}
		}
		</script>

</div>
</@t.template>