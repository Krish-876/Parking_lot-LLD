// Payment Receipt requires
// - id
// - amount
// - Payment status
public class PaymentReceipt {
    private final String receiptId;
    private final int amount;
    private final PaymentStatus status;

    public PaymentReceipt(String receiptId, int amount, PaymentStatus status){
        this.receiptId = receiptId;
        this.amount = amount;
        this.status = status;
    }

    public String getReceiptId(){
        return receiptId;
    }
    public int getAmount(){
        return amount;
    }
    public PaymentStatus getPaymentStatus(){
        return status;
    }
}
