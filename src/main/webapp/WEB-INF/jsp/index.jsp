<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
    <style>
    	.error {color:red}
    	.mytext {width: 200px; height: 100px;}
    </style>
        <title>Home page</title>
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
    <input type= "button" onclick="window.location.href='/add?productId=0'" value="Add product"/>
        <h3>Welcome, Enter Contact Details</h3>
        <form:form method="POST" modelAttribute="products">
       <input type="submit" name="submit" value="Usuń zaznaczone">
          
             <table>
	<tr>
		<th>checkbox</th>
		<th>Name</th>
		<th>price</th>
		<th>Edit</th>
	</tr>
	<c:forEach items="${products}" var="product" >
	
	
	<c:url var="updateLink" value="/add">
		<c:param name="productId" value="${product.id}"/>
		</c:url>
		<tr>
			<td><input type="checkbox" name="checkboxName" value="${product.id}"/></td>
			<td>${product.name}</td>
			<td>${product.price}"</td>
			<td> <a href="${updateLink}">update</a></td>
		</tr>
	</c:forEach>
	</table>
	</form:form>
    </body>
</html>