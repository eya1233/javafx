package esprit.monstergym.demo.Entities;

import java.sql.Date;

public class User {
    private int id;
    private String username;
    private String email;
    private String roles;
    private String resetToken;
    private String password;
    private boolean isVerified;
    private Date dateNaissance;
    private String numero;
    private Integer cin;
    private Integer etat;
    private String imageUrl;
    private String brochureFilename;

    // Constructors
    public User() {
    }

    public User(int id, String username, String email, String roles, String resetToken, String password, boolean isVerified, Date dateNaissance, String numero, Integer cin, Integer etat, String imageUrl, String brochureFilename) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
        this.resetToken = resetToken;
        this.password = password;
        this.isVerified = isVerified;
        this.dateNaissance = dateNaissance;
        this.numero = numero;
        this.cin = cin;
        this.etat = etat;
        this.imageUrl = imageUrl;
        this.brochureFilename = brochureFilename;
    }

    // Getters and Setters
    // id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // roles
    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    // resetToken
    public String getResetToken() {
        return resetToken;
    }

    public void setResetToken(String resetToken) {
        this.resetToken = resetToken;
    }

    // password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // isVerified
    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    // dateNaissance
    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    // numero
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    // cin
    public Integer getCin() {
        return cin;
    }

    public void setCin(Integer cin) {
        this.cin = cin;
    }

    // etat
    public Integer getEtat() {
        return etat;
    }

    public void setEtat(Integer etat) {
        this.etat = etat;
    }

    // imageUrl
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    // brochureFilename
    public String getBrochureFilename() {
        return brochureFilename;
    }

    public void setBrochureFilename(String brochureFilename) {
        this.brochureFilename = brochureFilename;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", roles='" + roles + '\'' +
                ", resetToken='" + resetToken + '\'' +
                ", password='" + password + '\'' +
                ", isVerified=" + isVerified +
                ", dateNaissance=" + dateNaissance +
                ", numero='" + numero + '\'' +
                ", cin=" + cin +
                ", etat=" + etat +
                ", imageUrl='" + imageUrl + '\'' +
                ", borchureFilename='" + brochureFilename + '\'' +
                '}';
    }
}
