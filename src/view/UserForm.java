package view;


import DAO.UserDAO;
import model.User;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class UserForm extends JFrame {
    private final UserDAO userDAO;


    private final JTextField nameField = new JTextField(20);
    private final JTextField emailField = new JTextField(20);
    private final JButton addButton = new JButton("Adicionar");
    private final JButton updateButton = new JButton("Atualizar");
    private final JButton deleteButton = new JButton("Excluir");
    private final JButton listButton = new JButton("Listar");
    private final DefaultListModel<User> userListModel = new DefaultListModel<>();
    private final JList<User> userList = new JList<>(userListModel);

    public UserForm() {
        super("Sistema CRUD");
        this.userDAO = new UserDAO();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Painel para campos e botões
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        inputPanel.add(new JLabel("Nome:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Email:"));
        inputPanel.add(emailField);
        inputPanel.add(addButton);
        inputPanel.add(updateButton);
        inputPanel.add(deleteButton);
        inputPanel.add(listButton);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(userList), BorderLayout.CENTER);

        // --- Lógica dos Botões e Eventos ---

        addButton.addActionListener(e -> addUser());
        listButton.addActionListener(e -> loadUsers());
        updateButton.addActionListener(e -> updateUser());
        deleteButton.addActionListener(e -> deleteUser());

        // Evento que preenche os campos quando um item da lista é selecionado
        userList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                User selectedUser = userList.getSelectedValue();
                if (selectedUser != null) {
                    nameField.setText(selectedUser.getName());
                    emailField.setText(selectedUser.getEmail());
                }
            }
        });


        loadUsers();
    }

    private void clearFields() {
        nameField.setText("");
        emailField.setText("");
        userList.clearSelection();
    }

    private void loadUsers() {
        userListModel.clear();
        List<User> users = userDAO.listUsers();
        for (User user : users) {
            userListModel.addElement(user);
        }
    }

    private void addUser() {
        String name = nameField.getText();
        String email = emailField.getText();
        if (name.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nome e Email são obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        userDAO.addUser(new User(name, email));
        loadUsers();
        clearFields();
    }

    private void updateUser() {
        User selectedUser = userList.getSelectedValue();
        if (selectedUser == null) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione um usuário para atualizar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String newName = nameField.getText();
        String newEmail = emailField.getText();
        if (newName.isEmpty() || newEmail.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nome e Email não podem ser vazios.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        selectedUser.setName(newName);
        selectedUser.setEmail(newEmail);
        userDAO.updateUser(selectedUser);
        loadUsers();
        clearFields();
    }

    private void deleteUser() {
        User selectedUser = userList.getSelectedValue();
        if (selectedUser == null) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione um usuário para excluir.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int response = JOptionPane.showConfirmDialog(this,
                "Tem certeza que deseja excluir o usuário " + selectedUser.getName() + "?",
                "Confirmar Exclusão", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            userDAO.deleteUser(selectedUser.getId());
            loadUsers();
            clearFields();
        }
    }
}
