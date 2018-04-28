<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="addMessage" scope="session" value="${addSuccessMessage}"/>
<p>${addMessage}</p>
<h2>Submit Picture</h2>
<form action="submitPicture" method="POST" id="picture-form">
    <div class="form-group">
        <label for="picture-url">Picture URL</label>
        <input type="text" class="form-control" id="picture-url" name="picture-url">
    </div>
    <div class="form-group">
        <label for="comment">Comment</label>
        <textarea id="comment" name="comment" class="form-control" cols="30" rows="10"></textarea>
    </div>
    <div class="form-group">
        <label for="restaurant-name">Restaurant Name</label>
        <select id="restaurant-name" name="restaurant-name">
            <c:forEach items="${restaurants}" var="restaurant">
                <option id="${restaurant.name}" name="${restaurant.name}">${restaurant.name}</option>
            </c:forEach>
            <option id="add-new" name="add-new">Add New</option>
        </select>
    </div>

</form>