<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<html:xhtml/>


<table width="600" border="0" cellspacing="1" cellpadding="3">
  <%--
<tr valign="top">
<td colspan="10"><img src="images/space.gif"/></td>
</tr>
  --%>
  <logic:empty name="unitstats">
    <tr valign="top">
      <td class="tableheader" colspan="10">No unit statistics available</td>
    </tr>
  </logic:empty>

  <logic:notEmpty name="unitstats">

  <logic:present name="unit">

  <tr valign="top">
    <td class="tableheader" colspan="13"><b>Usage statistics for <bean:write name="unit" property="name"/></b></td>
  </tr>

  <tr>
    <td width="23%" class="tablecellbold"><b>Month</b></td>
    <logic:iterate name="statsHeadings" id="heading">
      <td width="7%" class="tablecell" align="center"><bean:write name="heading" property="heading"/></td>
    </logic:iterate>
    <td width="7%" class="tablecell" align="center">Download CSV </br> (right-click and save as...)</td>
  </tr>

  <logic:iterate name="unitstats" id="stat" type="com.worthsoln.patientview.unitstat.UnitMonthStats">
  <tr>
    <td width="23%" class="tablecellbold"><b><bean:write name="stat" property="yearmonth"/></b></td>
    <logic:iterate name="statsHeadings" id="heading" type="com.worthsoln.patientview.unitstat.StatsHeading">
    <td width="7%" class="tablecell" align="center"><%= stat.getValue(heading.getHeading()) %>
    </td>
    </logic:iterate>
    <td width="7%" class="tablecell" align="center"><a
        href="unitstatfiles/<bean:write name="stat" property="downloadFilename"/>" type="text/csv"><bean:write
        name="stat" property="downloadFilename"/></a>
      </logic:iterate>

      </logic:present>

      </logic:notEmpty>

</table>

