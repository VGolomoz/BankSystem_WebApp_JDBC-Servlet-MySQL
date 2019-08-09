<ul>
    <%
        String name = (String) request.getAttribute("TestName");
        if (name != null) {
             out.println("<li>" + name + "</li>");
            }
    %>
</ul>