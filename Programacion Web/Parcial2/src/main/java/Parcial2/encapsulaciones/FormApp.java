package Parcial2.encapsulaciones;

public class FormApp {
    private int id;
    private int matricula;
    private String nombre;
    private String sector;
    private String nivel;
    private float latitud;
    private float longitud;
    private String usuario;

    public FormApp() {
    }
    public FormApp(int id, int matricula, String nombre, String sector, String nivel, float latitud, float longitud, String usuario) {
        this.id = id;
        this.matricula = matricula;
        this.nombre = nombre;
        this.sector = sector;
        this.nivel = nivel;
        this.latitud = latitud;
        this.longitud = longitud;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public float getLatitud() {
        return latitud;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
