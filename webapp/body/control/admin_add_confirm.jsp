<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/datetime" prefix="dt" %>

<html:xhtml/>

<p class="header">Admin Addition Confirmation</p>

On <dt:format
        pattern="d MMM yyyy"><dt:currentTime/></dt:format> you successfully added a new admin user with the following details:
<br/><br/>

<table cellpadding="3">
    <tr>
        <td><b>User Name</b></td>
        <td><bean:write name="adminuser" property="username"/></td>
    </tr>
    <tr>
        <td><b>Password</b></td>
        <td><bean:write name="adminuser" property="password"/></td>
    </tr>
    <tr>
        <td><b>Name</b></td>
        <td><bean:write name="adminuser" property="name"/></td>
    </tr>
    <tr>
        <td><b>Email Address</b></td>
        <td><bean:write name="adminuser" property="email"/></td>
    </tr>
</table>

<br/>

<logic:notEmpty name="adminuser" property="email">
    <p>A verification email has been sent to <bean:write name="adminuser" property="email"/>. The new user needs to click
        the link in that email to verify their email address. The verification link will expire in two weeks.</p>
</logic:notEmpty>
