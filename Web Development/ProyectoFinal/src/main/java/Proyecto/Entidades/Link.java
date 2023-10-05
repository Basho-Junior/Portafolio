package Proyecto.Entidades;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.*;

@Entity
public class Link implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String URL;
    private Date fecha = new Date();
    private int visitas = 0;

    private String URLF;

    @ManyToOne(optional = true)
    private Usuario usuario;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Visitante> visitantes;


    @Lob
    private String fotoBase64;

    public Link() {
    }

    public Link(int id, String URL, Date fecha, int visitas, String URLF, Usuario usuario, List<Visitante> visitantes, String fotoBase64) {
        this.id = id;
        this.URL = URL;
        this.fecha = fecha;
        this.visitas = visitas;
        this.URLF = URLF;
        this.usuario = usuario;
        this.visitantes = visitantes;
        this.fotoBase64 = fotoBase64;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getVisitas() {
        return visitas;
    }

    public void setVisitas(int visitas) {
        this.visitas = visitas;
    }

    public String getURLF() {
        return URLF;
    }

    public void setURLF(String URLF) {
        this.URLF = URLF;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Visitante> getVisitantes() {
        return visitantes;
    }

    public void setVisitantes(List<Visitante> visitantes) {
        this.visitantes = visitantes;
    }

    public String getFotoBase64() {
        return fotoBase64;
    }

    public void setFotoBase64(String fotoBase64) {
        this.fotoBase64 = fotoBase64;
    }

    public Map<String, Integer> calculadora() {
        List<Visitante> clients = new ArrayList<>(visitantes);
        if (!clients.isEmpty()) {
            Visitante primer = clients.get(0);

            Map<String, Integer> cantidad = new HashMap<String, Integer>();
            String reciente = primer.getFechaFormat();
            int aux = 1;
            int i = 1;
            while (i < clients.size()) {
                Visitante client = clients.get(i);
                if (!client.getFechaFormat().equalsIgnoreCase(reciente)) {
                    cantidad.put(reciente, aux);
                    aux = 1;
                    reciente = client.getFechaFormat();
                } else {
                    aux++;
                }
                i++;
            }
            cantidad.put(reciente, aux);

            return cantidad;
        }
        return null;
    }

}


