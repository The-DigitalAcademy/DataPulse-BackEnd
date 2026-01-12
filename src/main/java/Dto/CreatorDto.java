package Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import za.co.teama.data.pulse.Models.User;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatorDto {
        private UUID id;
        private String name;
        private String surname;
        private String email;

        public CreatorDto(User user) {
            this.id = user.getId();
            this.name = user.getName();
            this.surname = user.getSurname();
            this.email = user.getEmail();
        }
    }
