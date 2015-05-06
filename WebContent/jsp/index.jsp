<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="template/header.jsp"></jsp:include>
			<div class="row">
				<div class="col-lg-12">
                    <h1 class="page-header">Pacientes Diagnosticados</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-8">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="fa fa-bar-chart-o fa-fw"></i> Pacientes Diagnosticados
                            <div class="pull-right">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown">
                                        Actions
                                        <span class="caret"></span>
                                    </button>
                                    <ul class="dropdown-menu pull-right" role="menu">
                                        <li><a href="#">Ações</a>
                                        </li>
                                        <li><a href="#">Another action</a>
                                        </li>
                                        <li><a href="#">Something else here</a>
                                        </li>
                                        <li class="divider"></li>
                                        <li><a href="#">Separated link</a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div id="morris-area-chart"></div>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                </div>
                <!-- /.col-lg-4 -->
            </div>
            <!-- /.row -->
			<jsp:include page="template/script.jsp"></jsp:include>
			<script>
				$(function() {
	
				    Morris.Area({
				        element: 'morris-area-chart',
				        data: [{
				            period: '2010 Q1',
				            iphone: 2666,
				            ipad: null,
				            itouch: 2647
				        }, {
				            period: '2010 Q2',
				            iphone: 2778,
				            ipad: 2294,
				            itouch: 2441
				        }, {
				            period: '2010 Q3',
				            iphone: 4912,
				            ipad: 1969,
				            itouch: 2501
				        }, {
				            period: '2010 Q4',
				            iphone: 3767,
				            ipad: 3597,
				            itouch: 5689
				        }, {
				            period: '2011 Q1',
				            iphone: 6810,
				            ipad: 1914,
				            itouch: 2293
				        }, {
				            period: '2011 Q2',
				            iphone: 5670,
				            ipad: 4293,
				            itouch: 1881
				        }, {
				            period: '2011 Q3',
				            iphone: 4820,
				            ipad: 3795,
				            itouch: 1588
				        }, {
				            period: '2011 Q4',
				            iphone: 15073,
				            ipad: 5967,
				            itouch: 5175
				        }, {
				            period: '2012 Q1',
				            iphone: 10687,
				            ipad: 4460,
				            itouch: 2028
				        }, {
				            period: '2012 Q2',
				            iphone: 8432,
				            ipad: 5713,
				            itouch: 1791
				        }],
				        xkey: 'period',
				        ykeys: ['iphone', 'ipad', 'itouch'],
				        labels: ['iPhone', 'iPad', 'iPod Touch'],
				        pointSize: 2,
				        hideHover: 'auto',
				        resize: true
				    });
				});
			</script>
<jsp:include page="template/footer.jsp"></jsp:include>