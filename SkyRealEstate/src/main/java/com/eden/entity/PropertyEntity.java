package com.eden.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "properties")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PropertyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 主キー、ID

    private String title; // 物件タイトル

    private String description; // 物件説明

    private BigDecimal price; // 物件価格

    private String location; // 物件の場所

    private Double latitude; // 緯度

    private Double longitude; // 経度

    private String type; // 物件タイプ（売買/賃貸）

    private String status; // 状態（利用可能/売却済み/賃貸済み）

    @Column(name = "agent_id")
    private Long agentId; // スタッフID

    private LocalDate expiryDate; // 掲載期限
}
