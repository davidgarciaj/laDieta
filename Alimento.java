
/**
 * Write a description of class Alimento here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Alimento
{
    // cantidad de gramos de las proteinas del alimento
    private float grProteinas;
    // cantidad de gramos de los carbohidratos del alimento
    private float grCarbohidratos;
    // cantidad de gramos de las grasas del alimento
    private float grGrasas;
    //Nombre del alimento
    private String nombre;
    
    

    /**
     * Constructor for objects of class Alimento
     */
    public Alimento(float grProteinas, float grCarbohidratos, float grGrasas, String nombre)
    {
        // Cantidad de proteinas en 100gr de alimento 
        this.grProteinas = grProteinas;
        // Cantidad de proteinas en 100gr de alimento 
        this.grCarbohidratos = grCarbohidratos;
        // Cantidad de proteinas en 100gr de alimento 
        this.grGrasas = grGrasas;
        //El nombre de este alimento
        this.nombre = nombre;
    }

    /**
     * Nos devuelve número de carbohidratos
     */
    public float getCarbohidratos()
    {
        return grCarbohidratos;
    }
    
    /**
     * Nos devuelve número de grasas
     */
    public float getGrasas()
    {
        return grGrasas;
    }
    
    /**
     * Nos devuelve número de proteinas
     */
    public float getProteinas()
    {
        return grProteinas;
    }

    /**
     * Nos muestra la información del alimento
     */
    public void muestraDatos()
    {
        float calorias = (grProteinas + grCarbohidratos)*4 + (grGrasas*9);
        System.out.println("Nombre del alimento: " + nombre + ".");        
        System.out.println("Cantidad de proteínas: " + grProteinas + " por cada 100 gramos.");        
        System.out.println("Cantidad de Carbohidratos: " + grCarbohidratos + " por cada 100 gramos.");        
        System.out.println("Cantidad de Grasas: " + grGrasas + " por cada 100 gramos.");        
        System.out.println("Cantidad de Calorias: " + calorias + " por cada 100 gramos.");
        if(grProteinas > grCarbohidratos){
            if(grProteinas > grGrasas){
                System.out.println("Componente/s Mayoritario/s: Proteinas.");
            }
            else if(grProteinas == grGrasas){
                System.out.println("Componente/s Mayoritario/s: Proteinas, Grasas.");
            }
            else{
                System.out.println("Componente/s Mayoritario/s: Grasas.");
            }
        }
        else if(grProteinas == grCarbohidratos){
            if(grProteinas > grGrasas){
                System.out.println("Componente/s Mayoritario/s: Proteinas, Carbohidratos.");
            }
            else if(grProteinas == grGrasas){
                System.out.println("Componente/s Mayoritario/s: Proteinas, Carbohidratos, Grasas.");
            }
            else{
                System.out.println("Componente/s Mayoritario/s: Grasas.");
            }
        }
        else{
            if(grCarbohidratos == grGrasas){
                System.out.println("Componente/s Mayoritario/s: Carbohidratos, Grasas.");
            }
            else if(grCarbohidratos > grGrasas){
                System.out.println("Componente/s Mayoritario/s: Carbohidratos.");
            }
            else{
            
                System.out.println("Componente/s Mayoritario/s: Grasas.");}
        }
        
    }
}
