import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        // declaracion de variables
        final int DIAS = 15, MIN = 100, MAX = 2500;
        int sumaLaFe = 0, sumaClinico = 0;
        double mediaLaFe, mediaClinico;
        int nPcrLaFe, numPcrFe, nPcrClinico, numPcrCli;

        Map<Integer, Integer> pcrLaFe = new HashMap<>();
        Map<Integer, Integer> pcrClinico = new HashMap<>();
        // Relleno HashMap
        for (int i = 1; i <= DIAS; i++) {
            nPcrLaFe = (int) (Math.random() * (MIN - MAX)) + MAX;
            pcrLaFe.put(i, nPcrLaFe);
            sumaLaFe = sumaLaFe + nPcrLaFe;
            nPcrClinico = (int) (Math.random() * (MIN - MAX)) + MAX;
            pcrClinico.put(i, nPcrClinico);
            sumaClinico = sumaClinico + nPcrClinico;

            // imprimo HashMap y quien ha hecho mas PCRs
        }
        System.out.print("Dia      LaFe        Clinico");
        for (int j = 1; j <= DIAS; j++) {
            numPcrFe = pcrLaFe.get(j);
            numPcrCli = pcrClinico.get(j);
            System.out.print("\n" + j + "     " + numPcrFe + "        " + numPcrCli);
            if (numPcrFe > numPcrCli) {
                System.out.print("  --> Se hacen mas PCR en La Fe");
            }
            if (numPcrCli > numPcrFe) {
                System.out.print("  --> El Clinico hace mas PCR");
            }
            if (numPcrCli == numPcrFe) {
                System.out.print("  --> Los dos han hecho las mismas PCR");
            }
        }
        // analisis de datos de la Fe
        mediaLaFe = sumaLaFe / DIAS;
        System.out.println("\n\nANALISIS de datos en La Fe: ");
        System.out.println("Media de PCR por dia: " + mediaLaFe);

        System.out.println("\nDia(PCRs)      Cantidad de PCRs por encima de la media");
        for (int k = 1; k <= DIAS; k++) {
            numPcrFe = pcrLaFe.get(k);
            if (numPcrFe > mediaLaFe) {
                System.out.print("\n" + k + " (" + numPcrFe + ")      " + (numPcrFe - mediaLaFe));
            }
        }
        // analisis de datos del clinico
        mediaClinico = sumaClinico / DIAS;
        System.out.println("\n\nANALISIS de datos en el Clinico: ");
        System.out.println("Media de PCR por dia: " + mediaClinico);

        System.out.println("\nDia(PCRs)      Cantidad de PCRs por encima de la media");
        for (int m = 1; m <= DIAS; m++) {
            numPcrCli = pcrClinico.get(m);
            if (numPcrCli > mediaClinico) {
                System.out.print("\n" + m + " (" + numPcrCli + ")      " + (numPcrCli - mediaClinico));
            }
        }

    }
}
