
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
         * Inicializa el podómetro con la marca indicada por el parámetro. El
         * resto de atributos se ponen a 0 y el sexo, por defecto, es mujer
         */
        public Podometro(String queMarca) {
            this.marca = queMarca;
            this.altura = 0;
            this.sexo = 'M';
            this.longitudZancada = 0;
            this.totalPasosLaborables = 0;
            this.totalPasosDomingo = 0;
            this.totalPasosSabado = 0;
            this.totalDistanciaSemana = 0;
            this.totalDistanciaFinSemana = 0;
            this.tiempo = 0;
            this.caminatasNoche = 0;
        }

        /**
         * accesor para la marca
         *
         */
        public String getMarca() {
            return marca;
        }

        /**
         * Simula la configuración del podómetro. Recibe como parámetros la
         * altura y el sexo de una persona y asigna estos valores a los
         * atributos correspondientes. Asigna además el valor adecuado al
         * atributo longitudZancada
         *
         * (leer enunciado)
         *
         */
        public void configurar(int queAltura, char queSexo) {
            this.altura = queAltura;
            this.sexo = queSexo;

            if (queSexo == 'H') {
                this.longitudZancada = (int) Math.round(queAltura * RAZON_ZANCADA_HOMBBRE);
            } else if (queSexo == 'M') {
                this.longitudZancada = (int) Math.round(queAltura * RAZON_ZANCADA_MUJER);
            }

        }

        /**
         * Recibe cuatro parámetros que supondremos correctos: pasos - el nº de
         * pasos caminados dia - nº de día de la semana en que se ha hecho la
         * caminata (1 - Lunes, 2 - Martes - .... - 6 - Sábado, 7 - Domingo)
         * horaInicio – hora de inicio de la caminata horaFin – hora de fin de
         * la caminata
         *
         * A partir de estos parámetros el método debe realizar ciertos cálculos
         * y actualizará el podómetro adecuadamente
         *
         * (leer enunciado del ejercicio)
         */
        public void registrarCaminata(int pasos, int dia, int horaInicio, int horaFin) {
            switch (dia) {
                case 6:
                    totalPasosSabado = +pasos;
                    break;
                case 7:
                    totalPasosDomingo = +pasos;
                    break;
                default:
                    totalPasosLaborables = +pasos;
            }

            if (dia < 6) {
                totalDistanciaSemana += (pasos * longitudZancada) / 100000;
            } else if (dia == 6 || dia == 7) {
                totalDistanciaFinSemana += (pasos * longitudZancada) / 100000;
            }

            this.tiempo += ((horaFin / 100) * 60 + (horaFin % 100))
                    - ((horaInicio / 100) * 60 + (horaInicio % 100));

            if (horaInicio >= 2100) {
                caminatasNoche++;
            }
        }

        /**
         * Muestra en pantalla la configuración del podómetro (altura, sexo y
         * longitud de la zancada)
         *
         * (ver enunciado)
         *
         */
        public void printConfiguracion() {
            System.out.println("Configuración del podómetro");
            System.out.println("**************************");
            System.out.println("Altura: " + altura / 100.0);
            if (sexo == 'M') {
                System.out.println("Sexo: Mujer");
            } else {
                System.out.println("Sexo: Hombre");
            }
            System.out.println("Longitud zancada: " + longitudZancada / 100.0);
        }

        /**
         * Muestra en pantalla información acerca de la distancia recorrida,
         * pasos, tiempo total caminado, ....
         *
         * (leer enunciado)
         *
         */
        public void printEstadísticas() {
            System.out.println("Estadísticas");
            System.out.println("****************************");
            System.out.println("Distancia recorrida toda la semana: " + totalDistanciaSemana);
            System.out.println("Distancia recorrida fin de semana: " + totalDistanciaFinSemana);
            System.out.println();
            System.out.println("Nº pasos días laborables : " + totalPasosLaborables);
            System.out.println("Nº pasos SÁBADO: " + totalPasosSabado);
            System.out.println("Nº pasos DOMINGO: " + totalPasosDomingo);
            System.out.println();
            System.out.println("Nº caminatas realizadas a partir de las 21h.: " + caminatasNoche);
            System.out.println();
            System.out.println("Tiempo total caminado en la semana: " + (tiempo / 60) + "h y " + (tiempo % 60) + "m");
            System.out.println("Día/s con más pasos caminados: ");
        }

        /**
         * Calcula y devuelve un String que representa el nombre del día en el
         * que se ha caminado más pasos - "SÁBADO" "DOMINGO" o "LABORABLES"
         */
        public String diaMayorNumeroPasos() {

            int mayor = Math.max(totalPasosLaborables,
                    Math.max(totalPasosSabado, totalPasosDomingo));

            String resultado = "";

            if (totalPasosLaborables == mayor) {
                resultado += "LABORABLES";
            }

            if (totalPasosSabado == mayor) {
                if (!resultado.isEmpty()) {
                    resultado += " ";
                }
                resultado += "SÁBADO";
            }

            if (totalPasosDomingo == mayor) {
                if (!resultado.isEmpty()) {
                    resultado += " ";
                }
                resultado += "DOMINGO";
            }

            return resultado;
        }
    }

    /**
     * Restablecer los valores iniciales del podómetro Todos los atributos se
     * ponen a cero salvo el sexo que se establece a MUJER. La marca no varía
     *
     */
    public void reset() {
    
}
