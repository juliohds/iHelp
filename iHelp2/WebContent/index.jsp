<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html>
<head><title>iHelp</title>
<%@ include file="importFrame.jsp" %>
</head>

<body>
<%@ include file="MenuTop.jsp" %>

<div class="fora">
<div class="jumbotron">
  <div class="container">
  <h1>Seja um voluntário no iHelp!</h1>
  <p>Ferramenta especializada em encontrar o projeto ideal para você, centenas de voluntários são direcionados a projetos utilizando nossa plataforma, o iHelp encontra o projeto ideal para você de acordo com sua disponibilidade. </p>
  <p><a class="btn btn-primary btn-lg" data-toggle="tooltip" title="Aqui você pode se cadastrar e ser um voluntário iHelp" href="ManterVoluntario.do?acao=Cadastro" role="button">Seja um voluntário >></a></p>
  </div>	
</div>

<div class="container-heading">
      <!-- Example row of columns -->
      <div class="row">
        <div class="col-md-4">
          <h2>Voluntário</h2>
          <p>O objetivo de ser voluntário é ajudar o próximo proporcionando momentos agradáveis e felizes sem fim lucrativos. Quando você ajuda o próximo, está ajudando a si mesmo. </p>
          <p><a class="btn btn-primary" href="ManterVoluntario.do?acao=Cadastro" role="button">Cadastre-se &raquo;</a></p>
        </div>
        <div class="col-md-4">
          <h2>Projeto</h2>
          <p>Nossos projetos são todos regulamentados e certificados de que toda ajuda terá um grande resultado. Todos os mêses novos projetos são cadastrados na plataforma iHelp. Cadastre o seu também </p>
          <p><a class="btn btn-primary" href="projetos.jsp" role="button">Ver projetos &raquo;</a></p>
       </div>
        <div class="col-md-4">
          <h2>Organização Social</h2>
          <p>Um dos principais mantedores dos projetos são nossos parceiros de Organizações sociais, toda ajuda é bem vinda voce sabia que tambem pode contribuir com nossos projetos financeiramente?</p>
          <p><a class="btn btn-primary" href="parceiros.jsp" role="button">Conheça nossos parceiros &raquo;</a></p>
        </div>
      </div>
	</div>
	
</div> <!-- /container --> 
 

<%@ include file="MenuBot.jsp" %>
</body>