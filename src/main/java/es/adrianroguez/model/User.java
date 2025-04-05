package es.adrianroguez.model;

import java.util.Objects;

public class User {

    private String usuario;
    private String email;
    private String contrasenia;

    /**
     * constructor vacio
     */
    public User() {
    }

    /**
     * constructor por defecto
     * @param usuario
     * @param email
     * @param contrasenia
     */
    public User(String usuario, String email, String contrasenia) {
        this.usuario = usuario;
        this.email = email;
        this.contrasenia = contrasenia;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenia() {
        return this.contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public User usuario(String usuario) {
        setUsuario(usuario);
        return this;
    }

    public User email(String email) {
        setEmail(email);
        return this;
    }

    public User contrasenia(String contrasenia) {
        setContrasenia(contrasenia);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(usuario, user.usuario) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuario, email, contrasenia);
    }

    @Override
    public String toString() {
        return "{" +
                " usuario='" + getUsuario() + "'" +
                ", email='" + getEmail() + "'" +
                ", contrasenia='" + getContrasenia() + "'" +
                "}";
    }
}
