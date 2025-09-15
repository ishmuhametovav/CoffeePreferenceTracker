<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Add coffee info</title>
    </head>
    <body>
        <h2>Here you can add information about coffee!</h2>
        <form action="coffees" method="POST">
            Coffee name: <input type="text" name="name"/>
            <br></br>
            <label for="origin">Origin: </label>
            <select id="origin" name="origin">
                <option value="ethiopia">Ethiopia</option>
                <option value="kenya">Kenya</option>
                <option value="colombia">Colombia</option>
                <option value="brazil">Brazil</option>
            </select>
            <br></br>
            <label for="variety">Variety: </label>
            <select id="variety" name="variety">
                <option value="typica">Typica</option>
                <option value="bourbon">Bourbon</option>
                <option value="caturra">Caturra</option>
                <option value="catuai">Catuai</option>
                <option value="pacamara">Pacamara</option>
            </select>
            <br></br>
            <label for="processing">Processing: </label>
            <select id="processing" name="processing">
                <option value="washed">washed</option>
                <option value="natural">natural</option>
                <option value="honey">honey</option>
            </select>
            <br></br>
            <label for="roastlevel">Roast Level: </label>
            <select id="roastlevel" name="roastlevel">
                <option value="light">light</option>
                <option value="medium">medium</option>
                <option value="dark">dark</option>
            </select>
            <p>${error}</p>
            <input type="submit" value="Add coffee to list!"/>
        </form>
    </body>
</html>