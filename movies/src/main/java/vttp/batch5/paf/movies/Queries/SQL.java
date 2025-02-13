package vttp.batch5.paf.movies.Queries;

public class SQL {
    //check if datbase exists;
    public static final String SQL_CHECK_DB_EXISTS = "SELECT SCHEMA_NAME FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEMA_NAME = ?";

    public static final String SQL_INSERT_ONE = "INSERT INTO imdb values (?, ?, ?, ?, ?, ?, ?)"; 

    // public static final String SQL_GET_CUSTOMER_ID = "SELECT cust_id FROM customers where name = ? AND address = ?";

    // public static final String SQL_INSERT_PURCHASEORDER = "INSERT INTO purchaseOrders(deliveryDate, p_cust_id) values (?,?)";
    // public static final String SQL_GET_PURCHASE_ID = "SELECT purchase_id FROM purchaseOrders WHERE p_cust_id = ? AND deliveryDate = ?";

    // public static final String SQL_INSERT_ITEM = "INSERT INTO cartItems VALUES (?, ?, ?, ?)";



}
