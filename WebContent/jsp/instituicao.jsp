<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="template/header.jsp"></jsp:include>
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Instituição</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">	
                	<div class="panel-options mb">
						<button id="criar-instituicao" class="btn btn-info">Criar Instituição</button>
						<button id="listar-instituicao" class="btn btn-info">Listar Instituição</button>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Cadastro de Instituiçãos
                        </div>
                        <div class="panel-body">
                            <div class="row">
								<fieldset>	
                                	<form id="frm-instituicao" name="frm-instituicao" action="Instituicao.do" method="POST" class="crud-frm">
	                                	<input type="hidden" name="id_instituicao" class="form-control"/>
	                                	<div class="frm-form">
											<div class="col-md-6">
		                                        <div class="form-group">
		                                            <label>Nome da Instituição</label>
		                                            <input name="str_nome" class="form-control"/>
		                                        </div>
		                                        <div class="form-group">
		                                            <label>Email</label>
													<input name="str_email" class="form-control"/>
		                                        </div>
		                                        <div class="form-group">
		                                            <label>Descrição</label>
		                                            <textarea name="str_descricao" class="form-control"></textarea>
		                                        </div>
		                                        <div class="form-group">
		                                            <label>UF</label>
		                                             <input name="str_uf" class="form-control">
		                                        </div>
		                                        <div class="form-group">
		                                            <label>Cidade</label>
		                                             <input name="str_cidade" class="form-control">
		                                        </div>
			                                </div>
			                                <div class="col-md-6">
		                                        <div class="form-group">
		                                            <label>Telefone</label>
		                                            <input name="num_telefone" class="form-control"/>
		                                        </div>
		                                        <div class="form-group">
		                                            <label>Fax</label>
													<input name="num_fax" class="form-control"/>
		                                        </div>
		                                        <div class="form-group">
		                                            <label>Endereço</label>
		                                            <input name="str_endereco" class="form-control"/>
		                                        </div>
		                                        <div class="form-group">
		                                            <label>Bairro</label>
													<input name="str_bairro" class="form-control"/>
		                                        </div>
		                                        <div class="form-group">
		                                            <label>Número</label>
		                                            <input name="num_endereco" class="form-control"/>
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

					var $frmInstituicao = $("#frm-instituicao"),
						$btnCriar = $("#criar-instituicao"),
						$btnListar = $("#listar-instituicao"),
						crudeObj = $frmInstituicao.crud({
							crudId : "id_instituicao",
							list : ["id_instituicao","str_nome","str_email","num_telefone"]
						});
					
					$btnCriar.click(function(){
						$(".frm-list").css("display","none");
						$(".frm-form").css("display","inline");	
						$frmInstituicao.reseteForm();
					});

					$btnListar.click(function(){
						$(".frm-form").css("display","none");
						crudeObj.list();
					});

					// Salvando Registro
					// Formulário Original deve estar carregado
					// Deve ser validado e enviado
					// retornar mensagem
					$frmInstituicao.submit(function(event){
						
						event.preventDefault();
						
						crudeObj.save(function(){
							crudeObj.list();
	 					});

						return false;
					});
				})(jQuery);
			</script>
<jsp:include page="template/footer.jsp"></jsp:include>
