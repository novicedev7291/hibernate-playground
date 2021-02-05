package com.example.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * @author <a href="kuldeepyadav7291@gmail.com">Kuldeep</a>
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@DiscriminatorValue(value = "RETAIL")
public class RetailOrder extends Order {
    @Column(name = "is_paid")
    private Boolean isPaid = Boolean.FALSE;
}
