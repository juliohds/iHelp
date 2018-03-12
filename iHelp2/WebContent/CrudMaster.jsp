<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page import="model.Voluntario" %>
<%@page import="service.VoluntarioService" %>

<!doctype html>
<html>
<head><title>teste</title>
<%@ include file="importFrame.jsp" %>
</head>

<body>
<%@ include file="MenuTop.jsp" %>

<div class="container-fluid" style="padding:20px 10px; background-color: rgba(255,255,255, .8);">

<% //instanciar o javabean
Voluntario voluntario = new Voluntario();
VoluntarioService vs = new VoluntarioService();

%>

<div class="container-fluid">

<div class="row">
 
<div class="col-md-3">
<h3>Cadastrar Gestores</h3>


<div class="form-group">
<form action="ManterGestor.do" method="post">

<label class="col-md-4 control-label" for="nome">Nome: </label>  
<input id="nome" name="nome" type="text" placeholder="Insira o nome" class="form-control input-md"><br>

<label class="col-md-4 control-label" for="cpf">Cpf: </label>  
<input id="cpf" name="cpf" type="text" placeholder="Insira o cpf" class="form-control input-md"><br>

<label class="col-md-4 control-label" for="nome">Login: </label>  
<input id="login" name="login" type="text" placeholder="Insira o login" class="form-control input-md"><br>

<label class="col-md-4 control-label" for="senha">Senha: </label>  
<input id="senha" name="senha" type="text" placeholder="Insira a Senha" class="form-control input-md"><br>

<button type="submit" class="btn btn-default">Submit</button>

</form>
</div>

</div>

<div class="col-md-3">
<h3>Cadastrar Voluntario</h3>

<div class="form-group">
<form action="ManterVoluntario.do" method="get">

<label class="col-md-4 control-label" for="nome">Nome: </label>  
<input id="nome" name="nome" type="text" placeholder="Insira o nome" class="form-control input-md"><br>

<label class="col-md-4 control-label" for="nome">Email: </label>  
<input id="email" name="email" type="text" placeholder="Insira o email" class="form-control input-md"><br>

<label class="col-md-4 control-label" for="senha">Senha: </label>  
<input id="senha" name="senha" type="text" placeholder="Insira a senha" class="form-control input-md"><br>

<div class="row">
 <label class="col-md-6 control-label" for="">Segunda-feira: </label>             
                       
       <input type="checkbox" id="chkS1" name="chkS1" value="1">
       <input type="checkbox" id="chkS2" name="chkS2" value="1">
       <input type="checkbox" id="chkS3" name="chkS3" value="1">
</div>          
            
<div class="row">
<label class="col-md-6 control-label" for="">Terça-feira: </label>               
  
      <input type="checkbox" id="chkT1" name="chkT1" value="1">
      <input type="checkbox" id="chkT2" name="chkT2" value="1">
      <input type="checkbox" id="chkT3" name="chkT3" value="1"><br>
</div>
 
<div class="row">        
                
<label class="col-md-6 control-label" for="">Quarta-feira: </label>    
                   
      <input type="checkbox" id="chkQ1" name="chkQ1" value="1">
      <input type="checkbox" id="chkQ2" name="chkQ2" value="1">
      <input type="checkbox" id="chkQ3" name="chkQ3" value="1">
                        
 </div>     

<div class="row"> 

<label class="col-md-6 control-label" for="">Quinta-feira: </label>  

      <input type="checkbox" id="chkQI1" name="chkQI1" value="1">
      <input type="checkbox" id="chkQI2" name="chkQI2" value="1">
      <input type="checkbox" id="chkQI3" name="chkQI3" value="1">
                        
</div>
 
<div class="row"> 

<label class="col-md-6 control-label" for="">Sexta-feira: </label>                    
                    
                        <input type="checkbox" id="chkSX1" name="chkSX1" value="1">
                        <input type="checkbox" id="chkSX2" name="chkSX2" value="1">
                        <input type="checkbox" id="chkSX3" name="chkSX3" value="1">
                        
 </div>
 
<div class="row"> 

<label class="col-md-6 control-label" for="">Sabado: </label>                    
                    
       <input type="checkbox" id="chkSB1" name="chkSB1" value="1">
       <input type="checkbox" id="chkSB2" name="chkSB2" value="1">
       <input type="checkbox" id="chkSB3" name="chkSB3" value="1">
                        
</div>
  
<div class="row"> 

<label class="col-md-6 control-label" for="">Domingo: </label>                    
                   
      <input type="checkbox" id="chkD1" name="chkD1" value="1">
      <input type="checkbox" id="chkD2" name="chkD2" value="1">
      <input type="checkbox" id="chkD3" name="chkD3" value="1">
                        
</div>
     


<button type="submit" class="btn btn-default">Submit</button>

</form>
</div>
</div> 
  
<div class="col-md-6 teste">
<h3>Gestores Cadastrados</h3>
<table class="table table-bordered">
	<thead>
	<tr class="active">
		<td>NOME</td>
		<td>CPF</td>
		<td>LOGIN</td>
		<td>SENHA</td>
	</tr>
	</thead>
<tbody>	
<c:if test="${not empty gFor}">
<c:forEach var="gestor" items="${gFor}">
<tr>
<td class="success">${gestor.nome}</td>
<td class="danger">${gestor.cpf}</td>
<td class="warning">${gestor.login}</td>
<td class="info">${gestor.senha}</td>
</tr>
</c:forEach>
</c:if>

</tbody>

</table>
</div>
</div>
</div>

<div class="container-fluid">

<div class="row">

<div class="col-md-6">
<br><br><br>

<h3>Cadastrar Projeto</h3>

<div class="form-group">
<form action="ManterProjeto.do" method="post">

<label class="col-md-4 control-label" for="nome">Nome: </label>  
<input id="nome" name="nome" type="text" placeholder="Insira o nome" class="form-control input-md"><br>

<label class="col-md-4 control-label" for="nome">Descrição: </label>  
<input id="descricao" name="descricao" type="text" placeholder="Insira a descricao" class="form-control input-md"><br>

<div class="row">
 <label class="col-md-6 control-label" for="">Segunda-feira: </label>             
                       
       <input type="checkbox" id="chkS1" name="chkS1" value="1">
       <input type="checkbox" id="chkS2" name="chkS2" value="1">
       <input type="checkbox" id="chkS3" name="chkS3" value="1">
</div>          
            
<div class="row">
<label class="col-md-6 control-label" for="">Terça-feira: </label>               
  
      <input type="checkbox" id="chkT1" name="chkT1" value="1">
      <input type="checkbox" id="chkT2" name="chkT2" value="1">
      <input type="checkbox" id="chkT3" name="chkT3" value="1"><br>
</div>
 
<div class="row">        
                
<label class="col-md-6 control-label" for="">Quarta-feira: </label>    
                   
      <input type="checkbox" id="chkQ1" name="chkQ1" value="1">
      <input type="checkbox" id="chkQ2" name="chkQ2" value="1">
      <input type="checkbox" id="chkQ3" name="chkQ3" value="1">
                        
 </div>     

<div class="row"> 

<label class="col-md-6 control-label" for="">Quinta-feira: </label>  

      <input type="checkbox" id="chkQI1" name="chkQI1" value="1">
      <input type="checkbox" id="chkQI2" name="chkQI2" value="1">
      <input type="checkbox" id="chkQI3" name="chkQI3" value="1">
                        
</div>
 
<div class="row"> 

<label class="col-md-6 control-label" for="">Sexta-feira: </label>                    
                    
                        <input type="checkbox" id="chkSX1" name="chkSX1" value="1">
                        <input type="checkbox" id="chkSX2" name="chkSX2" value="1">
                        <input type="checkbox" id="chkSX3" name="chkSX3" value="1">
                        
 </div>
 
<div class="row"> 

<label class="col-md-6 control-label" for="">Sabado: </label>                    
                    
       <input type="checkbox" id="chkSB1" name="chkSB1" value="1">
       <input type="checkbox" id="chkSB2" name="chkSB2" value="1">
       <input type="checkbox" id="chkSB3" name="chkSB3" value="1">
                        
</div>
  
<div class="row"> 

<label class="col-md-6 control-label" for="">Domingo: </label>                    
                   
      <input type="checkbox" id="chkD1" name="chkD1" value="1">
      <input type="checkbox" id="chkD2" name="chkD2" value="1">
      <input type="checkbox" id="chkD3" name="chkD3" value="1">
                        
</div>
     
<button type="submit" class="btn btn-default">Submit</button>

</form>
</div>
</div> 


<div class="col-md-6">


<br><br><br>
<div class="col-md-6">

<h3>Voluntarios Cadastrados</h3>
<table class="table table-bordered">
	<tr class="active">
		<td>NOME</td>
		<td>EMAIL</td>
		<td>SENHA</td>
	</tr>

<c:forEach var="voluntario" items="${vFor}">
<tr>
<td class="success">${voluntario.nome}</td>
<td class="danger">${voluntario.email}</td>
<td class="warning">${voluntario.senha}</td>
</tr>
</c:forEach>
</table>
</div>

</div>

</div>
</div>



<%@ include file="MenuBot.jsp" %>
</body>



</html>