<!DOCTYPE html>
<%@ page import="java.util.List" %>
<%@ page import="model.Tasting" %>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Your reviews</title>
    </head>
    <body>
    <h2>Here you can read your reviews!</h2>
        <form action="show" method="GET">
            <%
                List<Tasting> tastings = (List<Tasting>)request.getAttribute("tastings");
                if(tastings != null)
                {
                    for(Tasting t : tastings)
                    {
                    %>
                        Coffee id: <%= t.getCoffeeId()%>
                        <br></br>
                        <p><%= t.getReview()%></p>
                    <%
                    }
                }
            %>
        </form>
    </body>
</html>