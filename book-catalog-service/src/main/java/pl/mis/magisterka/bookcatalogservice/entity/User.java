package pl.mis.magisterka.bookcatalogservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class User {

    private Long id;

    private String firstName;

    private String lastName;

}
