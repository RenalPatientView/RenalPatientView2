<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<html:xhtml/>

<p class="header">Patient Details</p>

<table width="440" border="0" cellspacing="1" cellpadding="3">

<logic:notPresent name="patient">
  <tr valign="top">
    <td class="tableheader" colspan="2">Patient details not uploaded</td>
  </tr>
</logic:notPresent>

<logic:present name="patient">
<tr valign="top">
  <td class="tableheader" colspan="2">Patient Details for
    <bean:write name="patient" property="forename"/>
    <bean:write name="patient" property="surname"/>
  </td>
</tr>

<tr valign="top">
  <td class="tablecellbold">Last Name</td>

  <td class="tablecell">
    <bean:write name="patient" property="surname"/>
  </td>
</tr>

<tr valign="top">
  <td class="tablecellbold">First Name</td>

  <td class="tablecell">
    <bean:write name="patient" property="forename"/>
  </td>
</tr>

<tr valign="top">
  <td class="tablecellbold">Date of Birth (yyyy-mm-dd)</td>

  <td class="tablecell">
    <bean:write name="patient" property="dateofbirth"/>
  </td>
</tr>

<tr valign="top">
  <td class="tablecellbold">NHS Number</td>

  <td class="tablecell">
    <bean:write name="patient" property="nhsno"/>
  </td>
</tr>

<tr valign="top">
  <td class="tablecellbold">Hospital Number</td>

  <td class="tablecell">
    <bean:write name="patient" property="hospitalnumber"/>
  </td>
</tr>

<tr valign="top">
  <td class="tablecellbold">Address</td>

  <td class="tablecell">
    <bean:write name="patient" property="address1"/>
    <br/>
    <bean:write name="patient" property="address2"/>
    <br/>
    <bean:write name="patient" property="address3"/>
  </td>
</tr>

<tr valign="top">
  <td class="tablecellbold">Postcode</td>

  <td class="tablecell">
    <bean:write name="patient" property="postcode"/>
  </td>
</tr>

<logic:notEmpty name="patient" property="telephone1">
  <tr valign="top">
    <td class="tablecellbold">Telephone 1</td>

    <td class="tablecell">
      <bean:write name="patient" property="telephone1"/>
    </td>
  </tr>
</logic:notEmpty>

<logic:notEmpty name="patient" property="telephone2">
  <tr valign="top">
    <td class="tablecellbold">Telephone 2</td>

    <td class="tablecell">
      <bean:write name="patient" property="telephone2"/>
    </td>
  </tr>
</logic:notEmpty>

<logic:notEmpty name="patient" property="mobile">
  <tr valign="top">
    <td class="tablecellbold">Mobile</td>

    <td class="tablecell">
      <bean:write name="patient" property="mobile"/>
    </td>
  </tr>
</logic:notEmpty>
<%--
            <tr valign="top">
              <td class="tablecellbold">Email Address</td>

              <td class="tablecell"><bean:write name="patient" property="email"/></td>
            </tr>
--%>
<tr valign="top">
  <td class="tablecellbold">Diagnosis</td>
  <logic:present name="edtaCode">
    <td class="tablecell">
      <bean:write name="edtaCode" property="description"/>
    </td>
  </logic:present>
  <logic:notPresent name="edtaCode">
    <td class="tablecell">&nbsp;</td>
  </logic:notPresent>
</tr>

<tr valign="top">
  <td class="tablecellbold">Treatment</td>

  <logic:present name="treatmentCode">
    <td class="tablecell">
      <bean:write name="treatmentCode" property="description"/>
    </td>
  </logic:present>
  <logic:notPresent name="treatmentCode">
    <td class="tablecell">&nbsp;</td>
  </logic:notPresent>
</tr>

<tr valign="top">
  <td class="tablecellbold">Transplant Status</td>

  <td class="tablecell">




      <logic:equal value="" name="uktstatus" property="uktkidney">
        <bean:message key="ukt.status.none"/>
      </logic:equal>


        <logic:notEqual value="" name="uktstatus" property="uktkidney">
          Kidney :
          <bean:write name="uktstatus" property="uktkidney"/>
        </logic:notEqual>

        <logic:notEqual value="" name="uktstatus" property="uktpancreas">
          <logic:notEqual value="Not on list" name="uktstatus" property="uktpancreas">
            <br/>
             Pancreas :
             <bean:write name="uktstatus" property="uktpancreas"/>
          </logic:notEqual>
        </logic:notEqual>



    <br/>(<a href="http://www.renal.org/rixg/transplant.html" target="_blank">Explain this</a>)
  </td>
</tr>

<tr valign="top">
  <td class="tablecellbold">Other Conditions</td>

  <td class="tablecell">
    <logic:present name="otherDiagnoses">
      <logic:iterate id="otherDiagnosis" name="otherDiagnoses">
        <bean:write name="otherDiagnosis" property="diagnosis"/>
        <br/>
      </logic:iterate>
    </logic:present>
  </td>
</tr>
</logic:present>

</table>