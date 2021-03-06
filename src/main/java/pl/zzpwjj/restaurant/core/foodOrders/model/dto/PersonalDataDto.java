package pl.zzpwjj.restaurant.core.foodOrders.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonalDataDto {
    @NotNull
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String surname;
}
