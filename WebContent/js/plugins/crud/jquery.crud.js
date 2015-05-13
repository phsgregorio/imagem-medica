
	/**
	 * jQuery Plugin to automate XML/JSON based forms
	 * @param $
	 */
	(function($){
		
		/**
		 * *Remember: crudObject context must be a form jQuery object
		 */
		var FRM_SAVE = "?o=save",
			FRM_EDIT = "?o=edit",
			FRM_LIST = "?o=list",
			FRM_DELE = "?o=dele",
			CRUD_DELETE = "<button type=\"button\" class='btn btn-danger glyphicon glyphicon-trash crud-delete' title='Excluir' data-id=''></button>",
			CRUD_EDIT = "<button type=\"button\" class='btn btn-info glyphicon glyphicon-edit crud-edit' title='Editar' data-id=''></button>",
			CRUD_TEMPLATE_SAVE_SUCCESS = "<div title='Sistema'>Salvo com Sucesso</div>",
			CRUD_TEMPLATE_INVALID_FIELDS = "<div title='Sistema'>Preencha os campos indicados antes de prosseguir</div>"
			CRUD_TEMPLATE_REMOVE_SUCCESS = "<div title='Sistema'>Registro excluído com Sucesso</div>",
			CRUD_TEMPLATE_LIST_EMPTY = "<div title='Sistema'>Nenhum registro foi encontrado</div>",
			CRUD_TEMPLATE_LIST_TABLE_CONTENT = "<div class=\"table-responsive frm-list\">",
			CRUD_TEMPLATE_LIST_TABLE = "<table class=\"table table-striped table-bordered table-hover\"></table>",
			CRUD_TEMPLATE_LIST_THEAD = "<thead></thead>",
			CRUD_TEMPLATE_LIST_TBODY = "<tbody></tbody>",
			crudDefault = {

				edit : function(data){
					
					if(data!=null) {

						for(var i in data){
							$("[name="+i+"]").val(data[i]);
						}
						
						$(".frm-list").css("display","none");
						$(".frm-form").css("display","inline");
					}
				},
				sendForm : function(o){

					$.ajax({
						url : o.url, data : o.data,
						type : "post", dataType : "json",
						success : function(data){
							o.callback.apply(this,[data]);
						}
					});
				}
			};
		
		$.fn.reseteForm = function(){
			this.find('input:text, input:password, input:file, input:hidden, select, textarea').val('');
			this.find('input:radio, input:checkbox').removeAttr('checked').removeAttr('selected');
			return this;
		};

		$.fn.crud = function(objProperties){

			var $this = $(this),
				_obj = objProperties;

			return {
				save : function(fn){
					
					var callbackFn = fn;
					
					// If theres no requiredFields or fields are not empty(valid)
					if (!_obj.hasOwnProperty("requiredFields") || this.validate() ) {
						
						crudDefault.sendForm({
							url: $this.attr("action")+FRM_SAVE,
							data: $this.serialize(),
							callback: function(data){

								// Callback
								if (callbackFn) {
									callbackFn.apply(this, arguments);
								}

								// Send user interface message
								$(CRUD_TEMPLATE_SAVE_SUCCESS).dialog({ 
							         autoOpen: true,
							         zIndex: 500
								});
								
								// Clean old required fields
								$(".requiredField").removeClass("requiredField");
							}
						});
					}
				},
				/**
				 * Validate the crud form fields
				 * _obj.requiredFields
				 */
				validate : function() {

					var $field,
						returnValue = true;
					
					for (var i in _obj.requiredFields) {
						
						$field = $("[name="+_obj.requiredFields[i]+"]");

						// Fields exists and not empty
						if ($field.length!=0 && $field.val().trim().length==0) {
							$field.addClass("requiredField");
							returnValue = false;
						}
					}

					if (!returnValue) {
						$(CRUD_TEMPLATE_INVALID_FIELDS).dialog({ 
					         autoOpen: true,
					         zIndex: 500
						});
					}
					
					return returnValue;
				},
				list : function(fn){
					
					crudDefault.sendForm({
						url: $this.attr("action")+FRM_LIST,
						callback: function(data){
							
							var $content = $(CRUD_TEMPLATE_LIST_TABLE_CONTENT),
								$table = $(CRUD_TEMPLATE_LIST_TABLE),
								$thead = $(CRUD_TEMPLATE_LIST_THEAD),
								$tbody = $(CRUD_TEMPLATE_LIST_TBODY),
								$frm = $this,
								$frmForm = $frm.find(".frm-form"),
								theadHtml = "";
							
							// Creating thead
							if (data.length>0) {

								// Creating THEAD
								for(var i in data[0]){
									
									if (objProperties==null || objProperties.list==null || objProperties.list.indexOf(i)!=-1) {
										var column = (i.indexOf("_")!=-1) ? i.split("_")[1].toUpperCase() : i.toUpperCase();
										theadHtml += "<th>"+column+"</th>";	
									}
								}
								
								theadHtml += "<th></th><th></th>";
								
								$thead.append($("<tr>"+theadHtml+"</tr>"));
								
								// Creating TBODY
								for(var i in data){
									
									var tbodyHtml = "<tr>",
										$tbodyContent,
										$tdEdit = $("<td align=\"center\"></td>"),
										$tdDelete = $("<td align=\"center\"></td>");
										$btnEdit = $(CRUD_EDIT),
										$btnDelete = $(CRUD_DELETE),
										obj = data[i];
									
									for(var j in data[i]){
										
										if (objProperties==null || objProperties.list==null || objProperties.list.indexOf(j)!=-1) {
											tbodyHtml += "<td>"+data[i][j]+"</td>";
										}
									}

									$btnEdit.attr("data-id",data[i][_obj.crudId]);
									$btnDelete.attr("data-id",data[i][_obj.crudId]);
														
									$tdEdit.append($btnEdit);
									$tdDelete.append($btnDelete);
									$tbodyContent = $(tbodyHtml+"</tr>").append($tdEdit).append($tdDelete);
									$tbody.append($tbodyContent);
								}
								
								// Creating TABLE
								if ($content.length>0) {
									$this.find(".frm-list").remove();
								}
								
								$frmForm.css("display","none");
								$table.append($thead).append($tbody);
								$this.append($content.append($table));
								$table.dataTable();
								
								// Bind crud edit event
								$(".crud-edit").click(function(event){
									event.preventDefault();
									
									crudDefault.sendForm({
										url: $this.attr("action")+FRM_EDIT,
										data: "c="+$(this).attr("data-id"),
										callback: crudDefault.edit
									});
								});
								
								// Bind crud delete event
								$(".crud-delete").click(function(event){
									event.preventDefault();
									$(this).closest("tr").remove();

									crudDefault.sendForm({
										url: $this.attr("action")+FRM_DELE,
										data: "c="+$(this).attr("data-id"),
										callback: function(data){
											$(CRUD_TEMPLATE_REMOVE_SUCCESS).dialog({ 
										         autoOpen: true,
										         zIndex: 500
											});
										}
									});
								});
							} else {
								
								// Nenhum registro cadastrado
								$(CRUD_TEMPLATE_LIST_EMPTY).dialog({ 
							         autoOpen: true,
							         zIndex: 500
								});
							}
						}
					});
				}
			};
		};
	})(jQuery);