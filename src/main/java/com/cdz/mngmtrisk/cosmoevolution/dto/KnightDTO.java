package com.cdz.mngmtrisk.cosmoevolution.dto;

import com.cdz.mngmtrisk.cosmoevolution.entity.Knight;
import com.cdz.mngmtrisk.cosmoevolution.enums.EnumKnightClasse;
import com.cdz.mngmtrisk.cosmoevolution.enums.EnumKnightElement;

import jakarta.validation.constraints.NotBlank;

public class KnightDTO {

    // attribute
    private Long id;
    private String name;    // setado
    @NotBlank(message = "campo requerido")
    private String star;
    @NotBlank(message = "campo requerido")
    private int cloth;
    @NotBlank(message = "campo requerido")
    private int constelation;
    private String imgUrl;  // setado
    private EnumKnightClasse classe;  // setado
    private EnumKnightElement element; // setado

    // constructor
    public KnightDTO() {

    }

    public KnightDTO(Long id, String name, String star, int cloth, int constelation, String imgUrl, EnumKnightClasse classe,
            EnumKnightElement element) {
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

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
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

    public EnumKnightClasse getClasse() {
        return classe;
    }

    public void setClasse(EnumKnightClasse classe) {
        this.classe = classe;
    }

    public EnumKnightElement getElement() {
        return element;
    }

    public void setElement(EnumKnightElement element) {
        this.element = element;
    }

}
