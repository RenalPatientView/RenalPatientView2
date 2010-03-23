<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<p class="header">Forgotten password</p>
<logic:notEmpty name="nullUser">
    <p class="error">Please enter your username.</p>
</logic:notEmpty>
<logic:equal name="foundUser" value="false">
    <p class="error">Sorry your username was not found.</p>
</logic:equal>
<logic:notEmpty name="nullEmail">
    <p class="error">Your username does not have an email set. Please contact an administrator.</p>
</logic:notEmpty>

<form action="forgotten-password.do" class="forgotenPassword">
    <label for="username">Please enter your user name in the field below</label>
    <input type="text" name="username" id="username" />
    <input type="submit" class="formButton"/>
</form>

