<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/datetime" prefix="dt" %>

<p class="header">Login Successful</p>

<p><b>This is a confidential record.</b></p>
<p>If you should not be reading it please <html:link action="logout">log out</html:link> now.</p>


<dl>

  <%
    if (request.getAttribute("lastLogin") != null) {
  %>
  <dt>Last login recorded</dt>
  <dd><%=request.getAttribute("lastLogin")%>
  </dd>
  <%
    }
  %>

  <%
    if (request.getAttribute("lastDataDate") != null) {
  %>
  <dt>Last data received for this record</dt>
  <dd>On <%=request.getAttribute("lastDataDate")%>
    <%
      if (request.getAttribute("lastDataFrom") != null) {
    %>
    from <%=request.getAttribute("lastDataFrom")%>
    <%
      }
    %>
  </dd>
  <%
    }
  %>
</dl>


<%
  if (request.getAttribute("isPatient") != null) {
%>
<p><b><a href="patient/patient_details.do">Continue</a></b></p>
<%
} else {
%>
<p><b><a href="control/index.jsp">Continue</a></b></p>
<%
  }
%>


<h2>Safe passwords</h2>

<p>Simple words or numbers are easy for machines or people to guess. Avoiding this is particularly important for
  passwords. Here are some simple ways to make it more difficult.</p>

<ol>
  <li>Do not share your password. The correct way to show someone else a patient's data is for the patient to share
    their password.
  </li>
  <li>Don't make your password easy to guess, so not less than 6 characters and not 123456 or 777777, and certainly
    don't use
    "password"! It is safer to avoid other simple words (e.g. daffodil) too.
  </li>
  <li>Using a mixture of numbers and letters makes it much safer, e.g. daff271odil (daffodil 271)</li>
  <li>Using a mixture of capitals and ordinary letters is even better, e.g. dAff271oDil - this would be a very
    difficult password to guess, and not impossible to remember.
  </li>
  <li>Changing your password from time to time is wise. Certainly do that if you think that someone else may know
    yours.
  </li>
  <li>Most systems, including RPV, allow just letters and numbers in passwords, not spaces or special characters or
    punctuation such as ! - &pound; @ _ -,.
  </li>
</ol>


