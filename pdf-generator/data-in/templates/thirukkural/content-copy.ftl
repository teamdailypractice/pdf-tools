<#macro content>
#set page("a4")
#set text(
  font: "TSCu_SaiIndira",
  size: 13pt
)

<#list book.getBookPages() as bookPage>
#set page("a4")
#set text(
  font: "TSCu_SaiIndira",
  size: 13pt
)
#set align(center)
= ${bookPage?index}    ${bookPage.getTitle()}
\
#set align(left)
#table(
  stroke: none,
  columns: (2cm, auto),
  [], [],
    <#list bookPage.getContents() as contents>
     <#list contents as content>
        [1], [${content.get(0)} \ ${content.get(1)} \ \ ],
     </#list>
    </#list>
)
</#list>
</#macro>
