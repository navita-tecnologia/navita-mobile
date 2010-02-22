	<#import "template-geral.ftl" as t >
	<@t.template>
	
		<h1>Alterar senha</h1>
		<br clear="all" />
	    <div class="contentArea">
		<@s.actionmessage/><@s.actionerror/>
	    	<div class="content" id="contentFull">
				<b class="bt"><b></b></b>
				<div class="body">
		            <strong>Alterar senha ADMIN</strong>
		            <@s.form action="admin!changeAdminPassword.action">		            
					<table class="gridContent">		
					<tr>
							<th class="left" width="250px">&nbsp;</th>
							<th class="left" >&nbsp;</th>
						</tr>				
							<tr class="active" valign="middle" >
								<td width="250">Senha</td>
								<td align="left"><@s.password name="password" theme="simple" maxlength="50" size="30" cssStyle="width: 200px; "/></td>	
							</tr>							
							<tr  valign="middle">
								<td>&nbsp;</td>
								<td align="left"><input type="submit" value="Salvar" style="width: 150px;"/></td>
							</tr>
							
							
							
					</table></@s.form>
	        	</div>
				<b class="bb"><b></b></b>	
			</div>
		</div>
		
		</@t.template>
