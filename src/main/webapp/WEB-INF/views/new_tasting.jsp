<!DOCTYPE html>
<%@ page import="java.util.List" %>
<%@ page import="model.Coffee" %>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>New tasting</title>
    </head>
    <body>
        <form action="new" method="POST">
            <label for="coffee">Choose coffee you have tasted</label>
            <select id="coffee" name="coffee">
                <%
                List<Coffee> coffeeList = (List<Coffee>) request.getAttribute("coffees");

                if (coffeeList != null)
                {
                    for (Coffee coffee : coffeeList)
                    {
                %>
                        <option value=<%= coffee.getName() %>>
                        <%= coffee.getName() %>
                        </option>
                <%
                    }
                }
                %>
            </select>
            <p>Choose grade</p>
            <input type="radio" name="grade" value="d"/>D
            <input type="radio" name="grade" value="c"/>C
            <input type="radio" name="grade" value="b"/>B
            <input type="radio" name="grade" value="a"/>A
            <input type="radio" name="grade" value="s"/>S
            <p>Write your review</p>
            <input type="text" name="review"/>
            <br></br>
            <input type="submit" value="Send review!"/>
        </form>
    </body>
</html>