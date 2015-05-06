	
	/**
	 * Image View Plugin
	 * @author pedro.gregorio
	 * @param $
	 */
	(function($){
		
		
		var BOX_TEMPLATE = "<div id='box-template' class='hide'></div>",
			SHADOW_BOX_TEMPLATE = "<div id='shadow-box-template'></div>",
			GALLERY_TEMPLATE = "<div id='gallery-{0}'><div class='gallery-head'><div class='gallery-close'></div></div><div class='gallery-body'><div class='gallery-prev'></div><div class='gallery-next'></div><canvas class='gallery-image-edit ui-widget-content'></canvas></div></div>",
			// Panel Buttons
			BTN_DRAGGABLE = "<button class='btn btn-warning glyphicon glyphicon-fullscreen movimentar-imagem' title='Movimentar Imagem'></button>";
			BTN_UNDO = "<button class='btn btn-warning glyphicon glyphicon-retweet undo' title='Desfazer última alteração'></button>";
			BTN_DIFF = "<button class='btn btn-warning glyphicon glyphicon-tags' title='Comparar Imagem'></button>";
			BTN_INVERT_COLORS = "<button class='btn btn-warning glyphicon glyphicon-adjust inverter-cores' title='Inverter Cores'></button>";
			BTN_GRAYSCALE = "<button class='btn btn-warning glyphicon glyphicon-eye-close tom-cinza' title='Tons de Cinza'></button>";
			BTN_HISTOGRAM = "<button class='btn btn-warning glyphicon glyphicon-signal histograma' title='Limiar'></button>";
			BTN_BRIGHTNESS = "<button class='btn btn-warning glyphicon glyphicon-search brightness' title='Suavizar Imagem'></button>",
			// End Panel Buttons
			PANEL_TEMPLATE = "<div id='gallery-panel' class='hide'>"+ BTN_DRAGGABLE + BTN_UNDO + BTN_DIFF + BTN_INVERT_COLORS + BTN_GRAYSCALE + BTN_HISTOGRAM + BTN_BRIGHTNESS + "</div>";
			IMAGE_TEMPLATE = "<a href='{0}' class='image-link hide'><img src='{1}'/></a>",
			// Dialog Templates
			HISTOGRAM_TEMPLATE = "<div id='histograma' title='Limiar'><div class='form-group'><label>Limiares</label><div id='threshold-slider'></div></div><button id='threshold-apply' class='btn btn-success'>Aplicar</button></div>",
			BRIGHTNESS_TEMPLATE = "<div id='brightness' title='Suavizar Imagem'><div class='form-group'><label>Ajustar</label><div id='brightness-slider'></div></div></div>",
			imageView = function($elements,settings){
				return this.init($elements, settings);
			};
		
		imageView.prototype = {

			gallery : null,
			settings : {},
			/**
			 * Init Function
			 * @param settings
			 */
			init : function($elements,settings){

				this.createBox();
				this.createGallery(settings.name);
				this.createPanel(settings.name);
				this.createImages($elements);
				this.createHistogram();
				this.createBrightness();
				this.createEvents();

				return this.gallery;
			},
			/**
			 * Create Image View Boxes
			 */
			createBox : function(){
				
				var $boxTemplate = $("#box-template"),
					$shadowBoxTemplate= $("#shadow-box-template");

				if ($boxTemplate.length==0) {
					$(document.body).append($(BOX_TEMPLATE));
				}
				
				if ($shadowBoxTemplate.length==0) {
					$(document.body).append($(SHADOW_BOX_TEMPLATE));
				}
			},
			/**
			 * Create Gallary
			 * @param name
			 */
			createGallery : function(name){
				
				var $boxTemplate = $("#box-template");

				this.gallery = $(GALLERY_TEMPLATE.replace("{0}",name));
				$boxTemplate.append(this.gallery);
				
				// Make canvas draggable
				this.gallery.find(".gallery-image-edit")
							.draggable().draggable("disable")
							.css("opacity","1");
			},
			/**
			 * Create Options Panel
			 * @param name
			 */
			createPanel : function(name){
				
				var $panelTemplate = $("#gallery-panel");
				
				if ($panelTemplate.length==0) {
					$(document.body).append($(PANEL_TEMPLATE));
				}		
			},
			/**
			 * Add imagens to gallery
			 */
			createImages : function($images){
				
				var $gallery = this.gallery;

				$images.each(function(){
					
					var $a = $(this), $img = $a.find("img"),
						canvasObj = $gallery.find(".gallery-image-edit").canvas(),
						$newImage = $(
							IMAGE_TEMPLATE.replace("{0}", "#"+$a.attr("href"))
										  .replace("{1}", $img.attr("src"))
						);

					$gallery.find(".gallery-body").append($newImage);

					$a.attr("href","#"+$a.attr("href")).click(function(){

						var $boxTemplate = $("#box-template"),
							$shadowBoxTemplate= $("#shadow-box-template"),
							$panelTemplate = $("#gallery-panel"),
							$image = $newImage.find("img");

						/**
						 * Load canvas image
						 */
						canvasObj.loadImage($image);

						$boxTemplate.removeClass("hide");
						$shadowBoxTemplate.fadeIn("slow");
						$panelTemplate.removeClass("hide");
					});
				});
			},
			createHistogram : function(){
				
				var $histograma = $("#histograma");

				if($histograma.length==0) {
					$(HISTOGRAM_TEMPLATE).dialog({ 
				         autoOpen: false,
				         zIndex: 950
					});
				}
			},
			createBrightness : function(){
				
				var $brightness = $("#brightness");

				if($brightness.length==0) {
					
					$(BRIGHTNESS_TEMPLATE).dialog({ 
				         autoOpen: false,
				         zIndex: 950
					});
				}
			},
			/**
			 * Create Gallery Events
			 */
			createEvents : function(){
				
				var $boxTemplate = $("#box-template"),
					$shadowBoxTemplate = $("#shadow-box-template"),
					$panelTemplate = $("#gallery-panel"),
					$a = $("a.image-link"),
					$close = this.gallery.find(".gallery-close"),
					$prev = this.gallery.find(".gallery-prev"),
					$next = this.gallery.find(".gallery-next"),
					$gallery = this.gallery,
					$canvas = $gallery.find(".gallery-image-edit");
					// PID
					$histograma = $("#histograma"),
					$brightness = $("#brightness"),
					
					/**
					 * Responsible for canvas operations
					 */
					canvasObj = $canvas.canvas(),
					$btnDragg = $panelTemplate.find(".movimentar-imagem"),
					$btnInvertColors = $panelTemplate.find(".inverter-cores"),
					$btnTonsDeCinza = $panelTemplate.find(".tom-cinza"),
					$btnHistogram = $panelTemplate.find(".histograma"),
					$btnUndo = $panelTemplate.find(".undo"),
					$btnBrightness = $panelTemplate.find(".brightness"),
					// END PID
					eventsObj = {
						hideImageView : function(){
							
							$a.addClass("hide");
							$boxTemplate.addClass("hide");
							$panelTemplate.addClass("hide");
							$shadowBoxTemplate.fadeOut("slow");
						},
						getImage : function(option){
							var $image = $gallery.find(".image-link").not(".hide"),
								$newImage = $image[option || "next"]("a");
							
							if ($newImage.length>0) {
								
								$image.addClass("hide");
								$newImage.removeClass("hide");
								$boxTemplate.css("margin-left",-($newImage.width()/2))
											.css("margin-top",-($newImage.height()/2));
							}
						},
						originalImage : function(){
							canvasObj.originalImage();
						},
						undo : function(){
							canvasObj.undo();
						},
						makeDraggable : function(){
							
							if ($(".gallery-image-edit").draggable( "option", "disabled" )) {
								
								$canvas.draggable("enable").css("cursor","move");
							} else {
								
								$canvas.draggable("disable").css({
									opacity : 1,
									cursor : "default"
								});
							}
						},
						invertColors : function(){
							canvasObj.invertColors();
						},
						grayscale : function(){
							canvasObj.grayscale();
						},
						/**
						 * This function executes using a dynamic slider,
						 * when using it u have to store the original image data
						 * and pass it as a argument every time u want to change
						 * the image data
						 * 
						 * Note* Functions like threshold demands the interface
						 * developer to call addLastState manualy
						 */
						threshold : function(){
							
							var originalImageData = canvasObj.getImageData(),
								$slider = $("#threshold-slider"),
								$btnApply = $("#threshold-apply"),
								_canvasObj = canvasObj;

							$histograma.dialog("open").zIndex("zindex",950);
							
							$slider.slider({
								range: true, max: 255,
								change: function(event,ui){
									canvasObj.threshold($slider.slider("values", 0), $slider.slider("values", 1), originalImageData);
								}
							});

							$btnApply.click(function(){

								canvasObj.addLastState(_canvasObj.getImageData());
								$histograma.dialog("close");
							});
						},
						/**
						 * This function executes using a dynamic slider,
						 * when using it u have to store the original image data
						 * and pass it as a argument every time u want to change
						 * the image data
						 */
						brightness : function (){
							
							var originalImageData = canvasObj.getImageData();

							$brightness.dialog("open").zIndex("zindex",950);

							$("#brightness-slider").slider({
								max: 255,
								change: function(event,ui){
									canvasObj.brightness(ui.value, originalImageData);
								}
							});
						}
					};

				// Close Image View
				$shadowBoxTemplate.click(eventsObj.hideImageView);
				$close.click(eventsObj.hideImageView);
				
				// Next and Previous Image
				$prev.click(function(){ eventsObj.getImage("prev"); });
				$next.click(function(){ eventsObj.getImage("next"); });
				
				// Undo operation
				$btnUndo.click(function(){ eventsObj.undo(); });
				
				// Dragg image
				$btnDragg.click(function(){ eventsObj.makeDraggable(); });
				
				// Show histogram
				$btnHistogram.click(function(){ eventsObj.threshold(); });
				
				// Invert Colors
				$btnInvertColors.click(function(){ eventsObj.invertColors(); });
				
				// Grayscale Image
				$btnTonsDeCinza.click(function(){ eventsObj.grayscale(); });
				
				// Brightness Image
				$btnBrightness.click(function(){ eventsObj.brightness(); });
			}
		};

		$.fn.imageView = function() {

			var iv = new imageView(this, (arguments[0]) ? arguments[0] : { name : "default" } );
			return iv.gallery;
		};
	})(jQuery);