<#import "template-geral.ftl" as t >
<@t.template>
<h1>Pacotes de Licen&ccedil;as</h1>
<br clear="all" />
<div class="contentArea">

<@s.actionmessage/>
	    	<div class="content" id="contentFull">
				<b class="bt">teste</b>
				<div class="body">
		            <strong>Pacotes de Licen&ccedil;as</strong>
					<table class="gridContent">
						<tr>
							<th class="left">Nome&nbsp;&nbsp;<a href='<@s.url action="licenses!createBundlePrepare.action"/>' title="Cadastrar Pacote" >&nbsp;<img src="images/ico_add.gif" alt="Adicionar" border="0" /></a></th>
							<th width="20%">Tipo</th>
							<th width="20%">Per&iacute;odo padr&atilde;o em dias</th>							
							<th width="70px">A&ccedil;&otilde;es</th>
						</tr>
						
							<tr valign="middle">
								<td>
									<a href='<@s.url action="licenses!viewBundle.action"/>' title="Editar" >Tradutor Free</a>
								</td>
								<td align="center">Free</td>	
								<td align="center">Infinito</td>								
								<td align="center">
									<a href="#" onclick='removeBundle("<@s.property value="name"/>","<@s.property value="id"/>")' >remover</a>
								</td>
							</tr>
							
							
					</table>
	        	</div>
				<b class="bb"><b></b></b>
	
			</div>
			<script>
		function removeBundle(nome,id){
			if(confirm('Tem certeza que quer remover o pacote '+nome+'?')){
				window.location='<@s.url action="licence!removeBundle.action"/>?bundle.id='+id	
			}
		}
		</script>

</div>
</@t.template>