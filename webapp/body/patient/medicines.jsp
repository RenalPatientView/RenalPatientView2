<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<html:xhtml/>

<table width="450" border="0" cellspacing="1" cellpadding="3">

  <tr valign="top">
    <td colspan="5"><img src="images/space.gif" height="5"/></td>
  </tr>

  <tr valign="top">
    <td colspan="5"><bean:message key="cautionary.medicines" /></td>
  </tr>

  <tr valign="top">
    <td colspan="5"><bean:message key="link.medicines" /></td>
  </tr>

  <tr valign="top">
    <td colspan="5"><img src="images/space.gif" height="5"/></td>
  </tr>

  <logic:empty name="medicines">
    <tr valign="top">
      <td class="tableheader" colspan="10">No medicines uploaded</td>
    </tr>
  </logic:empty>

  <logic:notEmpty name="medicines">

    <logic:present name="patient">

      <tr valign="top">
        <td class="tableheader" colspan="3"><b>Medicines for <bean:write name="patient" property="forename"/> <bean:write name="patient" property="surname"/></b></td>
      </tr>

      <tr>
        <td class="tablecellbold" width="75"><b>Start Date</b></td>
        <td class="tablecellbold">Medicine Name</td>
        <td class="tablecellbold">Dose</td>
      </tr>

      <logic:iterate name="medicines" id="medicinecine">
        <tr>
          <td class="tablecell"><bean:write name="medicinecine" property="formattedStartDate"/></td>
          <td class="tablecell"><bean:write name="medicinecine" property="name"/></td>
          <td class="tablecell"><bean:write name="medicinecine" property="dose"/></td>
        </tr>
      </logic:iterate>

    </logic:present>

  </logic:notEmpty>

</table>

