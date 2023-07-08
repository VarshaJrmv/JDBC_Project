package dao;

import java.sql.*;
import model.Product;

import connectionManager.ConnectionManager;

public class productDAO {

	public void addProduct(Product product) throws ClassNotFoundException, SQLException
	{
		//1.connect java and JDBC
		ConnectionManager conm =new ConnectionManager();
		Connection con=conm.establishConnection();
	    String sql_query = "insert into product(productId,productNmae,MinSellQuantity,price,quantity) values (?,?,?,?,?)";
	    PreparedStatement ps =con.prepareStatement(sql_query);
	    ps.setInt(1,product.getProductId());
	    ps.setString(2,product.getProductNmae());
	    ps.setInt(3,product.getMinSellQuantity());
	    ps.setInt(4,product.getPrice());
	    ps.setInt(5,product.getQuantity());
	    ps.executeUpdate();
	    conm.closeConnection();
	}
	public void display() throws ClassNotFoundException, SQLException
	{
		ConnectionManager conm =new ConnectionManager();
		Connection con=conm.establishConnection();
		Statement st=con.createStatement();
		//ResultSet class
		ResultSet rt=st.executeQuery("select * from product");
		while(rt.next())
		{
		   System.out.println(rt.getInt("productId")+"|"+rt.getString("productNmae")+"|"+rt.getInt("MinSellQuantity")+"|"+rt.getInt("price")+"|"+rt.getInt("quantity"));
		  }
		conm.closeConnection();
		}
	}

	



