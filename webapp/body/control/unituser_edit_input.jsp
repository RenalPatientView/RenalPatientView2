<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<html:xhtml/>

<p class="header">Unit User Edit</p>

<html:errors />


<table cellpadding="3" >
  <html:form action="/control/unitUserEdit">
    <tr>
      <td><img src="images/space.gif" height="10" /> </td>
    </tr>
    <tr>
      <td><b>User Name</b></td>
      <td><html:hidden name="unitUser" property="username" write="true"/></td>
    </tr>
    <tr>
      <td><b>Name</b></td>
      <td><html:text name="unitUser" property="name" /></td>
    </tr>
    <tr>
      <td><b>Email Address</b></td>
      <td><html:text name="unitUser" property="email" /></td>
    </tr>
    <tr>
      <td><b>Role</b></td>
      <td><html:select property="role" name="unitUser">
            <html:option value="unitstaff" >Unit Staff</html:option>
            <html:option value="unitadmin" >Unit Admin</html:option>
          </html:select>
      </td>
    </tr>
    <html:hidden name="unitUser" property="unitcode"/>
    <html:hidden name="unitUser" property="firstlogon"/>
    <html:hidden name="unitUser" property="password"/>

    <tr align="right">
      <td><html:submit value="Edit" styleClass="formbutton" /></td>
    </tr>
  </html:form>

    <tr align="right">
      <td>&nbsp;</td>
    </tr>

    <tr align="right">
      <td>&nbsp;</td>
    </tr>

  <html:form action="/control/resetPassword">
    <html:hidden name="unitUser" property="username"/>
    <tr align="left">
      <td><html:submit value="Reset Password" styleClass="formbutton" /></td>
    </tr>
  </html:form>

    <tr align="right">
      <td>&nbsp;</td>
    </tr>

    <tr align="right">
      <td>&nbsp;</td>
    </tr>

  <html:form action="/control/userDelete">
    <html:hidden name="unitUser" property="username"/>
    <tr align="left">
      <td><html:submit value="Delete Unit User" styleClass="formbutton" /></td>
    </tr>
  </html:form>

 </table>


