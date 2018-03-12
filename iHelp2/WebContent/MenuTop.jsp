<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- =====================  MENU   ============================= -->
<nav class="navbar navbar-inverse navbar" role="navigation">

  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href=<c:if test="${not empty voluntario}">"ManterVoluntario.do?acao=Carregar"</c:if> <c:if test="${empty voluntario}">"index.jsp"</c:if>><c:if test="${empty voluntario}"><i class="fa fa-home" aria-hidden="true"></i></c:if> <c:if test="${not empty voluntario}"><i class="fa fa-user-circle-o" aria-hidden="true"></i></c:if></a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        
		<li><a href="ManterMenu.do?acao=Os"><i class="fa fa-ravelry" aria-hidden="true"></i> Organizações Sociais</a></li>
        <li><a href="ManterMenu.do?acao=Projeto"><i class="fa fa-globe" aria-hidden="true"></i> Projetos da iHelp</a></li>
        <!-- <li><a href="sobre_nos.jsp"><i class="fa fa-info-circle" aria-hidden="true"></i> Sobre nós</a></li>
		<li><a href="fale_conosco.jsp"><i class="fa fa-volume-control-phone" aria-hidden="true"></i> Fale conosco</a></li>-->
		<!-- <li><a href="Test.do"><i class="fa fa-lightbulb-o" aria-hidden="true"></i> CRUD</a></li>-->
		<li class="dropdown" style="display: none;">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li class="divider"></li>
            <li><a href="#">Separated link</a></li>
            <li class="divider"></li>
            <li><a href="#">One more separated link</a></li>
          </ul>
        </li>
      </ul>
      <form class="navbar-form navbar-left" role="search" style="display: none;">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
       <!--<li><p class="navbar-text">Quer ser um voluntario ?</p></li>-->
       <c:choose>
       		<c:when test="${not empty voluntario}">
       			
       			<li class="dropdown">
       			<a href="#" class="dropdown-toggle" data-toggle="dropdown"><b><i class="fa fa-sign-out" aria-hidden="true"></i> Opções </b> <span class="caret"></span></a>
				<ul id="login-dp" class="dropdown-menu">
				<li>
					<div class="row">
       					<div class="col-md-12">
       						<div class="form-group">
       							<a href="LogOutController.do"><button  class="btn btn-default btn-block">Sair</button></a>
							</div>
       					</div>
       				</div>
       			</li>
       			</ul>
       			</li>
       			
       		</c:when>
       			
       		<c:otherwise>
       			<li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown"><b><i class="fa fa-sign-in" aria-hidden="true"></i> login </b> <span class="caret"></span></a>
			<ul id="login-dp" class="dropdown-menu">
				<li>
					 <div class="row">
							<div class="col-md-12">
								<!-- Entrar via
								<div class="social-buttons">
									<a href="usuario.jsp" class="btn btn-fb"><i class="fa fa-facebook"></i> Facebook</a>
								</div>
                                ou
                                 -->
								 <form class="form" role="form" method="post" action="LoginUsuario.do" accept-charset="UTF-8" id="login-nav">
										<div class="form-group">
											 <label class="sr-only" for="exampleInputEmail2">Email </label>
											 <input type="email" class="form-control" id="exampleInputEmail2" name="login" placeholder="Email " required>
										</div>
										<div class="form-group">
											 <label class="sr-only" for="exampleInputPassword2">Senha</label>
											 <input type="password" class="form-control" id="exampleInputPassword2" name="senha" placeholder="Senha" required>
                                             <!-- <div class="help-block text-right"><a href="">Esqueceu a senha ?</a></div> -->
										</div>
										<div class="form-group">
											 <button type="submit" class="btn btn-primary btn-block">Entrar</button>
										</div>
										<div class="checkbox">
											 <label>
											 <input type="checkbox"> Mantenha me conectado
											 </label>
										</div>
								 </form>
							</div>
							<div class="bottom text-center">
								Novo por aqui ? <a href="ManterVoluntario.do?acao=Cadastro"><b>Cadastrar-se</b></a>
							</div>
					 </div>
				</li>
			</ul>
        </li>
       		</c:otherwise>
       		      		
       </c:choose>
       
       
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

<!-- ===================== FIM DO MENU   ============================= -->


