<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<html:xhtml/>

<logic:notPresent name="emailSent">
<p class="header">Contact Details</p>


<logic:present name="patient">
        <p><b>Email your renal unit</b></p>
        <p>Any queries about results not appearing or being wrong, or about diagnosis or contact details.</p>
        <p>Note: Your name and NHS number will be sent with this message.</p>
    <logic:notEmpty name="unit" property="rpvadminemail">
        <html:form action="/patient/contactForm">
            Please enter your message bellow: <br />
            <html:textarea rows="6" cols="30" property="message"/>
            <br /><br />Email (this will help us contact you much faster to resolve your issue): <br />
            <html:text property="email" />
            <html:hidden property="rpvadminemail" name="unit" />
            <html:hidden property="type" value="unit" />
            <br /><br /><html:submit value="Send" />
        </html:form>
    </logic:notEmpty>
    <logic:empty name="unit" property="rpvadminemail">
        <p><font color="red">It seems that your renal unit has not set up a contact email address, so you are not able to contact them from here. Let them know.</font></p>
    </logic:empty>

    <br/>

    <p><b>Email the RPV system administrator</b></p>
    <p>Any comments about the system as a whole, or the information links suggested.</p>
    <html:form action="/patient/contactForm">
        Please enter your message bellow: <br />
        <html:textarea rows="6" cols="30" property="message"/>
        <br /><br />Email (this will help us contact you much faster to resolve your issue): <br />
        <html:text property="email" />
        <html:hidden property="type" value="admin" />
        <br />
        <input type="submit" value="Send" />
    </html:form>
</logic:present>

        <table width="440" border="0" cellspacing="1" cellpadding="3">

          <logic:notPresent name="patient">
            <tr valign="top">
              <td class="tableheader" colspan="2">Patient details not uploaded</td>
            </tr>
          </logic:notPresent>

          <logic:present name="patient">
            <tr valign="top">
              <td class="tableheader" colspan="2">GP details for <bean:write name="patient" property="forename"/> <bean:write name="patient" property="surname"/></td>
            </tr>

            <tr valign="top">
              <td class="tablecellbold">GP Name</td>

              <td class="tablecell"><bean:write name="patient" property="gpname"/></td>
            </tr>

            <tr valign="top">
              <td class="tablecellbold">Address</td>

              <td class="tablecell"><bean:write name="patient" property="gpaddress1"/><br />
              <bean:write name="patient" property="gpaddress2"/><br />
              <bean:write name="patient" property="gpaddress3"/></td>
            </tr>

            <tr valign="top">
              <td class="tablecellbold">Postcode</td>

              <td class="tablecell"><bean:write name="patient" property="gppostcode"/></td>
            </tr>

            <tr valign="top">
              <td class="tablecellbold">Telephone</td>

              <td class="tablecell"><bean:write name="patient" property="gptelephone"/></td>
            </tr>
          </logic:present>

            <tr valign="top">
              <td colspan="2" class="tablecell">&nbsp;</td>
            </tr>

          <logic:present name="unit">
            <tr valign="top">
              <td class="tableheader" colspan="2">Unit Details for <bean:write name="unit" property="name"/></td>
            </tr>

            <tr valign="top">
              <td class="tablecellbold">Name</td>
              <td class="tablecell"><bean:write name="unit" property="name"/></td>
            </tr>
            <tr valign="top">
              <td class="tablecellbold">Address</td>
              <td class="tablecell"><bean:write name="unit" property="address1"/><br />
                                    <bean:write name="unit" property="address2"/><br />
                                    <bean:write name="unit" property="address3"/></td>
            </tr>
            <tr valign="top">
              <td class="tablecellbold">Postcode</td>
              <td class="tablecell"><bean:write name="unit" property="postcode"/></td>
            </tr>
            <tr valign="top">
              <td class="tablecellbold">Unit Web Address</td>
              <td class="tablecell"><a href="<bean:write name="unit" property="uniturl"/>" target="_blank"><bean:write name="unit" property="uniturl"/></a></td>
            </tr>
            <tr valign="top">
              <td class="tablecellbold">Trust Web Address</td>
              <td class="tablecell"><a href="<bean:write name="unit" property="trusturl"/>" target="_blank"><bean:write name="unit" property="trusturl"/></a></td>
            </tr>
            <tr valign="top">
              <td class="tablecellbold">Patient View Admin Name</td>
              <td class="tablecell"><bean:write name="unit" property="rpvadminname"/></td>
            </tr>
            <tr valign="top">
              <td class="tablecellbold">Patient View Admin Phone</td>
              <td class="tablecell"><bean:write name="unit" property="rpvadminphone"/></td>
            </tr>
            <tr valign="top">
              <td class="tablecellbold">Unit Enquiries Phone</td>
              <td class="tablecell"><bean:write name="unit" property="unitenquiriesphone"/></td>
            </tr>
            <tr valign="top">
              <td class="tablecellbold">Unit Enquiries Email</td>
              <td class="tablecell">
                <logic:notEmpty name="unit" property="unitenquiriesemail">
                  <a href="mailto:<bean:write name="unit" property="unitenquiriesemail"/>?subject=[Renal Patient View Enquiry]"><bean:write name="unit" property="unitenquiriesemail"/></a>
                </logic:notEmpty>
              </td>
            </tr>
            <tr valign="top">
              <td class="tablecellbold">Appointments Phone</td>
              <td class="tablecell"><bean:write name="unit" property="appointmentphone"/></td>
            </tr>
            <tr valign="top">
              <td class="tablecellbold">Appointments Email</td>
              <td class="tablecell"><bean:write name="unit" property="appointmentemail"/></td>
            </tr>
            <tr valign="top">
              <td class="tablecellbold">Out of Hours Info</td>
              <td class="tablecell"><bean:write name="unit" property="outofhours"/></td>
            </tr>
            <tr valign="top">
              <td class="tablecellbold">Peritoneal Dialysis Phone</td>
              <td class="tablecell"><bean:write name="unit" property="peritonealdialysisphone"/></td>
            </tr>
            <tr valign="top">
              <td class="tablecellbold">Peritoneal Dialysis Email</td>
              <td class="tablecell"><bean:write name="unit" property="peritonealdialysisemail"/></td>
            </tr>


            <logic:notEmpty name="unit" property="haemodialysisunitname1">
            <tr valign="top">
              <td colspan="2" class="tablecell">&nbsp;</td>
            </tr>
            <tr valign="top">
              <td class="tableheader" colspan="2">Haemodialysis Unit - <bean:write name="unit" property="haemodialysisunitname1"/></td>
            </tr>
            <tr valign="top">               <td class="tablecellbold">Phone</td>               <td class="tablecell"><bean:write name="unit" property="haemodialysisunitphone1"/></td>             </tr>
            <tr valign="top">               <td class="tablecellbold">Location</td>               <td class="tablecell"><bean:write name="unit" property="haemodialysisunitlocation1"/></td>             </tr>
            <tr valign="top">               <td class="tablecellbold">Web Address</td>               <td class="tablecell"><bean:write name="unit" property="haemodialysisuniturl1"/></td>             </tr>
            </logic:notEmpty>

            <logic:notEmpty name="unit" property="haemodialysisunitname2">
            <tr valign="top">
              <td colspan="2" class="tablecell">&nbsp;</td>
            </tr>
            <tr valign="top">
              <td class="tableheader" colspan="2">Haemodialysis Unit - <bean:write name="unit" property="haemodialysisunitname2"/></td>
            </tr>
            <tr valign="top">               <td class="tablecellbold">Phone</td>               <td class="tablecell"><bean:write name="unit" property="haemodialysisunitphone2"/></td>             </tr>
            <tr valign="top">               <td class="tablecellbold">Location</td>               <td class="tablecell"><bean:write name="unit" property="haemodialysisunitlocation2"/></td>             </tr>
            <tr valign="top">               <td class="tablecellbold">Web Address</td>               <td class="tablecell"><bean:write name="unit" property="haemodialysisuniturl2"/></td>             </tr>
            </logic:notEmpty>

            <logic:notEmpty name="unit" property="haemodialysisunitname3">
            <tr valign="top">
              <td colspan="2" class="tablecell">&nbsp;</td>
            </tr>
            <tr valign="top">
              <td class="tableheader" colspan="2">Haemodialysis Unit - <bean:write name="unit" property="haemodialysisunitname3"/></td>
            </tr>
            <tr valign="top">               <td class="tablecellbold">Phone</td>               <td class="tablecell"><bean:write name="unit" property="haemodialysisunitphone3"/></td>             </tr>
            <tr valign="top">               <td class="tablecellbold">Location</td>               <td class="tablecell"><bean:write name="unit" property="haemodialysisunitlocation3"/></td>             </tr>
            <tr valign="top">               <td class="tablecellbold">Web Address</td>               <td class="tablecell"><bean:write name="unit" property="haemodialysisuniturl3"/></td>             </tr>
            </logic:notEmpty>

            <logic:notEmpty name="unit" property="haemodialysisunitname4">
            <tr valign="top">
              <td colspan="2" class="tablecell">&nbsp;</td>
            </tr>
            <tr valign="top">
              <td class="tableheader" colspan="2">Haemodialysis Unit - <bean:write name="unit" property="haemodialysisunitname4"/></td>
            </tr>
            <tr valign="top">               <td class="tablecellbold">Phone</td>               <td class="tablecell"><bean:write name="unit" property="haemodialysisunitphone4"/></td>             </tr>
            <tr valign="top">               <td class="tablecellbold">Location</td>               <td class="tablecell"><bean:write name="unit" property="haemodialysisunitlocation4"/></td>             </tr>
            <tr valign="top">               <td class="tablecellbold">Web Address</td>               <td class="tablecell"><bean:write name="unit" property="haemodialysisuniturl4"/></td>             </tr>
            </logic:notEmpty>

            <logic:notEmpty name="unit" property="haemodialysisunitname5">
            <tr valign="top">
              <td colspan="2" class="tablecell">&nbsp;</td>
            </tr>
            <tr valign="top">
              <td class="tableheader" colspan="2">Haemodialysis Unit - <bean:write name="unit" property="haemodialysisunitname5"/></td>
            </tr>
            <tr valign="top">               <td class="tablecellbold">Phone</td>               <td class="tablecell"><bean:write name="unit" property="haemodialysisunitphone5"/></td>             </tr>
            <tr valign="top">               <td class="tablecellbold">Location</td>               <td class="tablecell"><bean:write name="unit" property="haemodialysisunitlocation5"/></td>             </tr>
            <tr valign="top">               <td class="tablecellbold">Web Address</td>               <td class="tablecell"><bean:write name="unit" property="haemodialysisuniturl5"/></td>             </tr>
            </logic:notEmpty>

            <logic:notEmpty name="unit" property="haemodialysisunitname6">
            <tr valign="top">
              <td colspan="2" class="tablecell">&nbsp;</td>
            </tr>
            <tr valign="top">
              <td class="tableheader" colspan="2">Haemodialysis Unit - <bean:write name="unit" property="haemodialysisunitname6"/></td>
            </tr>
            <tr valign="top">               <td class="tablecellbold">Phone</td>               <td class="tablecell"><bean:write name="unit" property="haemodialysisunitphone6"/></td>             </tr>
            <tr valign="top">               <td class="tablecellbold">Location</td>               <td class="tablecell"><bean:write name="unit" property="haemodialysisunitlocation6"/></td>             </tr>
            <tr valign="top">               <td class="tablecellbold">Web Address</td>               <td class="tablecell"><bean:write name="unit" property="haemodialysisuniturl6"/></td>             </tr>
            </logic:notEmpty>

            <logic:notEmpty name="unit" property="haemodialysisunitname7">
            <tr valign="top">
              <td colspan="2" class="tablecell">&nbsp;</td>
            </tr>
            <tr valign="top">
              <td class="tableheader" colspan="2">Haemodialysis Unit - <bean:write name="unit" property="haemodialysisunitname7"/></td>
            </tr>
            <tr valign="top">               <td class="tablecellbold">Phone</td>               <td class="tablecell"><bean:write name="unit" property="haemodialysisunitphone7"/></td>             </tr>
            <tr valign="top">               <td class="tablecellbold">Location</td>               <td class="tablecell"><bean:write name="unit" property="haemodialysisunitlocation7"/></td>             </tr>
            <tr valign="top">               <td class="tablecellbold">Web Address</td>               <td class="tablecell"><bean:write name="unit" property="haemodialysisuniturl7"/></td>             </tr>
            </logic:notEmpty>

            <logic:notEmpty name="unit" property="haemodialysisunitname8">
            <tr valign="top">
              <td colspan="2" class="tablecell">&nbsp;</td>
            </tr>
            <tr valign="top">
              <td class="tableheader" colspan="2">Haemodialysis Unit - <bean:write name="unit" property="haemodialysisunitname8"/></td>
            </tr>
            <tr valign="top">               <td class="tablecellbold">Phone</td>               <td class="tablecell"><bean:write name="unit" property="haemodialysisunitphone8"/></td>             </tr>
            <tr valign="top">               <td class="tablecellbold">Location</td>               <td class="tablecell"><bean:write name="unit" property="haemodialysisunitlocation8"/></td>             </tr>
            <tr valign="top">               <td class="tablecellbold">Web Address</td>               <td class="tablecell"><bean:write name="unit" property="haemodialysisuniturl8"/></td>             </tr>
            </logic:notEmpty>

          </logic:present>

        </table>
</logic:notPresent>

<logic:present name="emailSent">
    <p class="header">Contact</p>

    <p>Your contact form was successfully submitted.</p>
</logic:present>

        <logic:present name="patient">
          <p>
            <logic:notEmpty name="unit" property="unitenquiriesemail">
              <a href="mailto:<bean:write name="unit" property="unitenquiriesemail"/>?subject=[Renal Patient View Enquiry]">Email Renal Unit</a>
            </logic:notEmpty>
          </p>
          <p>
              <a href="mailto:admin@renalpatientview.org?subject=[Renal Patient View Enquiry]">Email Renal PatientView Administrator</a>
          </p>
        </logic:present>
