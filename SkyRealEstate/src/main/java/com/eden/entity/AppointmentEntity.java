package com.eden.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "appointments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 主キー、ID

    @Column(name = "user_id")
    private Long userId; // ユーザーID

    @Column(name = "property_id")
    private Long propertyId; // 物件ID

    private LocalDate date; // 予約日

    private String status; // 予約状態（処理中/確認済み/キャンセル済み）
}
