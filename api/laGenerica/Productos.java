package laGenerica;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "db_productos")
public class Productos {
   @Id
   private Integer codigo;
   private Integer ivacompra;
   private Integer nitproveedor;
   private String nombre;
   private double preciocompra;
   private double precioventa;

   public Productos(Integer codigo, Integer ivacompra, Integer nitproveedor, String nombre, double preciocompra,
		double precioventa) {
	 super();
	 this.codigo = codigo;
	 this.ivacompra = ivacompra;
	 this.nitproveedor = nitproveedor;
	 this.nombre = nombre;
	 this.preciocompra = preciocompra;
	 this.precioventa = precioventa;
   }

   public Integer getCodigo() {
	 return codigo;
   }

   public void setCodigo(Integer codigo) {
	 this.codigo = codigo;
   }

   public Integer getIvacompra() {
	 return ivacompra;
   }

   public void setIvacompra(Integer ivacompra) {
	 this.ivacompra = ivacompra;
   }

   public Integer getNitproveedor() {
	 return nitproveedor;
   }

   public void setNitproveedor(Integer nitproveedor) {
	 this.nitproveedor = nitproveedor;
   }

   public String getNombre() {
	 return nombre;
   }

   public void setNombre(String nombre) {
	 this.nombre = nombre;
   }

   public double getPreciocompra() {
	 return preciocompra;
   }

   public void setPreciocompra(double preciocompra) {
  	 this.preciocompra = preciocompra;
   }

   public double getPrecioventa() {
	 return precioventa;
   }

   public void setPrecioventa(double precioventa) {
	 this.precioventa = precioventa;
   }  
}
