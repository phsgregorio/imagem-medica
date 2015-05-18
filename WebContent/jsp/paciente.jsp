<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="template/header.jsp"></jsp:include>
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Paciente</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">	
                	<div class="panel-options mb">
                		<button type="button" class="btn btn-info offset active" data-view="resumo">Resumo</button>
                		<button type="button" class="btn offset" data-view="dados-pessoais">Dados Pessoais</button>
                		<button type="button" class="btn offset" data-view="dados-parentes">Parentes</button>
                		<button type="button" class="btn offset" data-view="dados-clinicos">Dados Clínicos</button>
                		<button type="button" class="btn offset" data-view="laboratorio">Laboratório</button>
                		<button type="button" class="btn offset" data-view="imagem-medica">Imagens Clínicas</button>
                		<button type="button" class="btn offset" data-view="historico-caso">Histórico do Caso</button>
                		<button type="button" class="btn offset" data-view="notas">Notas</button>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Edição de Paciente
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-12">
                                    <form id="resumo" role="form" class="hide app-tab">
                                    	<jsp:include page="paciente/resumo.jsp"></jsp:include>
                                    </form>
									<form id="dados-pessoais" name="dados-pessoais" action="Pessoa.do" role="form" class="app-tab">
										<input type="hidden" name="id_paciente">
				                    	<jsp:include page="pessoa.jsp"></jsp:include>
									</form>
									<!-- SEPARAR EM PEQUENAS APLICAÇÕES, MUITO MELHOR -->
									<form id="dados-parentes" name="dados-parentes" action="Paciente.do" role="form" class="hide app-tab">
				                    	<input type="hidden" name="id_paciente">
				                    	<jsp:include page="pessoa.jsp"></jsp:include>
									</form>
                                    <form id=imagem-medica name="imagem-medica" role="form" class="hide app-tab" enctype="multipart/form-data">
                                    	<input type="hidden" name="id_paciente">
                                    	<jsp:include page="paciente/imagem_medica.jsp"></jsp:include>
                                    </form>
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

					var $frmResumo = $("#resumo"), // Apenas Exclusões, sem edição
						$frmDadosPessoais = $("#dados-pessoais"),
						$frmImagemMedica = $("#imagem-medica"),
						crudeDadosPessoais = $frmDadosPessoais.crud({
							crudId : "id_pessoa"
						});
					
					$frmDadosPessoais.submit(function(event){

						event.preventDefault();
						crudeDadosPessoais.save();
						return false;
					});
				})(jQuery);
			</script>
<jsp:include page="template/footer.jsp"></jsp:include>
