<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="template/header.jsp"></jsp:include>
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Usuário</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">	
                	<div class="panel-options mb">
						<button id="criar-usuario" class="btn btn-info">Criar Usuário</button>
						<button id="listar-usuario" class="btn btn-info">Listar Usuário</button>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Cadastro de Usuários
                        </div>
                        <div class="panel-body">
                            <div class="row">
								<fieldset>	
                                	<form id="frm-usuario" name="frm-usuario" action="Usuario.do" method="POST" class="crud-frm">
	                                	<input type="hidden" name="id_usuario" class="form-control"/>
	                                	<div class="frm-form">
											<div class="col-md-6">
		                                        <div class="form-group">
		                                            <label>Pessoa</label>
		                                             <div class="form-group">
			                                            <select name="id_pessoa" class="form-control">
			                                         		<option value=""></option>
			                                            	<c:forEach var="pessoa" items="${pessoas}">
			                                            		<option value="${pessoa.id_pessoa}">${pessoa.str_nome}</option>
			                                            	</c:forEach>
			                                            </select>
		                                            </div>
		                                        </div>
		                                        <div class="form-group">
		                                            <label>Permissão</label>
		                                             <div class="form-group">
			                                            <select name="id_permissao" class="form-control">
			                                            	<option value=""></option>
			                                            	<c:forEach var="permissao" items="${permissoes}">
			                                            		<option value="${permissao.id_permissao}">${permissao.str_nome}</option>
			                                            	</c:forEach>
			                                            </select>
		                                            </div>
		                                        </div>
		                                        <div class="form-group">
		                                            <label>Senha</label>
		                                            <input type="password" name="str_senha" class="form-control"></input>
		                                        </div>
		                                        <div class="form-group">
		                                            <label>Confirmação de Senha</label>
		                                            <input type="password" name="str_senha_confirmacao" class="form-control"></input>
		                                        </div>
			                                </div>
			                                <div class="col-md-12">
			                                    <button type="submit" class="btn btn-success">Salvar</button>
			                                    <button type="reset" class="btn btn-warning">Limpar</button>
		                                    </div>
	                                	</div>
	                                	<div class="frm-list"></div>
									</form>
                                </fieldset>
                            </div>
                            <!-- /.row (nested) -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
			<jsp:include page="template/script.jsp"></jsp:include>
			<jsp:include page="script/imagem_medica.jsp"></jsp:include>
			<script>
				(function($){

					var $frmDoenca = $("#frm-usuario"),
						$btnCriar = $("#criar-usuario"),
						$btnListar = $("#listar-usuario"),
						crudeObj = $frmDoenca.crud({
							crudId : "id_usuario",
							list : ["id_usuario","str_email","str_descricao"]
						});
					
					$btnCriar.click(function(){
						$(".frm-list").css("display","none");
						$(".frm-form").css("display","inline");	
						$frmDoenca.reseteForm();
					});

					$btnListar.click(function(){
						$(".frm-form").css("display","none");
						crudeObj.list();
					});

					$frmDoenca.submit(function(event){
						
						event.preventDefault();
						
						crudeObj.save();

						window.setTimeout(function(){
							crudeObj.list();
						}, 200);

						return false;
					});
				})(jQuery);
			</script>
<jsp:include page="template/footer.jsp"></jsp:include>
