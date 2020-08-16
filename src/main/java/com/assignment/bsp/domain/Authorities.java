package com.assignment.bsp.domain;

import javax.persistence.*;

@Entity
@Table(name = "AUTHORITIES")
public class Authorities {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BSP_SEQ_GEN")
    @SequenceGenerator(name = "BSP_SEQ_GEN")
    @Column(name = "ID")
    private Long id;

    /*
    @ManyToOne(optional = false)
    @JoinColumn(name = "USER_ID")
    private Users user_id;

     */

    @Column(name = "USERNAME")
    private String username;


    @Column(name = "AUTHORITY")
    private String authority;

    public Authorities(Long id, String username, String authority) {
        this.id=id;
        this.username = username;
        this.authority = authority;
    }
    public Authorities(String username, String authority) {
        this.username = username;
        this.authority = authority;
    }

    public Authorities() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthority() {
        return "USER_ROLE";
    }

    public void setAuthority(String authority) {
        this.authority = "USER_ROLE";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
