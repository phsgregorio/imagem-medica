<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    							<div class="row">
    								<div class="col-md-12">
										<fieldset>
	                                       	<legend>Adicionar Material</legend>
                                       		<div class="col-md-6">
		                                        <div class="form-group">
		                                            <label>Tipo Do Material</label>
		                                            <select name="id_tipo_material" class="form-control">
		                                                <option value=""></option>
		                                                <option value="1">Informa��o Cl�nica</option>
		                                                <option value="2">Imagem Cl�nica</option>
		                                                <option value="3">Raio-X</option>
		                                            </select>
		                                        </div>
		                                        <div class="form-group">
		                                            <label>Compartilhar Material</label>
		                                            <select name="ind_compartilhar" class="form-control">
		                                                <option value="">N�o Compartilhar</option>
		                                                <option value="M">M�dico</option>
		                                                <option value="E">Educa��o</option>
		                                                <option value="A">M�dico e Educa��o</option>
		                                            </select>
		                                        </div>
		                                        <div class="form-group">
		                                            <label>Descri��o</label>
													<textarea class="form-control" rows="3"></textarea>
		                                        </div>
		                                        <div class="form-group">
		                                            <label>Imagem</label>
													<div id="uploader">
													    <p>Seu navegador n�o oferece suporte ao HTML5 ou HTML4.</p>
													</div>
												</div><br/>
	                                       	 	<button type="submit" class="btn btn-success">Salvar</button>
	                                      	 	<button type="reset" class="btn btn-warning">Limpar</button>
											</div>
											<div class="col-md-6">
												<div class="form-group">
		                                            <label>Imagens Cadastradas</label>
													<c:if test="${not empty paciente.imagens}">
							                            <div class="table-responsive">
															<table id="image-table" class="table table-striped table-bordered table-hover" id="dataTables">
							                                    <thead>
							                                        <tr>
							                                            <th>Tipo Imagem</th>
							                                            <th>Descri��o</th>
							                                            <th>Miniatura</th>
							                                        </tr>
							                                    </thead>
							                                    <tbody>
							                                    	<c:forEach items="${paciente.imagens}" var="imagem">
								                                        <tr>
								                                            <td></td>
								                                            <td>${imagem.str_descricao}</td>
								                                            <td align="center">
															                	<a href="ServicoDeImagem.do?id=${imagem.id_paciente}&img=${imagem.str_caminho_fisico}" class="medical-image">
																					<img src="ServicoDeImagem.do?id=${imagem.id_paciente}&img=${imagem.str_caminho_fisico}" class="img-thumb" alt="${imagem.str_descricao}"/>
																				</a>
								                                            </td>
								                                        </tr>
							                                        </c:forEach>
																</tbody>
															</table>
														</div>
													</c:if>
		                                        </div>
                                       		</div>
										</fieldset>
									</div>
								</div>