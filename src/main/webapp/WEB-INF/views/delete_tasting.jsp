<!DOCTYPE html>
<%@ page import="java.util.List" %>
<%@ page import="model.Tasting" %>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Delete tasting</title>
    </head>
    <body>
        <form action="del" method="DELETE">
            <label for="tastingid">Choose review<label/>
            <select id="tastingid" name="tastingid">
                <%
                List<Tasting> tastings = (List<Tasting>)request.getAttribute("tastings");
                if(tastings != null)
                {
                    for(Tasting t : tastings)
                    {
                    %>
                        <option value=<%= t.getId()%>>
                            <%= t.getReview()%>
                        </option>
                    <%
                    }
                }
                %>
            </select>
            <input type="submit" value="Delete!"/>
        </form>
    </body>
</html>