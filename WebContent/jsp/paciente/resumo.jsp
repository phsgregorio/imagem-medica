<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    							<div class="row">
									<div class="col-md-6">
                                        <fieldset>
                                        	<legend>Diagnóstico</legend>
											<div class="form-group">
												<select multiple="multiple" class="form-control">
													<option>Diagnostico 1</option>
													<option>Diagnostico 2</option>
													<option>Diagnostico 3</option>
												</select>
				                            </div>
                                       	 	<button type="reset" class="btn btn-danger">Excluir</button>
                                        </fieldset>
                                   	</div>
                                   	<div class="col-md-6">
                                        <fieldset>
                                        	<legend>Parentes</legend>
											<div class="form-group">
												<select multiple="multiple" class="form-control">
													<option>Parente 1</option>
													<option>Parente 2</option>
													<option>Parente 3</option>
												</select>
				                            </div>
                                       		<button type="reset" class="btn btn-danger">Excluir</button>
                                        </fieldset>
                                   	</div>
                                   	<div class="col-md-12 mt">
                                        <fieldset>
                                        	<legend>Referênciado Por</legend>
											<div class="form-group">
		                                        <div class="form-group">
		                                            <label>Título</label>
		                                            <input name="nome" class="form-control" readonly="readonly"/>
		                                        </div>
												<div class="form-group">
		                                            <label>Nome do Médico</label>
		                                            <input name="nome" class="form-control" readonly="readonly"/>
		                                        </div>
				                            </div>
				                            <button type="reset" class="btn btn-success">Acessar Médico</button>
                                        </fieldset>
									</div>
								</div>