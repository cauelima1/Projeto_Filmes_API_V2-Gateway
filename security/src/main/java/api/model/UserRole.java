package api.model;

public enum UserRole {LEITOR("LEITOR"),
    BASICO("BASICO"),
    AVANCADO("AVANCADO"),
    MODERADOR("MODERADOR");

    private String role;

    UserRole(String role){
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
