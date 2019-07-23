<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
    
        <title>Home page</title>
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        
    </head>
    <body>
   
     <div class="container">
   
        <h3>Product list</h3>
         <c:if test="${SUCCESS_MESSAGE != null}">
  <div class="alert alert-success" id="status_message">${SUCCESS_MESSAGE}</div>
</c:if> 
 <c:if test="${WARNING_MESSAGE != null}">
  <div class="alert alert-warning" id="status_message">${WARNING_MESSAGE}</div>
</c:if> 
        <form:form method="POST" modelAttribute="products">
       <input class="btn btn-danger" type="submit" name="submit" value="Remove checked">
           <input class="btn btn-primary" type= "button" onclick="window.location.href='/add?productId=0'" value="Add product"/>
             <table class="table table-striped">
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
			<td><input type="checkbox" name="checkboxName" autocomplete="off" value="${product.id}"/></td>
			<td>${product.name}</td>
			<td>${product.price}</td>
			<td> <a class="btn btn-primary" href="${updateLink}">update</a></td>
		</tr>
	</c:forEach>
	</table>
	</form:form>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>