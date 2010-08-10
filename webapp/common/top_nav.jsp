<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

  <tr>
        <td colspan="2" bgcolor="#CFE6FC">
          <table border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td class="navcell-empty"><font class="navlink">&nbsp;</font></td>

              <td class="navcell"><html:link action="/index" styleClass="<%= ("index".equals(request.getAttribute("currentNav"))) ? "navlinkon" : "navlink" %>">Home</html:link></td>

              <td class="navcell"><html:link action="/patient/patient_details" styleClass="<%= ("patient_details".equals(request.getAttribute("currentNav"))) ? "navlinkon" : "navlink" %>">Patient Details</html:link></td>

              <td class="navcell"><html:link action="/patient/patient_view" styleClass="<%= ("patient_view".equals(request.getAttribute("currentNav"))) ? "navlinkon" : "navlink" %>">Patient Info</html:link></td>
<%--
              <td class="navcell"><html:link action="/patient/medical_view" styleClass="<%= ("medical_view".equals(request.getAttribute("currentNav"))) ? "navlinkon" : "navlink" %>">Medical Info</html:link></td>
--%>
              <td class="navcell"><html:link action="/patient/patient_entry" styleClass="<%= ("patient_entry".equals(request.getAttribute("currentNav"))) ? "navlinkon" : "navlink" %>">Enter My...</html:link></td>

              <td class="navcell"><html:link action="/patient/results" styleClass="<%= ("results".equals(request.getAttribute("currentNav"))) ? "navlinkon" : "navlink" %>">Results</html:link></td>

              <td class="navcell"><html:link action="/patient/medicines" styleClass="<%= ("medicines".equals(request.getAttribute("currentNav"))) ? "navlinkon" : "navlink" %>">Medicines</html:link></td>

              <td class="navcell"><html:link action="/patient/letters" styleClass="<%= ("letters".equals(request.getAttribute("currentNav"))) ? "navlinkon" : "navlink" %>">Letters</html:link></td>

              <td class="navcell"><html:link action="/patient/contact" styleClass="<%= ("contact".equals(request.getAttribute("currentNav"))) ? "navlinkon" : "navlink" %>">Contact</html:link></td>

              <td class="navcell"><html:link href="/forums/list.page" styleClass="<%= ("xxxxxxx".equals(request.getAttribute("currentNav"))) ? "navlinkon" : "navlink" %>">Forum</html:link></td>

              <td class="navcell-right"><html:link action="/help" styleClass="<%= ("help".equals(request.getAttribute("currentNav"))) ? "navlinkon" : "navlink" %>">Help</html:link></td>

              <td class="navcell-empty"><font class="navlink">&nbsp;</font></td>
            </tr>
          </table>
        </td>
      </tr>
