
/**
 * La clase modela un sencillo podómetro que registra información
 * acerca de los pasos, distancia, ..... que una persona
 * ha dado en una semana.
 *
 * @author    - Paula Fernández-Rubio Miranda -
 */
public class Podometro {

    // CONSTANTES
    private final char MUJER = 'M';
    private final char HOMBRE = 'H';
    private final double RAZON_ZANCADA_HOMBBRE = 0.45;
    private final double RAZON_ZANCADA_MUJER = 0.41;
    private final int SABADO = 6;
    private final int DOMINGO = 7;

    // ATRIBUTOS
    private String marca;
    private double altura;
    private char sexo;
    private int longitudZancada;
    private int totalPasosLaborables;
    private int totalPasosSabado;
    private int totalPasosDomingo;
    private double totalDistanciaSemana;
    private double totalDistanciaFinSemana;
    private int tiempo;
    private int caminatasNoche;

    /**
     * Inicializa el podómetro con la marca indicada por el parámetro. El resto
     * de atributos se ponen a 0 y el sexo, por defecto, es mujer
     */
    public Podometro(String queMarca) {
        this.marca = queMarca;
        this.altura = 0;
        this.sexo = 'M';
        this.longitudZancada = 0;
        this.totalPasosLaborables = 0;
        this.totalPasosDomingo = 0;
        this.totalPasosSabado;

    }

    /**
     * accesor para la marca
     *
     */
    public getMarca() {

    }

    /**
     * Simula la configuración del podómetro. Recibe como parámetros la altura y
     * el sexo de una persona y asigna estos valores a los atributos
     * correspondiente. Asigna además el valor adecuado al atributo
     * longitudZancada
     *
     * (leer enunciado)
     *
     */
    public void configurar(int queAltura, char queSexo) {

    }

    /**
     * Recibe cuatro parámetros que supondremos correctos: pasos - el nº de
     * pasos caminados dia - nº de día de la semana en que se ha hecho la
     * caminata (1 - Lunes, 2 - Martes - .... - 6 - Sábado, 7 - Domingo)
     * horaInicio – hora de inicio de la caminata horaFin – hora de fin de la
     * caminata
     *
     * A partir de estos parámetros el método debe realizar ciertos cálculos y
     * actualizará el podómetro adecuadamente
     *
     * (leer enunciado del ejercicio)
     */
    public void registrarCaminata(int pasos, int dia, int horaInicio,
            int horaFin) {

    }

    /**
     * Muestra en pantalla la configuración del podómetro (altura, sexo y
     * longitud de la zancada)
     *
     * (ver enunciado)
     *
     */
    public void printConfiguracion() {

    }

    /**
     * Muestra en pantalla información acerca de la distancia recorrida, pasos,
     * tiempo total caminado, ....
     *
     * (leer enunciado)
     *
     */
    public void printEstadísticas() {

    }

    /**
     * Calcula y devuelve un String que representa el nombre del día en el que
     * se ha caminado más pasos - "SÁBADO" "DOMINGO" o "LABORABLES"
     */
    public String diaMayorNumeroPasos() {

    }

    /**
     * Restablecer los valores iniciales del podómetro Todos los atributos se
     * ponen a cero salvo el sexo que se establece a MUJER. La marca no varía
     *
     */
    public void reset() {

    }

}
