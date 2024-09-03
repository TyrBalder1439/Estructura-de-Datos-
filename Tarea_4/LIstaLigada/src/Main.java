public class Main {
        public static void main(String[] args) {
            // Crear lista ligada de SmartPhone
            ListaLigada<SmartPhone> lista = new ListaLigada<>();

            // Agregar 5 SmartPhone
            lista.agregarAlFinal(new SmartPhone("Samsung", "", 999.99));
            lista.agregarAlFinal(new SmartPhone("Apple", "iPhone 12", 999.99));
            lista.agregarAlInicio(new SmartPhone("sansung", "iPhone 12", 999.99));
            SmartPhone Smart1 = new SmartPhone("Opoo", "pixel RTX 12", 9.299);

            ///lista.agregarAlInicio(Smart1);

            System.out.println("Contenido de la lista:");
            lista.transversal();


        }
}