import java.util.Date;

/**
 * Tienda
 */
public class Tienda {
    private ListaArticulos articulosEnVenta;

    public Tienda() {
        articulosEnVenta = new ListaArticulos(100);
        Articulo laptop = new Articulo("OMEN 15", "HPO15X");
        laptop.establecerPrecio(15000D);

        Articulo usb = new Articulo("USB 3.0 Kingston", "KGSB23");
        usb.establecerPrecio(200D);

        Articulo impresora = new Articulo("EPSON 374", "EPS374");
        impresora.establecerPrecio(1000D);

        registrarArticulo(laptop);
        registrarArticulo(usb);
        registrarArticulo(impresora);
    }

    public Cliente registrarCliente(String nombre) {
        return new Cliente(new Cuenta(0D, "992-122-212-111", new Date(120, 02, 01)), nombre);
    }

    public void registrarArticulo(Articulo articulo) {
        articulosEnVenta.agregarArticulo(articulo);
    }

    public Articulo obtenerArticuloEnVenta(int id) {
        return articulosEnVenta.obtenerArticulo(id);
    }

    public void imprimirArticulosEnVenta() {
        articulosEnVenta.imprimir();
    }

    public void venderArticulo(Articulo articulo, Cliente cliente) {
        if (articulo != null && cliente != null) {
            Cuenta cuenta;
            cuenta = cliente.obtenerCuenta();
            System.out.println(cuenta.cargarArticulo(articulo) + " Cliente: " + cliente);
            cliente.establecerCuenta(cuenta);
        }
    }
}