<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
</head>
<body>
    <h2>Welcome to registration page!</h2>
    <form action="reg" method="POST">
        First name: <input type="text" name="firstname"/>
        <br></br>
        Last name: <input type="text" name="lastname"/>
        <br></br>
        Age: <input type="number" name="age"/>
        <br></br>
        E-mail: <input type="text" name="email"/>
        <br></br>
        Password: <input type="password" name="password"/>
        <br></br>
        <input type="submit" value="Sign In!"/>
    </form>
    <p><span style="color:red">${error}</span></p>
</body>
</html>