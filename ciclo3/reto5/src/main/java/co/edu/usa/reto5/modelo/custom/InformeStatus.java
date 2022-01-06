package co.edu.usa.reto5.modelo.custom;

/**
 *
 * @author andresruedalibre
 */
public class InformeStatus {

    private Long total;
    private String status;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public InformeStatus(Long total, String status) {
        this.total = total;
        this.status = status;
    }

}
