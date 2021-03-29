<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%@include file="components/common_css_js.jsp"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</head>
<body class="bg-light">

	<div class="container mt-4">
		<%@include file="components/header.jsp"%>
	</div>


	<div class="container">
		<%@include file="components/message.jsp"%>
	</div>
	<div class="container">
		<%@include file="components/messageFail.jsp"%>
	</div>

	<div class="container mt-3 mb-5 bg-white border border-4 rounded ">

		<div class="row">
			<div class="col">
				<div class="card mt-5 mb-5">
					<h5 class="card-header">Configuration</h5>
					<div class="card-body">
						<h5 class="card-title">Enter the docker configuration details
							below.</h5>
						<form class="needs-validation" action="configuration" novalidate>
							<div class="form-group">
								<label for="dockerHost">Docker Host:</label> <input type="text"
									class="form-control" name="dockerHost" id="dockerHost"
									aria-describedby="dockerHost"
									placeholder="Enter the Docker host FQDN or I.P Address"
									required>
								<div class="invalid-feedback">This field is required!</div>

							</div>
							<div class="form-group">
								<label for="dockerPort">Docker Port:</label> <input type="text"
									class="form-control" name="dockerPort" id="dockerPort"
									placeholder="Enter the TCP port to communicate with Docker"
									required>
								<div class="invalid-feedback">This field is required!</div>
							</div>
							<div class="form-group">
								<label for="tlsFlag">Enable TLS:</label> <select
									class="form-control" name="tlsFlag" id="tlsFlag">
									<option>true</option>
									<option>false</option>
								</select>
							</div>
							<button type="submit" class="btn btn-primary">Configure</button>
						</form>
					</div>
				</div>
			</div>
			<div class="col">
				<div class="card mt-5 mb-5">
					<h5 class="card-header">Pull An Image</h5>
					<div class="card-body">
						<h5 class="card-title">Please enter the details of the image
							to be pulled</h5>
						<form class="needs-validation" action="imageCreate" novalidate>
							<div class="form-group">
								<label for="imageName">Image Name:</label> <input type="text"
									class="form-control" name="imageName" id="imageName"
									aria-describedby="dockerHost"
									placeholder="Enter the image name" required>
								<div class="invalid-feedback">This field is required!</div>



							</div>
							<div class="form-group">
								<label for="tag">Image Tag:</label> <input type="text"
									class="form-control" name="tag" id="tag"
									placeholder="Enter the tag name for the image">
							</div>
							<button type="submit" class="btn btn-primary">Pull Image</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="container mt-5 mb-5 bg-white border border-4 rounded ">
		<div class="row">
			<div class="col">
				<div class="card mt-5 mb-5">
					<h5 class="card-header">Images</h5>
					<div style="max-height: 250px; overflow-y: scroll;"
						class="card-body">
						<table class="table table-striped table-hover">
							<thead>
								<tr>
									<th scope="col">Image name and Id</th>
								</tr>
							</thead>
							<tbody>

								<c:forEach items="${images}" var="images">
									<tr>

										<td>${images}</td>
									</tr>

								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="col">
				<div class="card mt-5 mb-5">
					<h5 class="card-header">Containers</h5>
					<div style="max-height: 250px; overflow-y: scroll;"
						class="card-body">
						<table class="table table-striped table-hover">
							<thead>
								<tr>
									<th scope="col">Id</th>
									<th scope="col">Command</th>
									<th scope="col">Status</th>
								</tr>
							</thead>
							<tbody>

								<c:forEach items="${containers}" var="containers">
									<tr>
										<c:set var="string1" value="${containers.id}" />
										<td>${fn:substring(string1, 0, 12)}</td>
										<td>${containers.command}</td>
										<td>${containers.status}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="container mt-5 mb-5 bg-white border border-4 rounded ">
		<div class="row">
			<div class="col">
				<div class="card mt-5 mb-5">
					<h5 class="card-header">Create Container</h5>
					<div class="card-body">
						<h5 class="card-title">Please enter the image Id below.</h5>
						<form class="needs-validation" action="createContainer" novalidate>
							<div class="form-group">
								<label for="imageId">Image Id:</label> <input type="text"
									class="form-control" name="imageId" id="imageId"
									aria-describedby="imageId" placeholder="Enter the image name"
									required>
								<div class="invalid-feedback">This field is required!</div>
							</div>

							<button type="submit" class="btn btn-primary">Create</button>
						</form>
					</div>
				</div>
			</div>
			<div class="col">
				<div class="card mt-5 mb-5">
					<h5 class="card-header">Start Container</h5>
					<div class="card-body">
						<h5 class="card-title">Please enter the container Id below.</h5>
						<form class="needs-validation" action="startContainer" novalidate>
							<div class="form-group">
								<label for="containerId">Container Id:</label> <input
									type="text" class="form-control" name="containerId"
									id="containerId" aria-describedby="containerId"
									placeholder="Enter the container Id" required>
								<div class="invalid-feedback">This field is required!</div>
							</div>

							<button type="submit" class="btn btn-primary">Start</button>
						</form>
					</div>
				</div>
			</div>
			<div class="col">
				<div class="card mt-5 mb-5">
					<h5 class="card-header">Stop Container</h5>
					<div class="card-body">
						<h5 class="card-title">Please enter the container Id below.</h5>
						<form class="needs-validation" action="stopContainer" novalidate>
							<div class="form-group">
								<label for="containerId">Container Id:</label> <input
									type="text" class="form-control" name="containerId"
									id="containerId" aria-describedby="containerId"
									placeholder="Enter the container Id" required>
								<div class="invalid-feedback">This field is required!</div>
							</div>

							<button type="submit" class="btn btn-primary">Stop</button>
						</form>
					</div>
				</div>
			</div>
		</div>

	</div>


	<script>
            var forms = document.querySelectorAll('.needs-validation');
            
            Array.prototype.slice.call( forms ).forEach( function( form )
            {
                form.addEventListener( 'submit', function ( event )
                {
                    if ( !form.checkValidity( ) )
                    {
                        event.preventDefault( )
                        event.stopPropagation( );
                    }

                    form.classList.add( 'was-validated' );
              }, false );
            } );
        </script>

</body>
</html>