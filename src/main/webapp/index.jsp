<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8"/>
        <title>Login</title>
    </head>
    <body>
        <h2>Welcome to CoffeePreferenceTracker</h2>
        <form method="POST" action="auth">
            E-mail: <input type="text" name="email"/>
            <br></br>
            Password: <input type="password" name="password"/>
            <br></br>
            <input type="submit" value="Sign Up!"/>
        </form>

        <p><span style="color:red">${error}</span></p>
        Didn't Sign In? You can do it<a href="reg"> here!</a>
    </body>
</html>