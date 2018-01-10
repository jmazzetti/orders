package orders.dto;

public class OrderDTO {

    private Integer id;
    private Integer salesOrderId;
    private String purchaseOrderNumber;
    private Integer billToID;
    private String billToAddress;
    private String shipToAddress;
    private String shipMethod;
    private String buyerName;
    private String carrierAccount;

    public OrderDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSalesOrderId() {
        return salesOrderId;
    }

    public void setSalesOrderId(Integer salesOrderId) {
        this.salesOrderId = salesOrderId;
    }

    public String getPurchaseOrderNumber() {
        return purchaseOrderNumber;
    }

    public void setPurchaseOrderNumber(String purchaseOrderNumber) {
        this.purchaseOrderNumber = purchaseOrderNumber;
    }

    public Integer getBillToID() {
        return billToID;
    }

    public void setBillToID(Integer billToID) {
        this.billToID = billToID;
    }

    public String getBillToAddress() {
        return billToAddress;
    }

    public void setBillToAddress(String billToAddress) {
        this.billToAddress = billToAddress;
    }

    public String getShipToAddress() {
        return shipToAddress;
    }

    public void setShipToAddress(String shipToAddress) {
        this.shipToAddress = shipToAddress;
    }

    public String getShipMethod() {
        return shipMethod;
    }

    public void setShipMethod(String shipMethod) {
        this.shipMethod = shipMethod;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getCarrierAccount() {
        return carrierAccount;
    }

    public void setCarrierAccount(String carrierAccount) {
        this.carrierAccount = carrierAccount;
    }
}
