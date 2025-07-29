
package com.mycompany.apotek;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// Tambahan import untuk pindah view
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class ObatController {

    @FXML
    private TextField txtId;
    @FXML
    private TextField txtNama;
    @FXML
    private TextField txtHarga;

    @FXML
    private void simpanObat() {
        String id = txtId.getText();
        String nama = txtNama.getText();
        String harga = txtHarga.getText();

        String sql = "INSERT INTO obat (id, nama, harga) VALUES (?, ?, ?)";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            stmt.setString(2, nama);
            stmt.setDouble(3, Double.parseDouble(harga));  // <- Diperbaiki indeks kolom ke 3

            int rows = stmt.executeUpdate();

            if (rows > 0) {
                showAlert("Berhasil", "Data obat berhasil disimpan.");
                clearFields();
            } else {
                showAlert("Gagal", "Data gagal disimpan.");
            }

        } catch (SQLException | NumberFormatException e) {
            showAlert("Error", "Terjadi kesalahan: " + e.getMessage());
        }
    }

    // ✅ Tambahan untuk pindah ke TransaksiView.fxml
    @FXML
    private void keTransaksi(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/TransaksiView.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Form Transaksi");
        } catch (IOException e) {
            showAlert("Error", "Tidak dapat membuka form transaksi: " + e.getMessage());
        }
    }

    private void clearFields() {
        txtId.clear();
        txtNama.clear();
        txtHarga.clear();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
