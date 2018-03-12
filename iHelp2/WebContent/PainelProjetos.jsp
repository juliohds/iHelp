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
						<li class="active"><a href="ManterProjeto.do?acao=Carregar"><i class="fa fa-bar-chart"
								aria-hidden="true"></i><span class="hidden-xs hidden-sm">Projetos</span></a></li>
						<li><a href="ManterOs.do?acao=Carregar"><i class="fa fa-ravelry" aria-hidden="true"></i><span class="hidden-xs hidden-sm">Organizações</span></a></li>
									 
						<li><a href="ManterProjeto.do?acao=Carregar2"><i class="fa fa-user" aria-hidden="true"></i><span
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
						<h3 style="text-align: center;">${voluntario.nome} | Tela de Projetos</h3>
						<hr>
						
						<c:if test="${exclui == false}"><h3 style="text-align: center; color: red;"><b>Erro ao excluir, projeto vinculado a uma Organização Social!</b></h3></c:if>
						<div class="col-md-12">
							
							<div class="alert alert-info alert-dismissable">
							  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
							  <strong>Atenção: </strong>Role a tela para baixo para veja os projetos cadastrados!
							</div>
			
							<div class="user-dashboard">
								
								<h3>Cadastrar Projeto</h3>

								<div class="form-group">
								
									<!-- 
									 <form action="upload" method="post" enctype="multipart/form-data">
											<input type="file" name="file" id="file"/> <br>
											<input type="submit" value="Enviar Foto"/>
										</form>
										<label>${message}</label>
										<br/>
									 
									 <form action="upload" method="get" >
										<input type="submit" value="Visalizar imagem" />
									</form>	
									-->
																							
									<form action="ManterProjeto.do?acao=Criar" method="post">

										<label class="col-md-4 control-label" for="nome">Nome:
										</label> <input id="nome" name="nome" type="text"
											placeholder="Insira o nome" required class="form-control input-md">
										
										<br>
										
										<label class="col-md-12 control-label" for="nome">Quantidade de Voluntários:
										</label> <input id="quantidade" name="quantidade" type="text"
											placeholder="Entre somente com numeros" required class="form-control input-md">
										
										<br>
										
										<label class="col-md-12 control-label" for="nome">Areas de atuação:
										</label>
										<div class="col-md-12">
											
												   <!--  ${projeto.disponibilidade[0] == '1' ? 'checked' : ''}-->
											<input type="checkbox" id="" name="a" value="1">Esporte &nbsp
											<input type="checkbox" id="" name="b" value="2">Saude  &nbsp
											<input type="checkbox" id="" name="c" value="3">Cultura &nbsp
											<input type="checkbox" id="" name="d" value="4">Pessoas com deficiencia <br>
											<input type="checkbox" id="" name="e" value="5">Criancas e Adolescentes &nbsp
										    <input type="checkbox" id="" name="f" value="6">Meio ambiente &nbsp
										    <input type="checkbox" id="" name="g" value="7">Competitividade e Desenvolvimento &nbsp
										
										<br><hr>			
										</div>
										<hr>
					  					
					  					<label class="col-md-4 control-label" for="nome">Situação: </label>
										<select class="form-control input-sm" id="nivel_educacional" name="situacao" required>
									      <option value="" selected>Selecione...</option>
										  <option value="Em Busca de Voluntarios">Em Busca de Voluntários</option>
										  
										 							 				  					
					  					</select><br>
					  					
										<label class="col-md-4 control-label" for="nome">Descrição:
										</label> <input id="descricao" required name="descricao" type="text"
											placeholder="Insira a descricao"
											class="form-control input-md"><br>
										
										<h5 data-toggle="tooltip" title="Selecione quando ocorrerá as atividades do projeto"><b>Dias e horários de realização dos trabalhos (Manhã-Tarde-Noite)</b></h5><hr>
										<div class="row">
											<label class="col-md-6 control-label" for="">Segunda-feira:	</label>
											
											<input type="checkbox" id="chkS1" name="chkS1" value="1" data-toggle="tooltip" title="Noite" data-toggle="tooltip" title="Manhã">&nbsp M &nbsp
											<input type="checkbox" id="chkS2" name="chkS2" value="1" data-toggle="tooltip" title="Tarde">&nbsp T &nbsp
											<input type="checkbox" id="chkS3" name="chkS3" value="1" data-toggle="tooltip" title="Noite">&nbsp N &nbsp
										</div>

										<div class="row">
											<label class="col-md-6 control-label" for="">Terça-feira: </label>
											<input type="checkbox" id="chkT1" name="chkT1" value="1" data-toggle="tooltip" title="Noite">&nbsp M &nbsp
											<input type="checkbox" id="chkT2" name="chkT2" value="1" data-toggle="tooltip" title="Tarde">&nbsp T &nbsp
											<input type="checkbox" id="chkT3" name="chkT3" value="1" data-toggle="tooltip" title="Noite">&nbsp N &nbsp<br>
										</div>

										<div class="row">

											<label class="col-md-6 control-label" for="">Quarta-feira:
											</label> <input type="checkbox" id="chkQ1" name="chkQ1" value="1" data-toggle="tooltip" title="Noite">&nbsp M &nbsp
											<input type="checkbox" id="chkQ2" name="chkQ2" value="1" data-toggle="tooltip" title="Tarde">&nbsp T &nbsp
											<input type="checkbox" id="chkQ3" name="chkQ3" value="1" data-toggle="tooltip" title="Noite">&nbsp N &nbsp

										</div>

										<div class="row">

											<label class="col-md-6 control-label" for="">Quinta-feira:
											</label> <input type="checkbox" id="chkQI1" name="chkQI1" value="1" data-toggle="tooltip" title="Noite">&nbsp M &nbsp
											<input type="checkbox" id="chkQI2" name="chkQI2" value="1" data-toggle="tooltip" title="Tarde">&nbsp T &nbsp
											<input type="checkbox" id="chkQI3" name="chkQI3" value="1" data-toggle="tooltip" title="Noite">&nbsp N &nbsp

										</div>

										<div class="row">

											<label class="col-md-6 control-label" for="">Sexta-feira:
											</label> <input type="checkbox" id="chkSX1" name="chkSX1" value="1" data-toggle="tooltip" title="Noite">&nbsp M &nbsp
											<input type="checkbox" id="chkSX2" name="chkSX2" value="1" data-toggle="tooltip" title="Tarde">&nbsp T &nbsp
											<input type="checkbox" id="chkSX3" name="chkSX3" value="1" data-toggle="tooltip" title="Noite">&nbsp N &nbsp

										</div>

										<div class="row">

											<label class="col-md-6 control-label" for="">Sabado:
											</label> <input type="checkbox" id="chkSB1" name="chkSB1" value="1" data-toggle="tooltip" title="Noite">&nbsp M &nbsp
											<input type="checkbox" id="chkSB2" name="chkSB2" value="1" data-toggle="tooltip" title="Tarde">&nbsp T &nbsp
											<input type="checkbox" id="chkSB3" name="chkSB3" value="1" data-toggle="tooltip" title="Noite">&nbsp N &nbsp

										</div>

										<div class="row">

											<label class="col-md-6 control-label" for="">Domingo:
											</label> <input type="checkbox" id="chkD1" name="chkD1" value="1" data-toggle="tooltip" title="Noite">&nbsp M &nbsp
											<input type="checkbox" id="chkD2" name="chkD2" value="1" data-toggle="tooltip" title="Tarde">&nbsp T &nbsp
											<input type="checkbox" id="chkD3" name="chkD3" value="1" data-toggle="tooltip" title="Noite" data-toggle="tooltip" title="Noite">&nbsp N &nbsp

										</div>
										<br>
																			
										<button type="submit" class="btn btn-primary">Cadastrar Novo</button>

									</form>
								</div>
							</div>

						</div>
												
						<div class="col-md-12">
							<div class="col-md-12">
								<div class="alert alert-info alert-dismissable">
								  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
								  Para consultar os voluntários compativeis com cada projeto click em <Strong>Abrir</Strong>
								</div>
							</div>
						
							<h3>Projetos Cadastrados</h3>
							<table class="table table-bordered">
								<tr class="bg-primary">
									<td style="display:none">ID</td>
									<td>NOME</td>
									<td>DESCRICAO</td>
									<td>SITUAÇÃO</td>
									<td>OPCOES</td>
								</tr>
											
								<c:forEach var="projeto" items="${lista}">
									<tr>
										<td style="display:none">${projeto.id_projeto}</td>
										<td>${projeto.nome}</td>
										<td>${projeto.descricao}</td>
										<td>${projeto.situacao}</td>
										<td>
										<a href="ManterProjeto.do?acao=Visualizar&id_projeto=${projeto.id_projeto}" class="confirmation"><button type="button" data-toggle="tooltip" title="Veja os detalhes do projeto, consulte os voluntarios compativeis com esse projeto" class="btn btn-primary">Abrir</button></a>
										<a href="ManterProjeto.do?acao=Editar&id_projeto=${projeto.id_projeto}" class="confirmation"><button type="button" class="btn btn-success">Editar</button></a>
										<a href="#" data-toggle="tooltip" title="Lembre-se, antes de excluir um projeto você deve verificar se ele não está vinculado a uma OS."><button type="button" class="btn btn-danger" id="btn${projeto.id_projeto}" data-toggle="modal" title="Lembre-se antes de excluir um projeto, verifique se não existe uma OS vinculada a ele" data-target="#delete-modal" data-projeto="${projeto.id_projeto }">Excluir</button></a>
										
										</td>
										<!-- <td class="warning">${voluntario.senha}</td> -->
									</tr>
								</c:forEach>
							</table>
						
							
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