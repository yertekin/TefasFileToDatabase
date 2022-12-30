import data.InsertFundDetailList;
import dto.FundDetail;
import util.CsvToArray;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        CsvToArray csvToArray = new CsvToArray();
        InsertFundDetailList insertFundDetailList = new InsertFundDetailList();
        List<FundDetail> fundDetailList = csvToArray.readCSV();
        for (FundDetail fund:fundDetailList) {
            System.out.println(fund.toString());
        }
    }
}
