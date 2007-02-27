<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<html:xhtml/>

<p class="header">Administration User</p>


<html:form action="/control/adminAdd">
<table cellpadding="3" >
    <tr>
      <td><img src="images/space.gif" height="10" /> </td>
    </tr>
    <tr>
      <td><b>User Name</b></td>
      <td><html:text property="username" /></td>
    </tr>
    <tr>
      <td><b>Password</b></td>
      <td><html:text property="password" /></td>
    </tr>
    <tr>
      <td><b>Admin Type</b></td>
      <td><html:select property="admintype">
             <html:option value="super">Super Admin</html:option>
             <html:option value="unit">Unit Admin</html:option>
          </html:select></td>
    </tr>
    <tr>
      <td><b>Renal Unit</b></td>
      <td><html:select property="renalunit">
             <html:option value="leeds">Leeds</html:option>
             <html:option value="heartlands">Heartlands</html:option>
          </html:select></td>
    </tr>
    <tr>
      <td><b>Email Address</b></td>
      <td><html:text property="email" /></td>
    </tr>
    <tr align="right">
      <td><html:submit value="Add" styleClass="formbutton" /></td>
    </tr>
 </table>

</html:form>
