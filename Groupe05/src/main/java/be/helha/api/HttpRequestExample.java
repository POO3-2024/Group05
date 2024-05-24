package be.helha.api;

public class HttpRequestExample {
    public static void main(String[] args) {

        String allArmesResponse = ArmeApi.getArmes();
        System.out.println("Toutes les armes:");
        System.out.println(allArmesResponse);

        // Appel de la méthode getArmeById de la classe ArmeApi
        int id = 1; // Remplacez par l'identifiant de l'arme que vous souhaitez récupérer
        String armeResponse = ArmeApi.getArmeById(id);
        System.out.println("Arme avec l'ID " + id + ":");
        System.out.println(armeResponse);
    }
}
