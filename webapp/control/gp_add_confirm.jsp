<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<tiles:insert definition="control.layout" flush="true" >

    <tiles:put name="info_strip" value="/common/control/info_strip_no_login.jsp" />
    <tiles:put name="body" value="/body/control/gp_add_confirm.jsp" />

</tiles:insert>