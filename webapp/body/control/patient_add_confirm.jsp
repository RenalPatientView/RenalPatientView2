<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/datetime" prefix="dt" %>

<html:xhtml/>

<p class="header">Patient</p>


On <dt:format pattern="d MMM yyyy"><dt:currentTime/></dt:format> you successfully enrolled a new patient with the following details:
<br /><br />

<table cellpadding="3" >
    <tr>
      <td><b>User Name</b></td>
      <td><bean:write name="patient" property="username" /></td>
    </tr>
    <tr>
      <td><b>Password</b></td>
      <td class="password"><bean:write name="patient" property="password" /></td>
    </tr>
    <tr>
      <td><b>Name</b></td>
      <td><bean:write name="patient" property="name" /></td>
    </tr>
    <tr>
      <td><b>NHS Number</b></td>
      <td><bean:write name="patient" property="nhsno" /></td>
    </tr>
    <tr>
      <td><b>Email Address</b></td>
      <td><bean:write name="patient" property="email" /></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td><html:link action="/control/gpAdd">GP Logon Details</html:link></td>
    </tr>
 </table>

