<#macro content>
<title>${bc.templateFileAbsolutePath}</title>
<title>${bc.outputFileAbsolutePath}</title>

<#-- Note: x is a loop variable -->
<#list ['a', 'b', 'c'] as x>
index: ${x?index} value:${x}
</#list>
<#list data as x>
index: ${x?index} value:${x}
</#list>
</#macro>
