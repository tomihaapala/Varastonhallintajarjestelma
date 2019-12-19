import java.util.ArrayList;
 
public class Hajautustaulu<K, V> {
 
    private ArrayList<Pari<K, V>>[] arvot;
    private int arvoja;
 
    public Hajautustaulu() {
        this.arvot = new ArrayList[32];
        this.arvoja = 0;
    }
   
    public V hae(K avain, V arvo) {
        
    int hajautusArvo = Math.abs(avain.hashCode() % this.arvot.length);
    if (this.arvot[hajautusArvo] == null) {
        return null;
    } 

    ArrayList<Pari<K, V>> arvotIndeksissa = this.arvot[hajautusArvo];
 
    for (int i = 0; i < arvotIndeksissa.size(); i++) {
        if (arvotIndeksissa.get(i).getArvo().equals(arvo)) {
           
            return arvotIndeksissa.get(i).getArvo();
        }
   }
    return null;
}
    private ArrayList<Pari<K, V>> haeAvaimeenLittyvaLista(K avain) {
    int hajautusArvo = Math.abs(avain.hashCode() % arvot.length);
    if (arvot[hajautusArvo] == null) {
        arvot[hajautusArvo] = new ArrayList<>();
    }
 
    return arvot[hajautusArvo];

}
public void lisaa(K avain, V arvo) {
    
    ArrayList<Pari<K, V>> arvotIndeksissa = haeAvaimeenLittyvaLista(avain);

        arvotIndeksissa.add(new Pari<>(avain, arvo));
        this.arvoja++;
    
    if (1.0 * this.arvoja / this.arvot.length > 0.75) {
        kasvata();
    }   
}
private void kasvata() {
    
    ArrayList<Pari<K, V>>[] uusi = new ArrayList[this.arvot.length * 2];
 
    for (int i = 0; i < this.arvot.length; i++) {
        kopioi(uusi, i);
 
    }
    this.arvot = uusi;
}

private void kopioi(ArrayList<Pari<K, V>>[] uusi, int indeksista) {
    
    if (this.arvot[indeksista] != null){

    for (int i = 0; i < this.arvot[indeksista].size(); i++) {
        Pari<K, V> arvo = this.arvot[indeksista].get(i);
 
        int hajautusarvo = Math.abs(arvo.getAvain().hashCode() % uusi.length);
        if(uusi[hajautusarvo] == null) {
            uusi[hajautusarvo] = new ArrayList<>();
        }

        uusi[hajautusarvo].add(arvo);
    }
}

}
public V poista(K avain, V arvo) {
    ArrayList<Pari<K, V>> arvotIndeksissa = haeAvaimeenLittyvaLista(avain);
    if (arvotIndeksissa.isEmpty()) {
        return null;
    }
 
    int indeksi = haeArvonIndeksi(arvotIndeksissa, arvo);
    if (indeksi < 0) {
        return null;
    }
 
    Pari<K, V> pari = arvotIndeksissa.get(indeksi);
    arvotIndeksissa.remove(pari);
    return pari.getArvo();

}

private int haeArvonIndeksi(ArrayList<Pari<K, V>> lista, V arvo) {
    for (int i = 0; i < lista.size(); i++) {
        if (lista.get(i).getArvo().equals(arvo)) {
            return i;
        }
    }
 
    return -1;
    
    }
    public void listaa(K avain){
    int hajautusArvo = Math.abs(avain.hashCode() % this.arvot.length);
    if (this.arvot[hajautusArvo] == null) {
        System.out.println("Varasto "+avain+" on tyhjä");
    } 
        System.out.println("Varasto " +avain+ " sisältää:");
    ArrayList<Pari<K, V>> arvotIndeksissa = this.arvot[hajautusArvo];
    for (int i = 0; i < arvotIndeksissa.size(); i++) {
        if (arvotIndeksissa.get(i).getAvain().equals(avain)) {
            System.out.println(arvotIndeksissa.get(i).getArvo());
            
            }
        }
    }
}

