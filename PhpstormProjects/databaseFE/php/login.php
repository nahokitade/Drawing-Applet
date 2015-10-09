<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="dbstyle.css">

<title>Add Student</title>
</head>

<body>
<div id="wrapper">
<header>
    <form id="login">
        <h1>Log In</h1>
        <fieldset id="inputs">
            <input id="username" type="text" placeholder="Username" autofocus required>
            <input id="password" type="password" placeholder="Password" required>
        </fieldset>
        <fieldset id="actions">
            <input type="submit" id="submit" value="Log in">
        </fieldset>
    </form>
<header>

<?php

       include 'sunapeedb.php';
       $db = new SunapeeDB();
       $db->connect();

       if(!$db->insert_student($_GET["id"], $_GET["name"], $_GET["dept"], $_GET["credits"]))
       {
           print("Could not add student");
       } else { print("One student added."); }

       $db->disconnect();
?>
</div>
</body>
</html>
