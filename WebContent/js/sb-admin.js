/**
 * Side menu builder
 */
$(function() {
    $('#side-menu').metisMenu();
});

/**
 * Only system functions and scripts should be placed here
 */
$(function() {
	
	var $panelObjects = $(".panel-options .btn"),
		$panelForms = $("form.app-tab");
		pageObj = {
			/**
			 * Build application menu
			 */
			horizontalMenu : function(){
				
				if ($panelObjects.length>0) {
	
					$panelObjects.each(function(){
						
						var $this = $(this);

						$this.click(function(){

							var formSelector = "#"+$this.attr("data-view"),
								$form = $(formSelector);

							pageObj.hideAll();
							$form.removeClass("hide");		
						});
					});
				}
			},
			hideAll : function(){
				$panelForms.each(function(){
					$(this).addClass("hide");
				});
			}
		};

	/**
	 * Sidebar
	 */
    $(window).bind("load resize", function() {
        if ($(this).width() < 768) {
            $('div.sidebar-collapse').addClass('collapse');
        } else {
            $('div.sidebar-collapse').removeClass('collapse');
        }
    });

    /**
     * Build apps menu
     */
    pageObj.horizontalMenu();
    
    /**
     * Build datepicker
     */
    $(".datepicker").datepicker();
});