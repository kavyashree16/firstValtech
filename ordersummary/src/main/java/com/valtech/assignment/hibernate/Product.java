package com.valtech.assignment.hibernate;

public class Product {
	
		private int product_id;
		private String product_name;
		private int product_amt;
		
		
		
		public Product() {}
		
		public Product(int product_id, String product_name, int product_amt) {
			super();
			this.product_id = product_id;
			this.product_name = product_name;
			this.product_amt = product_amt;
		}
		public Product(String product_name, int product_amt) {
			super();
			this.product_name = product_name;
			this.product_amt = product_amt;
		}

		public int getProduct_id() {
			return product_id;
		}
		public void setProduct_id(int product_id) {
			this.product_id = product_id;
		}
		public String getProduct_name() {
			return product_name;
		}
		public void setProduct_name(String product_name) {
			this.product_name = product_name;
		}
		public int getProduct_amt() {
			return product_amt;
		}
		public void setProduct_amt(int product_amt) {
			this.product_amt = product_amt;
		}

}
