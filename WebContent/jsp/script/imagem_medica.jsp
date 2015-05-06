<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<script>
	(function($){
		
		var TEMPLATE_ARQUIVO = "<input type=\"file\" name=\"material\" class=\"form-control mt\"/>";
		$btnAddImagem = $("#add-imagem"),
		$btnRemImagem = $("#rem-imagem"),
		$arquivosMaterial = $("#arquivos-material");
		
		$btnAddImagem.click(function(){
			$arquivosMaterial.append($(TEMPLATE_ARQUIVO));
		});
		
		$btnRemImagem.click(function(){
			var $files = $arquivosMaterial.find("[type=file]");
			$($files.get($files.length-1)).remove();
		});
	})(jQuery);
</script>