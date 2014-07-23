<#global searchUrl="${request.contextPath}/licenses!viewLicenseBundleUse.action?id=${licenseBundle.id}" />
<#import "template-geral.ftl" as t >
<#import "_search_result_links.ftl" as search />
<@t.template>
<h1>${licenseBundle.name!}</h1>
<br clear="all" />
<div class="contentArea">
<@s.actionmessage/>
<#assign actList = bundleActivations/>

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
			<#list actList.elementsThisPage as lic>		
			<tr valign="middle">
				<td align="center">${lic.activationDate?string("dd/MM/yyyy kk:mm")}</td>				
				<td align="left">${lic.email!}</td>
				<td align="center" style="font-family: monospace;text-transform: uppercase;">${lic.pin}</td>
				<td align="center">${lic.brand!}</td>
				<td align="center">${lic.model!}</td>
				<td align="center">${lic.carrier!}</td>				
				<td align="center" style="font-family: monospace;">${lic.licenseKey!}</td>					
			</tr>				
			</#list>
		</table>
	</div>
	<b class="bb"><b></b></b>

</div>
</div>
<@search.searchResultLinks actList/> 
</@t.template>