<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html>
<head>
<title>${login.login}</title>
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
						<h3 style="text-align: center; color: white; background-color: #0e1a35; padding: 5px, 5px, 25px;">Editar Projeto: ${projeto.nome}</h3>
						<div class="col-md-12">
							

							<div class="user-dashboard">

								<h3>Editar Projeto</h3>

								<div class="form-group">
									<form action="ManterProjeto.do?acao=Atualizar&id_projeto=${projeto.id_projeto}" method="post">

										<label class="col-md-4 control-label" for="nome">Nome:
										</label> <input id="nome" name="nome" type="text"
											placeholder="Insira o nome" value="${projeto.nome}" class="form-control input-md"><br>
										
										<label class="col-md-12 control-label" for="nome">Quantidade de Voluntários:
										</label> <input id="quantidade" value="${projeto.quantidade}" name="quantidade" type="text"
											placeholder="Entre somente com numeros" required class="form-control input-md">
										
										<br>
										
										<label class="col-md-4 control-label" for="nome">Descrição:
										</label> <input id="descricao" value="${projeto.descricao}" name="descricao" type="text"
											placeholder="Insira a descricao"
											class="form-control input-md"><br>

										<div class="row">
											<label class="col-md-6 control-label" for="">Segunda-feira:
											</label> <input type="checkbox" ${vinculo == '1' ? 'disabled' : ''} id="chkS1" name="chkS1" value="1" ${projeto.disponibilidade[0] == '1' ? 'checked' : ''}>
											<input type="checkbox" ${vinculo == '1' ? 'disabled' : ''} id="chkS2" name="chkS2" value="1" ${projeto.disponibilidade[1] == '1' ? 'checked' : ''}>
											<input type="checkbox" ${vinculo == '1' ? 'disabled' : ''} id="chkS3" name="chkS3" value="1" ${projeto.disponibilidade[2] == '1' ? 'checked' : ''}>
										</div>

										<div class="row">
											<label class="col-md-6 control-label" for="">Terça-feira:
											</label> <input type="checkbox" ${vinculo == '1' ? 'disabled' : ''} id="chkT1" name="chkT1" value="1" ${projeto.disponibilidade[3] == '1' ? 'checked' : ''}>
											<input type="checkbox" ${vinculo == '1' ? 'disabled' : ''} id="chkT2" name="chkT2" value="1" ${projeto.disponibilidade[4] == '1' ? 'checked' : ''}>
											<input type="checkbox" ${vinculo == '1' ? 'disabled' : ''} id="chkT3" name="chkT3" value="1" ${projeto.disponibilidade[5] == '1' ? 'checked' : ''}>
										</div>

										<div class="row">

											<label class="col-md-6 control-label" for="">Quarta-feira:
											</label> <input type="checkbox" ${vinculo == '1' ? 'disabled' : ''} id="chkQ1" name="chkQ1" value="1" ${projeto.disponibilidade[6] == '1' ? 'checked' : ''}>
											<input type="checkbox" ${vinculo == '1' ? 'disabled' : ''} id="chkQ2" name="chkQ2" value="1" ${projeto.disponibilidade[7] == '1' ? 'checked' : ''}>
											<input type="checkbox" ${vinculo == '1' ? 'disabled' : ''} id="chkQ3" name="chkQ3" value="1" ${projeto.disponibilidade[8] == '1' ? 'checked' : ''}>

										</div>

										<div class="row">

											<label class="col-md-6 control-label" for="">Quinta-feira:
											</label> <input type="checkbox" ${vinculo == '1' ? 'disabled' : ''} id="chkQI1" name="chkQI1" value="1" ${projeto.disponibilidade[9] == '1' ? 'checked' : ''}>
											<input type="checkbox" ${vinculo == '1' ? 'disabled' : ''} id="chkQI2" name="chkQI2" value="1" ${projeto.disponibilidade[10] == '1' ? 'checked' : ''}>
											<input type="checkbox" ${vinculo == '1' ? 'disabled' : ''} id="chkQI3" name="chkQI3" value="1" ${projeto.disponibilidade[11] == '1' ? 'checked' : ''}>

										</div>

										<div class="row">

											<label class="col-md-6 control-label" for="">Sexta-feira:
											</label> <input type="checkbox" ${vinculo == '1' ? 'disabled' : ''} id="chkSX1" name="chkSX1" value="1" ${projeto.disponibilidade[12] == '1' ? 'checked' : ''}>
											<input type="checkbox" ${vinculo == '1' ? 'disabled' : ''} id="chkSX2" name="chkSX2" value="1" ${projeto.disponibilidade[13] == '1' ? 'checked' : ''}>
											<input type="checkbox" ${vinculo == '1' ? 'disabled' : ''} id="chkSX3" name="chkSX3" value="1" ${projeto.disponibilidade[14] == '1' ? 'checked' : ''}>

										</div>

										<div class="row">

											<label class="col-md-6 control-label" for="">Sabado:
											</label> <input type="checkbox" ${vinculo == '1' ? 'disabled' : ''} id="chkSB1" name="chkSB1" value="1" ${projeto.disponibilidade[15] == '1' ? 'checked' : ''}>
											<input type="checkbox" ${vinculo == '1' ? 'disabled' : ''} id="chkSB2" name="chkSB2" value="1" ${projeto.disponibilidade[16] == '1' ? 'checked' : ''}>
											<input type="checkbox" ${vinculo == '1' ? 'disabled' : ''} id="chkSB3" name="chkSB3" value="1" ${projeto.disponibilidade[17] == '1' ? 'checked' : ''}>

										</div>

										<div class="row">

											<label class="col-md-6 control-label" for="">Domingo:
											</label> <input type="checkbox" ${vinculo == '1' ? 'disabled' : ''} id="chkD1" name="chkD1" value="1" ${projeto.disponibilidade[18] == '1' ? 'checked' : ''}>
											<input type="checkbox" ${vinculo == '1' ? 'disabled' : ''} id="chkD2" name="chkD2" value="1" ${projeto.disponibilidade[19] == '1' ? 'checked' : ''}>
											<input type="checkbox" ${vinculo == '1' ? 'disabled' : ''} id="chkD3" name="chkD3" value="1" ${projeto.disponibilidade[20] == '1' ? 'checked' : ''}>

										</div>
																			
										<br>
										<label class="col-md-12 control-label" for="nome">Areas de atuação:
										</label>
										<div class="col-md-12">
											
												   <!--  ${projeto.disponibilidade[0] == '1' ? 'checked' : ''}-->
											<input type="checkbox" id="" ${vinculo == '1' ? 'disabled' : ''} name="a" value="1" ${projeto.id_area[0] == '1' || projeto.id_area[1] == '1' || projeto.id_area[2] == '1' || projeto.id_area[3] == '1' || projeto.id_area[4] == '1' || projeto.id_area[5] == '1' || projeto.id_area[6] == '1' ? 'checked' : ''}>Esporte &nbsp
											<input type="checkbox" id="" ${vinculo == '1' ? 'disabled' : ''} name="b" value="2" ${projeto.id_area[0] == '2' || projeto.id_area[1] == '2' || projeto.id_area[2] == '2' || projeto.id_area[3] == '2' || projeto.id_area[4] == '2' || projeto.id_area[5] == '2' || projeto.id_area[6] == '2' ? 'checked' : ''}>Saude  &nbsp
											<input type="checkbox" id="" ${vinculo == '1' ? 'disabled' : ''} name="c" value="3" ${projeto.id_area[0] == '3' || projeto.id_area[1] == '3' || projeto.id_area[2] == '3' || projeto.id_area[3] == '3' || projeto.id_area[4] == '3' || projeto.id_area[5] == '3' || projeto.id_area[6] == '3' ? 'checked' : ''}>Cultura &nbsp
											<input type="checkbox" id="" ${vinculo == '1' ? 'disabled' : ''} name="d" value="4" ${projeto.id_area[0] == '4' || projeto.id_area[1] == '4' || projeto.id_area[2] == '4' || projeto.id_area[3] == '4' || projeto.id_area[4] == '4' || projeto.id_area[5] == '4' || projeto.id_area[6] == '4' ? 'checked' : ''}>Pessoas com deficiencia <br>
											<input type="checkbox" id="" ${vinculo == '1' ? 'disabled' : ''} name="e" value="5" ${projeto.id_area[0] == '5' || projeto.id_area[5] == '5' || projeto.id_area[2] == '5' || projeto.id_area[3] == '5' || projeto.id_area[4] == '5' || projeto.id_area[5] == '5' || projeto.id_area[6] == '5' ? 'checked' : ''}>Criancas e Adolescentes &nbsp
										    <input type="checkbox" id="" ${vinculo == '1' ? 'disabled' : ''} name="f" value="6" ${projeto.id_area[0] == '6' || projeto.id_area[1] == '6' || projeto.id_area[2] == '6' || projeto.id_area[3] == '6' || projeto.id_area[4] == '6' || projeto.id_area[5] == '6' || projeto.id_area[6] == '6' ? 'checked' : ''}>Meio ambiente &nbsp
										    <input type="checkbox" id="" ${vinculo == '1' ? 'disabled' : ''} name="g" value="7" ${projeto.id_area[0] == '7' || projeto.id_area[1] == '7' || projeto.id_area[2] == '7' || projeto.id_area[3] == '7' || projeto.id_area[4] == '7' || projeto.id_area[5] == '7' || projeto.id_area[6] == '7' ? 'checked' : ''}>Competitividade e Desenvolvimento &nbsp
													
										<br><hr>			
										</div>
										<hr>
					  					
					  					<label class="col-md-4 control-label" for="nome">Situação: </label>
										<select class="form-control input-sm" id="nivel_educacional" name="situacao" required>
									      <option value="${projeto.situacao}" checked>${projeto.situacao} </option>
										  <option value="Em Busca de Voluntarios">Em Busca de Voluntários</option>
										  <option value="Ativo">Ativo</option>
										  <option value="Suspenso">Suspenso</option>
										  <option value="Extinto">Extinto</option>
										  									 				  					
					  					</select>
					  					<br><hr>
					  					
					  					<button type="submit" class="btn btn-default">Editar Projeto</button>
										<a href="ManterProjeto.do?acao=Carregar"> <button type="button" class="btn btn-primary">Cancelar</button></a>
									
									</form>
								</div>
							</div>

						</div>
	
						<div class="col-md-8">

							
						</div>
				</div>

			</div>
		</div>
	</div>
	
	

	<%@ include file="MenuBot.jsp"%>
</body>
</html>