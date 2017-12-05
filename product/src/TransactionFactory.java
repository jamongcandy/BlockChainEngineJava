/**
 * Created by daehyun on 2017. 12. 5..
 */
public class TransactionFactory {
    TxFormat data;


    public AbstractTransaction createTransaction(TxFormat.txDataType type) {
        try {
            Class<?> cls = Class.forName(type.toString());
            Object obj = cls.newInstance();
            return (AbstractTransaction) obj;
        }   catch (Exception e) {
            return null;
        }
    }


}
