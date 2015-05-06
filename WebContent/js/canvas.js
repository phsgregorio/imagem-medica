	
	/**
	 * Canvas Plugin
	 * @author pedro.gregorio
	 * @param $
	 * 
	 */
	(function($){
		
		if (!$) {
			throw "jQuery dependent";
		}
		
		$.fn.canvas = function(){

			var obj = this.get(0),
				context = obj.getContext('2d'),
				$originalImage = null,
				// Control image operations
				lastOperations = [];

			return {
				
				/**
				 * Get Image Data cloning object
				 */
				getImageData : function(){
					
					var imageData = context.getImageData(0,0, obj.width, obj.height),
						dataCopy = new Uint8ClampedArray(imageData.data),
						newImageData = context.createImageData(imageData);

					newImageData.data.set(dataCopy);
				
					return newImageData;
				},
				/**
				 * Clone Image Data object
				 */
				cloneImageData : function(imageData){

					var dataCopy = new Uint8ClampedArray(imageData.data),
						newImageData = context.createImageData(imageData);

					newImageData.data.set(dataCopy);

					return newImageData;
				},
				loadImage : function($image){
					
					var imageObj = new Image();
					
					$originalImage = $image;

					// Set canvas main properties
					imageObj.onload = function() {
						
						context.drawImage(imageObj, 0, 0);
						
						// Image operations controll
						imageData = context.getImageData(0,0, obj.width, obj.height);
						lastOperations.push(imageData);
					};

					// Set source and resize canvas
					imageObj.src = $originalImage.attr("src");
					this.resizeCanvas($originalImage);
				},
				resizeCanvas : function($image){

					var $obj = $(obj);
					
					$obj.attr("width", $image.get(0).width).attr("height", $image.get(0).height);
					$obj.css({
						position : "fixed",
						top : "80px",
						left : "50%",
						"margin-left" : - parseInt($image.get(0).width)/2
					});
				},
				/**
				 * PID Functions
				 * red = imageData.data[0];
				 * green = imageData.data[1];
				 * blue = imageData.data[2];
				 * alpha = imageData.data[3];
				 */
				addLastState : function(imageData){
					
					// this function have to ensure imageData not refer to a memory address
					var dataCopy = new Uint8ClampedArray(imageData.data),
						newImageData = context.createImageData(imageData);

					newImageData.data.set(dataCopy);
					lastOperations.push(newImageData);
				},
				
				clearOperationList : function(){
					lastOperations = [];
				},
				originalImage : function(){
					this.loadImage($originalImage);
				},
				undo : function(){

					if (lastOperations.length>0) {
						context.putImageData(lastOperations.pop(),0,0);
					} else if($originalImage!=null) {
						this.originalImage($originalImage);
					}
				},
				invertColors : function() {

					var imageData = context.getImageData(0,0, obj.width, obj.height);

					// Save Image Last State
					this.addLastState(imageData);
					
					for (var i=0;i<imageData.data.length;i+=4) {
						
						imageData.data[i] = 255-imageData.data[i];
						imageData.data[i+1] = 255-imageData.data[i+1];
						imageData.data[i+2] = 255-imageData.data[i+2];
						imageData.data[i+3] = 255;
					}
					
					context.putImageData(imageData,0,0);
				},
				grayscale : function() {
					
					var imageData = context.getImageData(0,0, obj.width, obj.height),
						brightness;

					// Save Image Last State
					this.addLastState(imageData);
					
					for(var i = 0; i < imageData.data.length; i += 4) {

					    brightness = 0.34 * imageData.data[i] + 0.5 * imageData.data[i + 1] + 0.16 * imageData.data[i + 2];

					    imageData.data[i] = brightness;
					    imageData.data[i + 1] = brightness;
					    imageData.data[i + 2] = brightness;
					}
					
					context.putImageData(imageData,0,0);
				},
				/**
				 * This function executes using a dynamic slider,
				 * when using it u have to store the original image data
				 * and pass it as a argument every time u want to change
				 * the image data
				 * 
				 * Note* The state cant be saved here
				 * It will be saved by the user when he applys the threshold
				 */
				threshold : function(thresholdLower, thresholdUper, original) {
					
					var imageData = this.cloneImageData(original),
						aux = 0, value;

					for (var i=0; i<imageData.data.length; i+=4) {

						aux = 0.2126*imageData.data[i] + 0.7152*imageData.data[i+1] + 0.0722*imageData.data[i+2];
						
						if (aux <= thresholdLower) {
							value = 0;
							imageData.data[i] = imageData.data[i+1] = imageData.data[i+2] = value;
						} else if (aux >= thresholdUper) {
							value = 255;
							imageData.data[i] = imageData.data[i+1] = imageData.data[i+2] = value;
						}
						// value = ( aux >= thresholdLower && (!thresholdUper || aux <= thresholdUper) ) ? 255 : 0;
					}
					
					context.putImageData(imageData,0,0);
				},
				/**
				 * This function executes using a dynamic slider,
				 * when using it u have to store the original image data
				 * and pass it as a argument every time u want to change
				 * the image data
				 */
				brightness : function(adjustment, original) {

					var imageData = this.cloneImageData(original);

					// Save Image Last State
					this.addLastState(imageData);
					
					for (var i=0; i<imageData.data.length; i+=4) {
						
						imageData.data[i] += adjustment;
						imageData.data[i+1] += adjustment;
						imageData.data[i+2] += adjustment;
					}
					
					context.putImageData(imageData,0,0);
				}
			};
		};
	})(jQuery);
	var debug;