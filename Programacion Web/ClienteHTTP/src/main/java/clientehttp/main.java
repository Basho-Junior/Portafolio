package clientehttp;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Scanner;

public class main {

    /* Variable tipo Document ya que el maestro explico en clases que el busca pasar documentos de que ya sabes cuales son sus resultados
    para verificar el programa */
    private static Document documento;

    /* Funcion para validar una URL. */
    private static boolean validacion(String url){

        try {
            documento = Jsoup.parse(url);
            documento = Jsoup.connect(url).get();
        }catch (IllegalArgumentException e){
            return false;
        } catch (IOException e) {
            //throw new RuntimeException(e);
            return false;
        }
        return true;
    }

    /* a) Funcion para indicar la cantidad de lineas del recurso retornado. */
    private static int contadorLineas(String url){
        Connection.Response doc = null;
        try {
            doc = Jsoup.connect(url).execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return doc.body().split("\n").length;
    }

    /* b) Funcion para indicar la cantidad de párrafos (p) que contiene el documento HTML. */

    private static int contadorParrafos(){
        int i ;

        Elements parrafos = documento.select("p");
        i = parrafos.size();

        return i;

    }

    /* c) Funcion para indicar la cantidad de imágenes (img) dentro de los párrafos que contiene el archivo HTML. */
    private static int contadorImagenes() {
        int i;

        Elements parrafoImagenes = documento.select("p img");
        i = parrafoImagenes.size();

        return i;
    }

    /* d) Funcion para indicar la cantidad de formularios (form) que contiene el HTML por categorizando por el método implementado POST o GET.
     * Tomando en cuent que para cada formulario mostrar los campos del tipo input y su respectivo tipo que contiene en el documento HTML.
     * Para cada formulario parseado, identificar que el método de envío del formulario sea POST y enviar una petición al servidor con el
     * parámetro llamado asignatura y valor practica1 y un header llamado matricula con el valor correspondiente a matrícula asignada. Debe
     * mostrar la respuesta por la salida estándar. */

    private static void sobreFormularios() throws IOException {
        int cantPost, cantGet, formularios = 1;

        Elements elementoPost = documento.select("[method=post]");
        cantPost = elementoPost.size();
        Elements elementoGet = documento.select("[method=get]");
        cantGet = elementoGet.size();

        System.out.println("Cantidad con el metodo POST: "+cantPost+" Cantidad con el metodo GET:"+cantGet);

        for(Element elemento: documento.getElementsByTag("form").forms()){

            Elements elementPost = elemento.getElementsByAttributeValueContaining("method","post");
            for(Element elmento: elementPost){
                String string = elmento.absUrl("action");
                System.out.println("Formulario: No."+formularios);

                Document otroDocumento = Jsoup.connect(string).data("asignatura","practica1").header("matricula","20180999").post();

                System.out.println(otroDocumento.body().toString());
            }
            Elements entrada = elemento.select("input");
            for (Element elment: entrada){
                System.out.println("Tipo: "+elment.attr("type"));
            }
            System.out.println(" ");
            formularios ++;
        }
    }

    public static void main(String[] args) throws IOException {
        String decision;
        do {
            System.out.println("En la siguiente linea digite una URL: ");
            Scanner scanner = new Scanner(System.in);
            String entrada = scanner.nextLine();

            if (validacion(entrada)) {
                System.out.println("La URL es valida!");
                System.out.println("Total de lineas: " + contadorLineas(entrada) + "\nTotal de parrafos: " + contadorParrafos() + "\nTotal de imagenes en los parrafos: " + contadorImagenes());
                try {
                    sobreFormularios();
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            } else {
                System.out.println("La URL es invalida!");
            }
            do {
                System.out.println("DESEA VOLVER A PROBAR OTRA URL? SI - (Y)  NO - (N)");
                decision = scanner.nextLine().toUpperCase();
            }while (!("Y").equals(decision) && !("N").equals(decision));
        } while (("Y").equals(decision));
    }

}
