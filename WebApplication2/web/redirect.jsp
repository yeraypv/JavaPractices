<%--
Views should be stored under the WEB-INF folder so that
they are not accessible except through controller process.

This JSP is here to provide a redirect to the dispatcher
servlet but should be the only JSP outside of WEB-INF.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <body>
<%!
    public String recursiva(int veces){
        String s = "";
        if(veces == 7){
            return "";
        }
        else{
            s = "uno";
            return  s + recursiva(veces+1);
        }
    }
    
%>

        <%
            out.println(recursiva(0));
            %>
    </body>
    
</html>