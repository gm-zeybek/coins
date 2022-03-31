package com.crypto.userAccount;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Log4j
public class User {


    private String firstname;
    private String lastname;
    private String phone;
    private String email;


}
