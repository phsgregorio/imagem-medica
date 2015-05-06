<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
			<nav class="navbar-default navbar-static-side" role="navigation">
	            <div class="sidebar-collapse">
	                <ul class="nav" id="side-menu">
	                    <li class="sidebar-search">
	                        <div class="input-group custom-search-form">
	                            <input type="text" class="form-control" placeholder="Search...">
	                            <span class="input-group-btn">
	                                <button class="btn btn-default" type="button">
	                                    <i class="fa fa-search"></i>
	                                </button>
	                            </span>
	                        </div>
	                        <!-- /input-group -->
	                    </li>
	                    <li>
	                        <a href="index.jsp"><i class="fa fa-dashboard fa-fw"></i> Painel Principal</a>
	                    </li>
	                    <li>
	                        <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Paciente<span class="fa arrow"></span></a>
	                        <ul class="nav nav-second-level">
	                            <li>
	                                <a href="Paciente.do?o=init">Cadastrar Paciente</a>
	                            </li>
	                            <li>
	                                <a href="Paciente.do?o=list">Listar Paciente</a>
	                            </li>
	                        </ul>
	                        <!-- /.nav-second-level -->
	                    </li>
	                    <li>
	                        <a href="tables.html"><i class="fa fa-table fa-fw"></i> Imagem M�dica</a>
	                        <ul class="nav nav-second-level">
	                            <li>
	                                <a href="imagem_list.jsp">Visualiza��o R�pida</a>
	                            </li>
	                            <li>
	                                <a href="tipo_imagem.jsp">Busca Detalhada</a>
	                            </li>
	                        </ul>
	                    </li>
	                    <li>
	                        <a href="forms.html"><i class="fa fa-edit fa-fw"></i> Institui��o</a>
	                        <ul class="nav nav-second-level">
	                            <li>
	                                <a href="Instituicao.do?o=init">Institui��o</a>
	                            </li>
	                            <li>
	                                <a href="Medico.do?o=init">M�dico</a>
	                            </li>
	                            <li>
	                                <a href="Doenca.do?o=init">Doen�as</a>
	                            </li>
	                            <li>
	                                <a href="Exame.do?o=init">Exames</a>
	                            </li>
	                        </ul>
	                    </li>
	                    <li>
	                        <a href="forms.html"><i class="fa fa-edit fa-wrench"></i> Configura��es</a>
	                        <ul class="nav nav-second-level">
	                            <li>
	                                <a href="perfil.jsp">Perfil</a>
	                            </li>
	                            <li>
	                                <a href="notificacoes.jsp">Notifica��es</a>
	                            </li>
	                            <li>
	                                <a href="Permissao.do?o=init">Permiss�es</a>
	                            </li>
	                            <li>
	                                <a href="Usuario.do?o=init">Usu�rio</a>
	                            </li>
	                        </ul>
	                        <!-- /.nav-second-level -->
	                    </li>
	                </ul>
	                <!-- /#side-menu -->
	            </div>
	            <!-- /.sidebar-collapse -->
	        </nav>
	        <!-- /.navbar-static-side -->