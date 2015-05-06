<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="jsp/template/header.jsp">
	<jsp:param value="../" name="PATH"/>
</jsp:include>
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Imagens M�dicas</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Visualiza��o R�pida de Imagens
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="table-responsive">
								<table id="image-table" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th>Paciente</th>
                                            <th>Diagn�stico</th>
                                            <th>M�dico Respons�vel</th>
                                            <th>Tipo Imagem</th>
                                            <th>Miniatura</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>Jo�o Alberto Pereira</td>
                                            <td>Anom�lia Gen�tica</td>
                                            <td>Roberto Drumond</td>
                                            <td>Radiol�gica</td>
                                            <td>
                                            	<a href="img/image2.jpg" class="medical-image">
													<img src="img/image2.jpg" class="img-thumb" alt=""/>
												</a>
											</td>
                                        </tr>
                                        <tr>
                                            <td>Jo�o Alberto Pereira</td>
                                            <td>Anom�lia Gen�tica</td>
                                            <td>Roberto Drumond</td>
                                            <td>Radiol�gica</td>
                                            <td>
                                            	<a href="img/image3.jpg" class="medical-image">
													<img src="img/image3.jpg" class="img-thumb" alt=""/>
												</a>
											</td>
                                        </tr>
                                        <tr>
                                            <td>Gilson Gustavo Dantas</td>
                                            <td>Anom�lia Gen�tica</td>
                                            <td>Roberto Drumond</td>
                                            <td>Radiol�gica</td>
                                            <td>
                                            	<a href="img/image4.jpg" class="medical-image">
													<img src="img/image4.jpg" class="img-thumb" alt=""/>
												</a>
											</td>
                                        </tr>
                                        <tr>
                                            <td>Adailr Silva Lemos</td>
                                            <td>Anom�lia Gen�tica</td>
                                            <td>Carla Versieux</td>
                                            <td>Radiol�gica</td>
                                            <td>
                                            	<a href="img/image5.jpg" class="medical-image">
													<img src="img/image5.jpg" class="img-thumb" alt=""/>
												</a>
											</td>
                                        </tr>
                                        <tr>
                                            <td>Adailr Silva Lemos</td>
                                            <td>Anom�lia Gen�tica</td>
                                            <td>Edigio Luiz</td>
                                            <td>Radiol�gica</td>
                                            <td>
                                           		<a href="img/image6.jpg" class="medical-image">
													<img src="img/image6.jpg" class="img-thumb" alt=""/>
												</a>
											</td>
                                        </tr>
                                        <tr>
                                            <td>Maria da Penha Cruz</td>
                                            <td>Anom�lia Gen�tica</td>
                                            <td>Edigio Luiz</td>
                                            <td>Radiol�gica</td>
                                            <td>
                                            	<a href="img/image7.jpg" class="medical-image">
													<img src="img/image7.jpg" class="img-thumb" alt=""/>
												</a>
											</td>
                                        </tr>
                                        <tr>
                                            <td>Jo�o Alberto Pereira</td>
                                            <td>Anom�lia Gen�tica</td>
                                            <td>Roberto Drumond</td>
                                            <td>Radiol�gica</td>
                                            <td>
                                            	<a href="img/image1.jpg" class="medical-image">
													<img src="img/image1.jpg" class="img-thumb" alt=""/>
												</a>
											</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                            <!-- /.table-responsive -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
			<jsp:include page="jsp/template/script.jsp"></jsp:include>
		    <script>
			    $(document).ready(function() {
			        
			    	/**
			    	 * Build the table
			    	 */
			    	$('#dataTables-example').dataTable();
			    	
			    	/**
			    	 * Build Image View
			    	 */
			    	$("a.medical-image").imageView({
			    		name : "medical-image"
			    	});
			    });
		    </script>
<jsp:include page="jsp/template/footer.jsp"></jsp:include>