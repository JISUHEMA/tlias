package com.eden.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 主キー、ID
    private String username; // ユーザー名
    private String name; // 名前
    private String phone; // 電話番号
    private String email; // メールアドレス
    private Boolean emailVerified; // メール確認済み
    private Boolean phoneVerified; // 電話確認済み
    private String avatar; // アバター
    private String role; // 役割
    private String resetToken; // リセットトークン
}
