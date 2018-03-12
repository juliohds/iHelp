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


<!-- 
<div class="container-fluid" style="padding:20px 10px; background-color: rgba(255,255,255, .8);">
    <h1 style="text-align: center; font-family: 'Merriweather'; color: #0080ff">Nossos Parceiros</h1>
<div class="container">
    	<div id="carousel">
	
			<figure><img src="https://catracalivre.com.br/wp-content/uploads/2015/10/imagens-3D_11.gif" alt="" width="100%" height="40%" title="teste"></figure>
			<figure><img src="https://catracalivre.com.br/wp-content/uploads/2015/10/imagens-3D_11.gif" alt="" width="100%" height="40%" title="teste"></figure>
			<figure><img src="https://catracalivre.com.br/wp-content/uploads/2015/10/imagens-3D_11.gif" alt="" width="100%" height="40%" title="teste"></figure>
			<figure><img src="https://catracalivre.com.br/wp-content/uploads/2015/10/imagens-3D_11.gif" alt="" width="100%" height="50%" title="teste"></figure>
			<figure><img src="https://catracalivre.com.br/wp-content/uploads/2015/10/imagens-3D_11.gif" alt="" width="100%" height="35%" title="teste"></figure>
			<figure><img src="https://catracalivre.com.br/wp-content/uploads/2015/10/imagens-3D_11.gif" alt="" width="100%" height="50%" title="teste"></figure>
			<figure><img src="https://catracalivre.com.br/wp-content/uploads/2015/10/imagens-3D_11.gif" alt="" width="100%" height="40%" title="teste"></figure>
			<figure><img src="https://catracalivre.com.br/wp-content/uploads/2015/10/imagens-3D_11.gif" alt="" width="100%" height="50%" title="teste"></figure>
			<figure><img src="https://catracalivre.com.br/wp-content/uploads/2015/10/imagens-3D_11.gif" alt="" width="100%" height="50%"></figure>
			
		</div>
	</div>    
    
    
</div>
-->
<div class="fora">
 <div class="container">
        <div class="row">
        <br>
        
        <div class="gallery col-lg-12 col-md-12 col-sm-12 col-xs-12">
            <h1 style="text-align: center; padding-bottom: 10px; background-color: #333; color: white; padding-top: 5px;"><i class="fa fa-ravelry" aria-hidden="true"></i> Organizações cadastradas na iHelp </h1>
        </div>  
<!--
        <div align="center">
            <button class="btn btn-default filter-button active" data-filter="all">Todos</button>
            <button class="btn btn-default filter-button" data-filter="hdpe">Saúde, Cultura e Esporte</button>
            <button class="btn btn-default filter-button" data-filter="sprinkle">Educação e Crianças</button>
            <button class="btn btn-default filter-button" data-filter="spray">Meio Ambiente</button>
            <button class="btn btn-default filter-button" data-filter="irrigation">Investimentos</button>
        </div>
        <br/>-->
        
			<c:forEach var="OS" items="${lista}">
			
			<div class="col-md-6" style="text-align: center; background-color: rgba(255,255,225,0.5);">
               <h2 style="background-color: rgba(0,0,128, 0.8); color: white	"><strong>Organização: </strong>${OS.nome}</h2>
               <h3><strong>Nome Fantasia: </strong>${OS.nome_fantasia}</h3>
               <h4><strong>Email: </strong>${OS.email}</h4><h4 style="color: red;"><strong>Data de Inicio: </strong>${OS.data_inicio}</h4>
            </div>			
			
			</c:forEach>
			
			<!-- 
			<div class="gallery_product col-lg-4 col-md-4 col-sm-4 col-xs-6 filter sprinkle">
                <img src="http://1.bp.blogspot.com/_AcBUSVxs82w/TS2A0IBYmwI/AAAAAAAAkaY/wgWwRtKeIK4/s1600/Kmart_Logo.jpg">
            </div>
            
            <div class="gallery_product col-lg-4 col-md-4 col-sm-4 col-xs-6 filter hdpe">
                <img src="https://krcdesign.files.wordpress.com/2010/09/burger-king-logo-lrg.png">
            </div>

            <div class="gallery_product col-lg-4 col-md-4 col-sm-4 col-xs-6 filter hdpe">
                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSSEzhcQ9PK7JxqgJzx6bvO5VHXwCvc4fgfgoN2gOqv69qWKETJ">
            </div> 
            <div class="gallery_product col-lg-4 col-md-4 col-sm-4 col-xs-6 filter irrigation">
                <img src="https://static1.squarespace.com/static/54e1cf1ae4b08791c7327b5f/54e2f229e4b066ba030ba57a/54e2f335e4b00965efcf2bd2/1424159541346/logos-MRE.jpg?format=500w">
            </div>

            
            <div class="gallery_product col-lg-4 col-md-4 col-sm-4 col-xs-6 filter irrigation">
                <img src="http://www.billigstautos.com/wp-content/uploads/2009/08/smart-logo.jpg" class="img-responsive">
            </div>

            <div class="gallery_product col-lg-4 col-md-4 col-sm-4 col-xs-6 filter spray">
                <img src="http://www.academie-air-espace.com/ATA/pic/logos/Logo_MeteoFrance_new.jpg">
            </div>

            <div class="gallery_product col-lg-4 col-md-4 col-sm-4 col-xs-6 filter irrigation">
                <img src="https://www.mitostudios.com/wp-content/uploads/2010/02/111215-Portfolio-Logo_RSD_Stacked.png">
            </div>

            <div class="gallery_product col-lg-4 col-md-4 col-sm-4 col-xs-6 filter sprinkle">
                <img src="http://www.kimlmacleod.com/images/portfolio/logos/LoveConnection_0.gif">
            </div>

            <div class="gallery_product col-lg-4 col-md-4 col-sm-4 col-xs-6 filter hdpe">
                <img src="http://diegomir.es/media/marcas-wichita-on.png">
            </div>

            <div class="gallery_product col-lg-4 col-md-4 col-sm-4 col-xs-6 filter spray">
                <img src="http://assaatcilik.com/uploads/images/logos_omega.jpg" class="img-responsive">
            </div>

            <div class="gallery_product col-lg-4 col-md-4 col-sm-4 col-xs-6 filter sprinkle">
                <img src="http://www.looselines.ag/images/logos/cc_logos.gif" class="img-responsive">
            </div>
            -->
        </div>
        <br>
    </div>
<br><br><br>
</div>


<%@ include file="MenuBot.jsp" %>
<script type="text/javascript" src="js/projetos.js"></script>

</body>
</html>
