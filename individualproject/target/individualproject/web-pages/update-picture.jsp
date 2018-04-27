<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


    <title>Food Pictures</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="style.css">
</head>

<body>
<!-- A grey horizontal navbar that becomes vertical on small screens -->
<nav class="navbar navbar-expand-sm bg-dark">
    <!-- Links -->
    <ul class="navbar-nav">
        <a class="navbar-brand" href="/individualproject">Food Pictures</a>
        <li class="nav-item">
            <a class="nav-link" href="#">Sign Out</a>
        </li>

    </ul>
</nav>

<div class="container ">
    <div class="row">
        <div class="col-sm-7">
            <div class="row">
                <div class="col-sm-2">
                    Date
                </div>
                <div class="col-sm-10">
                    <img src="${picture.picture}" width="400px" height="400px">
                </div>
            </div>
            <div class="row">
                <div class="col-sm-2">

                </div>
                <div class="col-sm-10">
                    <p>${picture.comment}</p>
                    <a href="/individualpictures?ID=${picture.id}">Link</a>
                </div>
            </div>

        </div>
        <div class="col-sm-5">second column</div>
    </div>
</div>


<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"/>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js"/>


</body>

</html>