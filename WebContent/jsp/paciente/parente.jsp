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
	                                       	 	<button type="submit" class="btn btn-success">Salvar</button>
	                                      	 	<button type="reset" class="btn btn-warning">Limpar</button>
											</div>
		                                   	<div class="col-md-6">
		                                        <div class="form-group" id="arquivos-material">
		                                            <label>Arquivos</label>
		                                            <input type="file" name="material" class="form-control"/>
		                                        </div>
		                                   	</div>
		                                   	<div class="col-md-6">
		                                   		<button type="button" id="add-imagem" class="btn btn-info">Adicionar</button>
		                                   		<button type="button" id="rem-imagem" class="btn btn-danger">Excluir</button>
		                                   	</div>
										</fieldset>
									</div>
								</div>