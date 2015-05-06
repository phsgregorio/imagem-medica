<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="template/header.jsp"></jsp:include>
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Nota</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">	
                	<div class="panel-options mb">
						<button id="criar-nota" class="btn btn-info">Criar Nota</button>
						<button id="listar-nota" class="btn btn-info">Listar Nota</button>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Cadastro de Notas
                        </div>
                        <div class="panel-body">
                            <div class="row">
                               	<form id="frm-nota" name="frm-nota" action="Nota.do" method="POST" class="crud-frm">
                               		<input type="hidden" name="id_nota" class="form-control"/>
                                	<input type="hidden" name="id_paciente" class="form-control"/>
									<div class="col-md-6">
                                        <div class="form-group">
                                            <label>Descrição</label>
                                            <textarea name="str_descricao" class="form-control"></textarea>
                                        </div>
                                    </div>
	                                <div class="col-md-12">
	                                    <button type="submit" class="btn btn-success">Salvar</button>
	                                    <button type="reset" class="btn btn-warning">Limpar</button>
                                    </div>
                                	<div class="frm-list"></div>
								</form>
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

					var $frmNota = $("#frm-nota"),
						$btnCriar = $("#criar-nota"),
						$btnListar = $("#listar-nota"),
						crudeObj = $frmNota.crud({
							crudId : "id_nota",
							list : ["id_nota","str_descricao"]
						});
					
					$btnCriar.click(function(){
						$(".frm-list").css("display","none");
						$(".frm-form").css("display","inline");	
						$frmNota.reseteForm();
					});

					$btnListar.click(function(){
						$(".frm-form").css("display","none");
						crudeObj.list();
					});

					$frmNota.submit(function(event){
						
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
