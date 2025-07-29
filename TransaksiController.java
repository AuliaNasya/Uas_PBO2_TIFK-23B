
package com.mycompany.apotek;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class TransaksiController {

    @FXML
    private TextField txtId;
    @FXML
    private TextField txtresep_id;
    @FXML
    private TextField txtobat_id;
    @FXML
    private TextField txtjumlah;
    @FXML
    private TextField txttotal_harga;
    @FXML
    private TextField txttanggal;

    @FXML
    private void simpanTransaksi() {
        String id = txtId.getText();
        String resepId = txtresep_id.getText();
        String obatId = txtobat_id.getText();
        String jumlah = txtjumlah.getText();
        String totalHarga = txttotal_harga.getText();
        String tanggal = txttanggal.getText(); // harus format yyyy-mm-dd

        String sql = "INSERT INTO transaksi (id, resep_id, obat_id, jumlah, total_harga, tanggal) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            stmt.setString(2, resepId);
            stmt.setString(3, obatId);
            stmt.setInt(4, Integer.parseInt(jumlah));
            stmt.setDouble(5, Double.parseDouble(totalHarga));
            stmt.setDate(6, java.sql.Date.valueOf(LocalDate.parse(tanggal)));

            int rows = stmt.executeUpdate();

            if (rows > 0) {
                showAlert("Berhasil", "Data transaksi berhasil disimpan.");
                clearFields();
            } else {
                showAlert("Gagal", "Data transaksi gagal disimpan.");
            }

         } catch (SQLException | NumberFormatException e) {
            showAlert("Error", "Terjadi kesalahan: " + e.getMessage());
        }
    }

    private void clearFields() {
        txtId.clear();
        txtresep_id.clear();
        txtobat_id.clear();
        txtjumlah.clear();
        txttotal_harga.clear();
        txttanggal.clear();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
