<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="template/header.jsp"></jsp:include>
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Médico</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">	
                	<div class="panel-options mb">
                		<button id="criar-medico" class="btn btn-info" type="button" data-view="frm-pessoa">Dados Gerais</button>
                		<button type="button" class="btn offset" data-view="frm-medico">Dados do Médico</button>
						<button id="listar-medico" class="btn btn-info">Listar Médico</button>

                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Cadastro de Médicos
                        </div>
                        <div class="panel-body">
                            <div class="row">
                            	<div class="col-lg-12">
									<fieldset>	
	                                	<form id="frm-pessoa" name="frm-pessoa" action="Medico.do" method="POST" class="crud-frm">
	                                		<input type="hidden" name="salva_pessoa" value="true">
		                                	<jsp:include page="pessoa.jsp"></jsp:include>
										</form>
	                                	<form id="frm-medico" name="frm-medico" action="Medico.do" method="POST" class="crud-frm hide app-tab">
		                                	<input type="hidden" id="id_medico" name="id_medico">
										</form>
	                                </fieldset>
                                </div>
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

					var $frmMedico = $("#frm-medico"),
						$frmPessoa = $("#frm-pessoa"),
						$btnCriar = $("#criar-medico"),
						$btnListar = $("#listar-medico"),
						crudPessoa = $frmPessoa.crud({
							crudId : "id_pessoa",
							requiredFields : ["str_nome","str_email","dta_nascimento","str_uf","str_cidade"],
							list : ["id_instituicao","str_nome","str_email","num_telefone"]
						}),
						crudMedico = $frmMedico.crud({
							crudId : "id_medico"
						});
					
					$btnCriar.click(function(){
						$(".frm-form").css("display","inline");
						$(".frm-list").css("display","none");
						$frmMedico.reseteForm();
						$frmPessoa.reseteForm();
					});

					$btnListar.click(function(){
						$(".frm-form").css("display","none");
						crudeObj.list();
					});

					/**
					 * Save Pessoa Control
					 */
					$frmPessoa.submit(function(event){
						
						event.preventDefault();
						
						crudPessoa.save(function(){
							crudMedico.list();
	 					});

						return false;
					});
					
					/**
					 * Save Medico Control
					 */
					$frmMedico.submit(function(event){
						//event.preventDefault();
						//crudMedico.save();
						//return false;
					});
				})(jQuery);
			</script>
<jsp:include page="template/footer.jsp"></jsp:include>
