<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="template/header.jsp"></jsp:include>
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Parente</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">	
                	<div class="panel-options mb">
						<button id="criar-parente" class="btn btn-info">Criar Parente</button>
						<button id="listar-parente" class="btn btn-info">Listar Parente</button>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Cadastro de Parentes
                        </div>
                        <div class="panel-body">
                            <div class="row">
								<fieldset>	
                                	<form id="frm-parente" name="frm-parente" action="Parente.do" method="POST" class="crud-frm">
	                                	<input type="hidden" name="id_paciente" class="form-control"/>
	                                	<jsp:include page="pessoa.jsp"></jsp:include>
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

					var $frmParente = $("#frm-parente"),
						$btnCriar = $("#criar-parente"),
						$btnListar = $("#listar-parente"),
						$crudFrm = $(".frm-form"),
						$listFrm = $(".frm-list"),
						crudeObj = $frmParente.crud({
							crudId : "id_paciente",
							list : ["id_parente","str_nome","str_descricao"]
						});
					
					$btnCriar.click(function(){
						$(".frm-list").css("display","none");
						$(".frm-form").css("display","inline");	
						$frmParente.reseteForm();
					});

					$btnListar.click(function(){
						$(".frm-form").css("display","none");
						crudeObj.list();
					});

					// Salvando Registro
					// Formulário Original deve estar carregado
					// Deve ser validado e enviado
					// retornar mensagem
					$frmParente.submit(function(event){
						
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
