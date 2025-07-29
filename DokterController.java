package com.mycompany.apotek;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.IOException;

public class DokterController {

    @FXML
    private TextField txtIdDokter;
    @FXML
    private TextField txtNamaDokter;
    @FXML
    private TextField txtSpesialis;

    @FXML
    private void simpanDokter() {
        String id = txtIdDokter.getText();
        String nama = txtNamaDokter.getText();
        String spesialis = txtSpesialis.getText();

        String sql = "INSERT INTO dokter (id, nama, spesialis) VALUES (?, ?, ?)";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            stmt.setString(2, nama);
            stmt.setString(3, spesialis);

            int rows = stmt.executeUpdate();

            if (rows > 0) {
                showAlert("Berhasil", "Data dokter berhasil disimpan.");
                clearFields();
                bukaFormResep();
            } else {
                showAlert("Gagal", "Data gagal disimpan.");
            }

        } catch (SQLException e) {
            showAlert("Error", "Terjadi kesalahan: " + e.getMessage());
        }
    }

    private void clearFields() {
        txtIdDokter.clear();
        txtNamaDokter.clear();
        txtSpesialis.clear();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void bukaFormResep() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ResepView.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) txtIdDokter.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            showAlert("Error", "Gagal membuka form resep: " + e.getMessage());
        }
    }
}

