package be.kdg.prog6.ticketing.adapters.in.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CreateVisitorDTO {
    private String name;
    private String address;
    private String email;
    private String phone;
}
