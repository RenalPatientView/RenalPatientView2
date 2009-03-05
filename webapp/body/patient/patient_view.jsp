<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<html:xhtml/>

<div align="left">
The links on this page are to information that is mainly written for patients, but it is often very useful for healthcare staff too. Almost all links are to other websites. These links have been chosen by us, but the information is not written by us.
</div>

<br/>

<div align="center">

  <table width="690">
    <logic:notPresent name="edtaCode">
      <tr>
        <td valign="top">Primary Diagnosis:</td>
        <td valign="top"><b>No primary diagnosis has been loaded</b></td>
      </tr>
    </logic:notPresent>

    <logic:present name="patient">
      <tr valign="top">
        <td class="tableheader" colspan="3">Patient Information Links for <bean:write name="patient" property="forename"/> <bean:write name="patient" property="surname"/></td>
      </tr>
    </logic:present>

    <logic:present name="edtaCode">
    <tr>
      <td valign="top" class="tablecell">Primary Diagnosis:</td>
      <td valign="top" class="tablecell"><b><bean:write name="edtaCode" property="description"/></b></td>
      <td valign="top" class="tablecell">
        <logic:notEmpty name="edtaCode" property="patientLink01">
           <a href="<bean:write name="edtaCode" property="patientLink01"/>" target="_blank"><bean:write name="edtaCode" property="patientLinkText01"/></a><br />
        </logic:notEmpty>
        <logic:notEmpty name="edtaCode" property="patientLink02">
           <a href="<bean:write name="edtaCode" property="patientLink02"/>" target="_blank"><bean:write name="edtaCode" property="patientLinkText02"/></a><br />
        </logic:notEmpty>
        <logic:notEmpty name="edtaCode" property="patientLink03">
           <a href="<bean:write name="edtaCode" property="patientLink03"/>" target="_blank"><bean:write name="edtaCode" property="patientLinkText03"/></a><br />
        </logic:notEmpty>
        <logic:notEmpty name="edtaCode" property="patientLink04">
           <a href="<bean:write name="edtaCode" property="patientLink04"/>" target="_blank"><bean:write name="edtaCode" property="patientLinkText04"/></a><br />
        </logic:notEmpty>
        <logic:notEmpty name="edtaCode" property="patientLink05">
           <a href="<bean:write name="edtaCode" property="patientLink05"/>" target="_blank"><bean:write name="edtaCode" property="patientLinkText05"/></a><br />
        </logic:notEmpty>
        <logic:notEmpty name="edtaCode" property="patientLink06">
           <a href="<bean:write name="edtaCode" property="patientLink06"/>" target="_blank"><bean:write name="edtaCode" property="patientLinkText06"/></a><br />
        </logic:notEmpty>
      </td>
    </tr>
    </logic:present>


    <logic:notPresent name="treatmentCode">
    <tr>
      <td valign="top" class="tablecell">Treatment:</td>
      <td valign="top" class="tablecell"><b>No treatment has been uploaded</b></td>
    </td>
    </logic:notPresent>

    <logic:present name="treatmentCode">
    <tr>
      <td valign="top" class="tablecell">Treatment:</td>
      <td valign="top" class="tablecell"><b><bean:write name="treatmentCode" property="description"/></b></td>
      <td valign="top" class="tablecell">
        <logic:notEmpty name="treatmentCode" property="patientLink01">
           <a href="<bean:write name="treatmentCode" property="patientLink01"/>" target="_blank"><bean:write name="treatmentCode" property="patientLinkText01"/></a><br />
        </logic:notEmpty>
        <logic:notEmpty name="treatmentCode" property="patientLink02">
           <a href="<bean:write name="treatmentCode" property="patientLink02"/>" target="_blank"><bean:write name="treatmentCode" property="patientLinkText02"/></a><br />
        </logic:notEmpty>
        <logic:notEmpty name="treatmentCode" property="patientLink03">
           <a href="<bean:write name="treatmentCode" property="patientLink03"/>" target="_blank"><bean:write name="treatmentCode" property="patientLinkText03"/></a><br />
        </logic:notEmpty>
        <logic:notEmpty name="treatmentCode" property="patientLink04">
           <a href="<bean:write name="treatmentCode" property="patientLink04"/>" target="_blank"><bean:write name="treatmentCode" property="patientLinkText04"/></a><br />
        </logic:notEmpty>
        <logic:notEmpty name="treatmentCode" property="patientLink05">
           <a href="<bean:write name="treatmentCode" property="patientLink05"/>" target="_blank"><bean:write name="treatmentCode" property="patientLinkText05"/></a><br />
        </logic:notEmpty>
        <logic:notEmpty name="treatmentCode" property="patientLink06">
           <a href="<bean:write name="treatmentCode" property="patientLink06"/>" target="_blank"><bean:write name="treatmentCode" property="patientLinkText06"/></a><br />
        </logic:notEmpty>
      </td>
    </tr>
    </logic:present>

    <logic:present name="staticLinks">
    <tr>
      <td valign="top" class="tablecell"><bean:write name="staticLinks" property="description"/></td>
      <td valign="top" class="tablecell">&nbsp;</td>
      <td valign="top" class="tablecell">
        <logic:notEmpty name="staticLinks" property="patientLink01">
           <a href="<bean:write name="staticLinks" property="patientLink01"/>" target="_blank"><bean:write name="staticLinks" property="patientLinkText01"/></a><br />
        </logic:notEmpty>
        <logic:notEmpty name="staticLinks" property="patientLink02">
           <a href="<bean:write name="staticLinks" property="patientLink02"/>" target="_blank"><bean:write name="staticLinks" property="patientLinkText02"/></a><br />
        </logic:notEmpty>
        <logic:notEmpty name="staticLinks" property="patientLink03">
           <a href="<bean:write name="staticLinks" property="patientLink03"/>" target="_blank"><bean:write name="staticLinks" property="patientLinkText03"/></a><br />
        </logic:notEmpty>
        <logic:notEmpty name="staticLinks" property="patientLink04">
           <a href="<bean:write name="staticLinks" property="patientLink04"/>" target="_blank"><bean:write name="staticLinks" property="patientLinkText04"/></a><br />
        </logic:notEmpty>
        <logic:notEmpty name="staticLinks" property="patientLink05">
           <a href="<bean:write name="staticLinks" property="patientLink05"/>" target="_blank"><bean:write name="staticLinks" property="patientLinkText05"/></a><br />
        </logic:notEmpty>
        <logic:notEmpty name="staticLinks" property="patientLink06">
           <a href="<bean:write name="staticLinks" property="patientLink06"/>" target="_blank"><bean:write name="staticLinks" property="patientLinkText06"/></a><br />
        </logic:notEmpty>
      </td>
    </tr>
    </logic:present>

  </table>

</div>