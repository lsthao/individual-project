<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items="${pictures}" var="picture">
    <br>
    <h5>date</h5>
    <div class="img bg-dark">
        <img src="${picture.picture}" width="450" height="400">
        <br>
        <p id="picture-comment">${picture.comment}</p>
        <a class="picture-link" href="/individualproject/individualpicture?ID=${picture.id}">see more...</a>
    </div>
    <br>
</c:forEach>
