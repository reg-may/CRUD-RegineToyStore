<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <script type="text/javascript">
        function postForm(method){
            var form = document.getElementById('formSearch');
            form.elements["dispatch"].value = method;
            form.submit();
        }

        function updateForm(method){
            var form = document.getElementById('formUpdate');
            form.elements["dispatch"].value = method;
            form.submit();
        }
    </script>
</head>
<body>
    <html:form action="/user" styleId="formSearch">
        <html:hidden property="dispatch" />
        <table>
            <tr>
                <td>User name</td>
                <td><html:text property="name" size="20" /></td>
                <td ><html:button value="Search" property="" onclick="postForm('searchUsers')" /></td>
            </tr>
        </table>
    </html:form>
    
    <br>
 <logic:notEmpty name="users" >
    <table width="21%">
        <tr>
        	<td bgcolor="#FF9900">ID</td>
            <td bgcolor="#FF9900">Name</td>
            <td bgcolor="#FF9900">Age</td>
        </tr>
        <logic:iterate name="users" id="user">
          <html:form action="/user" styleId="formUpdate">
          <html:hidden property="dispatch" />
            <tr> 
                <td bgcolor="#DBEAF9"><html:text  indexed="true" name="user" property="id" /></td>
                <td bgcolor="#DBEAF9"><html:text  indexed="true" name="user" property="name" /></td>
                <td bgcolor="#DBEAF9"><html:text  indexed="true" name="user" property="age" /></td>
                <td ><html:button value="Update" property="" onclick="updateForm('updateUser')" /></td>
            </tr>
           </html:form>
        </logic:iterate>
    </table>
    </logic:notEmpty>
        
    <br><br>
    <html:link href="${pageContext.request.contextPath}/"> Home </html:link>
</body>
</html>