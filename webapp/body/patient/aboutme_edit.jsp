<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/datetime" prefix="dt" %>

<html:xhtml/>

<p class="header">About Me</p>

<html:errors/>


<table cellpadding="3" >

<html:form action="/patient/aboutmeUpdate">

    <logic:notEmpty name="aboutme">
        <html:hidden name="aboutme" property="id"/>
    </logic:notEmpty>

    <html:hidden name="patient" property="nhsno" />

    <tr>
        <td align="center" >
            <p><b>Things people should know about me</b><br />(For example...)</p>
        </td>
    </tr>
    <tr>
        <td >
            <logic:empty name="aboutme">
                <html:textarea property="aboutme" rows="5" cols="40"/>
            </logic:empty>

            <logic:notEmpty name="aboutme">
                <html:textarea name="aboutme" property="aboutme" rows="5" cols="40"/>
            </logic:notEmpty>
        </td>
    </tr>
    <tr>
        <td >&nbsp;</td>
    </tr>

    <tr>
        <td >
            <p><b>Things I'd like to talk about</b><br />
                (For example... what should my blood pressure be, home dialysis, stopping dialysis, getting a transplant)</p>
        </td>
    </tr>
    <tr>
        <td >
            <logic:empty name="aboutme">
                <html:textarea property="talkabout" rows="5" cols="40"/>
            </logic:empty>

            <logic:notEmpty name="aboutme">
                <html:textarea name="aboutme" property="talkabout" rows="5" cols="40"/>
            </logic:notEmpty>
        </td>
    </tr>
    <tr>
        <td >&nbsp;</td>
    </tr>

    <tr>
        <td align="left">
             <html:submit value="Update" styleClass="formButton"/>
        </td>
    </tr>

</html:form>

</table>



