package laGenerica;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "db_consolidado")
public class Consolidado {
   @Id
   private String ciudad;
   private Integer id;
   private double totalventas;

   public Consolidado(String ciudad, Integer id, double totalventas) {
	 super();
	 this.ciudad = ciudad;
	 this.id = id;
	 this.totalventas = totalventas;
   }

   public String getCiudad() {
	 return ciudad;
   }

   public void setCiudad(String ciudad) {
	 this.ciudad = ciudad;
   }

   public Integer getId() {
	 return id;
   }

   public void setId(Integer id) {
	 this.id = id;
   }

   public double getTotalventas() {
	 return totalventas;
   }

   public void setTotalventas(double totalventas) {
	 this.totalventas = totalventas;
   }   
}
