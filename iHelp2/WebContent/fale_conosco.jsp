<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html>
<head><title>teste</title>
<%@ include file="importFrame.jsp" %>

	<link href="css/faleconosco.css" rel="stylesheet">
	
</head>

<body>
<%@ include file="MenuTop.jsp" %>
  
<section id="contact">
			<!-- <div class="section-content">
				<h1 class="section-header">Ei, psiu! <span class="content-header wow fadeIn " data-wow-delay="0.2s" data-wow-duration="2s"> Fala com a gente!</span></h1>
				<h3>Restou alguma dúvida?, tem uma sugestão ou reclamação? Deixa aqui o seu recado.</h3>
			</div>-->
			<div class="contact-section">
			<div class="container">
				<form>
					<div class="col-md-6 form-line">
			  			<div class="form-group">
			  				<label for="exampleInputUsername">Nome</label>
					    	<input type="text" class="form-control" id="" placeholder=" Digite seu nome aqui!">
				  		</div>
				  		<div class="form-group">
					    	<label for="exampleInputEmail">E-mail</label>
					    	<input type="email" class="form-control" id="exampleInputEmail" placeholder=" Digite seu email">
					  	</div>	
					  	
			  		</div>
			  		<div class="col-md-6">
			  			<div class="form-group">
			  				<label for ="description"> Mensagem</label>
			  			 	<textarea  class="form-control" id="description" placeholder="Digite sua Mensagem "></textarea>
			  			</div>
			  			<div>

			  				<button type="button" class="btn btn-default submit"><i class="fa fa-paper-plane" aria-hidden="true"></i>  Enviar </button>
			  			</div>
			  			
					</div>
				</form>
			</div>
			</div>
		</section>

</body>
</html>