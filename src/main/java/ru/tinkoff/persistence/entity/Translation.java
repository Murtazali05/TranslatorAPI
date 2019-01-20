package ru.tinkoff.persistence.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "translation", schema = "public", catalog = "translator")
public class Translation {
    private int id;
    private Timestamp calltime;
    private String input;
    private String output;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "calltime")
    public Timestamp getCalltime() {
        return calltime;
    }

    public void setCalltime(Timestamp calltime) {
        this.calltime = calltime;
    }

    @Basic
    @Column(name = "input", nullable = false)
    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    @Basic
    @Column(name = "output", nullable = false)
    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
}
