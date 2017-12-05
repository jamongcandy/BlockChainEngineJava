import java.util.Date;

/**
 * Created by daehyun on 2017. 12. 5..
 */
public class txType1 extends AbstractTransaction {
    public txType1(TransactionCreator from, Object data) {
        this.from = from;
        this.timestamp = new Date();
        this.data = data;
    }
}
