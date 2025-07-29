package com.mycompany.apotek;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PasienController {

    @FXML
    private TextField txtIdPasien;
    @FXML
    private TextField txtNamaPasien;
    @FXML
    private TextField txtUmur;
    @FXML
    private TextField txtAlamat;
    @FXML
    private TextField txtKeluhan;

    @FXML
    private void simpanPasien() {
        String id = txtIdPasien.getText();
        String nama = txtNamaPasien.getText();
        String umur = txtUmur.getText();
        String alamat = txtAlamat.getText();
        String keluhan = txtKeluhan.getText();

        String sql = "INSERT INTO pasien (id_pasien, nama, umur, alamat, keluhan) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            stmt.setString(2, nama);
            stmt.setString(3, umur);
            stmt.setString(4, alamat);
            stmt.setString(5, keluhan);

            int rows = stmt.executeUpdate();

            if (rows > 0) {
                showAlert("Berhasil", "Data pasien berhasil disimpan.");
                clearFields();
                pindahHalaman("/fxml/DokterView.fxml"); // setelah simpan, pindah ke form dokter
            } else {
                showAlert("Gagal", "Data gagal disimpan.");
            }

        } catch (SQLException e) {
            showAlert("Error", "Terjadi kesalahan: " + e.getMessage());
        }
    }

    private void pindahHalaman(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();
            Stage stage = (Stage) txtIdPasien.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            showAlert("Error", "Gagal pindah halaman: " + e.getMessage());
        }
    }

    private void clearFields() {
        txtIdPasien.clear();
        txtNamaPasien.clear();
        txtUmur.clear();
        txtAlamat.clear();
        txtKeluhan.clear();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
