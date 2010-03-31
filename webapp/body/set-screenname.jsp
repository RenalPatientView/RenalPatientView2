<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<p class="header">Set Screen Name</p>

<p>Before you can use the Renal PatientView forum you need to set a screen name that is
    different from your Renal PatientView user name. The screen name is what people will see on the
    forum when you add posts etc. So make it something you are happy to have seen by other users of RPV.</p>

<form action="/setscreenname.do" class="forgotenPassword">
    <label for="screenname">Please enter a screen name.</label>
    <input type="text" name="screenname" id="screenname" />
    <input type="submit" class="formButton"/>
</form>

