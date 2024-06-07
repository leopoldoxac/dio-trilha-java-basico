package banco.Digital.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class DatabaseManager {

    private static final String URL = "jdbc:sqlite:localdb.db";

    public static void connect() {
        try (Connection conn = DriverManager.getConnection(URL)) {
            if (conn != null) {
                System.out.println("Conectado ao banco de dados.");
            }
        } catch (SQLException e) {
            System.out.println("Conexão falhou: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void createNewTable() {
        String sql = "CREATE TABLE IF NOT EXISTS users (\n"
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + " agencia INTEGER NOT NULL,\n"
                + " nome TEXT NOT NULL,\n"
                + " email TEXT NOT NULL,\n"
                + " senha TEXT NOT NULL,\n"
                + " cpf INTEGER NOT NULL,\n"
                + " saldo DOUBLE NOT NULL\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table created.");
        } catch (SQLException e) {
            System.out.println("Table creation failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static boolean userExists(int id) {
        String sql = "SELECT id FROM users WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next(); // true if a result is found
            }
        } catch (SQLException e) {
            System.out.println("Existencia de usuario falhou: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
    public static boolean cpfExists(long cpf) {
        String sql = "SELECT cpf FROM users WHERE cpf = ?";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, cpf);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next(); // true se existe
            }
        } catch (SQLException e) {
            System.out.println("Verificação de existencia do usuario falhou: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
    public static boolean login(long cpf, String senha) {
        String sql = "SELECT cpf FROM users WHERE cpf = ?";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, cpf);
            pstmt.setString(2, senha);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next(); // true se existe
            }
        } catch (SQLException e) {
            System.out.println("Verificação de existencia do usuario falhou: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public static void insert(int agencia, String nome, String email, String senha, long cpf, double saldo) {
        String sql = "INSERT INTO users(agencia, nome, email, senha, cpf, saldo) VALUES(?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, agencia);
            pstmt.setString(2, nome);
            pstmt.setString(3, email);
            pstmt.setString(4, senha);
            pstmt.setLong(5, cpf);
            pstmt.setDouble(6, saldo);
            pstmt.executeUpdate();
            System.out.println("Data inserido.");
        } catch (SQLException e) {
            System.out.println("A inserção de dados falhou: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void updateUserField(int id, String fieldName, String newValue) {
        String sql = "UPDATE users SET " + fieldName + " = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newValue);
            pstmt.setInt(2, id);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Atualizado usuario com ID " + id + ": definido " + fieldName + " para " + newValue);
            } else {
                System.out.println("ID não encontrado: " + id);
            }
        } catch (SQLException e) {
            System.out.println("Update falhou: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void updateUserField(int id, String fieldName, int newValue) {
        String sql = "UPDATE users SET " + fieldName + " = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, newValue);
            pstmt.setInt(2, id);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Atualizado usuario com ID " + id + ": definido " + fieldName + " para " + newValue);
            } else {
                System.out.println("ID não encontrado: " + id);
            }
        } catch (SQLException e) {
            System.out.println("Update falhou: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void updateUserField(int id, String fieldName, double newValue) {
        String sql = "UPDATE users SET " + fieldName + " = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, newValue);
            pstmt.setInt(2, id);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Usuario com ID " + id + ": atualizado " + fieldName + " para " + newValue);
            } else {
                System.out.println("ID não encontrado para nem um usuario. " + id);
            }
        } catch (SQLException e) {
            System.out.println("Update falhou: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void printAllUsers() {
        String sql = "SELECT id, agencia, nome, email, saldo, cpf FROM users";

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // Loop through the result set and print the data
            while (rs.next()) {
                int id = rs.getInt("id");
                int agencia = rs.getInt("agencia");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                long cpf = rs.getLong("cpf");
                double saldo = rs.getDouble("saldo");
                System.out.println("ID: " + id + " | Agência: " + agencia + " | Nome: " + nome + " | Email: " + email + " | CPF: " + cpf + " | Saldo: " + saldo );
            }
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Current working directory: " + System.getProperty("user.dir"));
        System.out.println("Database path: " + URL);

        connect();
        createNewTable();

        // Insert example data
        insert(1234, "John Doe", "john.doe@example.com", "password123", 12345678901L, 123);
        insert(5678, "Jane Smith", "jane.smith@example.com", "password456", 23456789012L, 222);

        // Print all users
        printAllUsers();

        // Update an example field
        updateUserField(1, "email", "new.email@example.com");
        updateUserField(2, "agencia", 9999);
        updateUserField(1, "cpf", 98765432109L);
        updateUserField(1,"saldo", 22.5);

        // Print all users after update
        printAllUsers();

        System.out.println(cpfExists(98765432109L));
    }
}

