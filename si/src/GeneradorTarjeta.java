import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GeneradorTarjeta {
    private static final Set<String> tarjetasGeneradas = new HashSet<>();
    private static final Random random = new Random();

    public static String generarNumeroTarjeta() {
        String tarjeta;
        do {
            tarjeta = generarNumeroAleatorio();
        } while (tarjetasGeneradas.contains(tarjeta));

        tarjetasGeneradas.add(tarjeta);
        return tarjeta;
    }

    private static String generarNumeroAleatorio() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            sb.append(random.nextInt(10));  // Genera un dígito aleatorio del 0 al 9
        }
        return sb.toString();
    }
}