<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<tiles:insert definition="patient.layout" flush="true" >

    <tiles:put name="left_nav" value="/body/common/left_nav_empty.jsp" />

    <tiles:put name="body" value="/body/patient/patient_view.jsp" />

</tiles:insert>