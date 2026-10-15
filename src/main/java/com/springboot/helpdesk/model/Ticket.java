package com.springboot.helpdesk.model;

import com.springboot.helpdesk.enums.Priority;
import com.springboot.helpdesk.enums.Status;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Length;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Ticket { //t
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;        //findById

    private String subject; // findBySubject(subject)

    @Column(length = 1000)
    private String issue;;

    @CreationTimestamp
    @Column(updatable = false)
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;

    @Enumerated(EnumType.STRING)
    private Priority priority; // findByPriority(priority) : List<Ticket>

    @Enumerated(EnumType.STRING)
    private Status status;     // findByStatus(status) : List<Ticket>

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;                          //t.customer c

    @ManyToOne
    @JoinColumn(name = "executive_id")
    private Executive executive;                        //t.executive e
}
