<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<html:xhtml/>

<div>
    <!-- Who needs CSS... -->
    <div style="width:345px; float: left;">
        <h2>K</h2>
        <div id="k-plot" style="width:340px; height:180px; float: left;">
            <h2 class="plot-placeholder">Loading...</h2>
        </div>
    </div>
    <div style="width:345px; float: left;">
        <h2>PO4</h2>
        <div id="po-plot" style="width:340px; height:180px; float: left;">
            <h2 class="plot-placeholder">Loading...</h2>
        </div>
    </div>
</div>
<script>
    $(function () {
        $(".plot-placeholder").remove();

        var k_raw = [];
        var po_raw = [];
        $(".result_row").each(function () {
            var formatted_timestamp = $(this).find(".formatted_timestamp > b").html();
            //alert(formatted_timestamp);
            // I'm so sorry for this...
            var split_timestamp = formatted_timestamp.split(" ");
            var split_date = split_timestamp[0].split("/");
            var date_string = "20" + split_date[2] + " " + split_date[1] + " " + split_date[0];

            // Sick hack
            var k_val = $(this).find("td:nth-child(5)").html();
            var po_val = $(this).find("td:nth-child(8)").html();

            var timestamp = new Date(date_string).getTime();

            if (k_val) {
                k_raw.push([timestamp, k_val]);
                //alert(k_raw);
            }
            if (po_val) {
                po_raw.push([timestamp, po_val]);
                //alert(po_raw);
            }
        });

        var k_data = [{data: k_raw}];
        //alert(JSON.stringify(k_data));
        var po_data = [{data: po_raw}];
        //alert(JSON.stringify(po_data));
        var options = {
            xaxis: {mode: "time"},
            legend: {show: false},
            series: {
                lines: {show: true},
                points: {show: true}
            }
        };
        $.plot($("#k-plot"), k_data, options);
        $.plot($("#po-plot"), po_data, options);
    });
</script>

<table width="690" border="0" cellspacing="1" cellpadding="3">
      <tr valign="top">
        <td colspan="12" align="left">
            <div id="resultsPanelsLabel">
                Result panels :
                &nbsp;
                <logic:equal value="" name="panelNav" property="previousPanel">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </logic:equal>
                <logic:notEqual value="" name="panelNav" property="previousPanel">
                    <html:link action="/patient/results"  paramId="panel" paramName="panelNav" paramProperty="firstPanel" styleClass="paginate">|&lt;</html:link>
                    &nbsp;
                    <html:link action="/patient/results"  paramId="panel" paramName="panelNav" paramProperty="previousPanel" styleClass="paginate">&lt;</html:link>
                    &nbsp;
                </logic:notEqual>
            </div>
            <ul class="resultsPanels">
            <logic:iterate id="panel" name="panelNav" property="panels"  >
                <logic:equal value="true" name="panel" property="currentPanel">
                    <li><bean:write name="panel" property="panel" /></li>
                </logic:equal>
                <logic:notEqual value="true" name="panel" property="currentPanel">
                    <li>
                        <html:link action="/patient/results"  paramId="panel" paramName="panel" paramProperty="panel"><bean:write name="panel" property="panel" />
                        <span class="hover">
                            <logic:iterate name="panel" property="resultHeadings" id="heading" type="com.worthsoln.patientview.resultheading.ResultHeading" >
                                <%= heading.getHeadingcode() %>
                            </logic:iterate>
                        </span>
                        </html:link>
                    </li>
                </logic:notEqual>
            </logic:iterate>
            </ul>
            <div class="pagination">
                &nbsp;
                <logic:equal value="" name="panelNav" property="nextPanel">
                    &nbsp;&nbsp;&nbsp;
                </logic:equal>
                <logic:notEqual value="" name="panelNav" property="nextPanel">
                    <html:link action="/patient/results"  paramId="panel" paramName="panelNav" paramProperty="nextPanel" styleClass="paginate"><strong>More results</strong></html:link>
                    &nbsp;
                    <html:link action="/patient/results"  paramId="panel" paramName="panelNav" paramProperty="lastPanel" styleClass="paginate">&gt;|</html:link>
                </logic:notEqual>
                &nbsp;
            </div>
        </td>
      </tr>
</table>

<table width="600" border="0" cellspacing="1" cellpadding="3">
          <%--
  <tr valign="top">
    <td colspan="10"><img src="images/space.gif"/></td>
  </tr>
            --%>
  <logic:empty name="results">
    <tr valign="top">
      <td class="tableheader" colspan="10">No results uploaded</td>
    </tr>
  </logic:empty>

  <logic:notEmpty name="results">

    <logic:present name="user">

      <tr valign="top">
        <td class="tableheader" colspan="14"><b>Test results for <bean:write name="user" property="name"/></b></td>
      </tr>

      <tr>
        <td width="" class="tablecellbold"><b>Date and time</b></td>
          <td width="" class="tablecell">Label</td>
            <logic:iterate name="resultsHeadings" id="heading">
              <td width="" class="tablecell"><a href="<bean:write name="heading" property="link"/>" target="_blank" title="<bean:write name="heading" property="rollover"/>"><bean:write name="heading" property="heading"/></a></td>
            </logic:iterate>
          <td width="" class="tablecellbold">Source</td>
      </tr>

      <logic:iterate name="results" id="result" type="com.worthsoln.patientview.Result" length="resultsPerPage" offset="resultsOffset" >
        <tr class="result_row">
          <td width="" class="tablecellbold formatted_timestamp"><b><bean:write name="result" property="formattedTimeStamp"/></b></td>
          <td width="" class="tablecellbold"><bean:write name="result" property="prepost"/></td>
            <logic:iterate name="resultsHeadings" id="heading" type="com.worthsoln.patientview.resultheading.ResultHeading" >
              <bean:define id="content" value="<%= result.getValue(heading.getHeadingcode()) %>" />

              <logic:empty name="content">
                <td width="" class="tablecell"></td>
              </logic:empty>

              <logic:notEmpty name="content">
                <logic:equal value="resultcomment" name="heading" property="headingcode">
                  <td width="" class="tablecell"> <html:link action="/patient/patientEnteredCommentDisplay" paramId="commentId" paramName="content" >read...</html:link> </td>
                </logic:equal>

                <logic:notEqual value="resultcomment" name="heading" property="headingcode">
                  <td width="" class="tablecell"><bean:write name="content"/></td>
                </logic:notEqual>
              </logic:notEmpty>

            </logic:iterate>
          <td width="" class="tablecellbold"><bean:write name="result" property="shortname"/></td>
        </tr>
      </logic:iterate>

    </logic:present>

  </logic:notEmpty>

</table>
<table width="600" border="0" cellspacing="1" cellpadding="3">
      <tr valign="top">
        <td align="right">
          More results :
                &nbsp;
                <logic:equal value="" name="pageNav" property="previousPanel">
                   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </logic:equal>
                <logic:notEqual value="" name="pageNav" property="previousPanel">
                   <a href='results.do?panel=<%= request.getParameter("panel")%>&page=<bean:write name="pageNav" property="firstPanel" />' class="paginate">|&lt;</a>
                   &nbsp;
                   <a href='results.do?panel=<%= request.getParameter("panel")%>&page=<bean:write name="pageNav" property="previousPanel" />' class="paginate">&lt;</a>
                   &nbsp;
                </logic:notEqual>

          <logic:iterate id="pag" name="pages">
            <logic:equal value="true" name="pag" property="currentPanel">
              <bean:write name="pag" property="panel" />&nbsp;
            </logic:equal>
            <logic:notEqual value="true" name="pag" property="currentPanel">
              <a href='results.do?panel=<%= request.getParameter("panel")%>&page=<bean:write name="pag" property="panel" />'><bean:write name="pag" property="panel" /></a>&nbsp;
            </logic:notEqual>
          </logic:iterate>

                &nbsp;
                <logic:equal value="" name="pageNav" property="nextPanel">
                   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </logic:equal>
                <logic:notEqual value="" name="pageNav" property="nextPanel">
                   <a href='results.do?panel=<%= request.getParameter("panel")%>&page=<bean:write name="pageNav" property="nextPanel" />' class="paginate">&gt;</a>
                   &nbsp;
                   <a href='results.do?panel=<%= request.getParameter("panel")%>&page=<bean:write name="pageNav" property="lastPanel" />' class="paginate">&gt;|</a>
                   &nbsp;
                </logic:notEqual>
        </td>
      </tr>
</table>

