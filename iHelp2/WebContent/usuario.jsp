<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html>
<head>
<title>${voluntario.nome}</title>
<%@ include file="importFrame.jsp"%>
<link rel="stylesheet" href="css/usuario.css">

<script type="text/javascript">
    $('.confirmation').on('click', function () {
        return confirm('Are you sure?');
    });
</script>


</head>

<body>
	<%@ include file="MenuTop.jsp"%>
	
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
                            Deseja realmente excluir sua conta?
                        </div>
                        <div class="modal-footer">
                            <form action="ManterVoluntario.do?acao=Excluir&id_voluntario=${voluntario.id_voluntario}" method="post">
                                <input type="hidden" name="id" id="id_excluir" />
                                <button type="submit" class="btn btn-primary" name="acao" value="Excluir">Sim</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
    <!-- end modal -->

	<div class="container-fluid display-table">
		<div class="row display-table-row">
		
			
		<div class="col-md-2 col-sm-1 hidden-xs display-table-cell v-align box"
			id="navigation">
			<div class="logo">
				<a href="index.jsp"><img
					src="img/logo.png" data-toggle="tooltip" title="Clique aqui para ir na página inicial"
					alt="merkery_logo" class="hidden-xs hidden-sm"> <img
					src="http://ihelputech.com/images/New_iHelp_Logo_2.png"
					alt="merkery_logok" class="visible-xs visible-sm circle-logo">
				</a>
			</div>
			<div class="navi">
				<ul>
					<li class="active"><a href="ManterVoluntario.do?acao=Carregar"><i
							class="fa fa-cog" aria-hidden="true"></i><span
							class="hidden-xs hidden-sm">Opções</span></a></li>
					<li><a href="ManterProjeto.do?acao=Carregar"><i class="fa fa-bar-chart"
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
					   <h3 style="text-align: center;">Seja Bem-vindo ${voluntario.nome} | Tela Informações usuário</h3>
						<hr>
						
						<div class="col-md-12">
							<div class="alert alert-info alert-dismissable">
								  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
								  <strong>Atenção: </strong>Este é o seu painel com suas informações, baseado nelas a iHelp encontra o projeto ideal para você.
							</div>
						</div>
						
						<div class="col-md-4">
						
							<div class="user-dashboard">

								<div class="form-group">
									<form action="ManterVoluntario.do?acao=Editar&id_voluntario=${voluntario.id_voluntario}" method="post">
							
										
										<label class="col-md-4 control-label" for="nome">Nome: 
										</label> <input id="nome" name="nome" type="text"
											placeholder="Insira o nome" value="${voluntario.nome}" class="form-control input-md"><br>

										<label class="col-md-4 control-label" for="nome">Email:										
										</label> <input id="email" name="email" type="text" 
											placeholder="Insira a descricao" value="${voluntario.email}" class="form-control input-md"><br>
										
										<label class="col-md-4 control-label" for="senha">Senha: </label>
										<input id="senha" name="senha" type="password"
											placeholder="Insira a sua senha" value="${voluntario.senha}" class="form-control input-md"><br>
						
						
										<h5 data-toggle="tooltip" title="Marque os periodos dos dias que você estará disponivel"><b>Disponibilidade (Manhã-Tarde-Noite)</b></h5><hr>
										
										<div class="row">
											
											<label class="col-md-6 control-label" for="">Segunda-feira:
											</label> <input type="checkbox" ${vinculo == '1' ? 'disabled' : ''}  id="chkS1" data-toggle="tooltip" title="Manhã" name="chkS1" value="1" ${voluntario.disponibilidade[0] == '1' ? 'checked' : ''}>&nbsp M &nbsp
											<input type="checkbox" ${vinculo == '1' ? 'disabled' : ''}  id="chkS2" data-toggle="tooltip" title="Tarde" name="chkS2" value="1" ${voluntario.disponibilidade[1] == '1' ? 'checked' : ''}>&nbsp T &nbsp															
											<input type="checkbox" ${vinculo == '1' ? 'disabled' : ''}  id="chkS3" data-toggle="tooltip" title="Noite" name="chkS3" value="1" ${voluntario.disponibilidade[2] == '1' ? 'checked' : ''}>&nbsp N &nbsp
										</div>

										<div class="row">
											<label class="col-md-6 control-label" for="">Terça-feira:
											</label> <input type="checkbox" ${vinculo == '1' ? 'disabled' : ''}  id="chkT1" name="chkT1" value="1" ${voluntario.disponibilidade[3] == '1' ? 'checked' : ''}>&nbsp M &nbsp
											<input type="checkbox" ${vinculo == '1' ? 'disabled' : ''}  id="chkT2" name="chkT2" value="1" ${voluntario.disponibilidade[4] == '1' ? 'checked' : ''}>&nbsp T &nbsp
											<input type="checkbox" ${vinculo == '1' ? 'disabled' : ''}  id="chkT3" name="chkT3" value="1" ${voluntario.disponibilidade[5] == '1' ? 'checked' : ''}>&nbsp N &nbsp
										</div>

										<div class="row">

											<label class="col-md-6 control-label" for="">Quarta-feira:
											</label> <input type="checkbox" ${vinculo == '1' ? 'disabled' : ''}  id="chkQ1" name="chkQ1" value="1" ${voluntario.disponibilidade[6] == '1' ? 'checked' : ''}>&nbsp M &nbsp
											<input type="checkbox" ${vinculo == '1' ? 'disabled' : ''}  id="chkQ2" name="chkQ2" value="1" ${voluntario.disponibilidade[7] == '1' ? 'checked' : ''}>&nbsp T &nbsp
											<input type="checkbox" ${vinculo == '1' ? 'disabled' : ''}  id="chkQ3" name="chkQ3" value="1" ${voluntario.disponibilidade[8] == '1' ? 'checked' : ''}>&nbsp N &nbsp

										</div>

										<div class="row">

											<label class="col-md-6 control-label" for="">Quinta-feira:
											</label> <input type="checkbox" ${vinculo == '1' ? 'disabled' : ''}  id="chkQI1" name="chkQI1" value="1" ${voluntario.disponibilidade[9] == '1' ? 'checked' : ''}>&nbsp M &nbsp
											<input type="checkbox" ${vinculo == '1' ? 'disabled' : ''}  id="chkQI2" name="chkQI2" value="1" ${voluntario.disponibilidade[10] == '1' ? 'checked' : ''}>&nbsp T &nbsp
											<input type="checkbox" ${vinculo == '1' ? 'disabled' : ''}  id="chkQI3" name="chkQI3" value="1" ${voluntario.disponibilidade[11] == '1' ? 'checked' : ''}>&nbsp N &nbsp

										</div>

										<div class="row">

											<label class="col-md-6 control-label" for="">Sexta-feira:
											</label> <input type="checkbox" ${vinculo == '1' ? 'disabled' : ''}  id="chkSX1" name="chkSX1" value="1" ${voluntario.disponibilidade[12] == '1' ? 'checked' : ''}>&nbsp M &nbsp
											<input type="checkbox" ${vinculo == '1' ? 'disabled' : ''}  id="chkSX2" name="chkSX2" value="1" ${voluntario.disponibilidade[13] == '1' ? 'checked' : ''}>&nbsp T &nbsp
											<input type="checkbox" ${vinculo == '1' ? 'disabled' : ''}  id="chkSX3" name="chkSX3" value="1" ${voluntario.disponibilidade[14] == '1' ? 'checked' : ''}>&nbsp N &nbsp

										</div>

										<div class="row">

											<label class="col-md-6 control-label" for="">Sabado:
											</label>
											<input type="checkbox" ${vinculo == '1' ? 'disabled' : ''}  id="chkSB1" value="1" ${voluntario.disponibilidade[15] == '1' ? 'checked' : ''}>&nbsp M &nbsp
											<input type="checkbox" ${vinculo == '1' ? 'disabled' : ''}  id="chkSB2" name="chkSB2" value="1" ${voluntario.disponibilidade[16] == '1' ? 'checked' : ''}>&nbsp T &nbsp
											<input type="checkbox" ${vinculo == '1' ? 'disabled' : ''}  id="chkSB3" name="chkSB3" value="1" ${voluntario.disponibilidade[17] == '1' ? 'checked' : ''}>&nbsp N &nbsp

										</div>

										<div class="row">

											<label class="col-md-6 control-label" for="">Domingo:
											</label> 
											<input type="checkbox" ${vinculo == '1' ? 'disabled' : ''}  id="chkD1" name="chkD1" value="1" ${voluntario.disponibilidade[18] == '1' ? 'checked' : ''}>&nbsp M &nbsp
											<input type="checkbox" ${vinculo == '1' ? 'disabled' : ''}  id="chkD2" name="chkD2" value="1" ${voluntario.disponibilidade[19] == '1' ? 'checked' : ''}>&nbsp T &nbsp
											<input type="checkbox" ${vinculo == '1' ? 'disabled' : ''}  id="chkD3" name="chkD3" value="1" ${voluntario.disponibilidade[20] == '1' ? 'checked' : ''}>&nbsp N &nbsp

										</div>
											
										
								</div>
								
											
						
								
							</div>

						</div>
	
		
						<div class="col-md-8">
						 	
						<label class="col-md-4 control-label" for="rua">Rua: </label>
						<input id="endereco" name="endereco" type="text" placeholder="Insira a rua" value="${voluntario.endereco.endereco}" class="form-control input-md"><br>
						
						
						<label class="col-md-4 control-label" for="rua">Cidade: </label>
						<input id="cidade" name="cidade" type="text" placeholder="Insira a cidade" value="${voluntario.endereco.cidade}" class="form-control input-md"><br>
						
							
						<div class="col-md-2">	
						<label class="col-md-2 control-label" for="estado">Estado: </label>
						<input id="estado" name="estado" type="text" placeholder="Insira o estado" value="${voluntario.endereco.estado}" class="form-control input-md"><br>
						</div>
							
						<label class="col-md-4 control-label" for="prependedtext">Telefone: </label>
						
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-earphone"></i></span> <input
									id="prependedtext" name="telefone" value="${voluntario.telefone}" class="form-control"
									placeholder="XX XXXXX-XXXX" type="text" maxlength="13"
									pattern="\[0-9]{2}\ [0-9]{4,6}-[0-9]{3,4}$"
									OnKeyPress="formatar('## #####-####', this)">
							</div>
							<br>
						
						<label class="col-md-4 control-label" for="prependedtext">Celular: </label>
						
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-earphone"></i></span> <input
									id="prependedtext" name="celular" class="form-control"
									placeholder="XX XXXXX-XXXX" value="${voluntario.celular}" type="text" maxlength="13"
									pattern="\[0-9]{2}\ [0-9]{4,6}-[0-9]{3,4}$"
									OnKeyPress="formatar('## #####-####', this)">
							</div>
						
						<br>
			
						
						<div class="col-md-4">
						
						<label class="" for="Nome">CPF <h11>*</h11></label>
					
							<input id="cpf" name="cpf" placeholder="Apenas números"
								class="form-control input-md" value="${voluntario.cpf}" required="" type="text"
								maxlength="11" pattern="[0-9]+$">
						</div>
						
						
						<div class="col-md-4">
						<label class="" for="nome">RG <h11>*</h11>
						</label>
					
							<input id="rg" name="rg" placeholder="Apenas números"
								class="form-control input-md" value="${voluntario.rg}" required="" type="text"
								maxlength="11" pattern="[0-9]+$">
						
						</div>
						
						<div class="col-md-4">
						<button type="submit" class="btn btn-primary" data-toggle="tooltip" title="Está pronto para alterar seus dados? click aqui!" style="margin-top: 15px;">Editar Informações &nbsp</button><br><br>
						<a href="#" data-toggle="tooltip" title="Vai nos abandonar? tem certeza disso?" ><button type="button" class="btn btn-danger" id="btn${voluntario.id_voluntario}" data-toggle="modal" data-target="#delete-modal" data-voluntario="${voluntario.id_voluntario}">Excluir Minha Conta</button></a></td>
						</div>
												
						<div class="col-md-12">
							<label>Area de Atuação:</label><br>					   <!--  ${projeto.disponibilidade[0] == '1' ? 'checked' : ''}-->
							<input type="checkbox" id="" ${vinculo == '1' ? 'disabled' : ''} name="a" value="1" ${voluntario.id_area[0] == '1' || voluntario.id_area[1] == '1' || voluntario.id_area[2] == '1' || voluntario.id_area[3] == '1' || voluntario.id_area[4] == '1' || voluntario.id_area[5] == '1' || voluntario.id_area[6] == '1' ? 'checked' : ''}>Esporte &nbsp
							<input type="checkbox" id="" ${vinculo == '1' ? 'disabled' : ''} name="b" value="2" ${voluntario.id_area[0] == '2' || voluntario.id_area[1] == '2' || voluntario.id_area[2] == '2' || voluntario.id_area[3] == '2' || voluntario.id_area[4] == '2' || voluntario.id_area[5] == '2' || voluntario.id_area[6] == '2' ? 'checked' : ''}>Saude  &nbsp
							<input type="checkbox" id="" ${vinculo == '1' ? 'disabled' : ''} name="c" value="3" ${voluntario.id_area[0] == '3' || voluntario.id_area[1] == '3' || voluntario.id_area[2] == '3' || voluntario.id_area[3] == '3' || voluntario.id_area[4] == '3' || voluntario.id_area[5] == '3' || voluntario.id_area[6] == '3' ? 'checked' : ''}>Cultura &nbsp
							<input type="checkbox" id="" ${vinculo == '1' ? 'disabled' : ''} name="d" value="4" ${voluntario.id_area[0] == '4' || voluntario.id_area[1] == '4' || voluntario.id_area[2] == '4' || voluntario.id_area[3] == '4' || voluntario.id_area[4] == '4' || voluntario.id_area[5] == '4' || voluntario.id_area[6] == '4' ? 'checked' : ''}>Pessoas com deficiencia <br>
							<input type="checkbox" id="" ${vinculo == '1' ? 'disabled' : ''} name="e" value="5" ${voluntario.id_area[0] == '5' || voluntario.id_area[5] == '5' || voluntario.id_area[2] == '5' || voluntario.id_area[3] == '5' || voluntario.id_area[4] == '5' || voluntario.id_area[5] == '5' || voluntario.id_area[6] == '5' ? 'checked' : ''}>Criancas e Adolescentes &nbsp 
						    <input type="checkbox" id="" ${vinculo == '1' ? 'disabled' : ''} name="f" value="6" ${voluntario.id_area[0] == '6' || voluntario.id_area[1] == '6' || voluntario.id_area[2] == '6' || voluntario.id_area[3] == '6' || voluntario.id_area[4] == '6' || voluntario.id_area[5] == '6' || voluntario.id_area[6] == '6' ? 'checked' : ''}>Meio ambiente &nbsp
						    <input type="checkbox" id="" ${vinculo == '1' ? 'disabled' : ''} name="g" value="7" ${voluntario.id_area[0] == '7' || voluntario.id_area[1] == '7' || voluntario.id_area[2] == '7' || voluntario.id_area[3] == '7' || voluntario.id_area[4] == '7' || voluntario.id_area[5] == '7' || voluntario.id_area[6] == '7' ? 'checked' : ''}>Competitividade e Desenvolvimento &nbsp <br>
									
						</div>
						
						${vinculo == '1' ? '<br><div class="col-md-12">
							<div class="alert alert-danger alert-dismissable">
								  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
								  <strong>Atenção Voluntário: </strong>No momento não pode alterar sua disponibilidade e área de atuação, pois você está vinculado a um projeto.
							</div>
						</div>' : ''}							
						</div>
						
						
						
						</form>
						
						
								
			</div>
		
			
			
		</div>
	
	</div>
	
	

	<%@ include file="MenuBot.jsp"%>
	
	<script type="text/javascript">
                $("#delete-modal").on('show.bs.modal', function(event) {
                    var button = $(event.relatedTarget); //botao que disparou a modal
                    var recipient = button.data('voluntario');
                    $("#id_excluir").val(recipient);
                });
    </script>
    
</body>
</html>