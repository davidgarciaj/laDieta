
/**
 * Write a description of class Usuario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Usuario
{
    // Guarda nombre del usuario
    private String nombre;
	//Guarda primer apellido
    private String apellido1;
	//Guarda segundo apellido
    private String apellido2;
	//Guarda gramos de proteinas ingeridas
    private float proteinas;
	//Guarda gramos de grasas ingeridas
    private float grasas;
	//Guarda gramos de carbohidratos ingeridas
    private float carbohidratos;
	//Guarda calorias ingeridas
    private float calorias;

    /**
     * Constructor for objects of class Usuario
     */
    public Usuario(String nombre, String priApellido, String segApellido)
    {
        // Nombre para identificar al usuario
        this.nombre = nombre;
        //Primer apellido
        apellido1= priApellido;
        //Segundo apellido
        apellido2= segApellido;
        //proteinas digeridas por el usuario
        proteinas = 0;
        //grasas digeridas por el usuario
        grasas = 0;
        //carbohidratos digeridas por el usuario
        carbohidratos = 0;
        //calorias digeridas por el usuario
        calorias = 0;
    }

    /**
     * Darle a comer una cantidad de un alimento
     */
    public void comer(Alimento comida, float cantidad)
    {
      calorias = calorias + (((comida.getProteinas() + comida.getCarbohidratos()) * 4 + comida.getGrasas() * 9) * cantidad/100);
      proteinas = proteinas + (comida.getProteinas()*cantidad/100);
      grasas = grasas + (comida.getGrasas()*cantidad/100);
      carbohidratos = carbohidratos + (comida.getCarbohidratos()*cantidad/100);
    }
    
    /**
     * Mostrar datos del consumo del usuario
     */
    public void mostrarDatos(){
        System.out.println(nombre + " " + apellido1 + " " + apellido2);
        System.out.println();
        System.out.println("Gramos totales de proteinas ingeridos: " + proteinas);
        System.out.println("Gramos totales de grasas ingeridas: " + grasas);
        System.out.println("Gramos totales de carbohidratos ingeridos: " + carbohidratos);
        System.out.println("Calorias totales ingeridas: " + calorias);
    }
}
