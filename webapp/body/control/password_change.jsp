<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<html:xhtml/>

<p class="header">Change Password</p>

<logic:present name="firstLogon">
  <bean:message key="firstlogn.message" /><br /><br />
</logic:present>

<logic:present name="error">
  <bean:message key="errors.header"/><bean:message key="errors.prefix"/><bean:message key="oldpassword.incorrect" /><bean:message key="errors.suffix"/><bean:message key="errors.footer"/>
</logic:present>

<bean:message key="passwordstrength.message" /><br /><br />

<html:errors/>

<html:form action="/control/passwordChange">

  <table cellpadding="3" >

    <tr>
      <td><b>Username</b></td>
      <td><%= request.getUserPrincipal().getName() %></td>
    </tr>

    <tr>
      <td><b>Current Password</b></td>
      <td><html:password property="oldpassword" /></td>
    </tr>

    <tr>
      <td><b>New Password</b></td>
      <td><html:password property="newpassword" /></td>
    </tr>

    <tr>
      <td><b>Repeat New Password</b></td>
      <td><html:password property="newpasswordagain" /></td>
    </tr>

    <tr>
      <td><html:submit value="Submit" styleClass="formButton"/></td>
    </tr>

  </table>

</html:form>

