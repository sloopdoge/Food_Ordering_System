package com.example.ordering_system.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "order")
public class Order {
    private static final String SEQ_NAME = "order_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    @Column(name = "order_id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "total_price")
    private Double totalPrice;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderDetails> details;

}
