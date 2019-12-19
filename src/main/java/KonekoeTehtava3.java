
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class KonekoeTehtava3 {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        
        Hajautustaulu hallinta = new Hajautustaulu();
        
        System.out.println("Komennot: ");
        System.out.println("lisaa (varasto) (esine) -- lisää esineen varastoon");
        System.out.println("listaa (varasto) -- listaa kaikki annetun varaston esineet");
        System.out.println("hae (varasto) (esine) -- kertoo onko varastossa haettua esinettä");
        System.out.println("poista (varasto) (esine) -- poistaa yhden esineen annetusta varastosta");
        System.out.println("lopeta -- lopettaa ohjelman suorituksen");
        
        while (true){
            
        String komento = lukija.nextLine();
        String[] palat = komento.split(" ");
        String kasky = palat[0].trim();
        String varasto = palat[1].trim();

        if (kasky.equals("listaa")){
            hallinta.listaa(varasto);            
        }
 
        else if (kasky.equals("lisaa")){
            String esine = palat[2].trim();
            hallinta.lisaa(varasto, esine);
            
        }
        else if (kasky.equals("hae")){
            String esine = palat[2].trim();
            if (hallinta.hae(varasto, esine) == null){
                System.out.println("Esinettä "+esine+" ei löydy varastosta "+varasto);
            }else{
                System.out.println("Esine "+esine+" löytyy varastosta "+varasto);
          
                }
            }

        else if (kasky.equals("poista")){
            String esine = palat[2].trim();
            hallinta.poista(varasto, esine);
            }
        else if (kasky.equals("lopeta")){
            break;
            }
        }            
    }
}

        
        
        
        
        
        
        
        
        
        
