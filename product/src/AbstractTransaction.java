import java.util.Date;

/**
 * Created by daehyun on 2017. 12. 5..
 */
public abstract class AbstractTransaction {


    protected TransactionCreator from;
    protected Date timestamp;
    protected Object data;


    public Object getData() {
        return this.data;
    }

    public TransactionCreator getFrom() {
        return from;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}
