package entidad;

public class MovimientoXCuenta {
	
	   private long id;
	    private Movimiento movimiento;
	    private long nroCuenta;

	    // Constructor vacío
	    public MovimientoXCuenta() {}

	    // Constructor con parámetros
	    public MovimientoXCuenta(long id, Movimiento movimiento, long nroCuenta) {
	        this.id = id;
	        this.movimiento = movimiento;
	        this.nroCuenta = nroCuenta;
	    }
	    
	    // Getters y Setters
	    public long getId() {
	        return id;
	    }

	    public void setId(long id) {
	        this.id = id;
	    }

	    public Movimiento getMovimiento() {
	        return movimiento;
	    }

	    public void setMovimiento(Movimiento movimiento) {
	        this.movimiento = movimiento;
	    }

	    public long getNroCuenta() {
	        return nroCuenta;
	    }

	    public void setNroCuenta(long nroCuenta) {
	        this.nroCuenta = nroCuenta;
	    }

		@Override
		public String toString() {
			return "MovimientoXCuenta [id=" + id + ", movimiento=" + movimiento + ", nroCuenta=" + nroCuenta + "]";
		}
	    
	    
	

}
