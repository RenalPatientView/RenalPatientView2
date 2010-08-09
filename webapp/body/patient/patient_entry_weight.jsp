<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<html:xhtml/>

<p class="header">Enter My Weight</p>


<p>Use this page to enter values from home or from your GP surgery, for example. Important: these results will not be automatically sent to anyone at your renal unit. If you need advice, you must contact them in the usual way.</p>


<html:errors/>



  <table cellpadding="3" >

    <tr>
      <td class="tableheader" align="center">Date</td>
      <td class="tableheader" align="center">Time</td>
      <td class="tableheader" align="center">Weight (kg)</td>
    </tr>

    <logic:present name="weights" scope="session">
        <logic:iterate name="weights" id="weight">
             <tr>
                 <td class="tablecell" align="center"><bean:write name="weight" property="value.stringDate" /></td>
                 <td class="tablecell" align="center"><bean:write name="weight" property="value.stringTime" /></td>
                 <td class="tablecell" align="center"><bean:write name="weight" property="value.weight" /></td>
                 <html:form action="/patient/patientDeletesWeight">
                      <input type="hidden" name="weightkey" value='<bean:write name="weight" property="key" />' />
                  <td align="center" valign="center"><html:submit value="Delete" styleClass="formButton" /></td>
                 </html:form>
             </tr>
        </logic:iterate>
    </logic:present>

<html:form action="/patient/patientAddsWeight">

    <tr>
        <td class="tablecell" align="center">
            <html:select property="day">
                <html:option value=""></html:option>
                <html:option value="1">1</html:option>
                <html:option value="2">2</html:option>
                <html:option value="3">3</html:option>
                <html:option value="4">4</html:option>
                <html:option value="5">5</html:option>
                <html:option value="6">6</html:option>
                <html:option value="7">7</html:option>
                <html:option value="8">8</html:option>
                <html:option value="9">9</html:option>
                <html:option value="10">10</html:option>
                <html:option value="11">11</html:option>
                <html:option value="12">12</html:option>
                <html:option value="13">13</html:option>
                <html:option value="14">14</html:option>
                <html:option value="15">15</html:option>
                <html:option value="16">16</html:option>
                <html:option value="17">17</html:option>
                <html:option value="18">18</html:option>
                <html:option value="19">19</html:option>
                <html:option value="20">20</html:option>
                <html:option value="21">21</html:option>
                <html:option value="22">22</html:option>
                <html:option value="23">23</html:option>
                <html:option value="24">24</html:option>
                <html:option value="25">25</html:option>
                <html:option value="26">26</html:option>
                <html:option value="27">27</html:option>
                <html:option value="28">28</html:option>
                <html:option value="29">29</html:option>
                <html:option value="30">30</html:option>
                <html:option value="31">31</html:option>
            </html:select>
            -
            <html:select property="month">
                <html:option value=""></html:option>
                <html:option value="0">Jan</html:option>
                <html:option value="1">Feb</html:option>
                <html:option value="2">Mar</html:option>
                <html:option value="3">Apr</html:option>
                <html:option value="4">May</html:option>
                <html:option value="5">Jun</html:option>
                <html:option value="6">Jul</html:option>
                <html:option value="7">Aug</html:option>
                <html:option value="8">Sep</html:option>
                <html:option value="9">Oct</html:option>
                <html:option value="10">Nov</html:option>
                <html:option value="11">Dec</html:option>
            </html:select>
            -
            <html:select property="year">
                <html:option value=""></html:option>
                <html:option value="2009">2009</html:option>
                <html:option value="2010">2010</html:option>
            </html:select>
        </td>
        <td class="tablecell" align="center">
            <html:select property="hour">
                <html:option value=""></html:option>
                <html:option value="0">00</html:option>
                <html:option value="1">01</html:option>
                <html:option value="2">02</html:option>
                <html:option value="3">03</html:option>
                <html:option value="4">04</html:option>
                <html:option value="5">05</html:option>
                <html:option value="6">06</html:option>
                <html:option value="7">07</html:option>
                <html:option value="8">08</html:option>
                <html:option value="9">09</html:option>
                <html:option value="10">10</html:option>
                <html:option value="11">11</html:option>
                <html:option value="12">12</html:option>
                <html:option value="13">13</html:option>
                <html:option value="14">14</html:option>
                <html:option value="15">15</html:option>
                <html:option value="16">16</html:option>
                <html:option value="17">17</html:option>
                <html:option value="18">18</html:option>
                <html:option value="19">19</html:option>
                <html:option value="20">20</html:option>
                <html:option value="21">21</html:option>
                <html:option value="22">22</html:option>
                <html:option value="23">23</html:option>
            </html:select>
            :
            <html:select property="minute">
                <html:option value=""></html:option>
                <html:option value="0">00</html:option>
                <html:option value="10">10</html:option>
                <html:option value="20">20</html:option>
                <html:option value="30">30</html:option>
                <html:option value="40">40</html:option>
                <html:option value="50">50</html:option>
            </html:select>
        </td>
        <td class="tablecell" align="center">
            <html:text property="weight" size="3"/>
        </td>
      <td align="right" colspan="4"><html:submit value="Add" styleClass="formButton"/></td>
    </tr>
</html:form>

    <logic:present name="weights" scope="session">
      <logic:notEmpty name="weights" scope="session">
        <tr>
          <td>&nbsp;</td>  
        </tr>
        <tr>
          <td colspan="4">By pressing the Submit All button you will add these weight values to your record. After clicking, you will not be able to make any more changes. Use the Delete and Add buttons above to ensure that you are happy before clicking the Submit All button.</td>
        </tr>
        <tr>
          <html:form action="/patient/patientSubmitsWeights">
            <td><html:submit value="Submit All" styleClass="formButton"/></td>
          </html:form>
        </tr>
      </logic:notEmpty>
    </logic:present>

  </table>



