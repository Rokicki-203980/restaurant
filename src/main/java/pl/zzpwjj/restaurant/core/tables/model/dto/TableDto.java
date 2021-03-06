package pl.zzpwjj.restaurant.core.tables.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.zzpwjj.restaurant.core.reservations.model.entities.Reservation;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TableDto {
    @NotNull
    private Long id;

    private Reservation reservationId;
}
