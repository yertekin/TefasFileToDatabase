package data;

import dto.FundDetail;
import util.DateConversions;
import util.MySqlJdbcUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertFundDetailList {

    private static final String INSERT_PRICES_SQL = "INSERT INTO fund_prices(date,fund_code,price,total_fund_value)"
            +   "VALUES(?,?,?,?)";
    MySqlJdbcUtil mySqlJdbcUtil = new MySqlJdbcUtil();
    public void insertFundPrices(FundDetail detail){
        try (Connection conn = mySqlJdbcUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(INSERT_PRICES_SQL, Statement.RETURN_GENERATED_KEYS)) {

            // set parameters for statement
            pstmt.setString(1, DateConversions.JavaToMysqlDate(detail.getPricingDate()));
            pstmt.setString(2, detail.getFundCode());
            pstmt.setBigDecimal(3, BigDecimal.valueOf(detail.getPrice()));
            pstmt.setBigDecimal(4, BigDecimal.valueOf(detail.getTotalFundValue()));

            int rowAffected = pstmt.executeUpdate();
            if(rowAffected == 1)
            {
                System.out.println(detail.getFundCode() + " inserted");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
