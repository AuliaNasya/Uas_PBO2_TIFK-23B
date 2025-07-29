package com.mycompany.apotek;

public class Resep {
    private String id;
    private String pasienId;
    private String dokterId;
    private String tanggal;

    public Resep(String id, String pasienId, String dokterId, String tanggal) {
        this.id = id;
        this.pasienId = pasienId;
        this.dokterId = dokterId;
        this.tanggal = tanggal;
    }

    // Getter
    public String getId() {
        return id;
    }

    public String getPasienId() {
        return pasienId;
    }

    public String getDokterId() {
        return dokterId;
    }

    public String getTanggal() {
        return tanggal;
    }

    // Setter (optional jika nanti perlu edit)
    public void setId(String id) {
        this.id = id;
    }

    public void setPasienId(String pasienId) {
        this.pasienId = pasienId;
    }

    public void setDokterId(String dokterId) {
        this.dokterId = dokterId;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
}

