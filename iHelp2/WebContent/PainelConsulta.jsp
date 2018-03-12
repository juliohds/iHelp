<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html>
<head>
<title>${voluntario.nome}</title>
<%@ include file="importFrame.jsp"%>
<link rel="stylesheet" href="css/usuario.css">




</head>

<body>
	<!-- modal --> 
            <div class="modal fade" id="delete-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span aria-hidden="true">&times;</span>
                            </button>
                            <h4 class="modal-title" id="modalLabel">Excluir Projeto</h4>
                        </div>
                        <div class="modal-body">
                            Deseja realmente excluir este projeto?
                        </div>
                        <div class="modal-footer">
                            <form action="ManterProjeto.do" method="post">
                                <input type="hidden" name="id_projeto" id="id_excluir" />
                                <input type="hidden" name="acao" value="Excluir" />
                                <button type="submit" class="btn btn-primary" name="acao" value="Excluir">Sim</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
    <!-- end modal -->
            
	<%@ include file="MenuTop.jsp"%>

	<div class="container-fluid display-table">
		<div class="row display-table-row">
		
				<div class="container-fluid display-table">
		<div class="row display-table-row">
		
						<div class="col-md-2 col-sm-1 hidden-xs display-table-cell v-align box"
				id="navigation">
				<div class="logo">
					<a href="#"><img
						src="img/logo.png"
						alt="merkery_logo" class="hidden-xs hidden-sm"> <img
						src="http://ihelputech.com/images/New_iHelp_Logo_2.png"
						alt="merkery_logok" class="visible-xs visible-sm circle-logo">
					</a>
				</div>
				<div class="navi">
					<ul>
						<li><a href="ManterVoluntario.do?acao=Carregar"><i
								class="fa fa-cog" aria-hidden="true"></i><span
								class="hidden-xs hidden-sm">Opções</span></a></li>
						<li><a href="ManterProjeto.do?acao=Carregar"><i class="fa fa-bar-chart"
								aria-hidden="true"></i><span class="hidden-xs hidden-sm">Projetos</span></a></li>
						<li><a href="ManterOs.do?acao=Carregar"><i class="fa fa-ravelry" aria-hidden="true"></i><span class="hidden-xs hidden-sm">Organizações</span></a></li>
									 
						<li class="active"><a href="ManterProjeto.do?acao=Carregar2"><i class="fa fa-user" aria-hidden="true"></i><span
								class="hidden-xs hidden-sm">Consulta</span></a></li>
						<li><a href="LogOutController.do"><i class="fa fa-sign-out" aria-hidden="true"></i><span
								class="hidden-xs hidden-sm">Sair</span></a></li>
			
					</ul>
				</div>
			</div>
			
			<div class="col-md-10 col-sm-11 display-table-cell v-align">
				<!--<button type="button" class="slide-toggle">Slide Toggle</button> -->
				<div class="row">
					<header>
						<h3 style="text-align: center;">${voluntario.nome} | Tela de Consulta</h3>
						<hr>
						
						<c:if test="${exclui == false}"><h3 style="text-align: center; color: red;"><b>Erro ao excluir, projeto vinculado a uma Organização Social!</b></h3></c:if>
						
						<div class="col-md-12">
							<div class="alert alert-info alert-dismissable">
								  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
								  Para consultar os voluntários compativeis com cada projeto click em <Strong>Detalhes</Strong>
							</div>
						</div>
						
						<div class="col-md-12">
							
			
							<div class="user-dashboard">

								<h3>Buscar Projetos</h3> 				
								
								<div class="form-group">
									<form action="ManterProjeto.do?acao=Carregar3" method="post">
										
										
										<label class="col-md-4 control-label" for="nome">Nome:
										</label>
										
										<div class="col-md-10">
										 <input id="busca" name="busca" type="text"
											placeholder="Insira o nome para buscar"  class="form-control input-md">
										
										</div>
										<div class="col-md-2">
										<button type="submit" data-toggle="tooltip" title="Insira o nome do projeto e click em buscar" class="btn btn-primary"><i class="fa fa-search" aria-hidden="true"></i> Buscar projetos</button>
										</div>
									</form>
								</div>
							</div>

						</div>
	
						<div class="col-md-12">

							<h3>Lista de Projetos</h3>
							
						
								
							<table class="table table-bordered">
								<tr class="bg-primary">
									<td style="display:none">ID</td>
									<td>NOME</td>
									<td>DESCRICAO</td>
									<td>OPCOES</td>
								</tr>
											
								<c:forEach var="projeto" items="${lista}">
									<tr>
										<td style="display:none">${projeto.id_projeto}</td>
										<td>${projeto.nome}</td>
										<td>${projeto.descricao}</td>
										<td>
										<a href="ManterProjeto.do?acao=Visualizar&id_projeto=${projeto.id_projeto}" class="confirmation"><button type="button" class="btn btn-primary">Detalhes</button></a>
										
										</td>
										<!-- <td class="warning">${voluntario.senha}</td> -->
									</tr>
								</c:forEach>
							</table>
							
							
							<br>
							<br>
							<br>
							<br>
							<br>
						</div>
						
				</div>

			</div>
		</div>
	</div>

	<%@ include file="MenuBot.jsp"%>
	
	<script type="text/javascript">
				$("#delete-modal").on('show.bs.modal', function(event) {
                    var button = $(event.relatedTarget); //botao que disparou a modal
                    var recipient = button.attr('data-projeto');
                    $("#id_excluir").val(recipient);
                });
                
    </script>
	
	
</body>
</html>