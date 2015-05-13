<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    							<div class="row">
    								<div class="col-md-12">
										<fieldset>
	                                       	<legend>Adicionar Material</legend>
                                       		<div class="col-md-6">
		                                        <div class="form-group">
		                                            <label>Tipo Do Material</label>
		                                            <select name="id_tipo_material" class="form-control">
		                                                <option value=""></option>
		                                                <option value="1">Informação Clínica</option>
		                                                <option value="2">Imagem Clínica</option>
		                                                <option value="3">Raio-X</option>
		                                            </select>
		                                        </div>
		                                        <div class="form-group">
		                                            <label>Compartilhar Material</label>
		                                            <select name="ind_compartilhar" class="form-control">
		                                                <option value="">Não Compartilhar</option>
		                                                <option value="M">Médico</option>
		                                                <option value="E">Educação</option>
		                                                <option value="A">Médico e Educação</option>
		                                            </select>
		                                        </div>
		                                        <div class="form-group">
		                                            <label>Descrição</label>
													<textarea class="form-control" rows="3"></textarea>
		                                        </div>
												<div id="uploader">
												    <p>Seu navegador não oferece suporte ao HTML5 ou HTML4.</p>
												</div>
												<br/>
	                                       	 	<button type="submit" class="btn btn-success">Salvar</button>
	                                      	 	<button type="reset" class="btn btn-warning">Limpar</button>
                                       		</div>
										</fieldset>
									</div>
								</div>