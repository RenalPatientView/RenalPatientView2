<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<tiles:insert definition="control.layout" flush="true" >

    <tiles:put name="left_nav" value="/common/left_nav_login.jsp" />

    <tiles:put name="body" value="/body/control/index.jsp" />

</tiles:insert>