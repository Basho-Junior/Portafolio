package logical;

public class Banco {
	private Cuenta[] listaCuenta;
	private Cliente[] listaCliente;
	public static int cuentaCount;
	public static int clienteCount;
	
	public Banco() {
		super();
		listaCuenta = new Cuenta[200];
        listaCliente = new Cliente[100];
        cuentaCount=0;
        clienteCount=0;
        
	}

	public Cuenta[] getListaCuenta() {
		return listaCuenta;
	}

	public void setListaCuenta(Cuenta[] listaCuenta) {
		this.listaCuenta = listaCuenta;
	}

	public Cliente[] getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(Cliente[] listaCliente) {
		this.listaCliente = listaCliente;
	}

	public static int getCuentaCount() {
		return cuentaCount;
	}

	public static void setCuentaCount(int cuentaCount) {
		Banco.cuentaCount = cuentaCount;
	}

	public static int getClienteCount() {
		return clienteCount;
	}

	public static void setClienteCount(int clienteCount) {
		Banco.clienteCount = clienteCount;
	}
	



}
