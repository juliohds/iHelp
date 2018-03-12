<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html>
<head><title>teste</title>
<%@ include file="importFrame.jsp" %>

<link rel="stylesheet" href="css/projetos.css">

</head>

<body>


<%@ include file="MenuTop.jsp" %>

<div class="fora">
 <div class="container">
        <div class="row">
        <br>
       <div class="gallery col-lg-12 col-md-12 col-sm-12 col-xs-12">
            <h1 style="text-align: center; padding-bottom: 10px; background-color: #333; color: white; padding-top: 5px;">PROJETOS</h1>
        </div> 
		
		<c:forEach var="projeto" items="${lista2}">
			
			<div class="col-md-6" data-toggle="tooltip" title="Para se cadastrar nesse projeto, entre com sua conta e no painel do usuário escolha a opções projetos venha se seus dados são compativeis com a deste projeto	" style="text-align: center; background-color: rgba(255,255,225,0.5);">
               <h2 style="background-color: rgba(0,0,128, 0.8); color: white	"><strong>Nome: </strong>${projeto.nome}</h2>
               <h3><strong>Descrição: </strong>${projeto.descricao}</h3>
               <h4 style="color: red;"><strong> Situação: </strong>${projeto.situacao}</h4>
               <h4><strong>Voluntários: </strong>${projeto.quantidade}</h4>
            </div>			
			
		</c:forEach>
<!--  
        <div align="center">
            <button class="btn btn-default filter-button active" data-filter="all">Todos</button>
            <button class="btn btn-default filter-button" data-filter="hdpe">Saúde, Cultura e Esporte</button>
            <button class="btn btn-default filter-button" data-filter="sprinkle">Educação e Crianças</button>
            <button class="btn btn-default filter-button" data-filter="spray">Meio Ambiente</button>
            <button class="btn btn-default filter-button" data-filter="irrigation">Investimentos</button>
        </div>
   			
   			 
   			
			
            <div class="gallery_product col-lg-4 col-md-4 col-sm-4 col-xs-6 filter hdpe" data-toggle="tooltip" title="Para se cadastrar como voluntário neste projeto, por favor entre na sua conta de usuario e clique na parte de projetos dentro do painel do usuario">
                <img src="http://www.inter7gestao.com.br/wp-content/uploads/2015/12/gestao-de-recursos-inter-7-gestao-estrategica-da-saude-12.png">
            </div>

            <div data-toggle="tooltip" title="Para se cadastrar como voluntário neste projeto, por favor entre na sua conta de usuario e clique na parte de projetos dentro do painel do usuario" class="gallery_product col-lg-4 col-md-4 col-sm-4 col-xs-6 filter sprinkle">
                <img src="http://www.fae.ufmg.br/nepei/wp-content/uploads/2016/06/VI-Encontro-do-Forum-Mineiro-de-Educacao-Infantil-e1465592721178-365x365.jpg"  class="img-responsive">
            </div>

            <div data-toggle="tooltip" title="Para se cadastrar como voluntário neste projeto, por favor entre na sua conta de usuario e clique na parte de projetos dentro do painel do usuario" class="gallery_product col-lg-4 col-md-4 col-sm-4 col-xs-6 filter hdpe">
                <img src="https://guilhermegrandi.files.wordpress.com/2012/11/11-08-conferencia-cultura.jpg?w=365&h=365&crop=1" class="img-responsive">
            </div>

            <div data-toggle="tooltip" title="Para se cadastrar como voluntário neste projeto, por favor entre na sua conta de usuario e clique na parte de projetos dentro do painel do usuario" class="gallery_product col-lg-4 col-md-4 col-sm-4 col-xs-6 filter irrigation">
                <img src="http://noelleweber.com/wp-content/uploads/2016/10/logos.png" class="img-responsive">
            </div>

            <div data-toggle="tooltip" title="Para se cadastrar como voluntário neste projeto, por favor entre na sua conta de usuario e clique na parte de projetos dentro do painel do usuario" class="gallery_product col-lg-4 col-md-4 col-sm-4 col-xs-6 filter spray">
                <img src="http://static.wixstatic.com/media/1236a1_ce294230c4286d56a9b1e5496e89c542.png_srz_365_365_85_22_0.50_1.20_0.00_png_srz" class="img-responsive">
            </div>

            <div data-toggle="tooltip" title="Para se cadastrar como voluntário neste projeto, por favor entre na sua conta de usuario e clique na parte de projetos dentro do painel do usuario" class="gallery_product col-lg-4 col-md-4 col-sm-4 col-xs-6 filter irrigation">
                <img src="http://www.groverlimited.com/new2010/wp-content/uploads/2010/06/teencolorO.png" class="img-responsive">
            </div>

            <div data-toggle="tooltip" title="Para se cadastrar como voluntário neste projeto, por favor entre na sua conta de usuario e clique na parte de projetos dentro do painel do usuario" class="gallery_product col-lg-4 col-md-4 col-sm-4 col-xs-6 filter spray">
                <img src="http://grupomaisfood.com.br/wp-content/uploads/2015/06/sindileite-dia-do-MEIO-AMBIENTE-365x365.jpg" class="img-responsive">
            </div>

            <div data-toggle="tooltip" title="Para se cadastrar como voluntário neste projeto, por favor entre na sua conta de usuario e clique na parte de projetos dentro do painel do usuario" class="gallery_product col-lg-4 col-md-4 col-sm-4 col-xs-6 filter irrigation">
                <img src="http://santuarionacional.cl/wp-content/uploads/2016/08/Logos-03.jpg" class="img-responsive">
            </div>

            <div data-toggle="tooltip" title="Para se cadastrar como voluntário neste projeto, por favor entre na sua conta de usuario e clique na parte de projetos dentro do painel do usuario" class="gallery_product col-lg-4 col-md-4 col-sm-4 col-xs-6 filter sprinkle">
                <img src="http://www.artpensamento.com.br/novo/wordpress/wp-content/uploads/2014/05/sarco+projeto-04-365x365.png" class="img-responsive">
            </div>

            <div data-toggle="tooltip" title="Para se cadastrar como voluntário neste projeto, por favor entre na sua conta de usuario e clique na parte de projetos dentro do painel do usuario" class="gallery_product col-lg-4 col-md-4 col-sm-4 col-xs-6 filter hdpe">
                <img src="http://i1.wp.com/specialolympics.org.br/website/wp-content/uploads/0040-Olimpiadas-Especiais-Facebook-PostPadrao-2000x1414px_aberto.png?resize=365%2C365" class="img-responsive">
            </div>

            <div data-toggle="tooltip" title="Para se cadastrar como voluntário neste projeto, por favor entre na sua conta de usuario e clique na parte de projetos dentro do painel do usuario" class="gallery_product col-lg-4 col-md-4 col-sm-4 col-xs-6 filter spray">
                <img src="http://alunosonline.uol.com.br/upload/conteudo/images/desenvolvimento-sustentavel.jpg" class="img-responsive">
            </div>

            <div data-toggle="tooltip" title="Para se cadastrar como voluntário neste projeto, por favor entre na sua conta de usuario e clique na parte de projetos dentro do painel do usuario" class="gallery_product col-lg-4 col-md-4 col-sm-4 col-xs-6 filter sprinkle">
                <img src="https://mariababona.files.wordpress.com/2016/01/01-2.jpg?w=365&h=365&crop=1" class="img-responsive">
            </div>
             -->
        </div>
    </div>
</div>

<%@ include file="MenuBot.jsp" %>
<script type="text/javascript" src="js/projetos.js"></script>

</body>
</html>