package model;

public class User {
    private int id;
    private String name;
    private String email;

    /**
     * Construtor usado para criar um novo usuário que ainda não foi salvo no banco.
     * @param name O nome do usuário.
     * @param email O email do usuário.
     */
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    /**
     * Construtor usado para criar um objeto a partir de dados vindos do banco.
     * @param id O ID do usuário no banco.
     * @param name O nome do usuário.
     * @param email O email do usuário.
     */
    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Este método é muito importante.
     * A JList (lista visual) usará o retorno deste método para exibir cada usuário.
     * @return O nome do usuário.
     */
    @Override
    public String toString() {
        return getName();
    }
}
