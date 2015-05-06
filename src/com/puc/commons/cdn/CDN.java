package com.puc.commons.cdn;


public final class CDN {

	private static final Boolean IS_DEVELOPMENT = true;
	private static final String DEVELOPMENT_URL = "http://localhost:8080/imagem-medica/";
	private static final String PRODUCTION_URL = "";

	public static final String BOOTSTRAP_2_2_2 = "2.2.2";
	public static final String BOOTSTRAP_2_3_2 = "2.3.2";
	public static final String JQUERY_1_8_3 = "1.8.3";
	public static final String JQUERY_1_10_2 = "1.10.2";
	public static final String JQUERYUI_1_9_2 = "1.9.2";
	public static final String MODERNIZR_2_5_3 = "2.5.3";
	public static final String MODERNIZR_2_6_2 = "2.6.2";
	public static final String MASKED_INPUT_1_3 = "1.3";
	
	public static String getPriceFormat() {
		return getPath("priceformat/priceformat.js");
	}
	
	public static String getJqueryCDN(String version) {
		return "//ajax.googleapis.com/ajax/libs/jquery/" + getVersion(version) + "jquery.min.js";
	}
	
	public static String getJquery(String version) {
		return getPath("jquery/" + getVersion(version) + "jquery.js");
	}
	
	public static String getJqueryUiJSCDN(String version) {
		return "//ajax.googleapis.com/ajax/libs/jqueryui/" + getVersion(version) + "jquery-ui.min.js";
	}
	
	public static String getJqueryUiJS(String version) {
		return getPath("jqueryui/" + getVersion(version) + "js/jqueryui.js");
	}
	
	public static String getJqueryUiCSSLightness(String version) {
		return getPath("jqueryui/" + getVersion(version) + "css/ui-lightness/jquery-ui.css");
	}
	
	public static String getJqueryUiCSSSmoothness(String version) {
		return getPath("jqueryui/" + getVersion(version) + "css/smoothness/jquery-ui.css");
	}
	
	public static String getMaskedInput(String version) {
		return getPath("jqueryMaskedInput/" + getVersion(version) + "maskedinput.js");
	}
		
	public static String getModernizr(String version) {
		return getPath("modernizr/" + getVersion(version) + "modernizr.js");
	}
	
	public static String getBootstrapCSS(String version) {
		return getPath("bootstrap/" + getVersion(version) + "css/bootstrap.css");
	}
	
	public static String getBootstrapJS(String version) {
		return getPath("bootstrap/" + getVersion(version) + "js/bootstrap.js");
	}

	public static String getPath() {
		return getPath(null);
	}
	
	public static String getPath(String additional) {
		if (additional == null) {
			additional = "";
		}
		if (IS_DEVELOPMENT) {
			return DEVELOPMENT_URL + additional;
		}
		return PRODUCTION_URL + additional;
	}
	
	private static String getVersion(String version) {
		if (version == null) {
			return "";
		} else {
			return version + "/";
		}
	}
}
