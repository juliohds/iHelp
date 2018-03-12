<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html>
<head>
<title>teste</title>
<%@ include file="importFrame.jsp"%>

<link rel="stylesheet" href="css/cadastro.css">

</head>

<body>
	<%@ include file="MenuTop.jsp"%>

	<form class="form-horizontal" action="ManterVoluntario.do?acao=Criar" method="post">
		<fieldset>
			<div class="panel panel-primary">
				<div class="panel-heading">Cadastro de voluntário</div>

				<div class="panel-body">


					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-2 control-label" for="Nome">Nome
							Completo <h11>*</h11>
						</label>
						<div class="col-md-8">
							<input id="Nome" name="nome" placeholder=""
								class="form-control input-md" required="" type="text">
						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-2 control-label" for="Nome">CPF <h11>*</h11></label>
						<div class="col-md-2">
							<input id="cpf" name="cpf" placeholder="Apenas números"
								class="form-control input-md" required="" type="text"
								maxlength="11" pattern="[0-9]+$">
						</div>

						<label class="col-md-1 control-label" for="Nome">Nascimento<h11>*</h11></label>
						<div class="col-md-2">
							<input id="dtnasc" name="data_nascimento"
								placeholder="DD/MM/AAAA" class="form-control input-md"
								required="" type="text" maxlength="10"
								OnKeyPress="formatar('##/##/####', this)" onBlur="showhide()">
						</div>

						<!-- Multiple Radios (inline) -->

						<label class="col-md-1 control-label" for="radios">Sexo <h11>*</h11></label>
						<div class="col-md-4">
							<label required="" class="radio-inline" for="radios-0"> <input
								name="genero" id="genero" value="f" type="radio" required>
								Feminino
							</label> <label class="radio-inline" for="radios-1"> <input
								name="genero" id="genero" value="m" type="radio">
								Masculino
							</label>
						</div>

					</div>

					<!-- Prepended text-->
					<div class="form-group">
						<label class="col-md-2 control-label" for="nome">RG <h11>*</h11>
						</label>
						<div class="col-md-2">
							<input id="rg" name="rg" placeholder="Apenas números"
								class="form-control input-md" required="" type="text"
								maxlength="11" pattern="[0-9]+$">
						</div>

						<label class="col-md-1 control-label" for="prependedtext">Telefone</label>
						<div class="col-md-2">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-earphone"></i></span> <input
									id="prependedtext" name="telefone" class="form-control"
									placeholder="XX XXXXX-XXXX" type="text" maxlength="13"
									pattern="\[0-9]{2}\ [0-9]{4,6}-[0-9]{3,4}$"
									OnKeyPress="formatar('## #####-####', this)">
							</div>
						</div>

						<label class="col-md-1 control-label" for="prependedtext">Senha</label>
						<div class="col-md-2">
							<div class="input-group">
								<input id="senha"
									name="senha" class="form-control" placeholder="Digite sua senha"
									type="password">
							</div>
						</div>
					</div>

					<!-- Prepended text-->
					<div class="form-group">
						<label class="col-md-2 control-label" for="prependedtext">Email
							<h11>*</h11>
						</label>
						<div class="col-md-5">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-envelope"></i></span> <input
									id="prependedtext" name="email" class="form-control"
									placeholder="email@email.com" required="" type="text"
									pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$">
							</div>
						</div>

					<label class="col-md-1 control-label" for="prependedtext">Celular</label>
						<div class="col-md-2">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-earphone"></i></span> <input id="celular"
									name="celular" class="form-control" placeholder="XX XXXXX-XXXX"
									type="text" maxlength="13"
									pattern="\[0-9]{2}\ [0-9]{4,6}-[0-9]{3,4}$"
									OnKeyPress="formatar('## #####-####', this)">
							</div>
						</div>

						
					</div>
					
					


					<!-- Search input-->
					<div class="form-group">
						<label class="col-md-2 control-label" for="CEP">CEP <h11>*</h11></label>
						<div class="col-md-2">
							<input id="cep" name="cep" placeholder="Apenas números"
								class="form-control input-md" required="" value="" type="search"
								maxlength="8" pattern="[0-9]+$">
						</div>
						<div class="col-md-2">
							<button type="button" class="btn btn-primary"
								onclick="pesquisacep(cep.value)">Pesquisar</button>
						</div>
					</div>

					<!-- Prepended text-->
					<div class="form-group">
						<label class="col-md-2 control-label" for="prependedtext">Endereço</label>
						<div class="col-md-4">
							<div class="input-group">
								<span class="input-group-addon">Rua</span> <input id="rua"
									name="endereco" class="form-control" placeholder="" required=""
									readonly="readonly" type="text">
							</div>

						</div>
						<div class="col-md-2">
							<div class="input-group">
								<span class="input-group-addon">Nº <h11>*</h11></span> <input
									id="numero" name="numero" class="form-control" placeholder=""
									required="" type="text">
							</div>

						</div>

						<div class="col-md-3">
							<div class="input-group">
								<span class="input-group-addon">Bairro</span> <input id="bairro"
									name="complemento" class="form-control" placeholder=""
									required="" readonly="readonly" type="text">
							</div>

						</div>
					</div>

					<div class="form-group">
						<label class="col-md-2 control-label" for="prependedtext"></label>
						<div class="col-md-4">
							<div class="input-group">
								<span class="input-group-addon">Cidade</span> <input id="cidade"
									name="cidade" class="form-control" placeholder="" required=""
									readonly="readonly" type="text">
							</div>

						</div>

						<div class="col-md-2">
							<div class="input-group">
								<span class="input-group-addon">Estado</span> <input id="estado"
									name="estado" class="form-control" placeholder="" required=""
									readonly="readonly" type="text">
							</div>

						</div>

						<!-- Select Basic -->
						<div class="form-group">
							<label class="col-md-1 control-label" for="Estado Civil">Estado
								Civil <h11>*</h11>
							</label>
							<div class="col-md-2">
								<select required id="Estado Civil" name="estado_civil"
									class="form-control">
									<option value=""></option>
									<option value="Solteiro(a)">Solteiro(a)</option>
									<option value="Casado(a)">Casado(a)</option>
									<option value="Divorciado(a)">Divorciado(a)</option>
									<option value="Viuvo(a)">Viuvo(a)</option>
								</select>
							</div>
	

							<!-- Prepended checkbox -->
						</div>
					</div>
				
			
				<div class="container-fluid">
				
					<div class="row">
																											
							<div class="col-md-3 col-md-offset-1">
							
							<div class="row">
									<label data-toggle="tooltip" title="Marque os periodos disponiveis em cada dia">Disponibilidade (Manhã-Tarde-Noite)</label>
									<label for="">Segunda-feira:

										<input type="checkbox" data-toggle="tooltip" title=" Manhã " id="chkS1" name="chkS1" value="1">&nbsp M &nbsp
										<input type="checkbox" data-toggle="tooltip" title=" Tarde " id="chkS2" name="chkS2" value="1">&nbsp T &nbsp
										<input type="checkbox" data-toggle="tooltip" title=" Noite " id="chkS3" name="chkS3" value="1">&nbsp N &nbsp

									</label>
							</div>
							
							<div class="row">
									<label for="">Terça-feira: &nbsp &nbsp &nbsp
										<input type="checkbox" data-toggle="tooltip" title=" Manhã " id="chkT1" name="chkT1" value="1">&nbsp M &nbsp
										<input type="checkbox" data-toggle="tooltip" title=" Tarde " id="chkT2" name="chkT2" value="1">&nbsp T &nbsp
										<input type="checkbox" data-toggle="tooltip" title=" Noite " id="chkT3" name="chkT3" value="1">&nbsp N &nbsp
									</label>
							</div>

								<div class="row">

									<label for="">Quarta-feira: &nbsp &nbsp
										<input type="checkbox" data-toggle="tooltip" title=" Manhã " id="chkQ1" name="chkQ1" value="1">&nbsp M &nbsp
										<input type="checkbox" data-toggle="tooltip" title=" Tarde " id="chkQ2" name="chkQ2" value="1">&nbsp T &nbsp
										<input type="checkbox" data-toggle="tooltip" title=" Noite " id="chkQ3" name="chkQ3" value="1">&nbsp N &nbsp
									</label>
								</div>

								<div class="row">

									<label for="">Quinta-feira: &nbsp &nbsp
										<input type="checkbox" data-toggle="tooltip" title=" Manhã " id="chkQI1" name="chkQI1" value="1">&nbsp M &nbsp
										<input type="checkbox" data-toggle="tooltip" title=" Tarde " id="chkQI2" name="chkQI2" value="1">&nbsp T &nbsp
										<input type="checkbox" data-toggle="tooltip" title=" Noite " id="chkQI3" name="chkQI3" value="1">&nbsp N &nbsp
									</label>
								</div>

								<div class="row">

									<label for="">Sexta-feira: &nbsp&nbsp&nbsp&nbsp&nbsp
										<input type="checkbox" data-toggle="tooltip" title=" Manhã " id="chkSX1" name="chkSX1" value="1">&nbsp M &nbsp
										<input type="checkbox" data-toggle="tooltip" title=" Tarde " id="chkSX2" name="chkSX2" value="1">&nbsp T &nbsp
										<input type="checkbox" data-toggle="tooltip" title=" Noite " id="chkSX3" name="chkSX3" value="1">&nbsp N &nbsp
									</label>
								</div>

								<div class="row">

									<label for="">Sabado: &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
									<input
										type="checkbox" data-toggle="tooltip" title=" Manhã " id="chkSB1" name="chkSB1" value="1">&nbsp M &nbsp <input
										type="checkbox" data-toggle="tooltip" title=" Tarde " id="chkSB2" name="chkSB2" value="1">&nbsp T &nbsp <input
										type="checkbox" data-toggle="tooltip" title=" Noite " id="chkSB3" name="chkSB3" value="1">&nbsp N &nbsp
									</label>
								</div>

								<div class="row">

									<label for="">Domingo:  &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
									<input
										type="checkbox" data-toggle="tooltip" title=" Manhã " id="chkD1" name="chkD1" value="1">&nbsp M &nbsp <input
										type="checkbox" data-toggle="tooltip" title=" Tarde " id="chkD2" name="chkD2" value="1">&nbsp T &nbsp <input
										type="checkbox" data-toggle="tooltip" title=" Noite " id="chkD3" name="chkD3" value="1">&nbsp N &nbsp
									</label>
								</div>
							</div>						
						
						<div class="col-md-4">
						   <div class="row">
								
								<div class="col-md-12">
								
								<label class="" for="nome">DIGITE ALGO SOBRE VOCÊ <h11>*</h11></label>
									<textarea id="descricao" rows="10" name="descricao" placeholder="Digite seu texto aqui..."
										class="form-control input-md" required></textarea>
								</div>
						   </div>
						</div>
						
						<div class="col-md-4">   
						   <div class="row">
						   		<div class="col-md-12">
						   		
								<h4>Escolha suas areas de interesse	&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp	</h4>
								<p>
								
								<c:forEach var="area" items="${lista}">
									<input type="checkbox" id="${area.id_area}" name="${area.nome}" value="${area.id_area}"> ${area.nome}<br>
									
								</c:forEach>
									
								<button type="submit" class="btn btn-primary" style="margin-top: 15px; width: 200px;">Cadastrar</button>								
								</p>
								</div>
								
						</div>
					</div>
				</div>
			</div>
		</div>
	
	

		</fieldset>
		
	</form>
<%@ include file="MenuBot.jsp" %>
	<script type="text/javascript" src="js/cadastro.js"></script>


</body>
</html>