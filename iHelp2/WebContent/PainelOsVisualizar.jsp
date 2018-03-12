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
                            <h4 class="modal-title" id="modalLabel">Excluir Organização</h4>
                        </div>
                        <div class="modal-body">
                            Deseja realmente excluir esta organização social?
                        </div>
                        <div class="modal-footer">
                            <form action="ManterOs.do" method="post">
                                <input type="hidden" name="id_OS" id="id_excluir" />
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
						<li class="active"><a href="ManterOs.do?acao=Carregar"><i class="fa fa-ravelry" aria-hidden="true"></i><span class="hidden-xs hidden-sm">Organizações</span></a></li>
									 
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
						<h3 style="text-align: center;">${voluntario.nome} | Dados Organização Social</h3>
						<hr>
						<div class="col-md-5">
							

							<div class="user-dashboard">

								<h3>Dados Cadastrados</h3>

								<div class="form-group">
									<form action="ManterOs.do?acao=Atualizar&id=${os.id_OS}" method="post">

										
										<label class="col-md-12 control-label" for="nome">Nome da organização:
										</label> <input value="${os.nome}" id="nome" name="nome" type="text"
											placeholder="Insira o nome" class="form-control input-md">
											
										<label class="col-md-5 control-label" for="nome">Nome Fantasia:
										</label> <input id="nf" value="${os.nome_fantasia}" name="nf" type="text"
											placeholder="Insira o nome Fantasia" class="form-control input-md">
											
																					
										<label class="col-md-4 control-label" for="email">E-mail:
										</label> <input id="email" value="${os.email}" name="email" type="text"
											placeholder="Insira o email" class="form-control input-md"> <br>
											
																				
										
										

									
								</div>
							</div>

						</div>
	
						<div class="col-md-7">
							
							<div class="col-md-4">
							<label class="col-md-4 control-label" for="cnpj">CNPJ: </label>
							<input id="cnpj" name="cnpj" value="${os.cnpj}" type="text" placeholder="Insira o cnpj" class="form-control input-md">
							</div>
									
							<div class="col-md-8">
							<label class="col-md-4 control-label" for="endereco">Endereço:
							</label> <input id="endereco" value="${os.endereco}" name="endereco" type="text" placeholder="Insira o endereço" class="form-control input-md"><br>
							</div>
							<div class="col-md-4">
							<label class="col-md-4 control-label" for="endereco">CEP:
							</label> <input id="cep" name="cep" value="${os.cep}" type="text" placeholder="Insira o cep" class="form-control input-md"><br>
							</div>
							
							<div class="col-md-3">
							<label class="col-md-3 control-label" for="endereco">Numero:
							</label> <input id="numero" value="${os.numero}" name="numero" type="text" placeholder="Insira o nº" class="form-control input-md"><br>
							</div>
							
						<div class="col-md-5">
							<label class="col-md-2 control-label" for="endereco">Complemento:
							</label> <input id="complemento" value="${os.complemento}" name="complemento" type="text" placeholder="Insira o complemento" class="form-control input-md"><br>
						</div>	
								
						<div class="col-md-3">
							<label class="col-md-3 control-label" for="endereco">Estado:
							</label> <input id="estado" value="${os.estado}" name="estado" type="text" placeholder="Estado" class="form-control input-md"><br>
						</div>
						
						<div class="col-md-5">
							<label class="col-md-3 control-label" for="endereco">Cidade:
							</label> <input id="cidade" value="${os.cidade}" name="cidade" type="text" placeholder="Cidade" class="form-control input-md"><br>
						</div>
							
						<div class="col-md-4">
						<label class="col-md-2 control-label" for="Nome">Início<h11>*</h11></label>
							<input id="data_inicio" value="${os.data_inicio}" name="data_inicio"
								placeholder="DD/MM/AAAA" class="form-control input-md"
								required="" type="text" maxlength="10"
								OnKeyPress="formatar('##/##/####', this)" onBlur="showhide()">
						</div>
						
						<div class="col-md-2">
						</div>
						
						<div class="col-md-6">
						
							<label class="col-md-4 control-label" for="projeto">Status: </label>
										
										<select class="form-control input-sm" id="status" name="status" required>
									      <option value="">Selecione...</option>
										  <option value="Ativo" selected>Ativo</option>
										  <option value="Inativo">Inativo</option>
										  
					  					</select>
						
						</div>
						
						
						<div class="col-md-6">
							<br>
											    	
					    	<a href="ManterOs.do?acao=Carregar" class="btn btn-primary">Voltar para o Painel</a>
					    	
						</div>
						
						</form>
						<br>
						</div>				
						<hr>			
						<div class="col-md-12">
							<br>
							<hr>
							<h3 style="text-align: center;">Projetos vinculados a esta organização social</h3>
																			
									<table class="table table-bordered">
								<tr class="active">
									<td style="display:none">ID</td>
									<td>Projeto</td>
									<td>Ação</td>
								</tr>
											
								<c:forEach var="projeto" items="${v}">
									<tr>
										<td style="display:none">${projeto.id_projeto}</td>
										<td style="width: 800px">${projeto.nome}</td>
										<td><a href="ManterOs.do?acao=Desvincular&id_os=${os.id_OS}&id_projeto=${projeto.id_projeto}"><button class="btn btn-danger">Quer Desvincular?</button></a></td>								
										
									</tr>					
						
								</c:forEach>
							</table>
						</div>
						
						<div class="col-md-12">
							<h3 style="text-align: center;">Projetos não vinculados a nenhuma organização</h3>
																			
									<table class="table table-bordered">
								<tr class="active">
									<td style="display:none">ID</td>
									<td>Projeto</td>
									<td>Ação</td>
								</tr>
											
								<c:forEach var="projeto" items="${nv}">
									<tr>
										<td style="display:none">${projeto.id_projeto}</td>
										<td style="width: 800px">${projeto.nome}</td>
										<td><a href="ManterOs.do?acao=Vincular&id_os=${os.id_OS}&id_projeto=${projeto.id_projeto}"><button class="btn btn-primary">Deseja Vincular?</button></a></td>								
										
									</tr>					
						
								</c:forEach>
							</table>
						</div>
						
						
						
						</div>
						
						
						
				</div>

			</div>
		</div>
	</div>


	<%@ include file="MenuBot.jsp"%>
	
	<script type="text/javascript">
				$("#delete-modal").on('show.bs.modal', function(event) {
                    var button = $(event.relatedTarget); //botao que disparou a modal
                    var recipient = button.attr('data-os');
                    $("#id_excluir").val(recipient);
                });
                
    </script>
</body>
</html>