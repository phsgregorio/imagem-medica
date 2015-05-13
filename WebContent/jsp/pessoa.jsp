<%@page import="com.puc.commons.labels.ApplicationsObject"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
						<input type="hidden" id="id_pessoa" name="id_pessoa">
                        <div class="panel-body">
                            <div class="row">
								<fieldset>
                                <legend>Dados Gerais</legend>
                                	<div class="col-md-6">
                                        <div class="form-group">
                                            <label>Nome</label>
                                            <input name="str_nome" class="form-control"/>
                                        </div>
                                        <div class="form-group">
                                            <label>Sexo</label>
                                            <select name="chr_sexo" class="form-control">
                                                <option></option>
                                                <option value="<%=ApplicationsObject.VALOR_FEMININO%>">Feminino</option>
                                                <option value="<%=ApplicationsObject.VALOR_MASCULINO%>">Masculino</option>
                                            </select>
                                        </div>
										<div class="form-group">
                                            <label>Endereco</label>
                                            <input name="str_endereco" class="form-control">
                                        </div>
										<div class="form-group">
                                            <label>CPF</label>
                                            <input name="num_cpf" class="form-control">
                                        </div>
                                        <div class="form-group">
                                            <label>UF</label>
                                             <input name="str_uf" class="form-control">
                                        </div>
                                	</div>
	                                <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Data Nascimento</label>
                                            <input name="dta_nascimento" class="form-control datepicker"/>
                                        </div>
										<div class="form-group">
                                            <label>Telefone</label>
                                            <input name="num_telefone" class="form-control">
                                        </div>
										<div class="form-group">
                                            <label>Email</label>
                                            <input name="str_email" class="form-control">
                                        </div>
										<div class="form-group">
                                            <label>RG</label>
                                            <input name="str_rg" class="form-control">
                                        </div>
                                        <div class="form-group">
                                            <label>Cidade</label>
                                             <input name="str_cidade" class="form-control">
                                        </div>
	                                </div>
	                                <div class="col-md-12">
	                                    <button type="submit" class="btn btn-success">Salvar</button>
	                                    <button type="reset" class="btn btn-warning">Limpar</button>
                                    </div>
                                </fieldset>
                            </div>
                            <!-- /.row (nested) -->
                        </div>
                        <!-- /.panel-body -->