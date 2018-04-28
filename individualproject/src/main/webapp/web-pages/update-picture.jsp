<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <title>Food Pictures</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>

    <style>
        .img {
            width: 100%;
            text-align: center;

        }

        img {
            padding: 50px;
        }

        .picture-link {
            padding: 5px;
        }
    </style>
</head>
<body>

<div class="jumbotron text-center" style="margin-bottom:0">
    <h1>Food Pictures</h1>

</div>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <a class="navbar-brand" href="/individualproject">Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="">Sign Out</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container" style="margin-top:30px">

    <div class="row">
        <form method="post" action="updatePicture">
        <div class="col-sm-7">
            <input id="${picture.restaurant.name}" name="${picture.restaurant.name}" value="${picture.restaurant.name}">
            <h5>date</h5>
            <div class="img bg-dark">
                <img src="${picture.picture}" width="70%">
                <textarea id="comment" name="comment" class="form-control" cols="30" rows="10">${picture.comment}</textarea>
            </div>
        </div>
        <div class="col-sm-5">
            <h4>Location:</h4>
            <input id ="${picture.restaurant.location}" name="${picture.restaurant.location}" value="${picture.restaurant.location}">
            <h4>Phone Number:</h4>
            <input id="${picture.restaurant.phoneNumber}" name="${picture.restaurant.phoneNumber}" value="${picture.restaurant.phoneNumber}">
            <hr class="d-sm-none">
        </div>
        </form>
    </div>
</div>

</body>


</html>
