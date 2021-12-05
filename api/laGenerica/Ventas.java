package laGenerica;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "db_ventas")
public class Ventas {
   @Id
   private Integer codigo;
   private Integer cedulacliente;
   private ArrayList<DetalleVentas> detalleventa;
   private Integer ivaventa;
   private double totalventa;
   private double valorventa;

   public Ventas(Integer codigo, Integer cedulacliente, ArrayList<DetalleVentas> detalleventa, Integer ivaventa,
		double totalventa, double valorventa) {
	 super();
	 this.codigo = codigo;
	 this.cedulacliente = cedulacliente;
	 this.detalleventa = detalleventa;
	 this.ivaventa = ivaventa;
	 this.totalventa = totalventa;
	 this.valorventa = valorventa;
   }

   public Integer getCodigo() {
	 return codigo;
   }

   public void setCodigo(Integer codigo) {
	 this.codigo = codigo;
   }

   public Integer getCedulacliente() {
	 return cedulacliente;
   }

   public void setCedulacliente(Integer cedulacliente) {
	 this.cedulacliente = cedulacliente;
   }

   public ArrayList<DetalleVentas> getDetalleventa() {
	 return detalleventa;
   }

   public void setDetalleventa(ArrayList<DetalleVentas> detalleventa) {
	 this.detalleventa = detalleventa;
   }

   public Integer getIvaventa() {
	 return ivaventa;
   } 

   public void setIvaventa(Integer ivaventa) {
	 this.ivaventa = ivaventa;
   }

   public double getTotalventa() {
	 return totalventa;
   }

   public void setTotalventa(double totalventa) {
	 this.totalventa = totalventa;
   }

   public double getValorventa() {
	 return valorventa;
   }

   public void setValorventa(double valorventa) {
	 this.valorventa = valorventa;
   }   
}
