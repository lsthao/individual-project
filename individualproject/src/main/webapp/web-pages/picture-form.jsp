<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Submit Picture</h2>
<form id="picture-form">
    <div class="form-group">
        <label for="picture-url">Picture URL</label>
        <input type="text" class="form-control" id="picture-url">
    </div>
    <div class="form-group">
        <label for="picture-url">Comment</label>
        <textarea id="comment" class="form-control" cols="30" rows="10"></textarea>
    </div>
    <div class="form-group">
        <label for="restaurant">Restaurant</label>
        <input type="text" class="form-control" id="restaurant">
    </div>
    <select id="restaurant-name">
        <c:forEach items="${restaurants}" var="restaurant">
            <option id="${restaurant.id}">${restaurant.name}</option>
        </c:forEach>
        <option id="add-new}">Add New</option>
    </select>

</form>