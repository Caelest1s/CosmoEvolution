package com.cdz.mngmtrisk.cosmoevolution.dto;

import com.cdz.mngmtrisk.cosmoevolution.entity.Knight;

import jakarta.validation.constraints.NotBlank;

public class KnightDTO {

    // attribute
    private Long id;
    private String name;    // setado
    @NotBlank(message = "campo requerido")
    private int star;
    @NotBlank(message = "campo requerido")
    private int cloth;
    @NotBlank(message = "campo requerido")
    private int constelation;
    private String imgUrl;  // setado
    private String classe;  // setado
    private String element;

    // constructor
    public KnightDTO() {

    }

    public KnightDTO(Long id, String name, int star, int cloth, int constelation, String imgUrl, String classe,
            String element) {
        this.id = id;
        this.name = name;
        this.star = star;
        this.cloth = cloth;
        this.constelation = constelation;
        this.imgUrl = imgUrl;
        this.classe = classe;
        this.element = element;
    }

    // override constructor
    public KnightDTO(Knight knight) {
        id = knight.getId();
        name = knight.getName();
        star = knight.getStar();
        cloth = knight.getCloth();
        constelation = knight.getConstelation();
        imgUrl = knight.getImgUrl();
        classe = knight.getClasse();
        element = knight.getElement();
    }

    // getter and setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public int getCloth() {
        return cloth;
    }

    public void setCloth(int cloth) {
        this.cloth = cloth;
    }

    public int getConstelation() {
        return constelation;
    }

    public void setConstelation(int constelation) {
        this.constelation = constelation;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

}
