<#macro content>
<#list book.getBookPages() as bookPage>
index: ${bookPage?index} value:${bookPage}
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
</#list>
</#macro>
