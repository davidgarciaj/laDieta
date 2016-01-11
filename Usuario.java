
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
     * Devuelve el nombre del Usuario 
     */
    public String getNombreCompleto(){
        return nombre + " " + apellido1 + " " + apellido2;
    }
    
    /**
     * Devuelve calorias consumidas por el Usuario
     */
    public float getCalorias(){
        return calorias;
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
        float totalMacronutrientes = grasas + proteinas + carbohidratos;
        System.out.println(nombre + " " + apellido1 + " " + apellido2);
        System.out.println();
        if(proteinas != 0){
            System.out.println("Gramos totales de proteinas ingeridos: " + proteinas + " (" + proteinas/totalMacronutrientes*100 + "%)");
        }
        else{
            System.out.println("Gramos totales de proteinas ingeridos: " + proteinas);
        }
        if(grasas != 0){
            System.out.println("Gramos totales de proteinas ingeridos: " + grasas + " (" + grasas/totalMacronutrientes*100 + "%)");
        }
        else{
            System.out.println("Gramos totales de grasas ingeridas: " + grasas);
        }   
        if(carbohidratos != 0){
            System.out.println("Gramos totales de proteinas ingeridos: " + carbohidratos + " (" + carbohidratos/totalMacronutrientes*100 + "%)");
        }
        else{
            System.out.println("Gramos totales de carbohidratos ingeridos: " + carbohidratos);
        }
        System.out.println("Calorias totales ingeridas: " + calorias);
    }
    
    /**
     * Compara la ingesta de calorias de este usuario con otro usuario dado
     */
    public void comparaCalorias(Usuario usuarioAComparar){
        float caloriasSegundoUsuario = usuarioAComparar.getCalorias();
        String masCalorias = usuarioAComparar.getNombreCompleto() + " a consumido mas calorias que "+ getNombreCompleto();
        if(calorias > caloriasSegundoUsuario){
            masCalorias = getNombreCompleto() + " a consumido mas calorias que "+ usuarioAComparar.getNombreCompleto();
        }
        else if(calorias == caloriasSegundoUsuario){
            masCalorias = "Tanto "+ getNombreCompleto() + " como "+ usuarioAComparar.getNombreCompleto() + " han consumido las mismas calorias.";
        }
        System.out.println(masCalorias);
    }
}
