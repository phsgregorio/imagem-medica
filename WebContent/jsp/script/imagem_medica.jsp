<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

    <!-- Plupload Plugin -->
    <script src="js/plugins/plupload/plupload.full.min.js"></script>
    <script src="js/plugins/plupload/jquery.ui.plupload/jquery.ui.plupload.min.js"></script>
    <script src="js/plugins/plupload/jquery.plupload.queue/jquery.plupload.queue.min.js"></script>
    <script src="js/plugins/plupload/i18n/pt_BR.js"></script>

	<script>
		(function($){
			
			$(document).ready(function(){
				
				$(function() {
					
					var $inputIdPaciente = $("[name=id_paciente]");
					
					// Bind upload field events and ui
					$("#uploader").pluploadQueue({
				        // General settings
				        runtimes : 'html5,html4',
				        url : 'Paciente.do?o=upload&id_paciente=1'/* TODO pedro.gregorio Resolver problema Session(implementar medico e paciente)+$inputIdPaciente.val()*/,

				        filters : {
				            max_file_size : '30mb',
				 
				            // Specify what files to browse for
				            mime_types: [
				                {title : "Image files", extensions : "jpg,gif,png,dcm"},
				            ]
				        },

				        // PreInit events, bound before any internal events
				        preinit : {
				        },
				 
				        // Post init events, bound after the internal events
				        init : {
				        }
				    });
				});
			});
		})(jQuery);
	</script>
    <script>
	    $(document).ready(function() {
	        
	    	/**
	    	 * Build the table
	    	 */
	    	$('#dataTables').dataTable();
	    	
	    	/**
	    	 * Build Image View
	    	 */
	    	$("a.medical-image").imageView({
	    		name : "medical-image"
	    	});
	    });
    </script>