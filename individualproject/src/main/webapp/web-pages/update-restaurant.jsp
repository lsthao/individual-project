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
            height: 655px;
            text-align: center;

        }

        img {
            padding: 50px;
        }

        #picture-comment {
            color: white;
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
                <a class="nav-link" href="/individualproject/allRestaurants">Restaurants List</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="logout">Sign Out</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container" style="margin-top:30px">
    <div class="row">
        <div class="col-sm-7">


            <div class="img bg-dark text-light">
                <form method="post" action="updateRestaurant">
                    <input type="hidden" value="${restaurant.id}" name="restaurant-id" />
                <h2>Restaurant Name</h2>
                    <input type="text" id="name" name="name" value="${restaurant.name}"/>
                <h4>Location:</h4>
                <input type="text" id="location" name="location" value="${restaurant.location}"/>
                <h4>Phone Number:</h4>
                <input type="text" id="phonenumber" name="location" value="${restaurant.phoneNumber}"/>
                    <input id="submit" type="submit" value="submit changes">
                    <hr class="d-sm-none">
                </form>
            </div>
        </div>
        <div class="col-sm-5">

        </div>
    </div>
</div>

</body>


</html>
