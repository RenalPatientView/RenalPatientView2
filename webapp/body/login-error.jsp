<p class="header">Login Failed</p>

<%
  if (request.getAttribute("lockedOut") != null && (Boolean) request.getAttribute("lockedOut")) {
%>


<p>You are currently locked out. Please contact an administrator to be unlocked.</p>
<%
} else {
%>
<p>Your login attempt failed, please try again.</p>
<%
  }
%>