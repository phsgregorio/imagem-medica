<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="template/header.jsp"></jsp:include>
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Doença</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">	
                	<div class="panel-options mb">
						<button id="criar-doenca" class="btn btn-info">Criar Doença</button>
						<button id="listar-doenca" class="btn btn-info">Listar Doença</button>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Cadastro de Doenças
                        </div>
                        <div class="panel-body">
                            <div class="row">
								<fieldset>	
                                	<form id="frm-doenca" name="frm-doenca" action="Doenca.do" method="POST" class="crud-frm">
	                                	<input type="hidden" name="id_doenca" class="form-control"/>
	                                	<div class="frm-form">
											<div class="col-md-6">
		                                        <div class="form-group">
		                                            <label>Nome da Doença</label>
		                                            <input name="str_nome" class="form-control"/>
		                                        </div>
		                                        <div class="form-group">
		                                            <label>Descrição</label>
		                                            <textarea name="str_descricao" class="form-control"></textarea>
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

					var $frmDoenca = $("#frm-doenca"),
						$btnCriar = $("#criar-doenca"),
						$btnListar = $("#listar-doenca"),
						crudeObj = $frmDoenca.crud({
							crudId : "id_doenca",
							requiredFields : ["str_nome"],
							list : ["id_doenca","str_nome","str_descricao"]
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
						
						crudeObj.save(function(){
							crudeObj.list();
						});

						return false;
					});
				})(jQuery);
			</script>
<jsp:include page="template/footer.jsp"></jsp:include>
