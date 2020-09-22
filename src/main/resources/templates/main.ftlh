<#import "parts/common1.ftlh" as c>
<#import "parts/login.ftlh" as l>
<@c.page>
    <div>
        <@l.logout />
        <span><a href="/user">User list</a></span>
    </div>
    <div>
        <form method="post">
            <input type="text" name="text" placeholder="Input message">
            <input type="text" name="tag" placeholder="Input tag">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button type="submit">Submit</button>
        </form>
    </div>
    <div>List of messages</div>
    <form method="get" action="/main">
        <input type="text" name="filter"/>
        <button type="submit">Find</button>
    </form>
    <#list messages as message>
        <div>
            <b>${message.id}</b>
            <span>${message.text}</span>
            <i>${message.tag}</i>
            <i>${message.author}</i>
        </div>
    </#list>
</@c.page>