<#macro searchResultLinks searchResults>
	<#if searchResults??>
		<#global fromPage = 1 />
		<#if searchResults.pageNumber gt 5>
			<#global fromPage = searchResults.pageNumber - 4 />
		</#if>
		<#global toPage = fromPage + 8 />
		<#if searchResults.numPages < toPage>
			<#global toPage = searchResults.numPages />
			<#global fromPage = toPage - 8 />
			<#if fromPage lt 1>
				<#global fromPage = 1 />
			</#if>
		</#if>
		<br clear="all" />
		<center>
			<table>
				<tr>
					<td><a href="${searchUrl}<@addSearchUrlParameter "pageNumber=1" />"><img src="${request.contextPath}/images/arrow_first.gif" border="0" /></a></td>
					<#if !searchResults.firstPage>
						<td><a href="${searchUrl}<@addSearchUrlParameter "pageNumber=${fromPage}" />"><img src="${request.contextPath}/images/arrow_ff_previous.gif" border="0" /></a></td>
						<td><a href="${searchUrl}<@addSearchUrlParameter "pageNumber=${searchResults.pageNumber - 1}" />"><img src="${request.contextPath}/images/arrow_previous.gif" border="0" /></a></td>
					<#else>
						<td><a href="#" onclick="return false;"><img src="${request.contextPath}/images/arrow_ff_previous.gif" border="0" /></a></td>
						<td><a href="#" onclick="return false;"><img src="${request.contextPath}/images/arrow_previous.gif" border="0" /></a></td>
					</#if>
					<td valign="middle">
						<#list fromPage..toPage as pageNum>
							<#if searchResults.pageNumber = pageNum>
								<b><a href="#" onclick="return false;" class="pagingActionLink">${pageNum}</a></b>
							<#else>
								<a class="pagingLink" href="${searchUrl}<@addSearchUrlParameter "pageNumber=${pageNum}"  />">${pageNum}</a>
							</#if>
							<#if pageNum < toPage> | </#if>
							<#if searchResults.numPages == 0><#break /></#if>
						</#list>
					</td>
					<#if !searchResults.lastPage>
						<td><a href="${searchUrl}<@addSearchUrlParameter "pageNumber=${searchResults.pageNumber + 1}" />"><img src="${request.contextPath}/images/arrow_next.gif" border="0" /></a></td>
						<td><a href="${searchUrl}<@addSearchUrlParameter "pageNumber=${toPage}" />"><img src="${request.contextPath}/images/arrow_ff_next.gif" border="0" /></a></td>
					<#else>
						<td><a href="#" onclick="return false;"><img src="${request.contextPath}/images/arrow_next.gif" border="0" /></a></td>
						<td><a href="#" onclick="return false;"><img src="${request.contextPath}/images/arrow_ff_next.gif" border="0" /></a></td>
					</#if>
					<td><a href="${searchUrl}<@addSearchUrlParameter "pageNumber=${searchResults.numPages}" />"><img src="${request.contextPath}/images/arrow_last.gif" border="0" /></a></td>
				</tr>
			</table>
		</center>
		<div style="text-align: center; margin-top: 10px">Exibindo <b>${searchResults.firstElementInPageIndex}</b>&nbsp;-&nbsp;<b>${searchResults.lastElementInPageIndex}</b> de <b>${searchResults.totalElements}</b> registros.</div>
	</#if>
</#macro>

<#macro letters>
	<div class="letterFilter">
		<@generateLetter value="Todos" />
		<@generateLetter value="A" />
		<@generateLetter value="B" />
		<@generateLetter value="C" />
		<@generateLetter value="D" />
		<@generateLetter value="E" />
		<@generateLetter value="F" />
		<@generateLetter value="G" />
		<@generateLetter value="H" />
		<@generateLetter value="I" />
		<@generateLetter value="J" />
		<@generateLetter value="K" />
		<@generateLetter value="L" />
		<@generateLetter value="M" />
		<@generateLetter value="N" />
		<@generateLetter value="O" />
		<@generateLetter value="P" />
		<@generateLetter value="Q" />
		<@generateLetter value="R" />
		<@generateLetter value="S" />
		<@generateLetter value="T" />
		<@generateLetter value="U" />
		<@generateLetter value="V" />
		<@generateLetter value="W" />
		<@generateLetter value="X" />
		<@generateLetter value="Y" />
		<@generateLetter value="Z" />
	</div>
</#macro>

<#macro generateLetter value>
	<#if (!letter?? && value == "Todos") || (letter?? && letter == value)>
		<img border="0" src="${request.contextPath}/images/letters/${value}_sel.gif" />
	<#else>
		<#if value == "Todos">
			<a href="${searchUrl}<@addSearchUrlParameter action.customizedQueryString />">
		<#else>
			<a href="${searchUrl}<@addSearchUrlParameter "${action.letterQueryString}&letter=${value}" />">
		</#if>
		<#t><img border="0" src="${request.contextPath}/images/letters/${value}.gif" /><#t>
		</a>
	</#if>
</#macro>

<#macro addSearchUrlParameter param>
	<#if searchUrl?index_of('?') != -1>&<#else>?</#if>${param}
</#macro>