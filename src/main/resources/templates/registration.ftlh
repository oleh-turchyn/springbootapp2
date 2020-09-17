<#import "parts/common1.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
Add new user
${message}
<@l.login "/registration" />
</@c.page>