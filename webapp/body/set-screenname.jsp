<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<p class="header">Set Screen Name</p>

<form action="/setscreenname.do" class="forgotenPassword">
    <label for="screenname">Please enter a screen name in the field below</label>
    <input type="text" name="screenname" id="screenname" />
    <input type="submit" class="formButton"/>
</form>

