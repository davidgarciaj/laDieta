import java.util.ArrayList;
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
    //Guarda alimento con mas calorias
    private Alimento alMasCalorico;
    //Guarda todos los alimentos consumidos por el usuario
    private ArrayList<Alimento> alimentosConsumidos;

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
        //Alimento consumido con mayor calorias
        alMasCalorico = null;
        //Lista de alimentos consumidos
        alimentosConsumidos = new ArrayList<>();
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
      calorias = calorias + (comida.getCalorias() * cantidad/100);
      proteinas = proteinas + (comida.getProteinas()*cantidad/100);
      grasas = grasas + (comida.getGrasas()*cantidad/100);
      carbohidratos = carbohidratos + (comida.getCarbohidratos()*cantidad/100);
      if((alMasCalorico == null) || (comida.getCalorias() >= alMasCalorico.getCalorias())){
          alMasCalorico = comida;
      }
      alimentosConsumidos.add(comida);
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
        String masCalorias = usuarioAComparar.getNombreCompleto() + " ha consumido mas calorias que "
                + getNombreCompleto() + " (" + caloriasSegundoUsuario + " calorias frente a " + calorias + " calorias)";
        if(calorias > caloriasSegundoUsuario){
            masCalorias = getNombreCompleto() + " ha consumido mas calorias que "+ usuarioAComparar.getNombreCompleto() 
                + " (" + calorias + " calorias frente a " + caloriasSegundoUsuario + "calorias)";
        }
        else if(calorias == caloriasSegundoUsuario){
            masCalorias = "Tanto "+ getNombreCompleto() + " como "+ usuarioAComparar.getNombreCompleto() 
                + " han consumido las mismas calorias ("+ calorias +" calorias).";
        }
        System.out.println(masCalorias);
    }
    
    /**
     * Muestra por pantalla el alimento mas calorico
     */
    public void alimentoMasCalorico(){
        if(alMasCalorico != null){
            System.out.println("Alimento más calórico ingerido por este usuario hasta el momento: "
                 + alMasCalorico.getNombre() + " (" + alMasCalorico.getCalorias() + " calorias por cada 100 gramos)");
        }
        else{
            System.out.println("No ha consumido ningún alimento");
            }
    }
    
    /**
     * Muestra datos del alimento comido en la posición seleccionada
     */
    public void datosAlimentos(int orden){
        if((orden > alimentosConsumidos.size()) || (orden < 1)){
            System.out.println("El usuario no ha consumido ningún alimento en el orden del número: " + orden);
        }
        else{
            alimentosConsumidos.get(orden-1).muestraDatos();
        }
    }
    
    /**
     * Identifica si un alimento ha sido consumido y cuantas veces se ha consumido
     */
    public int cuentaVecesComidoUnAlimento(String nombreAlimento){
        int contador = 0;
        for(Alimento alimento: alimentosConsumidos){
            String revisaAlimento = alimento.getNombre();
            if(revisaAlimento == nombreAlimento){
                contador++;
            }
        }
        return contador;
    }
    
    /**
     * Identifica si un alimento ha sido consumido y cuantas veces se ha consumido
     */
    public void compruevaUnAlimento(String nombreAlimento){
        int contador = cuentaVecesComidoUnAlimento(nombreAlimento);
        if(contador == 0){
            System.out.println("El usuario no ha consumido nunca el alimento " + nombreAlimento + " con anterioridad.");
        }
        else{
            System.out.println("El número de veces que el usuario ha consumido el alimento " + nombreAlimento + " es: " + contador + ".");
        }
    }
    
    /**
     * Muestra alimentos consumidos más de una vez
     */
    public void alimentosConsumidosRepetidamente(){
        String comidas = "";
        boolean contador = true;
        ArrayList<String> alimentosRepetidos = new ArrayList<>();
        for(Alimento alimento: alimentosConsumidos){            
            if(cuentaVecesComidoUnAlimento(alimento.getNombre()) > 1 && !comidas.contains(alimento.getNombre())){               
                System.out.println( alimento.getNombre());
                comidas = comidas + alimento.getNombre();
                contador = false;
            }
        }
        if(contador){
            System.out.println("No se ha consumido ningún alimento mas de una vez.");
        }
    }
}
