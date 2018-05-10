<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <title>Food Pictures</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.css">

    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.js"></script>
    <script>
        $(document).ready(function() {
            $('#restaurants-table').DataTable();
        } );
    </script>
    <style>
        .img {
            height: 500px;
            width: 450px;
            text-align: center;

        }

        img {
            padding: 30px;
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
        <table id="restaurants-table" class="display" style="width:100%">
            <thead>
                <tr>
                    <td>Restaurant</td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${restaurants}" var="restaurant">
                    <tr>
                        <td>${restaurant.name}</td>
                        <td><a class="picture-link" href="/individualproject/individualrestaurant?ID=${restaurant.id}">Details</a></td>
                        <td><a href="/individualproject/byRestaurant?ID=${restaurant.id}">View Pictures</a></td>
                        <td><form action="deleteRestaurant" method="post"><input type="button" value="delete"></form></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>

</body>


</html>
