<#import "template-geral.ftl" as t >
<@t.template>
<h1>${bundle.name!}</h1>
<br clear="all" />
<div class="contentArea">
<@s.actionmessage/>
 <span align="left" style="border-bottom: 1px dashed #cccccc; margin-bottom: 15px;">
        <#if licenseUses.pageNumber != 1>
        <a href='licenses!viewLicenseBundleUse.action?bundle.id=${bundle.id}&pageNumber=${pageNumber-1}'>Anterior</a> 
        </#if>
        <#if licenseUses.pageNumber lt licenseUses.pagesAvailable>
        <a href='licenses!viewLicenseBundleUse.action?bundle.id=${bundle.id}&pageNumber=${pageNumber+1}'>Próximo</a>
        </#if>
        </span> 
<div class="content" id="contentFull">
	<b class="bt"><b></b></b>
	<div class="body">       
		<table class="gridContent">
			<tr>
				<th>Data Ativação</th>				
				<th align="left">Email</th>
				<th>PIN</th>
				<th>Fabricante</th>
				<th>Modelo</th>
				<th>Operadora</th>				
				<th>Chave gerada (se houver)</th>				
			</tr>	
			<#list licenseUses.pageItems as lic>		
			<tr valign="middle">
				<td align="center">${lic.activationDate?string("dd/MM/yyyy kk:mm")}</td>				
				<td align="left">${lic.email!}</td>
				<td align="center" style="font-family: monospace;text-transform: uppercase;">${lic.pin}</td>
				<td align="center">${lic.deviceBrand!}</td>
				<td align="center">${lic.deviceModel!}</td>
				<td align="center">${lic.carrier!}</td>				
				<td align="center" style="font-family: monospace;">${lic.licenseKey!}</td>					
			</tr>				
			</#list>
		</table>
	</div>
	<b class="bb"><b></b></b>

</div>
</div>
</@t.template>