package ksafinalproject.gbt.smoking.dto;

import ksafinalproject.gbt.smoking.model.Smoking;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Getter
@Setter
@ToString
@NoArgsConstructor
public class SmokingDto {
    Long total;
    List<Smoking> smokingList;
}
