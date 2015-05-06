package com.puc.hibernate;

import org.hibernate.cfg.ImprovedNamingStrategy;

public class NamingStrategy extends ImprovedNamingStrategy {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

   public String tableName(String tableName) {
      return "imed_" + tableName;
   }
}
