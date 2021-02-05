package com.example.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * @author <a href="kuldeepyadav7291@gmail.com">Kuldeep</a>
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@DiscriminatorValue(value = "EXPORT")
public class ExportOrder extends Order{
    private String shipper;
    private String consignee;
}
