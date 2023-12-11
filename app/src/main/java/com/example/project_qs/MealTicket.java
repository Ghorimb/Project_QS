package com.example.project_qs;
import java.util.Date;

public class MealTicket {

    private User user;
    private MealOrder mealOrder;
    private String qrCode;
    private Date reservationTime;

    public MealTicket(User user, MealOrder mealOrder) {
        this.user = user;
        this.mealOrder = mealOrder;
        this.qrCode = generateQRCode();
        this.reservationTime = new Date();  // Pode ser útil registrar o tempo da reserva
    }

    public User getUser() {
        return user;
    }

    public MealOrder getMealOrder() {
        return mealOrder;
    }

    public String getQrCode() {
        return qrCode;
    }

    public Date getReservationTime() {
        return reservationTime;
    }

    private String generateQRCode() {
        // Lógica para gerar o código QR
        return "QRCode123";  // Substitua com uma implementação real
    }

    public void setMealOrder(MealOrder updatedOrder) {
    }

    // Adicione métodos adicionais conforme necessário
}

