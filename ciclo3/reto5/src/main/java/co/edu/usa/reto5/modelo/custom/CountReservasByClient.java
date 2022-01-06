package co.edu.usa.reto5.modelo.custom;

import co.edu.usa.reto5.modelo.Cliente;

/**
 *
 * @author andresruedalibre
 */
public class CountReservasByClient {

    private Long total;
    private Cliente client;

    public CountReservasByClient(Long total, Cliente client) {
        this.total = total;
        this.client = client;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

}
