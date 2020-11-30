import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
// declaracion de variables        
        Random aleatorio = new Random();
        final int dias = 15;
        int sumaLaFe = 0, sumaClinico = 0;
        double mediaLaFe, mediaClinico;
        int nPcrLaFe, nPcrClinico;

        Map<Integer, Integer> pcrLaFe = new HashMap<>();
        Map<Integer, Integer> pcrClinico = new HashMap<>();
// Relleno HashMap
        for (int i = 1; i <= dias; i++) {
            nPcrLaFe = 100 + aleatorio.nextInt(2400);
            pcrLaFe.put(i, nPcrLaFe);
            sumaLaFe = sumaLaFe + nPcrLaFe;
            nPcrClinico = 100 + aleatorio.nextInt(2400);
            pcrClinico.put(i, nPcrClinico);
            sumaClinico = sumaClinico + nPcrClinico;

// imprimo HashMap y quien ha hecho mas PCRs
        }
        System.out.print("Dia      LaFe        Clinico");
        for (int j = 1; j <= dias; j++) {
            System.out.print("\n" + j + "     " + pcrLaFe.get(j) + "        " + pcrClinico.get(j));
            if (pcrLaFe.get(j) > (pcrClinico.get(j))) {
                System.out.print("  --> Se hacen mas PCR en La Fe");
            }
            if (pcrClinico.get(j) > pcrLaFe.get(j)) {
                System.out.print("  --> El Clinico hace mas PCR");
            }
        }
// analisis de datos de la Fe        
        mediaLaFe = sumaLaFe / dias;
        System.out.println("\n\nANALISIS de datos en La Fe: ");
        System.out.println("Media de PCR por dia: " + mediaLaFe);

        System.out.println("\nDia(PCRs)      Cantidad de PCRs por encima de la media");
        for (int k = 1; k <= dias; k++) {
            if (pcrLaFe.get(k) > mediaLaFe) {
                System.out.print("\n" + k + " (" + pcrLaFe.get(k) + ")      " + (pcrLaFe.get(k) - mediaLaFe));
            }
        }
// analisis de datos del clinico
        mediaClinico = sumaClinico / dias;
        System.out.println("\n\nANALISIS de datos en el Clinico: ");
        System.out.println("Media de PCR por dia: " + mediaClinico);

        System.out.println("\nDia(PCRs)      Cantidad de PCRs por encima de la media");
        for (int m = 1; m <= dias; m++) {
            if (pcrClinico.get(m) > mediaClinico) {
                System.out.print("\n" + m + " (" + pcrClinico.get(m) + ")      " + (pcrClinico.get(m) - mediaClinico));
            }
        }

    }
}
