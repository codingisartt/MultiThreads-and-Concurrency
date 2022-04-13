public class OrderMatic implements Runnable{
    private int orderNo;
    private final Object LOCK=new Object();

    public OrderMatic() {
        this.orderNo = 0;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    @Override
    public void run() {
       try {
        Thread.sleep(2000);
    }catch (InterruptedException e) {
        e.printStackTrace();
    }

    increaseOrder();

    /*synchronized(LOCK){  //other way
        this.orderNo++;
        System.out.println(Thread.currentThread().getName()+" - OrderNo->"+this.orderNo);
    }*/
        
    }

    public synchronized void increaseOrder() {
        this.orderNo++;
        //System.out.println(Thread.currentThread().getName()+" - OrderNo->"+this.orderNo);
        StringBuilder builder = new StringBuilder();
        builder.append(Thread.currentThread().getName());
        builder.append(" thread got ");
        builder.append(this.orderNo);
        builder.append(" from Qmatic!");

        System.out.println(builder.toString());
    }

    


}
